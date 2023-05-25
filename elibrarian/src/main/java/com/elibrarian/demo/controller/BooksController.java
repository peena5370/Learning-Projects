package com.elibrarian.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elibrarian.demo.model.BooksEntity;
import com.elibrarian.demo.services.BooksService;

@RestController
@RequestMapping("/api/books")
public class BooksController {
	
	@Autowired
	private BooksService booksService;
	
	@PostMapping("/addbook")
	public ResponseEntity<BooksEntity> addBook(@RequestBody BooksEntity book) {
		return ResponseEntity.ok(booksService.addBook(book));
	}
	
	@GetMapping("/viewbooks")
	public ResponseEntity<List<BooksEntity>> viewBooks() {
		return ResponseEntity.ok(booksService.viewBooks());
	}
	
	@GetMapping("/viewbooks/{id}")
	public ResponseEntity<Optional<BooksEntity>> viewBookById(@PathVariable Integer id) {
		return ResponseEntity.ok(booksService.viewBookById(id));
	}
	
	@PutMapping("/updatebook")
	public ResponseEntity<BooksEntity> updateBook(@RequestBody BooksEntity book) {
		return ResponseEntity.ok(booksService.updateBook(book));
	}
	
	@DeleteMapping("/deletebook/{id}")
	public ResponseEntity<Integer> removeBook(@PathVariable Integer id) {
		return ResponseEntity.ok(booksService.removeBook(id));
	}
}
