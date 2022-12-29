package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;



import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileUtil {
	XSSFWorkbook wb;
	//create excel path
	public ExcelFileUtil(String excelpath) throws Throwable
	{
		FileInputStream f = new FileInputStream(excelpath);
		wb = new XSSFWorkbook(f);
		
	}
	//row count
	public int rowCount(String sheetName)
	{
		return wb.getSheet(sheetName).getLastRowNum();
		
	}
	//get cell data
	public String getCellData(String sheetname,int row,int column) 
	{
		String data="";
		if(wb.getSheet(sheetname).getRow(row).getCell(column).getCellType()== Cell.CELL_TYPE_NUMERIC)
		{
			int celldata = (int) wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
			data = String.valueOf(celldata);
		}
		else {
			data = wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
		}
		return data;
	}
	
	//set cell data
	public void setcelldata(String sheetname,int row,int column,String status,String writeexcel)throws Throwable
	{
		XSSFSheet sh = wb.getSheet(sheetname);
		XSSFRow rownum = sh.getRow(row);
		XSSFCell cell = rownum.createCell(column);
		//write status
		cell.setCellValue(status);
		if(status.equalsIgnoreCase("pass")) {
			XSSFCellStyle style = wb.createCellStyle();
			XSSFFont font = wb.createFont();
			font.setColor(IndexedColors.GREEN.getIndex());
			font.setBold(true);
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			style.setFont(font);
			rownum.getCell(column).setCellStyle(style);
		
		}
		else if(status.equalsIgnoreCase("fail"))
		{
			XSSFCellStyle style = wb.createCellStyle();
			XSSFFont font = wb.createFont();
			font.setColor(IndexedColors.RED.getIndex());
			font.setBold(true);
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			style.setFont(font);
			rownum.getCell(column).setCellStyle(style);
		
		}
		else if (status.equalsIgnoreCase("Blocked"))
		{
			XSSFCellStyle style = wb.createCellStyle();
			XSSFFont font = wb.createFont();
			font.setColor(IndexedColors.BLUE.getIndex());
			font.setBold(true);
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			style.setFont(font);
			rownum.getCell(column).setCellStyle(style);
		
		}
		FileOutputStream fo = new FileOutputStream(writeexcel);
		wb.write(fo);
	}
	public static void main(String[] args)throws Throwable
	{
		ExcelFileUtil xl = new ExcelFileUtil("C:\\sample data\\sample data qa.xlsx");
		//count rows
		int rc = xl.rowCount("employeedata");
		System.out.println(rc);
		for(int i=1;i<=rc;i++) 
		{
			String name = xl.getCellData("employeedata", i, 0);
			String dep = xl.getCellData("employeedata", i, 1);
			String salary = xl.getCellData("employeedata", i, 2);
			String age = xl.getCellData("employeedata", i, 3);
			System.out.println(name+dep+salary+age);
		xl.setcelldata("employeedata", i, 4, "fail", "C:\\sample data\\resultsD.xlsx");

		}
	}
	
	



	}


