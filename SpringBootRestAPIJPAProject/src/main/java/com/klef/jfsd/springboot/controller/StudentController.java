package com.klef.jfsd.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klef.jfsd.springboot.model.Student;
import com.klef.jfsd.springboot.service.StudentServcie;

@RestController
@RequestMapping("student")
public class StudentController {

	@Autowired
	 private StudentServcie service;
	
	@GetMapping("/")
	public String home()
	{
		return "<h3>Spring Boot Rest API and JPA</h3>";
	}
	
	@PostMapping("/add")
	public String addStudent(@RequestBody Student stundent) {
		return service.addStudent(stundent);
	}
	
	@GetMapping("/viewall")
	public List<Student> viewAllStudents() {
		return service.displayAllStundents();
	}
	
	@GetMapping("/display")
	public Student displayStudent(@RequestParam("id") int sid) {
		return service.displayStudentByID(sid);
	}
	
	@DeleteMapping("/delete")
	public String deleteStudent(@RequestParam("id") int sid) {
		return service.deleteStudent(sid);
	}
	
	@PutMapping("/update")
	public String updateStudent(@RequestBody  Student s) {
		return service.updateStudent(s);
	}
}
