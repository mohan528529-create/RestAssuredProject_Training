package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility {
	
	public static String readexceldata(int rownum, int cellnum) throws IOException
	{
	FileInputStream fileinput=new FileInputStream("C:\\Users\\mohaa\\Downloads\\api_testing_data.xlsx");
	XSSFWorkbook workbook=new XSSFWorkbook(fileinput);
	XSSFSheet sheet=workbook.getSheet("Sheet1");
	String stringvalue=sheet.getRow(rownum).getCell(cellnum).getStringCellValue();
	return stringvalue;
	}

}
