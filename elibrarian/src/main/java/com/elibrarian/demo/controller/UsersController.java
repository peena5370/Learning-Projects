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

import com.elibrarian.demo.model.UsersEntity;
import com.elibrarian.demo.services.UsersService;

@RestController
@RequestMapping("/api/users")
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	@PostMapping("/adduser")
	public ResponseEntity<UsersEntity> addUser(@RequestBody UsersEntity user) {
		return ResponseEntity.ok(usersService.addUser(user));
	}
	
	@GetMapping("/viewuser")
	public ResponseEntity<List<UsersEntity>> viewUsers() {
		return ResponseEntity.ok(usersService.viewUsers());
	}
	
	@GetMapping("/viewuser/{id}")
	public ResponseEntity<Optional<UsersEntity>> viewUserById(@PathVariable Integer id) {
		return ResponseEntity.ok(usersService.viewUserById(id));
	}
	
	@PutMapping("/updateuser")
	public ResponseEntity<UsersEntity> updateUser(@RequestBody UsersEntity user) {
		return ResponseEntity.ok(usersService.updateUser(user));
	}
	
	@DeleteMapping("/deleteuser/{id}")
	public ResponseEntity<Integer> removeUser(@PathVariable Integer id) {
		return ResponseEntity.ok(usersService.removeUser(id));
	}
}
