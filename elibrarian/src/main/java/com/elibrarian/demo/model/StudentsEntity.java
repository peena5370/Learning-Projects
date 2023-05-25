package com.elibrarian.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "e_students")
public class StudentsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stud_id")
	private Integer studId;

	@Column(name = "stud_name", nullable = false)
	private String studName;

	@Column(name = "stud_phone")
	private String studPhone;

	@Column(name = "stud_email")
	private String studEmail;
}
