package v2.com.company.payroll.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeSalary implements Serializable {
	private static final long serialVersionUID = -6506694281832594752L;
	
	private int id;
	private Double monthlySalary;
	private Double annualSalary;
	private String employeeName;
	
	public EmployeeSalary(Double monthlySalary, Double annualSalary, String employeeName) {
		this.monthlySalary = monthlySalary;
		this.annualSalary = annualSalary;
		this.employeeName = employeeName;
	}
}
