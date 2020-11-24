package de.onsite.quickstart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@RequestMapping("/")
	public String home() {
	  return "Hello Onsite!";
	}

        @RequestMapping("/test")
	public String test() {
	  return "This is a test!";
	}

	@RequestMapping("/students")
	public List<Student> students() {
	  return studentRep.findAll();
	}
	
	@RequestMapping("/items")
	public List<Item> items() {
	  return itemRep.findAll();
	}
	
	@RequestMapping("/student/{name}")
	public String oneStudent(@PathVariable("name") String name) {
	  return "Hello " + name;
	}
}
