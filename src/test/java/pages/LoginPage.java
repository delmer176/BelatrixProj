package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends PageObject {

	public LoginPage(WebDriver driver) {
		super(driver);
		wait.until(ExpectedConditions.urlContains("login.aliexpress.com"));
	}
	
	private WebElement account = driver.findElement(By.xpath("//input[normalize-space(@id)='fm-login-id']"));
	private WebElement password = driver.findElement(By.xpath("//input[normalize-space(@id)='fm-login-password']"));
	private WebElement signInButton = driver.findElement(By.xpath("//input[normalize-space(@id)='fm-login-submit']"));
	private WebElement loginForm = driver.findElement(By.xpath("//div[normalize-space(@id)='signInField']"));
	
	public boolean isCorrectlyDisplayed() {
		try {
			wait.until(ExpectedConditions.visibilityOf(loginForm));
		} catch (Exception e) {
			System.out.println(e);
		}
		return loginForm.isDisplayed();
	}
	public void setAccount(String user) {
		wait.until(ExpectedConditions.visibilityOf(account));
		account.sendKeys(user);
	}
	
	public void setPassword(String pwd) {
		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys(pwd);
	}
	
	public void clickOnSignInButton() {
		wait.until(ExpectedConditions.visibilityOf(signInButton));
		signInButton.click();
	}

}
