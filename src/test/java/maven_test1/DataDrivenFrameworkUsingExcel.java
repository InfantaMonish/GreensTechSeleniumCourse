package maven_test1;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenFrameworkUsingExcel {
	
	public static void main(String[] args) throws IOException{
		File file = new File("C:\\Users\\admin\\eclipse-workspace\\Projectname\\Excel Data\\TestData for Feedback.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet("Sheet1");
		//Row row = sheet.getRow(5);
		//Cell cell = row.getCell(1);
		//String stringCellValue = cell.getStringCellValue();
		//System.out.println(stringCellValue);
		
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			
			Row row = sheet.getRow(i);
			
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				
	    Cell cell = row.getCell(j);
	    int cellType = cell.getCellType();
	    if (cellType ==1) {
	    	String stringCellValue = cell.getStringCellValue();
		    System.out.println(stringCellValue);	
			
		}
	    else if (DateUtil.isCellDateFormatted(cell)) {
			Date dateCellValue = cell.getDateCellValue();
			SimpleDateFormat dateFormat = new SimpleDateFormat ("dd-MM-yy");
			String format = dateFormat.format(dateCellValue);
			System.out.println(format);
			
	    }else {
	    	
	    	double numericCellValue = cell.getNumericCellValue();
	    	long l = (long)numericCellValue;
	    	System.out.println(l);
	    }
	    
	    
				
			}
		}
		
	}

}
