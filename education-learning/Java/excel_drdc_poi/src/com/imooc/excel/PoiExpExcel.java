package com.imooc.excel;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * POI create and write to excel document
 * @author dyz
 * @param args
 */
public class PoiExpExcel {

    public static void main(String[] args) {
    	// declare excel header
        String[] title = {"ID", "NAME", "SEX"};

        //create excel workbook
        HSSFWorkbook workbook = new HSSFWorkbook();

        //create excel workbook > sheet
        HSSFSheet sheet = workbook.createSheet();

        //create sheet first row 
        HSSFRow row = sheet.createRow(0);

        //declare cell
        HSSFCell cell = null;
        //create title for first row, input data id, name, sex
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
        }

        //extend data, input for following row data
        for (int i = 1; i <= 10; i++) {			//start from 2nd row, for 10 rows
            HSSFRow nextrow = sheet.createRow(i);

            HSSFCell cell2 = nextrow.createCell(0);
            cell2.setCellValue("a" + i);

            cell2 = nextrow.createCell(1);
            cell2.setCellValue("user" + i);

            cell2 = nextrow.createCell(2);
            cell2.setCellValue("Male");
        }

        //create excel file, declare excel file location(default to workspace location)
        File file = new File("poi_test.xls");

        try {
            file.createNewFile();

            //write the data to the excel file using fileoutputstream, let excel file data to save at memory
            FileOutputStream stream = FileUtils.openOutputStream(file);
            workbook.write(stream);
            stream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
