package com.elibrarian.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "e_issuebooks")
public class IssueBooksEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "issue_id")
	private Integer issueid;

	@Column(name = "issued_date")
	private LocalDateTime issueddate;

	@Column(name = "return_status")
	private String returnstatus;

	@OneToOne
	@JoinColumn(name = "book_id")
	private BooksEntity books;

	@OneToOne
	@JoinColumn(name = "stud_id")
	private StudentsEntity students;
}
