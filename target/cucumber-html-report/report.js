$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/myFirstTest.feature");
formatter.feature({
  "name": "Search product",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Search a product in eBay",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@ebay"
    },
    {
      "name": "@all"
    }
  ]
});
formatter.step({
  "name": "I open \"https://www.ebay.com/\" in \"Firefox\" browser",
  "keyword": "Given "
});
formatter.match({
  "location": "HomePageSteps.i_open_in_browser(String,String)"
});
formatter.result({
  "status": "passed"
});
});