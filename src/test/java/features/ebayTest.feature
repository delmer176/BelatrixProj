Feature: Search product

  @ebay @english
  Scenario: Belatrix automation exam
    Given I open "https://www.ebay.com/" in "Firefox" browser
    When I search for "shoes"
    Then "shoes" should be displayed
    When I select "Brand" "PUMA"
    Then "brand" "PUMA" should be displayed
    When I select "Size" "10"
    Then "size" "10" should be displayed
    When I print the number of results
    When I order by "Price + Shipping: lowest first"
    Then I verify that results are ordered by "Price + Shipping: lowest first"
    When I print the first 5 products
    When I order by "name" "ascendant" and print results
    When I order by "price" "descendant" and print results
    
    @ebay @spanish
  Scenario: Belatrix automation exam
    Given I open "https://www.ebay.com/" in "Firefox" browser
    When I search for "zapatos"
    Then "zapatos" should be displayed
    When I select "Marca" "PUMA"
    Then "marca" "PUMA" should be displayed
    When I select "Talla" "10"
    Then "talla" "10" should be displayed
    When I print the number of results
    When I order by "Precio + Envío: más bajo primero"
    Then I verify that results are ordered by "Precio + Envío: más bajo primero"
    When I print the first 5 products
    When I order by "name" "ascendant" and print results
    When I order by "price" "descendant" and print results
    