package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LandingPage extends PageObject {

	private By searchLabel = By.xpath("//input[@id='gh-ac']");
	private By searchButton = By.xpath("//input[@id='gh-btn']");
	
	
	public LandingPage(WebDriver driver) {
		super(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchLabel));
	}
	
	public void setSearch(String pwd) {
		waitClearAndSet(searchLabel, pwd);
	}
	
	public SearchPage clickOnSearchButton() {
		waitAndClick(searchButton);
		return new SearchPage(driver);
	}

}
