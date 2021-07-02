package org.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomFrameWorkLoginPage extends BaseClass{
	public PomFrameWorkLoginPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="Username")
	private WebElement txtUserName;
	
	@FindBy(id="Password")
	private WebElement txtPassword;
	
	@FindBy(xpath="//input[@type='Submit']")
	private WebElement btnLogin;

	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}
}
