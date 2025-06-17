package com.imooc.dom.helper;

import com.imooc.dom.handler.SAXParserHandler;
import com.imooc.dom.model.Book;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DOMHelper {

    private DOMHelper() {

    }

    /**
     * Method of iterating the whole xml attributes by using dom4j library
     *
     * @param xmlFilePath XML file path to be imported
     * @throws DocumentException
     */
    public static void dom4jXmlParser(String xmlFilePath) throws DocumentException {
        //create SAXReader reader object
        SAXReader reader = new SAXReader();
        //through reader object use read method to load books.xml file and sent to document object
        Document document = reader.read(new File(xmlFilePath));
        //through document object to get parent node(bookstore)
        Element bookStore = document.getRootElement();
        //through iterator method to get "diedaiqi"
        Iterator<Element> it = bookStore.elementIterator();
        //read through diedaiqi, get parent node source
        while (it.hasNext()) {
            System.out.println("=====Start to analyse book =====");
            Element book = it.next();
            //get book element name and value
            List<Attribute> bookAttrs = book.attributes();
            for (Attribute attr : bookAttrs) {
                System.out.println("Element name: " + attr.getName() + " --- Element value: " + attr.getValue());
            }
            Iterator<Element> itt = book.elementIterator();
            while (itt.hasNext()) {
                Element bookChild = itt.next();
                System.out.println("Child node name is: " + bookChild.getName() + " --- Child node value is: " + bookChild.getStringValue());
            }
            System.out.println("=====End of analyse book =====");
        }
    }

    /**
     * XML DOM with SAXParser
     *
     * @param xmlFilePath
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    public static void domSAXParser(String xmlFilePath) throws ParserConfigurationException, SAXException,
            IOException {
        //acquire SAXParserFactory example
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        //create SAXParserHandler object
        SAXParserHandler handler = new SAXParserHandler();
        parser.parse(xmlFilePath, handler);
        System.out.println(" - - - Total have: " + handler.getBookList().size() + " books.");

        for (Book book : handler.getBookList()) {
            System.out.println(book.getId());
            System.out.println(book.getName());
            System.out.println(book.getAuthor());
            System.out.println(book.getYear());
            System.out.println(book.getPrice());
            System.out.println(book.getLanguage());
            System.out.println(" --- Finish ---");
        }
    }

    public static void domParser(String xmlFilePath) throws ParserConfigurationException, SAXException,
            IOException {
        //create DocumentBuilderFactory objects
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        //create DocumentBuilder objects
        //create DocumentBuilder objects
        DocumentBuilder db = dbf.newDocumentBuilder();
        //through DocumentBuilder object parse books.xml to existing project
        org.w3c.dom.Document document = db.parse(xmlFilePath);
        //get all book node collection
        NodeList bookList = document.getElementsByTagName("book");
        //from NodeList getlength() get bookList length
        System.out.println("Total have: " + bookList.getLength() + " books.");
        //run through every book node
        for (int i = 0; i < bookList.getLength(); i++) {
//				go through item(i) to get 1 book node, nodeList search start from 0
            System.out.println("\n------Below are NO:" + (i + 1) + " book's index.------");
            Node book = bookList.item(i);
//				 get book node all elements childnode
            NamedNodeMap attrs = book.getAttributes();
            System.out.println("Books No." + (i + 1) + " and total have " + attrs.getLength() + " elements.");
//				 go through book elements
            for (int j = 0; j < attrs.getLength(); j++) {
//				     item(index) method to get book node selected element
                Node attr = attrs.item(j);
//				 	 get element name
                System.out.print("Element name are: " + attr.getNodeName());
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
            System.out.println("NO:" + (i + 1) + " books have " + childNodes.getLength() + "child nodes.");
            for (int k = 0; k < childNodes.getLength(); k++) {
                //#text is empty space in xml(TEXT_NODE),count as 1 node
                //differentiate text datatype node and element type node
                if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
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
            System.out.println("End of read " + (i + 1) + "th element's.");
        }
    }

    /**
     * Method of iterating xml with jdom2 library
     * @param filePath
     * @throws FileNotFoundException
     * @throws JDOMException
     * @throws IOException
     */
    public static void jdom2XmlParser(String filePath) throws FileNotFoundException, JDOMException,
            IOException {
        List<Book> newBookList = new ArrayList<Book>();
        // 1. create SAXBuilder object
        SAXBuilder saxBuilder = new SAXBuilder();
        // 2.create input stream to let xml file load to inputstream
        InputStream in;
        in = new FileInputStream(filePath);
        //for solving code unreadable, use to convert and change to UTF-8 for support other languages text
        InputStreamReader isr = new InputStreamReader(in, "UTF-8");
        // 3. use saxBuilder build method, let inputstream add to saxBuilder
        org.jdom2.Document document = saxBuilder.build(isr);
        // 4. through document object get xml file parent node
        org.jdom2.Element rootElement = document.getRootElement();
        // 5. get child node from parent node
        List<org.jdom2.Element> bookList = rootElement.getChildren();
        // 6. continue to analyse
        for (org.jdom2.Element book : bookList) {
            Book bookEntity = new Book();
            System.out.println("======Start to analyse no." + (bookList.indexOf(book) + 1) + " of book.=====");
            //analyse book element
            List<org.jdom2.Attribute> attrList = book.getAttributes();
            //for known book node there got what name
//				book.getAttributeValue("id");
            //alalyse attrList(for analyse unknown book node there got what name and quantity)
            for (org.jdom2.Attribute attr : attrList) {
                //get element name
                String attrName = attr.getName();
                //get lement value
                String attrValue = attr.getValue();
                System.out.println("Element name are: " + attrName + " --- Element value are: " + attrValue);
                if (attrName.equals("id")) {
                    bookEntity.setId(attrValue);
                }
            }
            //parent node(book) >> child node get child node name and value
            List<org.jdom2.Element> bookChilds = book.getChildren();
            for (org.jdom2.Element child : bookChilds) {
                System.out.println("Child node are: " + child.getName() + " --- Child node value are: " + child.getValue());
                if (child.getName().equals("name")) {
                    bookEntity.setName(child.getValue());
                } else if (child.getName().equals("author")) {
                    bookEntity.setAuthor(child.getValue());
                } else if (child.getName().equals("year")) {
                    bookEntity.setYear(child.getValue());
                } else if (child.getName().equals("price")) {
                    bookEntity.setPrice(child.getValue());
                } else if (child.getName().equals("language")) {
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
    }
}
