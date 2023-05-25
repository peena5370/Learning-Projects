package com.elibrarian.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elibrarian.demo.model.LibrariansEntity;

public interface LibrariansRepository extends JpaRepository<LibrariansEntity, Integer> {
}
