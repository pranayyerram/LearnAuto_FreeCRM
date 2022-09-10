package com.hybrid.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelDataProvider {
	
	public XSSFWorkbook wib;
	public ExcelDataProvider(){
		File src=new File("./TestData/Data.xlsx");
		
			FileInputStream fis;
			try {
				fis = new FileInputStream("./TestData/Data.xlsx");
				wib=new XSSFWorkbook(fis);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}
	public String getStringData(String sheetname, int row, int column ) {
		return wib.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
	}
	//public String getStringData(int sheetIndex, int row, int column ) {
	//	return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	//}
	public double getNumericData(String sheetname, int row, int column ) {
		return wib.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
	}
}
