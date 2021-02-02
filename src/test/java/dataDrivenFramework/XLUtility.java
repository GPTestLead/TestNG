package dataDrivenFramework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility {

	
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path = null;
	
	//constructor to call path of excel sheet
	
	XLUtility(String path)
	{
		this.path = path;
	}
	
	public int getRowCount(String sheetname) throws IOException 
	{
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetname);
		int rowcount = sheet.getLastRowNum();
		workbook.close();
		return rowcount;
		
	}
	
	public int getCellCount(String sheetname, int rownum) throws IOException 
	{
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetname);
		row = sheet.getRow(rownum);
		short cellcount = row.getLastCellNum();
		workbook.close();
		return cellcount;
		
	}
	
	public String getCellData(String sheetname, int rownum, int column) throws IOException 
	{
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetname);
		row = sheet.getRow(rownum);
		cell=row.getCell(column);
		
		
		/* different variety of data in excel sheet - string,int,date format 
		---- but will read all data in String format
		so using DataFormatter class
		*/
		
		DataFormatter formatter = new DataFormatter();
	   String data ;
	   try {
		   data= formatter.formatCellValue(cell); // formatted value of cell as a String type regardless of any data type in excel
	       } catch (Exception e) {
		      data = "";
	       }
	   
		workbook.close();
		fi.close();
		return data;
		
		
	}
	
	public void setCellData(String sheetname, int rownum, int column, String data) throws IOException 
	{
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetname);
		
		row = sheet.getRow(rownum);
		cell=row.getCell(column);
		cell.setCellValue(data);
		
		
	fo = new FileOutputStream(path);
	workbook.write(fo);
	workbook.close();
	fi.close();
	fo.close();
		
	}
	
	public void fillGreenColor(String sheetname, int rownum, int column) throws IOException 
	{
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetname);
		
		row = sheet.getRow(rownum);
		cell=row.getCell(column);
		
	    style = workbook.createCellStyle();
	    style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
	    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	    
	    cell.setCellStyle(style);
	    workbook.write(fo);
	    workbook.close();
	    fi.close();
	    fo.close();
		
	}
	
	public void fillRedColor(String sheetname, int rownum, int column) throws IOException 
	{
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetname);
		
		row = sheet.getRow(rownum);
		cell=row.getCell(column);
		
	    style = workbook.createCellStyle();
	    style.setFillForegroundColor(IndexedColors.RED.getIndex());
	    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	    
	    cell.setCellStyle(style);
	    workbook.write(fo);
	    workbook.close();
	    fi.close();
	    fo.close();
		
	}
	
}
