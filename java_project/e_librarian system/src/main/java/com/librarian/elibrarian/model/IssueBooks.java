package com.librarian.elibrarian.model;

/**
 * Issue Book entity
 * */
public class IssueBooks {
	private String callno;
	private String stud_id;
	private String stud_name;
	private String stud_phone;
	private String issueddate;
	private String returnstatus;
	
	public IssueBooks() {}
	
	public IssueBooks(String callno, String stud_id, String stud_name, String stud_phone) {
		this.callno = callno;
		this.stud_id = stud_id;
		this.stud_name = stud_name;
		this.stud_phone = stud_phone;
	}

	public String getCallno() {
		return callno;
	}

	public void setCallno(String callno) {
		this.callno = callno;
	}

	public String getStud_id() {
		return stud_id;
	}

	public void setStud_id(String stud_id) {
		this.stud_id = stud_id;
	}

	public String getStud_name() {
		return stud_name;
	}

	public void setStud_name(String stud_name) {
		this.stud_name = stud_name;
	}

	public String getStud_phone() {
		return stud_phone;
	}

	public void setStud_phone(String stud_phone) {
		this.stud_phone = stud_phone;
	}

	public String getIssueddate() {
		return issueddate;
	}

	public void setIssueddate(String issueddate) {
		this.issueddate = issueddate;
	}

	public String getReturnstatus() {
		return returnstatus;
	}

	public void setReturnstatus(String returnstatus) {
		this.returnstatus = returnstatus;
	}
	
}
