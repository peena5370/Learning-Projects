package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
* InterfaceController which used to loads html contents.
* @author Caroline Lee
* Created on 13-05-2022
**/
@Controller
public class InterfaceController {
	@GetMapping("/student/main")
	public String StudentInterface() {
		return "main";
	}
}
