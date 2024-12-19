package com.learning.model;


/**
 * Employee Model
 * @author Peena
 * @since 3/1/2022
 * */
public class EmployeeModel {
	private int id;
	private String password;
	private String key;
	private String fullname;
	private String position;
	private String department;
	private Double base_salary;
	private String phone;
	private String email;
	private String startdate;
	private String enddate;
	
	public EmployeeModel() {}
	
	public EmployeeModel(int id, String fullname, String position, String department, String phone, String email, 
			String startdate, String enddate) {
		this.id = id;
		this.fullname = fullname;
		this.position = position;
		this.department = department;
		this.phone = phone;
		this.email = email;
		this.startdate = startdate;
		this.enddate = enddate;
	}
	
	public EmployeeModel(String password, String key, String fullname, String position, String department, Double base_salary,
					String phone, String email, String startdate) {
		this.password = password;
		this.key = key;
		this.fullname = fullname;
		this.position = position;
		this.department = department;
		this.base_salary = base_salary;
		this.phone = phone;
		this.email = email;
		this.startdate = startdate;
	}

	public EmployeeModel(int id, String fullname, String position, String department, String phone, String email) {
		this.id = id;
		this.fullname = fullname;
		this.position = position;
		this.department = department;
		this.phone = phone;
		this.email = email;
	}
	
	public EmployeeModel(int id, String password, String key) {
		this.id = id;
		this.password = password;
		this.key = key;
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

	public Double getBase_salary() {
		return base_salary;
	}

	public void setBase_salary(Double base_salary) {
		this.base_salary = base_salary;
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

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
}
