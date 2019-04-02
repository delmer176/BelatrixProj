Feature: Search product

  @aliexpress @all
  Scenario: Search a product in Aliexpress
    Given I open "https://www.aliexpress.com/" in "Firefox" browser
    Then Home page should be displayed
    When I close the coupon pop up
    Then The coupon pop up is closed
    When I click on Sign In button
    Then Sign In page is displayed
    When I login with user "delmer176@gmail.com" and password "Universitario1924"
    Then user "Delmer Espinoza Vigo" should be logged in
    
    
  @ebay @all @noSteps
  Scenario: Search a product in eBay
    Given I open "https://www.ebay.com/" in "Firefox" browser