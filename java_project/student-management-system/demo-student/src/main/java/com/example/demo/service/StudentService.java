package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentService {

	public List<Student> listStudent();
	
	public Student selectStudent(int id);
	
	public Integer addStudent(Student student);
	
	public Integer updateStudent(Student student);
	
	public Integer removeStudent(int id);
}
