package co.qa.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static FileInputStream fis;

	public static XSSFWorkbook wb;

	public static XSSFSheet sh;

	public static XSSFRow row;

	public static XSSFCell cell;

	public static FileOutputStream fos;

	public static int getRow(String xlPath, String XlSheet) throws IOException {
		fis = new FileInputStream(xlPath);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet(XlSheet);
		int Rowcount = sh.getLastRowNum();
		wb.close();
		fis.close();
		return Rowcount;
	}

	public static int getCol(String xlPath, String xlSheet, int rownum) throws IOException {
		fis = new FileInputStream(xlPath);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet(xlSheet);
		row = sh.getRow(rownum);
		int Colcount = row.getLastCellNum();
		wb.close();
		fis.close();
		return Colcount;

	}

	public static String getCellData(String xlPath, String xlSheet, int rownum, int colnum) throws IOException {
		fis = new FileInputStream(xlPath);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet(xlSheet);
		row = sh.getRow(rownum);
		cell = row.getCell(colnum);
		String Data;
		try {
			DataFormatter dataformatter = new DataFormatter();
			String cellData = dataformatter.formatCellValue(cell);
			return cellData;
		} catch (Exception e) {
			Data = "";
		}
		wb.close();
		fis.close();
		return Data;
	}

	public static void setCellData(String xlPath, String xlSheet, int rownum, int colnum, String Data)
			throws IOException {
		fis = new FileInputStream(xlPath);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet(xlSheet);
		row = sh.getRow(rownum);
		cell = row.createCell(colnum);
		cell.setCellValue(Data);
		fos = new FileOutputStream(xlPath);
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
	}
}
