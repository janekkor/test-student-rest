package de.onsite.quickstart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.onsite.quickstart.model.Student;
import de.onsite.quickstart.repository.StudentRepository;

@RestController
public class HomeController {

	@Autowired
	StudentRepository studentRep;
	
	
	@RequestMapping("/")
	public String home() {
	  return "Hello Onsite!";
	}
	

	@RequestMapping("/students")
	public List<Student> students() {
	  return studentRep.findAll();
	}
	
}
