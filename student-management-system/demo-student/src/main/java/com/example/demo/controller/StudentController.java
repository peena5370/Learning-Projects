package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

/**
* Student controller with @RestController.
* 
* @author Caronline Lee
* Created on 12-05-2022
**/
@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/list")
	public List<Student> listStudent() {
		return studentService.listStudent();
	}
	
	@GetMapping("/list/{id}")
	public Student selectStudent(@PathVariable int id) {
		return studentService.selectStudent(id);
	}

	@PostMapping("/insert")
	public Integer insertStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}
	
	@PutMapping("/{id}/update")
	public Integer updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}
	
	@DeleteMapping("/{id}/delete")
	public Integer deleteStudent(@PathVariable int id) {
		return studentService.removeStudent(id);
	}
}
