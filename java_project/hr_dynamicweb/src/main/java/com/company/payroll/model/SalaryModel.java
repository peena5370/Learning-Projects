package com.company.payroll.model;

/**
 * Salary Model
 * @author Peena
 * @since 3/1/2022
 * */
public class SalaryModel {
	private int s_id;
	private Double base_salary;
	private Double incremented_salary;
	private String increment_date;
	private String employee_name;
	private String issuedByManager;
	
	public SalaryModel() {}
	
	public SalaryModel(int s_id, Double base_salary, Double incremented_salary, String increment_date, 
			String employee_name, String issuedByManager) {
		this.s_id = s_id;
		this.base_salary = base_salary;
		this.incremented_salary = incremented_salary;
		this.increment_date = increment_date;
		this.employee_name = employee_name;
		this.issuedByManager = issuedByManager;
	}
	
	public SalaryModel(Double incremented_salary, String increment_date, String employee_name, String issuedByManager) {
		this.incremented_salary = incremented_salary;
		this.increment_date = increment_date;
		this.employee_name = employee_name;
		this.issuedByManager = issuedByManager;
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public Double getBase_salary() {
		return base_salary;
	}

	public void setBase_salary(Double base_salary) {
		this.base_salary = base_salary;
	}

	public Double getIncremented_salary() {
		return incremented_salary;
	}

	public void setIncremented_salary(Double incremented_salary) {
		this.incremented_salary = incremented_salary;
	}

	public String getIncrement_date() {
		return increment_date;
	}

	public void setIncrement_date(String increment_date) {
		this.increment_date = increment_date;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getIssuedByManager() {
		return issuedByManager;
	}

	public void setIssuedByManager(String issuedByManager) {
		this.issuedByManager = issuedByManager;
	}
	
}
