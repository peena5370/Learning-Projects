package com.librarian.elibrarian.model;

/**
 * Librarian entity
 * @param 	lib_id
 * 			Librarian ID
 * @param	lib_name
 * 			Librarian name
 * @param	lib_email
 * 			Librarian email
 * @param	lib_pass
 * 			Librarian password
 * @param	lib_phone
 * 			Librarian phone number
 * */
public class Librarian {
	private int lib_id;
	private String lib_name;
	private String lib_email;
	private String lib_pass;
	private String lib_phone;
	
	public Librarian() {}
	
	public Librarian(int lib_id, String lib_name, String lib_email, String lib_pass, String lib_phone) {
		this.lib_id = lib_id;
		this.lib_name = lib_name;
		this.lib_email = lib_email;
		this.lib_pass = lib_pass;
		this.lib_phone = lib_phone;
	}
	
	public Librarian(String lib_name, String lib_email, String lib_pass, String lib_phone) {
		this.lib_name = lib_name;
		this.lib_email = lib_email;
		this.lib_pass = lib_pass;
		this.lib_phone = lib_phone;
	}

	public int getLib_id() {
		return lib_id;
	}

	public void setLib_id(int lib_id) {
		this.lib_id = lib_id;
	}

	public String getLib_name() {
		return lib_name;
	}

	public void setLib_name(String lib_name) {
		this.lib_name = lib_name;
	}

	public String getLib_email() {
		return lib_email;
	}

	public void setLib_email(String lib_email) {
		this.lib_email = lib_email;
	}

	public String getLib_pass() {
		return lib_pass;
	}

	public void setLib_pass(String lib_pass) {
		this.lib_pass = lib_pass;
	}

	public String getLib_phone() {
		return lib_phone;
	}

	public void setLib_phone(String lib_phone) {
		this.lib_phone = lib_phone;
	}
}
