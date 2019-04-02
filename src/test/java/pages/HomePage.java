package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends PageObject{

	private By couponPopUp = By.xpath("//div[normalize-space(@class)='ui-window-content']");
	private By closeCouponPopUp = By.xpath("//div[normalize-space(@class)='ui-window-content']/a[normalize-space(@class)='close-layer']");
	private By signInLink = By.xpath("//a[normalize-space(text())='Sign In']");
	private By signInButton = By.xpath("//a[normalize-space(@class)='sign-btn']");
	
	
	public HomePage(WebDriver driver) {
		super(driver);
		wait.until(ExpectedConditions.titleContains("AliExpress.com"));
	}
	
	public boolean isCouponPopUpDisplayed() {
		return isElementDisplayed(couponPopUp);
	}
	
	public void closeCouponPopUp() {
		waitAndClick(closeCouponPopUp);
	}
	
	public LoginPage clickOnSignInButton() {
		
		hoverElement(signInLink);
		waitAndClick(signInButton);
		
		return new LoginPage(driver);
	}
	
	
}
