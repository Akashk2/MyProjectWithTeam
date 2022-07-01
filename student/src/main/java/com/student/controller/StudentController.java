package com.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.student.bean.Student;
import com.student.service.Service;

@RestController
public class StudentController {


	@Autowired
	Service service;
	
	@PostMapping("/addRecord")
	public Student addRecord(@RequestBody Student student) {
		return service.addRecord(student);
	}
	
	@GetMapping("/getById")
	public Optional<Student> getById(@RequestParam int id) {
		return service.getById(id);
	}
	
	@GetMapping("/getAll")
	public List<Student> getAll() {
		return service.getAll();
	}
	
	@PutMapping("/updateById/{id}")
	public Student updateById(@RequestBody Student student) {
		return service.updateById(student);
	}
	
	@DeleteMapping("/deletedById")
	public String deletedById(@RequestParam int id) {
		service.deletedById(id);
		return "deleted data";
	}
	
//	@GetMapping("/getData")
//	public String getData() {
//		RestTemplate restTemplate = new RestTemplate();
//		return restTemplate.getForObject("http://127.0.0.1:8000/stuinfo/", String.class);
//	}
}
