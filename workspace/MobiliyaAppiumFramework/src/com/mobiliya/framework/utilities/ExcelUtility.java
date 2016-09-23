package com.mobiliya.framework.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.mobiliya.framework.configure.Constants;
import com.mobiliya.framework.configure.BaseClass;

public class ExcelUtility extends BaseClass {
	private static XSSFSheet excelSheet;
	private static XSSFWorkbook excelWorkbook;
	private static XSSFCell excelCell;
	private static XSSFRow excelRow;

	public static void setExcelFile(String path, String sheetName) {
		try {
			FileInputStream fis = new FileInputStream(path);
			excelWorkbook = new XSSFWorkbook(fis);
			excelSheet = excelWorkbook.getSheet(sheetName);
			APP_LOGS.info("Excel file setup completed.");
		} catch (Exception e) {
			APP_LOGS.error("Unable to open file : " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static String getCellData(int row, int col) {
		try {
			excelCell = excelSheet.getRow(row).getCell(col, Row.CREATE_NULL_AS_BLANK);
			String cellData = excelCell.getStringCellValue();
			APP_LOGS.info("Read from excel sheet completed.");
			return cellData;
		} catch (Exception e) {
			APP_LOGS.error("Unable to fetch data from Excel File : " + e.getMessage());
			e.printStackTrace();
			return "";
		}
	}

	public static void setCellData(String result, int row, int col) {
		try {
			excelRow = excelSheet.getRow(row);
			excelCell = excelRow.getCell(col, Row.RETURN_BLANK_AS_NULL);

			if (excelCell != null) {
				excelCell.setCellValue("");
			}

			excelCell = excelRow.createCell(col);
			excelCell.setCellValue(result);

			FileOutputStream fos = new FileOutputStream(Constants.TESTDATA_FILEPATH);
			excelWorkbook.write(fos);
			fos.flush();
			fos.close();
			APP_LOGS.info("Write to excel file completed.");
		} catch (Exception e) {
			APP_LOGS.error("Unable to open / write to Excel file : " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static int getRowsCount() {
		try {
			return excelSheet.getLastRowNum() + 1;
		} catch (Exception e) {
			APP_LOGS.error("Unable to get row count: " + e.getMessage());
			e.printStackTrace();
			return -1;
		}
	}

	public static int getColumnsCount(int row) {
		try {
			return excelSheet.getRow(row).getLastCellNum();
		} catch (Exception e) {
			APP_LOGS.error("Unable to get row count: " + e.getMessage());
			e.printStackTrace();
			return -1;
		}
	}
}