package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InterfaceController {
	@GetMapping("/student/main")
	public String StudentInterface() {
		return "main";
	}
}
