package com.elibrarian.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elibrarian.demo.model.StudentsEntity;
import com.elibrarian.demo.services.StudentsService;

@RestController
@RequestMapping("/api/students")
public class StudentsController {
	
	@Autowired
	private StudentsService studentsService;
	
	@PostMapping("/addstudent")
	public ResponseEntity<StudentsEntity> addStudent(@RequestBody StudentsEntity student) {
		return ResponseEntity.ok(studentsService.addStudent(student));
	}
	
	@GetMapping("/viewstudent")
	public ResponseEntity<List<StudentsEntity>> viewStudents() {
		return ResponseEntity.ok(studentsService.viewStudents());
	}
	
	@GetMapping("/viewstudent/{id}")
	public ResponseEntity<Optional<StudentsEntity>> viewStudentById(@PathVariable Integer id) {
		return ResponseEntity.ok(studentsService.viewStudentById(id));
	}
	
	@PutMapping("/updatestudent")
	public ResponseEntity<StudentsEntity> updateStudent(@RequestBody StudentsEntity student) {
		return ResponseEntity.ok(studentsService.updateStudent(student));
	}
	
	@DeleteMapping("/removestudent/{id}")
	public ResponseEntity<Integer> removeStudent(@PathVariable Integer id) {
		return ResponseEntity.ok(studentsService.removeStudent(id));
	}
}
