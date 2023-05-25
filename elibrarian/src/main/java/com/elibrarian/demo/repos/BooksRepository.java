package com.elibrarian.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elibrarian.demo.model.BooksEntity;

public interface BooksRepository extends JpaRepository<BooksEntity, Integer> {

}
