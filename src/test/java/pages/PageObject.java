package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {

	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public PageObject(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	public boolean isElementDisplayed(By by) {
		boolean isDisplayed = true;
		try {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
		} catch (Exception e) {
			isDisplayed = false;
		}
		return isDisplayed;
	}
	
	public void waitAndClick(By by) {
		wait.until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).click();
	}
	
	public void waitClearAndSet(By by, String value) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		driver.findElement(by).clear(); 
		driver.findElement(by).sendKeys(value);
	}
	
	public void hoverElement(By by) {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(by)).perform();
	}
	
	public void switchToFrame(String id) {
		driver.switchTo().frame(id);
	}
	
	public void switchToParent() {
		driver.switchTo().parentFrame();
	}
	
}
