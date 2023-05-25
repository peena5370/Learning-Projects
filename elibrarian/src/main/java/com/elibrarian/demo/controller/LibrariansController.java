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

import com.elibrarian.demo.model.LibrariansEntity;
import com.elibrarian.demo.services.LibrariansService;

@RestController
@RequestMapping("/api/librarian")
public class LibrariansController {
	
	@Autowired
	private LibrariansService librariansService;
	
	@PostMapping("/addlibrarian")
	public ResponseEntity<LibrariansEntity> addLibrarian(@RequestBody LibrariansEntity librarian) {
		return ResponseEntity.ok(librariansService.addLibrarian(librarian));
	}
	
	@GetMapping("/viewlibrarian")
	public ResponseEntity<List<LibrariansEntity>> viewLibrarians() {
		return ResponseEntity.ok(librariansService.viewLibrarians());
	}
	
	@GetMapping("/viewlibrarian/{id}")
	public ResponseEntity<Optional<LibrariansEntity>> viewLibrarianById(@PathVariable Integer id) {
		return ResponseEntity.ok(librariansService.viewLibrarianById(id));
	}
	
	@PutMapping("/updatelibrarian")
	public ResponseEntity<LibrariansEntity> updateLibrarian(@RequestBody LibrariansEntity librarian) {
		return ResponseEntity.ok(librariansService.updateLibrarian(librarian));
	}
	
	@DeleteMapping("/deletelibrarian/{id}")
	public ResponseEntity<Integer> removeLibrarian(@PathVariable Integer id) {
		return ResponseEntity.ok(librariansService.removeLibrarian(id));
	}
}
