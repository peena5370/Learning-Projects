package com.imooc.dom.helper;

import org.junit.jupiter.api.Test;

public class DOMHelperTest {
    @Test//	use for calculate runtime
    public void performanceTest() throws Exception {
        long start = System.currentTimeMillis();

        String xmlFilePath = "src/main/resources/books.xml";

        DOMHelper.dom4jXmlParser(xmlFilePath);

        System.out.println("DOM time: " + (System.currentTimeMillis() - start) + "ms");
    }
}
