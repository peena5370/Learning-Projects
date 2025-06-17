package com.imooc.excel.helper;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.io.File;

public class ExcelHelper {

    private ExcelHelper() {
    }

    /**
     * Generate an excel file with the fixed column headers and some values
     * @param filePath File path that would create the file and the directory
     * @throws Exception
     */
    public static void generateExcelFileByFilePath(String filePath) throws Exception {
        //use array to save table title
        String[] title = {"ID", "NAME", "SEX", "AGE"};

        //create excel file(default is to workspace location)
        File file = new File(filePath);
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
            label = new Label(0, i, "a" + i);            // output to row 0, col i , (data to write)
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
    }

    /**
     * Read excel file data from the provided file path and console the output to the terminal
     * @param filePath Excel file path
     * @throws Exception
     */
    public static void readExcelFileByFilePath(String filePath) throws Exception {
        //create workbook and declare a specific location(default to workspace folder)
        Workbook workbook = Workbook.getWorkbook(new File(filePath));

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
    }
}
