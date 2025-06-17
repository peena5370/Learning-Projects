package com.imooc.excel.helper;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

public class ExcelTemplateHelper {

    private ExcelTemplateHelper() {
    }

    private static void setType(HSSFWorkbook wb, HSSFCell cell, Element td) {
        Attribute typeAttr = td.getAttribute("type");
        String type = typeAttr.getValue();
        HSSFDataFormat format = wb.createDataFormat();
        HSSFCellStyle cellStyle = wb.createCellStyle();
        if ("NUMERIC".equalsIgnoreCase(type)) {
            //cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);//è¿‡æ—¶
            cell.setCellType(CellType.NUMERIC);
            Attribute formatAttr = td.getAttribute("format");
            String formatValue = formatAttr.getValue();
            formatValue = StringUtils.isNotBlank(formatValue) ? formatValue : "#,##0.00";
            cellStyle.setDataFormat(format.getFormat(formatValue));
        } else if ("STRING".equalsIgnoreCase(type)) {
            cell.setCellValue("");
            //cell.setCellType(HSSFCell.CELL_TYPE_STRING);//è¿‡æ—¶
            cell.setCellType(CellType.STRING);
            cellStyle.setDataFormat(format.getFormat("@"));
        } else if ("DATE".equalsIgnoreCase(type)) {
            //cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);//è¿‡æ—¶
            cell.setCellType(CellType.NUMERIC);
            cellStyle.setDataFormat(format.getFormat("yyyy-m-d"));
        } else if ("ENUM".equalsIgnoreCase(type)) {
            CellRangeAddressList regions = new CellRangeAddressList(cell.getRowIndex(), cell.getRowIndex(),
                    cell.getColumnIndex(), cell.getColumnIndex());
            Attribute enumAttr = td.getAttribute("format");
            String enumValue = enumAttr.getValue();

            DVConstraint constraint = DVConstraint.createExplicitListConstraint(enumValue.split(","));

            HSSFDataValidation dataValidation = new HSSFDataValidation(regions, constraint);
            wb.getSheetAt(0).addValidationData(dataValidation);
        }
        cell.setCellStyle(cellStyle);
    }

    private static void setColumnWidth(HSSFSheet sheet, Element colgroup) {
        //using jdom to read through xml document and get colgroup > col > element name and element value
        List<Element> cols = colgroup.getChildren("col");
        for (int i = 0; i < cols.size(); i++) {
            Element col = cols.get(i);
            Attribute width = col.getAttribute("width");
            //get value unit
            String unit = width.getValue().replaceAll("[0-9,\\.]", "");
            String value = width.getValue().replaceAll(unit, "");
            int v = 0;

            //convert xml value (17em to pixel value)
            if (StringUtils.isBlank(unit) || "px".endsWith(unit)) {
                v = Math.round(Float.parseFloat(value) * 37F);
            } else if ("em".endsWith(unit)) {
                v = Math.round(Float.parseFloat(value) * 267.5F);
            }
            //set column width (column index(i), width(v))
            sheet.setColumnWidth(i, v);
        }
    }

    public static void generateExcelTemplateByFilePath(String templateFilePath, String outputDirectory) throws Exception {
        File file = new File(templateFilePath);

        //java dom SAXBuilder for xml
        SAXBuilder builder = new SAXBuilder();
        //analyse xml document
        Document parse = builder.build(file);

        //create excel workbook
        HSSFWorkbook wb = new HSSFWorkbook();

        //create new sheet
        HSSFSheet sheet = wb.createSheet("Sheet0");

        //get xml parent node
        Element root = parse.getRootElement();

        //get parent node > element name and get element value
        String templateName = root.getAttribute("name").getValue();

        //declare initial row and column number
        int rownum = 0;
        int column = 0;

        //get xml child node > colgroup
        Element colgroup = root.getChild("colgroup");
        setColumnWidth(sheet, colgroup);

        //set title and get child node from xml document
        Element title = root.getChild("title");
        List<Element> trs = title.getChildren("tr");
        //loop through xml title > tr
        for (Element tr : trs) {        //for(int i = 0; i < trs.size(); i++)
            //Element tr = trs.get(i);

            List<Element> tds = tr.getChildren("td");

            HSSFRow row = sheet.createRow(rownum);
            //declare for create cell style(text alignment top,center or bottom)
            HSSFCellStyle cellStyle = wb.createCellStyle();
            cellStyle.setAlignment(HorizontalAlignment.CENTER);
            //cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

            for (column = 0; column < tds.size(); column++) {
                Element td = tds.get(column);
                HSSFCell cell = row.createCell(column);
                //loop through xml and get rowspan, colspan and value tag attribute
                Attribute rowSpan = td.getAttribute("rowspan");
                Attribute colSpan = td.getAttribute("colspan");
                Attribute value = td.getAttribute("value");

                if (value != null) {
                    String val = value.getValue();
                    //set cell value to excel
                    cell.setCellValue(val);
                    //convert value from xml to suit excel col and row default value
                    int rspan = rowSpan.getIntValue() - 1;
                    int cspan = colSpan.getIntValue() - 1;

                    //set font style
                    HSSFFont font = wb.createFont();
                    //set font pattern to excel(Times New Roman....)
                    font.setFontName("Microsoft Yahei");
                    //bold text
                    font.setBold(true);
                    //font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//
                    //font.setFontHeight((short)12);
                    font.setFontHeightInPoints((short) 12);
                    //set font style to cell
                    cellStyle.setFont(font);
                    cell.setCellStyle(cellStyle);
                    //combine cell together and text align center(first row,last row, first col, last col)
                    sheet.addMergedRegion(new CellRangeAddress(rspan, rspan, 0, cspan));
                }
            }
            //need to add rownum, if not it will replace same row data
            rownum++;
        }

        //set excel table heading
        Element thead = root.getChild("thead");
        trs = thead.getChildren("tr");
        for (Element tr : trs) {        //for(int i=0; i < trs.size(); i++)
            //Element tr = trs.get(i);

            HSSFRow row = sheet.createRow(rownum);
            List<Element> ths = tr.getChildren("th");

            for (column = 0; column < ths.size(); column++) {
                Element th = ths.get(column);
                Attribute valueAttr = th.getAttribute("value");
                HSSFCell cell = row.createCell(column);
                if (valueAttr != null) {
                    String value = valueAttr.getValue();
                    cell.setCellValue(value);
                }
            }
            rownum++;
        }

        //set excel body text format(Numbering, Text, date ...)
        Element tbody = root.getChild("tbody");
        Element tr = tbody.getChild("tr");
        int repeat = tr.getAttribute("repeat").getIntValue();

        List<Element> tds = tr.getChildren("td");
        for (int i = 0; i < repeat; i++) {        //for(int i=0; i < repeat; i++)
            HSSFRow row = sheet.createRow(rownum);

            for (column = 0; column < tds.size(); column++) {
                Element td = tds.get(column);
                HSSFCell cell = row.createCell(column);
                setType(wb, cell, td);
            }
            rownum++;
        }

        File tempFile = new File(outputDirectory + templateName + ".xls");
        tempFile.delete();
        tempFile.createNewFile();
        FileOutputStream stream = FileUtils.openOutputStream(tempFile);
        wb.write(stream);
        stream.close();
    }
}
