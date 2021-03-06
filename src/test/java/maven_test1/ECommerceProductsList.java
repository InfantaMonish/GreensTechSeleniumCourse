package maven_test1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ECommerceProductsList {

	
	public static void main(String[] args) throws IOException {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\eclipse-workspace\\Projectname\\Driver\\chromedriver.exe");
		File file = new File("C:\\Users\\admin\\eclipse-workspace\\Projectname\\Excel Data\\TestData for Feedback.xlsx");
		FileInputStream fileInputStream =new FileInputStream(file);
		Workbook workbook =new XSSFWorkbook(fileInputStream);
		Sheet createSheet = workbook.createSheet("JIOMart");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jiomart.com/catalogsearch/result?q=Snacks");
		driver.manage().window().maximize();
		List<WebElement>Product = driver.findElements(By.xpath("//span[@class=\"clsgetname\"]"));
		
		for (int i = 0; i <Product .size(); i++) {
			WebElement name = Product.get(i);
			String text = name.getText();
			Row createRow = createSheet.createRow(i);
			org.apache.poi.ss.usermodel.Cell createCell = createRow.createCell(0);
		createCell.setCellValue(text);	  
}
		FileOutputStream Stream =new FileOutputStream(file);
		workbook.write(Stream);
	}

	
}
