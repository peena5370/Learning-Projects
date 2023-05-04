package com.learning.model;

/**
 * Book entity
 * @param callno, bookname, author, publisher, bookquantity, bookissued
 * */
public class Books {
	private String callno;
	private String bookname;
	private String author;
	private String publisher;
	private int bookquantity;
	private int bookissued;
	
	public Books() {}
	
	public Books(String callno, String bookname, String author, String publisher, int bookquantity) {
		this.callno = callno;
		this.bookname = bookname;
		this.author = author;
		this.publisher = publisher;
		this.bookquantity = bookquantity;
	}

	public String getCallno() {
		return callno;
	}

	public void setCallno(String callno) {
		this.callno = callno;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getBookquantity() {
		return bookquantity;
	}

	public void setBookquantity(int bookquantity) {
		this.bookquantity = bookquantity;
	}

	public int getBookissued() {
		return bookissued;
	}

	public void setBookissued(int bookissued) {
		this.bookissued = bookissued;
	}
	
}
