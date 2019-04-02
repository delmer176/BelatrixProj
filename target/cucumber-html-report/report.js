$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/myFirstTest.feature");
formatter.feature({
  "name": "Search product",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Search a product in Aliexpress",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@aliexpress"
    },
    {
      "name": "@all"
    }
  ]
});
formatter.step({
  "name": "I open \"https://www.aliexpress.com/\" in \"Firefox\" browser",
  "keyword": "Given "
});
formatter.match({
  "location": "HomePageSteps.i_open_in_browser(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Home page should be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "HomePageSteps.home_page_should_be_displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I close the coupon pop up",
  "keyword": "When "
});
formatter.match({
  "location": "HomePageSteps.i_close_the_coupon_pop_up()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The coupon pop up is closed",
  "keyword": "Then "
});
formatter.match({
  "location": "HomePageSteps.the_coupon_pop_up_is_closed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on Sign In button",
  "keyword": "When "
});
formatter.match({
  "location": "HomePageSteps.i_click_on_Sign_In_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Sign In page is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginPageSteps.sign_In_page_is_displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I login with user \"delmer176@gmail.com\" and password \"Universitario1924\"",
  "keyword": "When "
});
formatter.match({
  "location": "LoginPageSteps.i_login_with_user_and_password(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user \"Delmer Espinoza Vigo\" should be logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "HomePageSteps.user_should_be_logged_in(String)"
});
formatter.result({
  "status": "passed"
});
});