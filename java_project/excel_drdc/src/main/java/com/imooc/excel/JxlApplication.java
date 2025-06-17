package com.imooc.excel;

import com.imooc.excel.helper.ExcelHelper;

public class JxlApplication {

    public static void main(String[] args) {

        String filePath = "src/main/resources/test_output.xls";
        // generate excel file
        try {
            ExcelHelper.generateExcelFileByFilePath(filePath);
        } catch (Exception e) {
            System.out.println("error when generating excel file: " + e.getMessage());
        }

        // read created excel file
        try {
            ExcelHelper.readExcelFileByFilePath(filePath);
        } catch (Exception e) {
            System.out.println("error when reading excel file: " + e.getMessage());
        }
    }
}
