package com.elibrarian.demo.services.impl;

import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elibrarian.demo.model.LibrariansEntity;
import com.elibrarian.demo.repos.LibrariansRepository;
import com.elibrarian.demo.services.LibrariansService;

@Slf4j
@Service
public class LibrariansServiceImpl implements LibrariansService {

	private final LibrariansRepository librariansRepository;

    @Autowired
    public LibrariansServiceImpl(LibrariansRepository librariansRepository) {
        this.librariansRepository = librariansRepository;
    }
	
	@Override
	public LibrariansEntity addLibrarian(LibrariansEntity librarian) {
		return librariansRepository.saveAndFlush(librarian);
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
		return librariansRepository.saveAndFlush(librarian);
	}

	@Override
	public int removeLibrarian(Integer libId) {
        int row = 0;
		try {
			librariansRepository.deleteById(libId);
			row = 1;
		} catch(IllegalArgumentException e) {
			log.error("Exception encountered when remove librarian: {}", e.getMessage());
		}
		
		return row;
	}

}
