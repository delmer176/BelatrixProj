package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends PageObject {

	private By account = By.xpath("//input[normalize-space(@id)='fm-login-id']");
	private By password = By.xpath("//input[normalize-space(@id)='fm-login-password']");
	private By signInButton = By.xpath("//input[normalize-space(@id)='fm-login-submit']");
	private By loginForm = By.xpath("//div[normalize-space(@id)='signInField']");
	private String loginFrameID = "alibaba-login-box";
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		wait.until(ExpectedConditions.urlContains("login.aliexpress.com"));
	}
	
	public void switchToLoginFrame() {
		switchToFrame(loginFrameID);
	}
	
	public boolean isCorrectlyDisplayed() {
		return isElementDisplayed(loginForm);
	}
	public void setAccount(String user) {
		waitClearAndSet(account, user); 
	}
	
	public void setPassword(String pwd) {
		waitClearAndSet(password, pwd);
	}
	
	public HomePage clickOnSignInButton() {
		waitAndClick(signInButton);
		return new HomePage(driver);
	}

}
