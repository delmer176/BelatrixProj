package steps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;

public class HomePageSteps extends MainSteps {
	
	private HomePage homePage;
	
	
	@Given("I open {string} in {string} browser")
	public void i_open_in_browser(String url, String browser) {
		switch (browser) {
			case "Firefox": System.setProperty("webdriver.gecko.driver","src/test/java/resources/drivers/geckodriver.exe");
							driver = new FirefoxDriver();
							break;
			case "Chrome": System.setProperty("webdriver.chrome.driver","src/test/java/resources/drivers/chromedriver.exe");
							driver = new ChromeDriver();
							break;
			default: System.setProperty("webdriver.ie.driver","src/test/java/resources/drivers/IEDriverServer.exe");
						driver = new InternetExplorerDriver();
						break;
		}
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	@Then("Home page should be displayed")
	public void home_page_should_be_displayed() {
		homePage = new HomePage(driver);
	    //assertTrue("Home page is not displayed",homePage.isCouponPopUpDisplayed());
	}

	@When("I close the coupon pop up")
	public void i_close_the_coupon_pop_up() {
		homePage = new HomePage(driver);
	    homePage.closeCouponPopUp();
	}

	@Then("The coupon pop up is closed")
	public void the_coupon_pop_up_is_closed() {
		homePage = new HomePage(driver);
	    //assertFalse("The coupon pop up was not closed.", homePage.isCouponPopUpDisplayed());
	}
	
	@When("I click on Sign In button")
	public void i_click_on_Sign_In_button() {
		homePage = new HomePage(driver);
		homePage.clickOnSignInButton();
	}

	@Then("user {string} should be logged in")
	public void user_should_be_logged_in(String name) {
	    // 
	}

}
