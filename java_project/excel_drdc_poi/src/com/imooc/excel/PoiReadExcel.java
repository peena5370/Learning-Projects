package com.imooc.excel;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.IOException;

/**
 * POI analyse/read excel document
 * @author dyz
 * @param args
 */
public class PoiReadExcel {

    public static void main(String[] args) {

        //declare a file location for analyse/read
        File file = new File("poi_test.xls");

        try {
            //create excel and read workbook data
            HSSFWorkbook workbook = new HSSFWorkbook(FileUtils.openInputStream(file));

            //get first workbook list(workbook.getSheet("sheet name that want to read");)
//			HSSFSheet sheet = workbook.getSheet("Sheet0");

            //read default first workbook sheet table
            HSSFSheet sheet = workbook.getSheetAt(0);
            
            //declare first row number to 0
            int firstRowNum = 0;

            //get/read through sheet and get last row number
            int lastRowNum = sheet.getLastRowNum();

            for (int i = firstRowNum; i <= lastRowNum; i++) {
                HSSFRow row = sheet.getRow(i);

                //get available last cell number 
                int lastCellNum = row.getLastCellNum();
                
                //
                for (int j = 0; j < lastCellNum; j++) {

                    HSSFCell cell = row.getCell(j);
                    //get string value
                    String value = cell.getStringCellValue();
                    //output data
                    System.out.print(value + "	");
                }
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
