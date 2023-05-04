package com.imooc.excel;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.io.File;

/**
 * Create JXL Excel document and write title and data using array to excel document
 * @author dyz
 * @param args
 */
public class JxlExpExcel {

    public static void main(String[] args) {
        //use array to save table title
        String[] title = {"ID", "NAME", "SEX", "AGE"};

        //create excel file(default is to workspace location)
        File file = new File("jxl_test.xls");
        try {
            file.createNewFile();
            //create workbook
            WritableWorkbook workbook = Workbook.createWorkbook(file);
            //create workbook > sheet
            WritableSheet sheet = workbook.createSheet("sheet1", 0);
            //declare sheet label as null
            Label label = null;
            //first row set column name
            for (int i = 0; i < title.length; i++) {
                //Label(i,0,title[i]) Label (row, col, (title to put in)), excel use row and col to put in data
                label = new Label(i, 0, title[i]);
                sheet.addCell(label);
            }
            //set extend data
            for (int i = 1; i < 10; i++) { 
                //Label(0,i,"a"+1) Label(row, col, id + 1) 
                label = new Label(0, i, "a" + i);			// output to row 0, col i , (data to write)
                sheet.addCell(label);
                label = new Label(1, i, "user" + i);		
                sheet.addCell(label);
                label = new Label(2, i, "male");
                sheet.addCell(label);
                label = new Label(3, i, "20");
                sheet.addCell(label);
            }
            //write data into excel
            workbook.write();
            //close excel after write
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
