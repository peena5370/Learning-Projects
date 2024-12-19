package com.imooc.dmtest.test;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMTest {

	public static void main(String[] args) {
		//create DocumentBuilderFactory objects
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		//create DocumentBuilder objects
		try {
			//create DocumentBuilder objects
			DocumentBuilder db = dbf.newDocumentBuilder();
			//through DocumentBuilder object parse books.xml to existing project
			Document document = db.parse("src/books.xml");
			//get all book node collection
			NodeList bookList = document.getElementsByTagName("book");
			//from NodeList getlength() get bookList length
			System.out.println("Total have: "+ bookList.getLength() + " books.");
			//run through every book node
			for(int i = 0; i < bookList.getLength(); i++) {
//				go through item(i) to get 1 book node, nodeList search start from 0
				System.out.println("\n------Below are NO:" + (i + 1) + " book's index.------");
				 Node book = bookList.item(i);
//				 get book node all elements childnode
				 NamedNodeMap attrs = book.getAttributes();
				 System.out.println("Books No." + (i+1) + " and total have " + attrs.getLength() + " elements.");
//				 go through book elements
				 for(int j =0; j < attrs.getLength(); j++) {
//				     item(index) method to get book node selected element
					 Node attr = attrs.item(j);
//				 	 get element name
					 System.out.print("Element name are: "+ attr.getNodeName());
//					 get element value
					 System.out.println("--Element value are: " + attr.getNodeValue());
				 }
				
				//if already know book node and only have 1 id element
				//force book node to convert datatype, change to Element datatype
//				Element book = (Element) bookList.item(i);
//				//using getAttribute("id") to get element value
//				String attrValue = book.getAttribute("id");
//				System.out.println("id element value are: " + attrValue);
//				System.out.println("End of read " +(i + 1) +"th element's.");
				
				//analyse book node > childnode
				NodeList childNodes = book.getChildNodes();
				//go through childNodes and get every nodeName and nodeValue
				//java check childNodes will include spaces inside the parentNode
				System.out.println("NO:" + (i+1) + " books have " + childNodes.getLength() + "child nodes.");
				for(int k =0; k < childNodes.getLength(); k ++) {
					//#text is empty space in xml(TEXT_NODE),count as 1 node
					//differentiate text datatype node and element type node
					if(childNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
						//will print out elementNode
						System.out.println("NO:" + (k + 1) + "th node name is: " + childNodes.item(k).getNodeName());
						//need to get FirstChild then getNodeValue, if not will throw null
						System.out.println("Node value are: " + (childNodes.item(k).getFirstChild().getNodeValue()));
						//same function as .getTextContext() = .getFirstChild().getNodeValue()
						//got different if childNode inside still have another childNode
						//getTextContent() will read together all the nodeValue, getFirstChild().getNodeValue() will throw null
//						System.out.println("Node value are: " + (childNodes.item(k).getTextContent()));
					}
					
				}
				System.out.println("End of read " +(i + 1) +"th element's.");
			}
		}
		catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
