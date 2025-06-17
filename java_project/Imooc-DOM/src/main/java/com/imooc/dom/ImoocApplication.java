package com.imooc.dom;

import com.imooc.dom.helper.DOMHelper;
import org.dom4j.DocumentException;

public class ImoocApplication {

    public static void main(String[] args) {

        //analyse books.xml
        String xmlFilePath = "src/main/resources/books.xml";
        try {
            DOMHelper.dom4jXmlParser(xmlFilePath);
        } catch (DocumentException e) {
            System.out.println("error when reading the xml file with dom4jXmlParser: " + e.getMessage());
        }

        //through factory get SAXParser
        try {
            DOMHelper.domSAXParser(xmlFilePath);
        } catch (Exception e) {
            System.out.println("error when reading the xml file with SAXParser: " + e.getMessage());
        }

        try {
            DOMHelper.domParser(xmlFilePath);
        }
        catch (Exception e) {
            System.out.println("error when reading the xml file with domParser: " + e.getMessage());
        }

        try {
            DOMHelper.jdom2XmlParser(xmlFilePath);
        }
        catch (Exception e) {
            System.out.println("error when reading the xml file with jdom2XmlParser: " + e.getMessage());
        }
    }
}
