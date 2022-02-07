package stepdefmakemytrip;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pages.DepartureAndReturnPage;
import pages.FlightPage;
import pages.SourceAndDestinationPage;
import pages.TravellersAndClassPage;
import utilities.BaseClass;
import utilities.ConfigClass;
import utilities.UtilitiesClass;

public class MakeMyTripTestScript extends BaseClass {

    // Object creation for page classes
    SourceAndDestinationPage objSADP = new SourceAndDestinationPage(driver);
    DepartureAndReturnPage objDARP = new DepartureAndReturnPage(driver);
    TravellersAndClassPage objTACP = new TravellersAndClassPage(driver);
    FlightPage objFP = new FlightPage(driver);

    // Object creation for utilities classes
    ConfigClass config=new ConfigClass();
    UtilitiesClass objUtil = new UtilitiesClass();
    BaseClass objBC = new BaseClass();


    @Before
    public void start( ) throws Exception{
        config.loadPropertyFile();
    }

    /*Scenario: select source and destination in makemytrip # Features/makemytrip.feature:3
    Given user is already on home page
    When user select source and destination
    Then display source and destination on home page

    io.cucumber.junit.UndefinedStepException: The step 'user is already on home page' and 2 other step(s) are undefined.
    You can implement these steps using the snippet(s) below:*/

    @Given("user is already on home page")
    public void user_is_already_on_home_page() {
        launchBrowser(config.getProperty("url"));
    }

    @When("user select source and destination")
    public void user_select_source_and_destination() {
        objSADP.sendSourcePlace(config.getProperty("from"), driver);
        objSADP.sendDestinationPlace(config.getProperty("to"), driver);

    }
    @Then("display source and destination on home page")
    public void display_source_and_destination_on_home_page() {
        String source = objSADP.getTextFromSource(driver);
        System.out.println("Return Source Value : " + source);
       // Assert.assertEquals(config.getProperty("from"), source);
        String destination = objSADP.getTextFromDestination(driver);
        //Assert.assertEquals(config.getProperty("to"), destination);
    }


    /*Scenario: select departure and return date                               # Features/makemytrip.feature:8
    Given user is already on home page
    When user select departure date as 13th feb and return date as 19th Feb
    Then display departure date and return date on home page

    io.cucumber.junit.UndefinedStepException: The step 'user is already on home page' and 2 other step(s) are undefined.
    You can implement these steps using the snippet(s) below:*/

    /*@Given("user is already on home page")
    public void user_is_already_on_home_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }*/

    @When("user select departure date as 10th feb and return date as 18th Feb")
    public void user_select_departure_date_as_10th_feb_and_return_date_as_18th_feb() {
        objSADP.sendSourcePlace(config.getProperty("from"), driver);
        objSADP.sendDestinationPlace(config.getProperty("to"), driver);
        String source = objSADP.getTextFromSource(driver);
        System.out.println("Return Source Value : " + source);
       // Assert.assertEquals(config.getProperty("from"), source);
        String destination = objSADP.getTextFromDestination(driver);
       // Assert.assertEquals(config.getProperty("to"), destination);
        objDARP.selectDepartureDate(driver);
        objDARP.selectReturnDate(driver);
    }
    @Then("display departure date and return date on home page")
    public void display_departure_date_and_return_date_on_home_page() {
        String departureDate = objDARP.getDepartureDate(driver);
        System.out.println("Selected Departure Date: " + departureDate);
        String returnDate = objDARP.getReturnDate(driver);
        System.out.println("Selected Return Date: " + returnDate);
    }


   /* Scenario: select passengers like adults and childrens combination # Features/makemytrip.feature:13
    Given user is already on home page
    When user select 2 adults and 1 children
    Then display total number of passengers on home page

    io.cucumber.junit.UndefinedStepException: The step 'user is already on home page' and 2 other step(s) are undefined.
    You can implement these steps using the snippet(s) below:*/

