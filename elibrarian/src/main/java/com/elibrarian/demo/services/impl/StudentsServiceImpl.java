package com.elibrarian.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elibrarian.demo.model.StudentsEntity;
import com.elibrarian.demo.repos.StudentsRepository;
import com.elibrarian.demo.services.StudentsService;

@Service
public class StudentsServiceImpl implements StudentsService {

	@Autowired
	private StudentsRepository studentsRepository;
	
	@Override
	public StudentsEntity addStudent(StudentsEntity student) {
		StudentsEntity savedEntity = studentsRepository.save(student);
		studentsRepository.flush();
		
		return savedEntity;
	}

	@Override
	public List<StudentsEntity> viewStudents() {
		return studentsRepository.findAll();
	}

	@Override
	public Optional<StudentsEntity> viewStudentById(Integer studId) {
		return studentsRepository.findById(studId);
	}

	@Override
	public StudentsEntity updateStudent(StudentsEntity student) {
		StudentsEntity updatedEntity = studentsRepository.save(student);
		studentsRepository.flush();
		
		return updatedEntity;
	}

	@Override
	public Integer removeStudent(Integer studId) {
		Integer row = 0;
		try {
			studentsRepository.deleteById(studId);
			row = 1;
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
			row = 0;
		}
		
		return row;
	}

}
