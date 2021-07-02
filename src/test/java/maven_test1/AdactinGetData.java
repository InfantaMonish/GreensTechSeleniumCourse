package maven_test1;

import java.io.IOException;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AdactinGetData extends BaseClass {

	public static void main(String[] args) throws IOException {
		BaseClass baseClass = new BaseClass();
		baseClass.getDriver();
		baseClass.launchUrl("https://adactinhotelapp.com/");
		WebElement txtUserName = driver.findElement(By.id("username"));
		txtUserName.sendKeys(baseClass.getDataFromExcel("C:\\Users\\admin\\eclipse-workspace\\Projectname\\Excel Data\\TestData for Feedback.xlsx", "Sheet2", 0, 0));
		
		WebElement txtPassword = driver.findElement(By.id("password"));
		txtPassword.sendKeys(baseClass.getDataFromExcel("C:\\Users\\admin\\eclipse-workspace\\Projectname\\Excel Data\\TestData for Feedback.xlsx", "Sheet2", 0, 1));
		
	}
}
