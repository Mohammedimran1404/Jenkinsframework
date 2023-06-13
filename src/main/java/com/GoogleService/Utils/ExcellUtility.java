package com.GoogleService.Utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcellUtility {
	public FileInputStream inputstream;
	public FileOutputStream outputstream;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell column;
	public XSSFCellStyle cellstyle;
	 String path=null;
	 
	 public ExcellUtility(String path){
		 this.path=path;
	 }
	 
	 public int getRowCount(String sheetname) throws IOException {
		 inputstream = new FileInputStream(path);
		 workbook=new XSSFWorkbook(inputstream);
		sheet= workbook.getSheet(sheetname);
		int rowcount= sheet.getLastRowNum();
		workbook.close();
		inputstream.close();
		return rowcount;	 
	 }
	 public int getColumnCount(String sheetname,int rownum) throws IOException {
		 inputstream = new FileInputStream(path);
		 workbook=new XSSFWorkbook(inputstream);
		sheet= workbook.getSheet(sheetname);
		 row=sheet.getRow(rownum);
		int columncount= row.getLastCellNum();
		workbook.close();
		inputstream.close();
		return columncount;	 
	 }
	 public String getCellData(String sheetname,int rownum,int colnum) throws IOException {
		 inputstream = new FileInputStream(path);
		 workbook= new XSSFWorkbook(inputstream);
		sheet= workbook.getSheet(sheetname);
		 row=sheet.getRow(rownum);
		 column=row.getCell(colnum);
		 DataFormatter df = new DataFormatter();
		 String data;
		 try {
		 data=df.formatCellValue(column);
		 }
		 catch(Exception e) {
			 data="";
		 }
		 workbook.close();
		 inputstream.close();
		 return data;
	 }
	 public void setCellData(String sheetname,int rownum,int colnum,String data) throws IOException {
		 inputstream = new FileInputStream(path);
		 workbook=new XSSFWorkbook(inputstream);
		sheet= workbook.getSheet(sheetname);
		 row=sheet.getRow(rownum);
		 column=row.createCell(colnum);
		 column.setCellValue(data);
		 outputstream =new FileOutputStream(path);
		 workbook.write(outputstream);
		 inputstream.close();
		 outputstream.close();
	 }
	
}
