package com.imooc.excel;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import java.io.File;

/**
 *JXL analyse/read excel 
 * @author dyz
 * @param args
 */
public class JxlReadExcel {

    public static void main(String[] args) {

        try {
            //create workbook and declare a specific location(default to workspace folder)
            Workbook workbook = Workbook.getWorkbook(new File("jxl_test.xls"));

            //get worksheet
            Sheet sheet = workbook.getSheet(0); // get sheet 1 

            //get data using for loop
            for (int i = 0; i < sheet.getRows(); i++) {			//get rows
                for (int j = 0; j < sheet.getColumns(); j++) {		//get columns
                    Cell cell = sheet.getCell(j, i);				//get cell data(row, col)
                    System.out.print(cell.getContents() + "  ");	//output data
                }
                System.out.println();
            }
            //close workbook
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
