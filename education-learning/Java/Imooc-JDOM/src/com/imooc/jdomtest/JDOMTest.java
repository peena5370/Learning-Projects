package com.imooc.jdomtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.imooc.dmtest.entity.Book;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;

public class JDOMTest {
	private static ArrayList<Book> newBookList = new ArrayList<Book>();

	public static void main(String[] args) {
		// JDOM analyse books.xml
		// preparing
		// 1. create SAXBuilder object
		SAXBuilder saxBuilder = new SAXBuilder();
		// 2.create input stream to let xml file load to inputstream
		InputStream in;
		try {
			in = new FileInputStream("src/res/books.xml");
			//for solving code unreadable, use to convert and change to UTF-8 for support other languages text
			InputStreamReader isr = new InputStreamReader(in, "UTF-8");
			// 3. use saxBuilder build method, let inputstream add to saxBuilder
			Document document = saxBuilder.build(isr);
			// 4. through document object get xml file parent node
			Element rootElement = document.getRootElement();
			// 5. get child node from parent node
			List<Element> bookList = rootElement.getChildren();
			// 6. continue to analyse
			for (Element book : bookList) {
				Book bookEntity = new Book();
				System.out.println("======Start to analyse no." + (bookList.indexOf(book) + 1) + " of book.=====");
				//analyse book element
				List<Attribute> attrList = book.getAttributes();
				//for known book node there got what name
//				book.getAttributeValue("id");
				//alalyse attrList(for analyse unknown book node there got what name and quantity)
				for(Attribute attr : attrList) {
					//get element name
					String attrName = attr.getName();
					//get lement value
					String attrValue = attr.getValue();
					System.out.println("Element name are: " + attrName + " --- Element value are: " + attrValue);
					if(attrName.equals("id")) {
						bookEntity.setId(attrValue);
					}
				}
				//parent node(book) >> child node get child node name and value
				List<Element> bookChilds = book.getChildren();
				for(Element child : bookChilds) {
					System.out.println("Child node are: "+ child.getName() + " --- Child node value are: " + child.getValue());
					if(child.getName().equals("name")) {
						bookEntity.setName(child.getValue());
					}
					else if(child.getName().equals("author")) {
						bookEntity.setAuthor(child.getValue());
					}
					else if(child.getName().equals("year")) {
						bookEntity.setYear(child.getValue());
					}
					else if(child.getName().equals("price")) {
						bookEntity.setPrice(child.getValue());
					}
					else if(child.getName().equals("language")) {
						bookEntity.setLanguage(child.getValue());
					}
				}
				System.out.println("======Ending of analysis book's no." + (bookList.indexOf(book) + 1) + ".=====");
				newBookList.add(bookEntity);
				bookEntity = null;
				System.out.println(newBookList.size());
				System.out.println(newBookList.get(0).getId());
				System.out.println(newBookList.get(0).getName());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
