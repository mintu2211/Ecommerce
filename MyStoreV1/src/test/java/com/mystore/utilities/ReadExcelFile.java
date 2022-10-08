package com.mystore.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	
	//isme hum file ka path nahi denge..file ka path hum test file me denge..
	
	public static FileInputStream inputstream;
	public static XSSFWorkbook workBook;
	public static XSSFSheet excelsheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	
	public static String getCellValue(String filename, String sheetName, int rows, int cellNo) throws IOException
	{
		try {
			inputstream =new FileInputStream(filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		workBook =new XSSFWorkbook(inputstream);
		excelsheet =workBook.getSheet(sheetName);
		cell= workBook.getSheet(sheetName).getRow(rows).getCell(cellNo);
	    
		workBook.close();
		return sheetName;
		
	}
	
	
	public static int getRowCount (String fileName, String sheetName) throws IOException
	{
		
		try {
			inputstream= new FileInputStream(fileName);
			//create xssfworkBook class object for excel file manipulation
			workBook=new XSSFWorkbook(inputstream);
			excelsheet = workBook.getSheet(sheetName);
			//get total no of row
			int ttlrow = excelsheet.getLastRowNum() + 1;
			
			workBook.close();
			return ttlrow;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return 0;
		
		}
	
	
	public static int getColCount (String fileName, String sheetName) throws IOException
	{
		try {
			FileInputStream inputstream=new FileInputStream(fileName);
	//create xssfworkBook class kobject for excel filoe manipulation 
			XSSFWorkbook workBook = new XSSFWorkbook(inputstream);
			XSSFSheet excelsheet= workBook.getSheet(sheetName);
			
			//get total no of columns
			int ttlcells =excelsheet.getRow(0).getLastCellNum();
			
			workBook.close();
			return ttlcells;
		
		
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
		
		
	}

}
