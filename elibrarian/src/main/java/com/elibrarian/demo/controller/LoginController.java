package com.elibrarian.demo.controller;

//import java.util.List;
import java.util.Optional;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elibrarian.demo.model.UsersEntity;
import com.elibrarian.demo.services.UsersService;

@RestController
@RequestMapping("/api")
public class LoginController {
	
	@Autowired
	private UsersService usersService;
	
//	private LibrariansRepository librarianRepository;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody UsersEntity user) {
//		Librarian librarian = new Librarian(2, "lib name one two", "libmail1@email.com", "password123", "secretkey123", "1234567890");
		
		// insert to table is id not exist, else update the table if id exist
//		librarianRepository.save(librarian);
//		librarianRepository.flush();
		
//		Librarian librarian2 = new Librarian(3, "lib name one two1", "libmail1@email.com", "password123", "secretkey123", "1234567890");
//		Librarian librarian3 = new Librarian(4, "lib name one two2", "libmail1@email.com", "password123", "secretkey123", "1234567890");
//		Librarian librarian4 = new Librarian(5, "lib name one two3", "libmail1@email.com", "password123", "secretkey123", "1234567890");
		
		// insert all to table, similar as save() method
//		librarianRepository.saveAll(Stream.of(librarian2, librarian3, librarian4).collect(Collectors.toList()));
//		librarianRepository.flush();
//		List<LibrariansEntity> list = librarianRepository.findAll();
//		
//		for(LibrariansEntity libra: list) {
//			System.out.println("librarian: " + libra);
//		}
		
//		Optional<Librarian> lib = librarianRepository.findById(3);
		
//		return list;
		
		Optional<UsersEntity> userEntity = usersService.viewUserByUsername(user.getUsername());
		
		if(!userEntity.isPresent()) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("no such user");
		} else {
			UsersEntity entity = userEntity.get();
			if(entity.getUsername().equals("administrator")) {
				return ResponseEntity.ok("redirect to admin page");
			} else {
				return ResponseEntity.ok("redirect to librarian page");
			}
		}
	}
	
	@PostMapping("/logout")
	public ResponseEntity<String> logout() {
		return ResponseEntity.ok("logout");
	}
}
