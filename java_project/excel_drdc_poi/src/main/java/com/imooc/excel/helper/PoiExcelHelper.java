package com.imooc.excel.helper;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class PoiExcelHelper {

    private PoiExcelHelper() {
    }

    /**
     * Create excel file to the provided file path
     * @param filePath File path of excel file to be exported
     * @throws IOException
     */
    public static void generateExcelByFilePath(String filePath) throws IOException {
        // declare excel header
        String[] titles = {"ID", "NAME", "SEX"};

        //create excel workbook
        HSSFWorkbook workbook = new HSSFWorkbook();

        //create excel workbook > sheet
        HSSFSheet sheet = workbook.createSheet();

        //create sheet first row
        HSSFRow row = sheet.createRow(0);

        //declare cell
        HSSFCell cell = null;
        //create title for first row, input data id, name, sex
        int colIndex = 0;
        for (String title : titles) {
            cell = row.createCell(colIndex);
            cell.setCellValue(title);

            colIndex++;
        }

        //extend data, input for following row data
        for (int i = 1; i <= 10; i++) {            //start from 2nd row, for 10 rows
            HSSFRow nextrow = sheet.createRow(i);

            HSSFCell cell2 = nextrow.createCell(0);
            cell2.setCellValue("a" + i);

            cell2 = nextrow.createCell(1);
            cell2.setCellValue("user" + i);

            cell2 = nextrow.createCell(2);
            cell2.setCellValue("Male");
        }

        //create excel file, declare excel file location(default to workspace location)
        File file = new File(filePath);

        //write the data to the excel file using FileOutputStream, let excel file data to save at memory
        FileOutputStream stream = FileUtils.openOutputStream(file);
        workbook.write(stream);
        stream.close();
    }


    /**
     * Generate xlsx excel file to the provided file path
     *
     * @param filePath File path of excel file to be exported
     * @throws IOException
     */
    public static void generateXSSFExcelFileByFilePath(String filePath) throws IOException {
        String[] titles = {"ID", "NAME", "SEX"};

        //create higher version excel document(.xlsx)
        XSSFWorkbook workbook = new XSSFWorkbook();

        //create excel workbook > sheet
        Sheet sheet = workbook.createSheet();

        //create sheet first row
        Row row = sheet.createRow(0);

        //declare cell
        Cell cell = null;
        //create title for first row, input data id, name, sex
        int colIndex = 0;
        for (String title : titles) {
            cell = row.createCell(colIndex);
            cell.setCellValue(title);

            colIndex++;
        }

        //extend data, input for following row data
        for (int i = 1; i <= 10; i++) {
            Row nextrow = sheet.createRow(i);

            Cell cell2 = nextrow.createCell(0);
            cell2.setCellValue("a" + i);

            cell2 = nextrow.createCell(1);
            cell2.setCellValue("user" + i);

            cell2 = nextrow.createCell(2);
            cell2.setCellValue("Male");
        }

        //create excel(.xlsx) file, declare excel file location(default to workspace location)
        File file = new File(filePath);
        //write the data to the excel file using FileOutputStream, let excel file data to save at memory
        FileOutputStream stream = FileUtils.openOutputStream(file);
        workbook.write(stream);
        stream.close();
    }

    /**
     * Read excel by provided file path
     * @param filePath File path for reading the excel file
     * @throws IOException
     */
    public static void readExcelByFilePath(String filePath) throws IOException {
        //declare a file location for analyse/read
        File file = new File(filePath);
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
    }
}
