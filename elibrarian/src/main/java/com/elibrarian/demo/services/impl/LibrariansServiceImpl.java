package com.elibrarian.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elibrarian.demo.model.LibrariansEntity;
import com.elibrarian.demo.repos.LibrariansRepository;
import com.elibrarian.demo.services.LibrariansService;

@Service
public class LibrariansServiceImpl implements LibrariansService {

	@Autowired
	private LibrariansRepository librariansRepository;
	
	@Override
	public LibrariansEntity addLibrarian(LibrariansEntity librarian) {
		LibrariansEntity savedEntity = librariansRepository.save(librarian);
		librariansRepository.flush();
		
		return savedEntity;
	}

	@Override
	public List<LibrariansEntity> viewLibrarians() {
		return librariansRepository.findAll();
	}

	@Override
	public Optional<LibrariansEntity> viewLibrarianById(Integer libId) {
		return librariansRepository.findById(libId);
	}

	@Override
	public LibrariansEntity updateLibrarian(LibrariansEntity librarian) {
		LibrariansEntity updatedEntity = librariansRepository.save(librarian);
		librariansRepository.flush();
		
		return updatedEntity;
	}

	@Override
	public Integer removeLibrarian(Integer libId) {
		Integer row = 0;
		try {
			librariansRepository.deleteById(libId);
			row = 1;
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
			row = 0;
		}
		
		return row;
	}

}
