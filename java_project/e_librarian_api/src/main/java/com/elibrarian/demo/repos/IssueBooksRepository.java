package com.elibrarian.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elibrarian.demo.model.IssueBooksEntity;

public interface IssueBooksRepository extends JpaRepository<IssueBooksEntity, Integer> {

}
