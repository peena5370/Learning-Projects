package com.elibrarian.demo.model;

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
@Table(name = "e_librarian")
public class LibrariansEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lib_id")
	private Integer libId;

	@Column(name = "lib_name", nullable = false)
	private String libName;

	@Column(name = "lib_phone")
	private String libPhone;

	@Column(name = "lib_email")
	private String libEmail;

	@OneToOne
	@JoinColumn(name = "u_id")
	private UsersEntity users;

}
