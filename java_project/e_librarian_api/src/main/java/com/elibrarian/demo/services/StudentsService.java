package com.elibrarian.demo.services;

import java.util.List;
import java.util.Optional;

import com.elibrarian.demo.model.StudentsEntity;

public interface StudentsService {
    StudentsEntity addStudent(StudentsEntity student);

    List<StudentsEntity> viewStudents();

    Optional<StudentsEntity> viewStudentById(Integer studId);

    StudentsEntity updateStudent(StudentsEntity student);

    Integer removeStudent(Integer studId);
}
