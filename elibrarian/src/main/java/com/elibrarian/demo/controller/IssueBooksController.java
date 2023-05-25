package com.elibrarian.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elibrarian.demo.model.IssueBooksEntity;
import com.elibrarian.demo.services.IssueBooksService;

@RestController
@RequestMapping("/api/issuebook")
public class IssueBooksController {
	
	@Autowired
	private IssueBooksService issueBooksService;
	
	@PostMapping("/addissuebook")
	public ResponseEntity<IssueBooksEntity> issueBook(@RequestBody IssueBooksEntity issueBook) {
		return ResponseEntity.ok(issueBooksService.issueBook(issueBook));
	}
	
	@GetMapping("/viewissuebook")
	public ResponseEntity<List<IssueBooksEntity>> viewIssueBooks() {
		return ResponseEntity.ok(issueBooksService.viewIssueBooks());
	}
	
	@GetMapping("/viewissuebook/{id}")
	public ResponseEntity<Optional<IssueBooksEntity>> viewIssueBooksById(@PathVariable Integer id) {
		return ResponseEntity.ok(issueBooksService.viewIssueBookById(id));
	}
	
	@PutMapping("/returnbook")
	public ResponseEntity<IssueBooksEntity> returnBook(@RequestBody IssueBooksEntity issueBook) {
		return ResponseEntity.ok(issueBooksService.returnBook(issueBook));
	}
}
