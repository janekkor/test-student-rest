package de.onsite.quickstart.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.onsite.quickstart.model.Item;
import de.onsite.quickstart.model.Student;
import de.onsite.quickstart.repository.ItemRepository;
import de.onsite.quickstart.repository.StudentRepository;

@RestController
public class HomeController {

	@Autowired
	StudentRepository studentRep;
	
	@Autowired
	ItemRepository itemRep;
	
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
	
	@PostMapping("/itemsUpdate")
	public List<Item> studentsUpdate(@RequestBody List<Item> updatedItems) {
	  itemRep.deleteAll();	
	  itemRep.saveAll(updatedItems);
	  return itemRep.findAll();
	}
}
