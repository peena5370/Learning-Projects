package com.imooc.dom4jtest;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class DOM4JTest {

	public static void main(String[] args) {
		//analyse books.xml 
		//create SAXReader reader object
		SAXReader reader = new SAXReader();
		//
		try {
			//through reader object use read method to load books.xml file and sent to document object 
			Document document = reader.read(new File("src/res/books.xml"));
			//through document object to get parent node(bookstore)
			Element bookStore = document.getRootElement();
			//through iterator method to get "diedaiqi"
			Iterator it = bookStore.elementIterator();
			//read through diedaiqi, get parent node source
			while(it.hasNext()) {
				System.out.println("=====Start to analyse book =====");
				Element book = (Element) it.next();
				//get book element name and value
				List<Attribute> bookAttrs = book.attributes();
				for(Attribute attr : bookAttrs) {
					System.out.println("Element name: " + attr.getName() + " --- Element value: " + attr.getValue());
				}
				Iterator itt = book.elementIterator();
				while(itt.hasNext()) {
					Element bookChild = (Element) itt.next();
					System.out.println("Child node name is: "+ bookChild.getName() + " --- Child node value is: " + bookChild.getStringValue());
				}
				System.out.println("=====End of analyse book =====");
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
//	use for calculate runtime
//	@Test
//	public void testPerformance() throws Exception {
//		long start = System.currentTimeMillis();
//		domXmlParser();
//		System.out.println("DOM time: " + (System.currentTimeMillis() - start));
//	}

}
