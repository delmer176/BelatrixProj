Feature: Search product

  @aliexpress @all
  Scenario: Search a product in Aliexpress
    Given I open "https://www.aliexpress.com/" in "Firefox" browser
    When I get an ID using a rest service
    Then Home page should be displayed
    When I close the coupon pop up
    Then The coupon pop up is closed
    When I click on Sign In button
    Then Sign In page is displayed
    When I login with user "delmer176@gmail.com" and password "Universitario1924"
    Then user "Delmer Espinoza Vigo" should be logged in
    
    
  @ebay @all
  Scenario: Belatrix automation exam
    Given I open "https://www.ebay.com/" in "Firefox" browser
    When I search for "shoes"
    Then "shoes" should be displayed
    When I select brand "PUMA"
    Then brand "PUMA" should be displayed
    When I select size "10"
    Then size "10" should be displayed
    When I print the number of results
    When I order by "price" "ascendant"
    Then I verify that results are ordered by "price" "ascendant"
    When I print the first 5 products
    When I order by "name" "ascendant"
    Then I verify that results are ordered by "name" "ascendant"
    When I order by "price" "descendant"
    Then I verify that results are ordered by "price" "descendant"
    