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
import pages.LoginPage;

public class HomePageSteps extends MainSteps {
	
	private HomePage homePage;
	private LoginPage loginPage;
	
	
	@Given("I open {string} in {string} browser")
	public void i_open_in_browser(String url, String browser) {
		driver = setDriver(browser);
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	@Then("Home page should be displayed")
	public void home_page_should_be_displayed() {
		homePage = new HomePage(driver);
	    assertTrue("Home page is not displayed",homePage.isCouponPopUpDisplayed());
	}

	@When("I close the coupon pop up")
	public void i_close_the_coupon_pop_up() {
		homePage = new HomePage(driver);
	    homePage.closeCouponPopUp();
	}

	@Then("The coupon pop up is closed")
	public void the_coupon_pop_up_is_closed() {
		homePage = new HomePage(driver);
	    assertFalse("The coupon pop up was not closed.", homePage.isCouponPopUpDisplayed());
	}
	
	@When("I click on Sign In button")
	public void i_click_on_Sign_In_button() {
		homePage = new HomePage(driver);
		loginPage = homePage.clickOnSignInButton();
	}

	@Then("user {string} should be logged in")
	public void user_should_be_logged_in(String name) {
	    // 
	}

}
