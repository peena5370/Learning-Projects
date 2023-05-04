package com.imooc.dmtest.handler;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.imooc.dmtest.entity.Book;

public class SAXParserHandler extends DefaultHandler {
	
	String value = null;
	Book book = null;
	private ArrayList<Book> bookList = new ArrayList<Book>();
	
	public ArrayList<Book> getBookList() {
		return bookList;
	}
	//use to run through startElement in xml
	//and analyse element in xml
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes)
			throws SAXException {
		//use DefaultHandler class startElement method
		super.startElement(uri, localName, qName, attributes);
		//start to analyse book element
		if(qName.equals("book")) {
				//create book object
			book = new Book();
//					String value = attributes.getValue("id"); //get book element id value
//					System.out.println("book element value is: " + value);
					//if dont recognize book element name, how to get element name and element value
					int num = attributes.getLength();
					for(int i = 0; i < num; i++) {
						System.out.println("book No." + (i + 1) + "th element name is: " + attributes.getQName(i));
						System.out.println("---element value is: " + attributes.getValue(i));
						
						if(attributes.getQName(i).equals("id")) {
							book.setId(attributes.getValue(i));
						}
					}
		}
		else if(!qName.contentEquals("book") && !qName.equals("bookstore")) {
			System.out.print("parent node is: " + qName + "---");
		}
		//when qName.equals("name"),setName to book object
		
	}
	//use to run through endElement in xml
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		super.endElement(uri, localName, qName);
		
		if(qName.equals("book")) {
			bookList.add(book);
			book = null;
			System.out.println("--- End of reading one book contents. ---");
		}
		else if(qName.equals("name")) {
			book.setName(value);
		}
		else if(qName.equals("author")) {
			book.setAuthor(value);
		}
		else if(qName.equals("year")) {
			book.setYear(value);
		}
		else if(qName.equals("price")) {
			book.setPrice(value);
		}
		else if(qName.equals("language")) {
			book.setLanguage(value);
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) 
		throws SAXException {
			super.characters(ch, start, length);
			value = new String(ch, start, length);
			if(!value.trim().equals("")) {
				System.out.println("node value is: " + value);
			}
		}

	//use to mark analyze startup 
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		System.out.println("SAX analysis start.");
	}
	//use to mark analyze end
	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
		System.out.println("SAX analysis end.");
	}

}
