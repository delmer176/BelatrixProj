package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends PageObject{

	public HomePage(WebDriver driver) {
		super(driver);
		wait.until(ExpectedConditions.titleContains("AliExpress.com"));
	}
	
	private WebElement couponPopUp = driver.findElement(By.xpath("//div[normalize-space(@class)='ui-window-content']"));
	private WebElement closeCouponPopUp = driver.findElement(By.xpath("//div[normalize-space(@class)='ui-window-content']/a[normalize-space(@class)='close-layer']"));
	private WebElement signInLink = driver.findElement(By.xpath("//a[normalize-space(text())='Sign In']"));
	private WebElement signInButton = driver.findElement(By.xpath("//a[normalize-space(@class)='sign-btn']"));
	
	public boolean isCouponPopUpDisplayed() {
		try {
			wait.until(ExpectedConditions.visibilityOf(couponPopUp));
		} catch (Exception e) {
			System.out.println(e);
		}
		return couponPopUp.isDisplayed();
	}
	
	public void closeCouponPopUp() {
		wait.until(ExpectedConditions.visibilityOf(closeCouponPopUp));
		closeCouponPopUp.click();
	}
	
	public void clickOnSignInButton() {
		wait.until(ExpectedConditions.visibilityOf(signInLink));
		Actions action = new Actions(driver);
		action.moveToElement(signInLink).perform();
		wait.until(ExpectedConditions.visibilityOf(signInButton));
		signInButton.click();
	}
	
	
}
