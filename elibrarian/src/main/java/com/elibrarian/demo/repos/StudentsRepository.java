package com.elibrarian.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elibrarian.demo.model.StudentsEntity;

public interface StudentsRepository extends JpaRepository<StudentsEntity, Integer> {

}
