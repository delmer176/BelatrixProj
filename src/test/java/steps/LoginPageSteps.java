package steps;

import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageSteps extends MainSteps{

	private LoginPage loginPage;
	private HomePage homePage;


	@Then("Sign In page is displayed")
	public void sign_In_page_is_displayed() {
	    loginPage = new LoginPage(driver);
	    assertTrue("Login page was not displayed", loginPage.isCorrectlyDisplayed());
	}

	@When("I login with user {string} and password {string}")
	public void i_login_with_user_and_password(String user, String password) {
		loginPage = new LoginPage(driver);
		loginPage.switchToLoginFrame();
		loginPage.setAccount(user);
		loginPage.setPassword(password);
		homePage = loginPage.clickOnSignInButton();
	}
	
}
