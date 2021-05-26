package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	
	public static FileInputStream fi;
	public static Workbook wb;
	public static Sheet sh;
	public static Row row;
	public static Cell cell;
	public static FileOutputStream fo;
	public static CellStyle style;
	
	public static int getRowCount(String xlfile,String sheetname) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		sh=wb.getSheet(sheetname);
		int rowcount=sh.getLastRowNum();
		
		fi.close();
		wb.close();
		
		return rowcount;
	}

	public static int getCellCount(String xlfile,String sheetname,int rownum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		sh=wb.getSheet(sheetname);
		row=sh.getRow(rownum);
		short cellcount=row.getLastCellNum();
		
		fi.close();
		wb.close();
		
		return cellcount;
		
	}

    public static String getStringCellData(String xlfile,String sheetname,int rownum,int columnNum) throws IOException
{
	String data;
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	sh=wb.getSheet(sheetname);
	row=sh.getRow(rownum);
	
	try {
		
		cell=row.getCell(columnNum);
		data=cell.getStringCellValue();
	} catch (Exception e) {
		data=" ";
	}
	
	return data;
	
}

    public static double getNumericCellData(String xlfile,String sheetname,int rownum,int columnNum) throws IOException
    {
    	double data;
    	fi=new FileInputStream(xlfile);
    	wb=new XSSFWorkbook(fi);
    	sh=wb.getSheet(sheetname);
    	row=sh.getRow(rownum);
    	
    	try {
    		
    		cell=row.getCell(columnNum);
    		data=cell.getNumericCellValue();
    	} catch (Exception e) {
    		data=0.0;
    	}
    	
    	return data;
    	
    }

    public static boolean getBooleanCellData(String xlfile,String sheetname,int rownum,int columnNum) throws IOException
    {
    	boolean data = false;
    	
    	fi=new FileInputStream(xlfile);
    	wb=new XSSFWorkbook(fi);
    	sh=wb.getSheet(sheetname);
    	row=sh.getRow(rownum);
    	
    	try {
    		
    		cell=row.getCell(columnNum);
    		data=cell.getBooleanCellValue();
    	} catch (Exception e) {
    		    	}
    	fi.close();
    	wb.close();
    	return data;
    	
    }

    public static void setCellData(String xlfile,String sheetname,int rownum,int columnNum,String cellData) throws IOException
    {
    	fi=new FileInputStream(xlfile);
    	wb=new XSSFWorkbook(fi);
    	sh=wb.getSheet(sheetname);
    	row=sh.getRow(rownum);
    	
    	cell=row.createCell(columnNum);
    	cell.setCellValue(cellData);
    	fo=new FileOutputStream(xlfile);
    	wb.write(fo);
    	
    	fi.close();
    	wb.close();
    	fo.close();
    }

    public static void fillGreenColor(String xlfile,String sheetname,int rownum,int columnNum) throws IOException
    {
    	fi=new FileInputStream(xlfile);
    	wb=new XSSFWorkbook(fi);
    	sh=wb.getSheet(sheetname);
    	row=sh.getRow(rownum);
    	cell=row.getCell(columnNum);

    	style=wb.createCellStyle();
    	style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
    	style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    	
    	cell.setCellStyle(style);
    	
    	fo=new FileOutputStream(xlfile);
    	wb.write(fo);
    	
    	fi.close();
    	fo.close();
    	wb.close();

    }

    public static void fillRedColor(String xlfile,String sheetname,int rownum,int columnNum) throws IOException
    {
    	fi=new FileInputStream(xlfile);
    	wb=new XSSFWorkbook(fi);
    	sh=wb.getSheet(sheetname);
    	row=sh.getRow(rownum);
    	cell=row.getCell(columnNum);

    	style=wb.createCellStyle();
    	style.setFillForegroundColor(IndexedColors.RED.getIndex());
    	style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    	
    	cell.setCellStyle(style);
    	
    	fo=new FileOutputStream(xlfile);
    	wb.write(fo);
    	
    	fi.close();
    	fo.close();
    	wb.close();

    }
}
