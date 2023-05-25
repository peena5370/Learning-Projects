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
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody UsersEntity user) {
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
