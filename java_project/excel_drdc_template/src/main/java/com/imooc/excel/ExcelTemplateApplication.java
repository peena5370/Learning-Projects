package com.imooc.excel;

import com.imooc.excel.helper.ExcelTemplateHelper;

public class ExcelTemplateApplication {

    public static void main(String[] args) {

        //String path = System.getProperty("user.dir") use to get current file location directory
        //String path = System.getProperty("user.dir") + "/bin/student2.xml"; // 
        String templateFilePath = "src/main/resources/student.xml";
        String outputDirectory = "src/main/resources/";

        try {
            ExcelTemplateHelper.generateExcelTemplateByFilePath(templateFilePath, outputDirectory);
        } catch (Exception e) {
            System.out.println("error when generating excel template: " + e.getMessage());
        }
    }
}
