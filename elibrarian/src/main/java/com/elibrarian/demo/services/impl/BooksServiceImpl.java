package com.elibrarian.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elibrarian.demo.model.BooksEntity;
import com.elibrarian.demo.repos.BooksRepository;
import com.elibrarian.demo.services.BooksService;

@Service
public class BooksServiceImpl implements BooksService {
	
	@Autowired
	private BooksRepository booksRepository;

	@Override
	public BooksEntity addBook(BooksEntity book) {
		BooksEntity savedEntity = booksRepository.save(book);
		booksRepository.flush();
		
		return savedEntity;
	}

	@Override
	public List<BooksEntity> viewBooks() {
		return booksRepository.findAll();
	}

	@Override
	public Optional<BooksEntity> viewBookById(Integer book_id) {
		return booksRepository.findById(book_id);
	}

	@Override
	public BooksEntity updateBook(BooksEntity book) {
		BooksEntity updatedEntity = booksRepository.save(book);
		booksRepository.flush();
		
		return updatedEntity;
	}

	@Override
	public Integer removeBook(Integer book_id) {
		Integer row = 0;
		try {
			booksRepository.deleteById(book_id);
			row = 1;
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
			row = 0;
		}
		
		return row;
	}

}