    @Given("user navigate to travellers and class screen from home page")
    public void user_navigate_to_travellers_and_class_screen_from_home_page() {
        objSADP.sendSourcePlace(config.getProperty("from"), driver);
        objSADP.sendDestinationPlace(config.getProperty("to"), driver);
        String source = objSADP.getTextFromSource(driver);
        System.out.println("Return Source Value : " + source);
       // Assert.assertEquals(config.getProperty("from"), source);
        String destination = objSADP.getTextFromDestination(driver);
       // Assert.assertEquals(config.getProperty("to"), destination);
        objDARP.selectDepartureDate(driver);
        objDARP.selectReturnDate(driver);
        String departureDate = objDARP.getDepartureDate(driver);
        System.out.println("Selected Departure Date: " + departureDate);
        String returnDate = objDARP.getReturnDate(driver);
        System.out.println("Selected Return Date: " + returnDate);
        objTACP.navigateToTravellersAndClassScreen(driver);
    }

    @When("user select {int} adults and {int} children")
    public void user_select_adults_and_children(Integer int1, Integer int2) {
        objTACP.selectAdults(driver);
        objTACP.selectChildrens(driver);
    }
    @Then("display total number of passengers on home page")
    public void display_total_number_of_passengers_on_home_page() {
        objTACP.clickOnApplyButton(driver);
        String numberOfPassengers = objTACP.getNumberOfPassengers(driver);

    }


    /*Scenario: select low priced airlines and click book now button # Features/makemytrip.feature:18
    Given user navigate from home page to flights page
    When user select low price airlines
    And user click BOOK NOW button
    Then user navigate to more fares popup window

    io.cucumber.junit.UndefinedStepException: The step 'user navigate from home page to flights page' and 3 other step(s) are undefined.
    You can implement these steps using the snippet(s) below:*/

    @Given("user navigate from home page to flights page")
    public void user_navigate_from_home_page_to_flights_page() {
        objSADP.sendSourcePlace(config.getProperty("from"), driver);
        objSADP.sendDestinationPlace(config.getProperty("to"), driver);
        String source = objSADP.getTextFromSource(driver);
        System.out.println("Return Source Value : " + source);
       // Assert.assertEquals(config.getProperty("from"), source);
        String destination = objSADP.getTextFromDestination(driver);
       // Assert.assertEquals(config.getProperty("to"), destination);
        objDARP.selectDepartureDate(driver);
        objDARP.selectReturnDate(driver);
        String departureDate = objDARP.getDepartureDate(driver);
        System.out.println("Selected Departure Date: " + departureDate);
        String returnDate = objDARP.getReturnDate(driver);
        System.out.println("Selected Return Date: " + returnDate);
        objTACP.navigateToTravellersAndClassScreen(driver);
        objTACP.selectAdults(driver);
        objTACP.selectChildrens(driver);
        objTACP.clickOnApplyButton(driver);
        String numberOfPassengers = objTACP.getNumberOfPassengers(driver);
        objFP.clickOnSearchButton(driver);

    }
    @When("user select low price airlines")
    public void user_select_low_price_airlines() {
        System.out.println("");
    }
    @When("user click BOOK NOW button")
    public void user_click_book_now_button() {
        System.out.println("");
    }
    @Then("user navigate to more fares popup window")
    public void user_navigate_to_more_fares_popup_window() {
        System.out.println("");
    }


    /*Scenario: change premium flex from economic class and click continue # Features/makemytrip.feature:24
    Given user is already on more fares popup window
    When user change Premium Flex from Economic class
    And user click CONTINUE button
                    Then user navigate to CompleteYourBooking window

                    io.cucumber.junit.UndefinedStepException: The step 'user is already on more fares popup window' and 3 other step(s) are undefined.
    You can implement these steps using the snippet(s) below:*/

    @Given("user is already on more fares popup window")
    public void user_is_already_on_more_fares_popup_window() {
        System.out.println("");
    }
    @When("user change Premium Flex from Economic class")
    public void user_change_premium_flex_from_economic_class() {
        System.out.println("");
    }
    @When("user click CONTINUE button")
    public void user_click_continue_button() {
        System.out.println("");
    }
    @Then("user navigate to CompleteYourBooking window")
    public void user_navigate_to_complete_your_booking_window() {
        System.out.println("");
    }

    @After
    public void browser() throws Throwable {
        driver.close();
    }
}
