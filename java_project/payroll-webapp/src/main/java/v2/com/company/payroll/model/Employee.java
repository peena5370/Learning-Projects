package v2.com.company.payroll.model;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Employee implements Serializable {
	private static final long serialVersionUID = -4886691213315244145L;
	
	private int id;
	private String fullname;
	private String gender;
	private int age;
	private String martialStatus;
	private String education;
	private String address;
	private String state;
	private String country;
	private String phone;
	private String email;
	private LocalDate dateHired;
	private LocalDate dateQuit;
	private String department;
	private String hirer;
	private String title;
	private int account_id;
	private String username;
	private String dateCreated;
	private String dateChanged;
	
	public Employee(String fullname, String gender, int age, String martialStatus, String education, String address, String state, String country, String phone, String email, 
			LocalDate dateHired, LocalDate dateQuit, String username, String department, String hirer, String title) {
		this.fullname = fullname;
		this.gender = gender;
		this.age = age;
		this.martialStatus = martialStatus;
		this.education = education;
		this.address = address;
		this.state = state;
		this.country = country;
		this.phone = phone;
		this.email = email;
		this.dateHired = dateHired;
		this.dateQuit = dateQuit;
		this.username = username;
		this.department = department;
		this.hirer = hirer;
		this.title = title;
	}
	
	public Employee(int id, String fullname, String gender, int age, String martialStatus, String education, String address, String state, String country, String phone, String email) {
		this.id = id;
		this.fullname = fullname;
		this.gender = gender;
		this.age = age;
		this.martialStatus = martialStatus;
		this.education = education;
		this.address = address;
		this.state = state;
		this.country = country;
		this.phone = phone;
		this.email = email;
	}
}
