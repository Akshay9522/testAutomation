package util;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	static XSSFWorkbook workbook;
	 static XSSFSheet sheet;
	 
	public static  int rowCount(String path, String sheetName) throws Throwable {		
		File file = new File(path);
		FileInputStream fr = new FileInputStream(file);
		workbook = new XSSFWorkbook(fr);
		sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getPhysicalNumberOfRows();
		return rowCount;
		}
	
	public static String readCell(String path, String sheetName, int rowNumber, int cellNumber) throws Throwable {		
		File file = new File(path);
		FileInputStream fr = new FileInputStream(file);
		workbook = new XSSFWorkbook(fr);
		sheet = workbook.getSheet(sheetName);
		XSSFRow row = sheet.getRow(rowNumber);
		XSSFCell cell = row.getCell(cellNumber);
		return cell.getStringCellValue();
		}
	
	public static void writeCell(String path, String sheetName, int rowNumber, int cellNumber,String Value) throws Throwable {		
		File file = new File(path);
		FileInputStream fr = new FileInputStream(file);
		workbook = new XSSFWorkbook(fr);
		sheet = workbook.getSheet(sheetName);
		XSSFRow row = sheet.createRow(rowNumber);
		row.createCell(cellNumber).setCellValue(Value);		
		}
}
