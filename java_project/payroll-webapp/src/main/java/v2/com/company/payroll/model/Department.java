package v2.com.company.payroll.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Department implements Serializable {
	private static final long serialVersionUID = 6170243857431656421L;
	
	private int id;
	private String departmentName;
	private String location;
	private String state;
	private String country;
	
	public Department(String departmentName, String location, String state, String country) {
		this.departmentName = departmentName;
		this.location = location;
		this.state = state;
		this.country = country;
	}
}
