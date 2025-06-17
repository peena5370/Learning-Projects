package com.imooc.excel;

import com.imooc.excel.helper.PoiExcelHelper;

import java.io.IOException;

public class PoiApplication {

    public static void main(String[] args) {

        String excelFilePath = "src/main/resources/poi_output.xls";

        // Create excel file with apache poi
        try {
            PoiExcelHelper.generateExcelByFilePath(excelFilePath);
        } catch (IOException e) {
            System.out.println("error when generating excel file using apache poi");
        }

        // Read excel file with apache poi
        try {
            PoiExcelHelper.readExcelByFilePath(excelFilePath);
        } catch (IOException e) {
            System.out.println("error when reading excel file using apache poi");
        }

        // Create xlsx excel file with apache poi
        String xssfFilePath = "src/main/resources/poi_xssf_output.xlsx";
        try {
            PoiExcelHelper.generateXSSFExcelFileByFilePath(xssfFilePath);
        } catch (IOException e) {
            System.out.println("error when generating xssf excel file using apache poi");
        }
    }

}
