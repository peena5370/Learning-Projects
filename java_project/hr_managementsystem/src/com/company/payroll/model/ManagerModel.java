package com.company.payroll.model;

/**
 * Manager model
 * @author Peena
 * @since 3/1/2022
 * */
public class ManagerModel {
	private int id;
	private String password;
	private String key;
	private String role;
	private String fullname;
	private String position;
	private String department;
	private String phone;
	private String email;
	
	public ManagerModel() {}
	
	public ManagerModel(int id, String fullname, String role, String position, String department, 
			String phone, String email) {
		this.id = id;
		this.role = role;
		this.fullname = fullname;
		this.position = position;
		this.department = department;
		this.phone = phone;
		this.email = email;
	}
	
	public ManagerModel(String password, String key, String role, String fullname, String position, 
			String department, String phone, String email) {
			this.password = password;
			this.key = key;
			this.role = role;
			this.fullname = fullname;
			this.position = position;
			this.department = department;
			this.phone = phone;
			this.email = email;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
