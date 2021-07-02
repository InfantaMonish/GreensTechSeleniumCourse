package org.base;


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
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;

	public class BaseClass {
		

		public static WebDriver driver;
		
		private WebElement target;
		public void getDriver() {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\eclipse-workspace\\Projectname\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		public void launchUrl(String data) {
			driver.get(data);
			
		}
		public void type(WebElement element,String data) {
			element.sendKeys(data);
			
		}
		public void buttonClick(WebElement element) {
			element.click();
		}
	    public void mouseHoverAction(WebElement element) {
	    	Actions ac = new Actions(driver);
			ac.moveToElement(target).perform();
		}
	    
	    public void selectByVisibleText(WebElement element,String Data) {
	    Select se = new Select (element);
	    se.selectByVisibleText(Data);
	}
	    public void enterByTextJs(WebElement element,String Data) {
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    	js.executeScript("argument[0].setAttribute('value','"+Data+"')", element);
			
		}
	    

	public String getDataFromExcel(String pathname,String name,int rowNo, int cellNo) throws IOException {
		File file = new File(pathname);
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(name);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		int cellType = cell.getCellType();
		String value = "";
		if (cellType ==1) {
			value = cell.getStringCellValue();
		}else if(DateUtil.isCellDateFormatted(cell)) {
			Date dateCellValue = cell.getDateCellValue();
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-YYYY");
			value = format.format(dateCellValue);
		}else {
			double numericCellValue = cell.getNumericCellValue();
			long l = (long) numericCellValue;
			value = String.valueOf(l);
				}
			return value;
		}
		
		
		

	}













