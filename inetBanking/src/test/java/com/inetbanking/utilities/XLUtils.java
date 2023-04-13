package com.inetbanking.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {

    public static String getCellData(String filePath, String sheetName, int rowNum, int colNum) {
        String cellData = null;
        try {
            FileInputStream fis = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            Row row = sheet.getRow(rowNum);
            Cell cell = row.getCell(colNum);
            cellData = cell.toString();
            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cellData;
    }

    public static void setCellData(String filePath, String sheetName, int rowNum, int colNum, String cellData) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            Row row = sheet.getRow(rowNum);
            Cell cell = row.createCell(colNum);
            cell.setCellValue(cellData);
            FileOutputStream fos = new FileOutputStream(filePath);
            workbook.write(fos);
            workbook.close();
            fis.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getRowCount(String filePath, String sheetName) {
        int rowCount = 0;
        try {
            FileInputStream fis = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            rowCount = sheet.getLastRowNum();
            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rowCount;
    }
    
    public static int getCellCount(String filePath, String sheetName, int rowNum) {
        int cellCount = 0;
        try {
            FileInputStream fis = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            Row row = sheet.getRow(rowNum);
            if (row != null) {
                cellCount = row.getPhysicalNumberOfCells();
            }
            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cellCount;
    }

}
