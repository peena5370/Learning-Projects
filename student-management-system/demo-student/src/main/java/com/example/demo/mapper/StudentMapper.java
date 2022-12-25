package com.example.demo.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository
public interface StudentMapper {
	
	/**
	 * List all available student information
	 * @return List
	 */
	public List<Student> selectList();
	
	/**
	 * Get student information by id
	 * @param id
	 * @return Student
	 */
	public Student selectStudent(int id);
	
	/**
	 * Insert new student information
	 * @param student
	 * @return Inserted row
	 */
	public Integer insertStudent(Student student);
	
	/**
	 * Update selected student information
	 * @param student
	 * @return Updated row
	 */
	public Integer updateStudent(Student student);
	
	/**
	 * Delete selected student information
	 * @param id
	 * @return Deleted row
	 */
	public Integer deleteStudent(int id);
}
