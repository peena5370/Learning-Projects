package v2.com.company.payroll.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeSalaryModel implements Serializable {
	private static final long serialVersionUID = -6506694281832594752L;
	
	private int id;
	private Double monthlySalary;
	private Double annualSalary;
	private String employeeName;
	
	public EmployeeSalaryModel() {}
	
	public EmployeeSalaryModel(Double monthlySalary, Double annualSalary, String employeeName) {
		this.monthlySalary = monthlySalary;
		this.annualSalary = annualSalary;
		this.employeeName = employeeName;
	}
}
