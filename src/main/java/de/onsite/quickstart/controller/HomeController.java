package de.onsite.quickstart.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.onsite.quickstart.model.Item;
import de.onsite.quickstart.model.ItemList;
import de.onsite.quickstart.model.Student;
import de.onsite.quickstart.repository.ItemListRepository;
import de.onsite.quickstart.repository.ItemRepository;
import de.onsite.quickstart.repository.StudentRepository;

@RestController
public class HomeController {

	@Autowired
	StudentRepository studentRep;

	@Autowired
	ItemRepository itemRep;

	@Autowired
	ItemListRepository itemListRep;

	@GetMapping("/")
	public String home() {
		return "Hello Onsite!";
	}

	@GetMapping("/test")
	public String test() {
		return "This is a test!";
	}

	@GetMapping("/students")
	public List<Student> students() {
		return studentRep.findAll();
	}

	@GetMapping("/items")
	public List<Item> items() {
		List<Item> allItems = itemRep.findAll();
		return allItems;
	}

	@PostMapping("/itemsForItemList")
	public List<Item> itemsForItemList(@RequestBody Long id) {
		List<Item> allItems = itemRep.findAllByItemListId(id);
		return allItems;
	}

	@GetMapping("/itemLists")
	public List<ItemList> itemLists() {
		List<ItemList> allItemLists = itemListRep.findAll();
		return allItemLists;
	}

	@GetMapping("/student/{id}")
	public Student studentById(@PathVariable("id") Long id) {
		List<Student> studentsById = studentRep.findAllById(Arrays.asList(id));

		if (studentsById == null || studentsById.isEmpty()) {
			throw new RuntimeException("The Student with id " + id + " could not be found!");
		}

		return studentsById.get(0);
	}

	@GetMapping("/studentName/{name}")
	public String oneStudent(@PathVariable("name") String name) {
		return "Hello " + name;
	}

	@PostMapping("/itemsUpdateORG")
	public List<Item> itemsUpdateORG(@RequestBody List<Item> updatedItems) {
		itemRep.deleteAll();
		itemRep.saveAll(updatedItems);
		return itemRep.findAll();
	}

	@PostMapping("/itemsUpdate")
	public List<Item> itemsUpdate(@RequestBody List<Item> updatedItems) {
		if (updatedItems != null) {
			//delete
			List<Item> allItemsForList = itemRep.findAllByItemListId(updatedItems.get(0).getItemList().getId());
			for (Item itemFromDB : allItemsForList) {
				boolean foundInUpdated = false;
				for (Item updatedItem : updatedItems) {
					if (itemFromDB.getId() == updatedItem.getId()) {
						foundInUpdated = true;
					}
				}
				if (!foundInUpdated) {
					deleteItem(itemFromDB);
				}
			}
			
			//update and create
			for (Item item : updatedItems) {
				Optional<Item> dbItemOptional = itemRep.findById(item.getId());
				if (dbItemOptional.isPresent()) {
					if (item.equals(dbItemOptional.get())) {
						continue;
					} else {
						updateItem(item);
					}
				} else {
					createItem(item);
				}
			}
		}

		return itemRep.findAll();
	}


	@PutMapping("/item/create")
	public Item createItem(@RequestBody Item newItem) {
		Item savedItem = itemRep.save(newItem);
		return savedItem;
	}

	@DeleteMapping("/item/delete")
	public void deleteItem(@RequestBody Item item) {
		itemRep.deleteById(item.getId());
	}

	@PostMapping("/item/createOrUpdate")
	public Item createOrUpdateItem(@RequestBody Item changedItem) {
		Optional<Item> dbItemOptional = itemRep.findById(changedItem.getId());

		if (!dbItemOptional.isPresent()) {
			return createItem(changedItem);
		}

		Item dbItem = dbItemOptional.get();
		dbItem.setItemName(changedItem.getItemName());
		Item savedItem = itemRep.save(dbItem);

		return savedItem;
	}

	@PostMapping("/item/update")
	public Item updateItem(@RequestBody Item changedItem) {
		Optional<Item> dbItemOptional = itemRep.findById(changedItem.getId());

		Item dbItem = dbItemOptional.get();
		dbItem.setItemName(changedItem.getItemName());
		dbItem.setCount(changedItem.getCount());
		dbItem.setDescription(changedItem.getDescription());
		dbItem.setDone(changedItem.isDone());
		dbItem.setItemList(changedItem.getItemList());

		Item savedItem = itemRep.save(dbItem);

		return savedItem;
	}

	@PostMapping("/item/read")
	public Item readItem(@RequestBody Long id) {
		Optional<Item> dbItemOptional = itemRep.findById(id);

		if (dbItemOptional.isPresent()) {
			return dbItemOptional.get();
		}

		return null;
	}
	
	@PostMapping("/mypost")
	public String myPost(@RequestBody Long id) {

		return "This is my request body id: " + id;
	}
}
