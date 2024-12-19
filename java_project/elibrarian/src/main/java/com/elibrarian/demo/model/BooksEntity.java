package com.elibrarian.demo.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "e_books")
@EntityListeners(value = AuditingEntityListener.class)
public class BooksEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer book_id;

	@Column(name = "callno", unique = true, nullable = false)
	private String callno;

	@Column(name = "book_name", nullable = false)
	private String bookname;

	@Column(name = "author")
	private String author;

	@Column(name = "publisher")
	private String publisher;

	@Column(name = "book_quantity")
	private int bookquantity;

	@Column(name = "book_issued")
	private int bookissued;
}
