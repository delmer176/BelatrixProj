package steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LandingPage;
import pages.SearchPage;

public class EbaySteps extends MainSteps{
	
	private LandingPage landingPage;
	private SearchPage searchPage;
	
	
	@Given("I open {string} in {string} browser")
	public void i_open_in_browser(String url, String browser) {
		driver = setDriver(browser);
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	@After()
	public void closeBrowser(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		    scenario.embed(screenshot, "image/png");
		}
	    driver.quit();
	}

	@When("I search for {string}")
	public void i_search_for(String string) {
		landingPage = new LandingPage(driver);
		landingPage.setSearch(string);
		landingPage.clickOnSearchButton();
	}

	@Then("{string} should be displayed")
	public void should_be_displayed(String string) {
		searchPage = new SearchPage(driver);
		assertTrue("Search unsuccessful", searchPage.verifySearch(string));
	}

	@When("I select {string} {string}")
	public void i_select_brand(String string, String string2) {
	    searchPage.setFilter(string, string2);
	}

	@Then("{string} {string} should be displayed")
	public void brand_should_be_displayed(String string, String string2) {
		assertTrue("The filter was not applied", searchPage.verifyFilterApplied(string2));
	}

	@When("I print the number of results")
	public void i_print_the_number_of_results() {
		searchPage.printResults();
	}

	@When("I order by {string}")
	public void i_order_by(String string) {
		searchPage.orderList(string);
	}

	@Then("I verify that results are ordered by {string}")
	public void i_verify_that_results_are_ordered_by(String string) {
		assertTrue("Sorted incorrectly", searchPage.verify5SortedPriceASC());
	}
	
	@When("I order by {string} {string} and print results")
	public void i_order_by_and_print_results(String string, String string2) {
		searchPage.orderTop5(string, string2);
	}

	@When("I print the first {int} products")
	public void i_print_the_first_products(Integer int1) {
		searchPage.printTop5();
	}
	
}
