package com.company.payroll.model;

import java.sql.Date;

/**
 * Loan Model
 * @author Peena
 * @since 3/1/2022
 * */
public class LoanModel {
	private int loan_id;
	private String reasons;
	private Double loan_amount;
	private Date issued_date;
	private String loan_status;
	private String employee_name;
	private int e_id;
	private String approvedByManager;
	
	public LoanModel() {}
	
	public LoanModel(int loan_id, String reasons, Double loan_amount, Date issued_date, 
			String loan_status, String employee_name, String approvedByManager) {
		this.loan_id = loan_id;
		this.reasons = reasons;
		this.loan_amount = loan_amount;
		this.issued_date = issued_date;
		this.loan_status = loan_status;
		this.employee_name = employee_name;
		this.approvedByManager = approvedByManager;
	}
	
	public LoanModel(String reasons, Double loan_amount, Date issued_date, String loan_status, int e_id) {
		this.reasons = reasons;
		this.loan_amount = loan_amount;
		this.issued_date = issued_date;
		this.loan_status = loan_status;
		this.e_id = e_id;
	}

	public int getLoan_id() {
		return loan_id;
	}

	public void setLoan_id(int loan_id) {
		this.loan_id = loan_id;
	}

	public String getReasons() {
		return reasons;
	}

	public void setReasons(String reasons) {
		this.reasons = reasons;
	}

	public Double getLoan_amount() {
		return loan_amount;
	}

	public void setLoan_amount(Double loan_amount) {
		this.loan_amount = loan_amount;
	}

	public Date getIssued_date() {
		return issued_date;
	}

	public void setIssued_date(Date issued_date) {
		this.issued_date = issued_date;
	}

	public String getLoan_status() {
		return loan_status;
	}

	public void setLoan_status(String loan_status) {
		this.loan_status = loan_status;
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

	public int getE_id() {
		return e_id;
	}

	public void setE_id(int e_id) {
		this.e_id = e_id;
	}
}
