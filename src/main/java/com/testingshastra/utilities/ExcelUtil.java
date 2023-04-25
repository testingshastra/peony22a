package com.testingshastra.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	/**
	 * This method will load specified row into the List from excel
	 * @param filePath name of excel file
	 * @param sheetName name of sheet from which you want to load row
	 * @param rowNum from which you want all data
	 * @return
	 */
	public List getRowFromExcel(String filePath, String sheetName, int rowNum) {
		List data = new ArrayList<>();
		try {
			FileInputStream fis =  new FileInputStream(filePath);
			XSSFWorkbook book = new XSSFWorkbook(fis);
			XSSFSheet sheet = book.getSheet(sheetName);
			XSSFRow row = sheet.getRow(rowNum);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				Cell cell = row.getCell(i);
				switch (cell.getCellType()) {
				case STRING:
					data.add(cell.getStringCellValue());
					break;
				case NUMERIC:
					data.add(cell.getNumericCellValue());
					break;
				case BLANK:
					data.add("");
					break;
				default:
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
		
	}
	
	public void loadExcelToMap(String filePath, String sheetName) {
		
	}
	
	/**
	 * Use this method to load any column from the excel sheet into the List
	 * @param filePath from which you want to load the column
	 * @param sheetName from which you want column data
	 * @param colNum index of column from which you want to load data
	 * @return list containing data from column
	 */
	public List getColumnFromExcel(String filePath, String sheetName, int colNum) {
		return new ArrayList<>();
	}
}
