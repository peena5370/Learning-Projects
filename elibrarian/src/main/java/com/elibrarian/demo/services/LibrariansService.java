package com.elibrarian.demo.services;

import java.util.List;
import java.util.Optional;

import com.elibrarian.demo.model.LibrariansEntity;

public interface LibrariansService {
	LibrariansEntity addLibrarian(LibrariansEntity librarian);
	
	List<LibrariansEntity> viewLibrarians();
	
	Optional<LibrariansEntity> viewLibrarianById(Integer libId);
	
	LibrariansEntity updateLibrarian(LibrariansEntity librarian);
	
	Integer removeLibrarian(Integer libId);
}
