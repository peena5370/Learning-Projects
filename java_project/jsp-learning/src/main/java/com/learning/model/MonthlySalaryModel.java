package com.learning.model;

import java.sql.Date;

/**
 * Monthly Salary Model
 * @author Peena
 * @since 3/1/2022
 * */
public class MonthlySalaryModel {
	private int monthlysalary_id;
	private Double current_salary;
	private Double overtime_pay;
	private Double deduction;
	private Double total_salary;
	private String employee_name;
	private String approvedByManager;
	private Date payment_date;
	
	public MonthlySalaryModel() {}
	
	public MonthlySalaryModel(int monthlysalary_id, Double current_salary, Double overtime_pay, Double deduction, 
			Double total_salary, String employee_name, String approvedByManager, Date payment_date) {
		this.monthlysalary_id = monthlysalary_id;
		this.current_salary = current_salary;
		this.overtime_pay = overtime_pay;
		this.deduction = deduction;
		this.total_salary = total_salary;
		this.employee_name = employee_name;
		this.approvedByManager = approvedByManager;
		this.payment_date = payment_date;
	}

	public MonthlySalaryModel(Double current_salary, Double overtime_pay, Double deduction, Double total_salary, 
			String employee_name, String approvedByManager, Date payment_date) {
		this.current_salary = current_salary;
		this.overtime_pay = overtime_pay;
		this.deduction = deduction;
		this.total_salary = total_salary;
		this.employee_name = employee_name;
		this.approvedByManager = approvedByManager;
		this.payment_date = payment_date;
	}
	
	public MonthlySalaryModel(int monthlysalary_id, Double current_salary, Double overtime_pay, Double deduction,
			Double total_salary, Date payment_date, String approvedByManager) {
		this.monthlysalary_id = monthlysalary_id;
		this.current_salary = current_salary;
		this.overtime_pay = overtime_pay;
		this.deduction = deduction;
		this.total_salary = total_salary;
		this.approvedByManager = approvedByManager;
		this.payment_date = payment_date;
	}

	public int getMonthlysalary_id() {
		return monthlysalary_id;
	}

	public void setMonthlysalary_id(int monthlysalary_id) {
		this.monthlysalary_id = monthlysalary_id;
	}

	public Double getCurrent_salary() {
		return current_salary;
	}

	public void setCurrent_salary(Double current_salary) {
		this.current_salary = current_salary;
	}

	public Double getOvertime_pay() {
		return overtime_pay;
	}

	public void setOvertime_pay(Double overtime_pay) {
		this.overtime_pay = overtime_pay;
	}

	public Double getDeduction() {
		return deduction;
	}

	public void setDeduction(Double deduction) {
		this.deduction = deduction;
	}

	public Double getTotal_salary() {
		return total_salary;
	}

	public void setTotal_salary(Double total_salary) {
		this.total_salary = total_salary;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getApprovedByManager() {
		return approvedByManager;
	}

	public void setApprovedByManager(String approvedByManager) {
		this.approvedByManager = approvedByManager;
	}

	public Date getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}
		
}
