package com.elibrarian.demo.services.impl;

import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elibrarian.demo.model.StudentsEntity;
import com.elibrarian.demo.repos.StudentsRepository;
import com.elibrarian.demo.services.StudentsService;

@Slf4j
@Service
public class StudentsServiceImpl implements StudentsService {

	private final StudentsRepository studentsRepository;

    @Autowired
    public StudentsServiceImpl(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }
	
	@Override
	public StudentsEntity addStudent(StudentsEntity student) {
		return studentsRepository.saveAndFlush(student);
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
		return studentsRepository.saveAndFlush(student);
	}

	@Override
	public int removeStudent(Integer studId) {
		int row = 0;
		try {
			studentsRepository.deleteById(studId);
			row = 1;
		} catch(IllegalArgumentException e) {
			log.error("Exception encountered when remove student: {}", e.getMessage());
		}
		
		return row;
	}

}
