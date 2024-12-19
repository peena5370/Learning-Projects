package com.imooc.excel;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * library use: poi,examples,excelant,ooxml,schemas,scratchpad,xmlbeans 3.1.0,commons.io,commons.collections4,commons.compress,commons.math3
 *POI create and write to higher version excel document(doc_name.xlsx)
 *
 * @author mayn
 * @param args
 */
public class PoiXSSFExpExcel {

    public static void main(String[] args) {
        String[] title = {"ID", "NAME", "SEX"};

      //create higher version excel document(.xlsx)
        XSSFWorkbook workbook = new XSSFWorkbook();

      //create excel workbook > sheet
        Sheet sheet = workbook.createSheet();

      //create sheet first row 
        Row row = sheet.createRow(0);
        
      //declare cell
        Cell cell = null;
      //create title for first row, input data id, name, sex
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
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
        File file = new File("poi_testt.xlsx");

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
