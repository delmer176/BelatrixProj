package pages;

import java.util.ArrayList;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import entities.Product;

public class SearchPage extends PageObject {

	private By results = By.xpath("//h1[@class='srp-controls__count-heading']");
	private By relatedSuggestion = By.xpath("(//a/span[@class='BOLD']/..)[1]");
	private By currentSorting = By.xpath("//div[@class='srp-controls--selected-value']");
	private By sortDropdown = By.xpath("//div[@class='srp-controls--selected-value']");
	private By sortOption(String value) { 
		return By.xpath("//span[text()='"+value+"']");
	}
	private By filterCbx(String category, String value) { 
		return By.xpath("//h3[contains(text(),'"+category+"')]/../following-sibling::*//span[text()='"+value+"']");
		}
	private By isFilterApplied(String value) { 
		return By.xpath("//span[text()='Filter Applied']/preceding-sibling::span[text()='"+value+"']");
		}
	private By itemPrice(int i) {
		return By.xpath("//li[@id='srp-river-results-listing"+i+"']//span[@class='s-item__price']");
	}
	private By itemName(int i) {
		return By.xpath("//li[@id='srp-river-results-listing"+i+"']//a[@class='s-item__link']");
	}
	private By itemShipping(int i) {
		return By.xpath("//li[@id='srp-river-results-listing"+i+"']//span[@class='s-item__shipping s-item__logisticsCost']");
	}
	
	
	public SearchPage(WebDriver driver) {
		super(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(relatedSuggestion));
	}
	
	public boolean verifySearch(String value) {
		return getLocatorText(relatedSuggestion).contains(value);
	}
	
	public void setFilter(String category, String value) {
		waitAndClick(filterCbx(category, value));
	}
	
	public boolean verifyFilterApplied(String value) {
		return isElementDisplayed(isFilterApplied(value));
	}
	
	public void printResults() {
		System.out.println(getLocatorText(results));
	}
	
	public void orderList(String value) {
		waitAndClick(sortDropdown);
		waitAndClick(sortOption(value));
	}
	
	public boolean verifySortedList(String value) {
		return getLocatorText(currentSorting).contains(value);
	}
	
	public boolean verify5SortedPriceASC() {
		double price = 0.0;
		boolean result = true;
		for (int i = 1; i < 6; i++) {
			String np = getLocatorText(itemPrice(i));
			int npi = np.lastIndexOf(" ")+1;
			String ns = getLocatorText(itemShipping(i));
			int nsi = ns.indexOf(" ")+1;
			int nsf = ns.indexOf(" ", nsi)+1;
			double shipping = 0.0;
			try {
				shipping = Double.parseDouble(ns.substring(nsi,nsf));
			} catch (Exception e) {}
			double newPrice = Double.parseDouble(np.substring(npi)) + shipping;
			
			if (newPrice >= price) {
				price = newPrice;
			}else {
				result = false;
			}
		}
		
		return result;
	}
	
	public void printTop5() {
		String price;
		String shipping;
		String product;
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("THE LIST OF THE 5 FIRST PRODUCTS BEGINS");
		for (int i = 1; i < 6; i++) {
			price = getLocatorText(itemPrice(i));
			product = getLocatorText(itemName(i));
			shipping = getLocatorText(itemShipping(i));
			
			System.out.println("The price of the product "+product+" is: " + price + " " + shipping);
		}
		System.out.println("THE LIST OF THE 5 FIRST PRODUCTS ENDS");
	}
	
	public void orderTop5(String criteria, String dir) {
		
		ArrayList<Product> productList = new ArrayList<Product>();
		Double price;
		String name;
		
		
		for (int i = 1; i < 6; i++) {
			Product product = new Product();
			String prc = getLocatorText(itemPrice(i));
			int prcb = prc.lastIndexOf(" ")+1;
			price = Double.parseDouble(prc.substring(prcb));
			product.setPrice(price);
			
			name = getLocatorText(itemName(i));
			product.setName(name);
			
			productList.add(product);
		}
		
		if (criteria.compareTo("name") == 0) {
			for (int i = 0; i < productList.size()-1; i++) {
				for (int j = 0; j < productList.size()-1-i; j++) {
					if (productList.get(j).getName().compareTo(productList.get(j+1).getName())>0) 
	                { 
	                    Product temp = new Product();
	                    temp.setName(productList.get(j).getName());
	                    temp.setPrice(productList.get(j).getPrice());
	                    productList.get(j).setName(productList.get(j+1).getName());
	                    productList.get(j).setPrice(productList.get(j+1).getPrice());
	                    productList.get(j+1).setName(temp.getName());
	                    productList.get(j+1).setPrice(temp.getPrice());
	                } 
				}
			}
		}else {
			for (int i = 0; i < productList.size()-1; i++) {
				for (int j = 0; j < productList.size()-1-i; j++) {
					if (productList.get(j).getPrice() > productList.get(j+1).getPrice()) 
	                { 
	                    Product temp = new Product();
	                    temp.setName(productList.get(j).getName());
	                    temp.setPrice(productList.get(j).getPrice());
	                    productList.get(j).setName(productList.get(j+1).getName());
	                    productList.get(j).setPrice(productList.get(j+1).getPrice());
	                    productList.get(j+1).setName(temp.getName());
	                    productList.get(j+1).setPrice(temp.getPrice());
	                } 
				}
			}
		}
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("THE LIST SORTED BY "+criteria +" "+dir+" BEGINS");
		if (dir.compareTo("ascendant")==0) {
			for (int i = 0; i < productList.size(); i++) {
				System.out.println("The price of the product "+productList.get(i).getName()+" is: " + productList.get(i).getPrice());
			}
		}else {
			for (int i = productList.size()-1; i >= 0 ; i--) {
				System.out.println("The price of the product "+productList.get(i).getName()+" is: " + productList.get(i).getPrice());
			}
		}
		System.out.println("THE LIST SORTED BY "+criteria +" "+dir+" ENDS");
	}

}
