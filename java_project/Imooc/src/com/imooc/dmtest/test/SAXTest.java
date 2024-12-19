package com.imooc.dmtest.test;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

import com.imooc.dmtest.entity.Book;
import com.imooc.dmtest.handler.SAXParserHandler;

public class SAXTest {

	public static void main(String[] args) {
		//acquire SAXParserFactory example
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//through factory get SAXParser
		try {
			SAXParser parser = factory.newSAXParser();
			//create SAXParserHandler object
			SAXParserHandler handler = new SAXParserHandler();
			parser.parse("src/books.xml", handler);
			System.out.println(" - - - Total have: " + handler.getBookList().size() + " books.");
			
			for(Book book : handler.getBookList()) {
				System.out.println(book.getId());
				System.out.println(book.getName());
				System.out.println(book.getAuthor());
				System.out.println(book.getYear());
				System.out.println(book.getPrice());
				System.out.println(book.getLanguage());
				System.out.println(" --- Finish ---");
			}
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
