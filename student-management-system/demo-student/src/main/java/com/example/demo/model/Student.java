package com.example.demo.model;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Student implements Serializable {
	private static final long serialVersionUID = 1009170367593177196L;
	
	private int id;
	private String studName;
	private LocalDate dateOfBirth;
	private String studClass;
	private String race;
	private String nationality;
}
