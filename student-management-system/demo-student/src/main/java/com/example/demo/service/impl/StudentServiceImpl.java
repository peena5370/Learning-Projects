package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.StudentMapper;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	private final StudentMapper studentMapper;
	
	@Autowired
	public StudentServiceImpl(StudentMapper studentMapper) {
		this.studentMapper = studentMapper;
	}

	@Override
	public List<Student> listStudent() {
		return studentMapper.selectList();
	}
	
	@Override
	public Student selectStudent(int id) {
		return studentMapper.selectStudent(id);
	}

	@Override
	public Integer addStudent(Student student) {
		return studentMapper.insertStudent(student);
	}

	@Override
	public Integer updateStudent(Student student) {
		return studentMapper.updateStudent(student);
	}

	@Override
	public Integer removeStudent(int id) {
		return studentMapper.deleteStudent(id);
	}

}
