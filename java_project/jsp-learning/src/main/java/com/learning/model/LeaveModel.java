package com.learning.model;

/**
 * Leave Model
 * @author Peena
 * @since 3/1/2022
 * */
public class LeaveModel {
	private int l_id;
	private String reasons;
	private String date_from;
	private String date_to;
	private String leave_type;
	private String status;
	private String employee_name;
	private String approvedByManager;
	private int e_id;
	
	public LeaveModel() {}
	
	public LeaveModel(int l_id, String reasons, String date_from, String date_to, String leave_type, String status, 
			String employee_name, String approvedByManager) {
		this.l_id = l_id;
		this.reasons = reasons;
		this.date_from = date_from;
		this.date_to = date_to;
		this.leave_type = leave_type;
		this.status = status;
		this.employee_name = employee_name;
		this.approvedByManager = approvedByManager;
	}

	public LeaveModel(String reasons, String date_from, String date_to, String leave_type, String status,
			String approvedByManager) {
		this.reasons = reasons;
		this.date_from = date_from;
		this.date_to = date_to;
		this.leave_type = leave_type;
		this.status = status;
		this.approvedByManager = approvedByManager;
	}

	public LeaveModel(String reasons, String date_from, String date_to, String leave_type, String status,
			int e_id) {
		this.reasons = reasons;
		this.date_from = date_from;
		this.date_to = date_to;
		this.leave_type = leave_type;
		this.status = status;
		this.e_id = e_id;
	}

	public int getL_id() {
		return l_id;
	}

	public void setL_id(int l_id) {
		this.l_id = l_id;
	}

	public String getReasons() {
		return reasons;
	}

	public void setReasons(String reasons) {
		this.reasons = reasons;
	}

	public String getDate_from() {
		return date_from;
	}

	public void setDate_from(String date_from) {
		this.date_from = date_from;
	}

	public String getDate_to() {
		return date_to;
	}

	public void setDate_to(String date_to) {
		this.date_to = date_to;
	}

	public String getLeave_type() {
		return leave_type;
	}

	public void setLeave_type(String leave_type) {
		this.leave_type = leave_type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
