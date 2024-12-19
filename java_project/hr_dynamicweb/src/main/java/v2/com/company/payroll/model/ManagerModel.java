package v2.com.company.payroll.model;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ManagerModel implements Serializable {
	private static final long serialVersionUID = -5540512927020995426L;
	
	private int id;
	private String fullname;
	private String role;
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
	private String title;
	private String department;
	private int account_id;
	private String username;
	private String dateCreated;
	private String dateChanged;
	
	public ManagerModel(String fullname, String role, String gender, int age, String martialStatus, String education, String address, String state, String country, String phone, String email,
					LocalDate dateHired, LocalDate dateQuit, String username, String department, String title) {
		this.fullname = fullname;
		this.role = role;
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
		this.title = title;
	}
	
	public ManagerModel(int id, String fullname, String gender, int age, String martialStatus, String education, String address, String state, String country, String phone, String email) {
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
