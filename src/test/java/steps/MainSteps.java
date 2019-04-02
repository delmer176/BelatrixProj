package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;

public class MainSteps {
	
	protected static WebDriver driver;
	
	public WebDriver setDriver(String browser) {
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
		return driver;
	}

}
