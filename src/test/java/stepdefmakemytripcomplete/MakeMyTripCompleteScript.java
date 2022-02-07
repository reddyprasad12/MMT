package stepdefmakemytripcomplete;

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

public class MakeMyTripCompleteScript extends BaseClass {

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

    @Given("Given user is already on home page")
    public void given_user_is_already_on_home_page() {
        launchBrowser(config.getProperty("url"));
    }
    @When("user select source and destination")
    public void user_select_source_and_destination() {
        objSADP.sendSourcePlace(config.getProperty("from"), driver);
        objSADP.sendDestinationPlace(config.getProperty("to"), driver);
        String source = objSADP.getTextFromSource(driver);
        //System.out.println("Return Source Value : " + source);
        // Assert.assertEquals(config.getProperty("from"), source);
        String destination = objSADP.getTextFromDestination(driver);
        //Assert.assertEquals(config.getProperty("to"), destination);
    }
    @When("user select departure and return date")
    public void user_select_departure_and_return_date() {
        objDARP.selectDepartureDate(driver);
        objDARP.selectReturnDate(driver);
        String departureDate = objDARP.getDepartureDate(driver);
       // System.out.println("Selected Departure Date: " + departureDate);
        String returnDate = objDARP.getReturnDate(driver);
        //System.out.println("Selected Return Date: " + returnDate);
    }
    @When("user select passengers like adults and childrens combination")
    public void user_select_passengers_like_adults_and_childrens_combination() {
        objTACP.navigateToTravellersAndClassScreen(driver);
        objTACP.selectAdults(driver);
        objTACP.selectChildrens(driver);
        objTACP.clickOnApplyButton(driver);
        String numberOfPassengers = objTACP.getNumberOfPassengers(driver);
        System.out.println("Total Passengers: " + numberOfPassengers);
    }
    @When("user select low priced airlines and click book now button")
    public void user_select_low_priced_airlines_and_click_book_now_button() {
        objFP.clickOnSearchButton(driver);
        objFP.clickOnExpandFareList(driver);
        objFP.selectLowPriceArilines(driver);
        objFP.clickOnBookNowButton(driver);
    }
    @Then("user navigate to paymentgate way page")
    public void user_navigate_to_paymentgate_way_page() {
       System.out.println("Build Script part is pending");
    }

    @After
    public void browser() throws Throwable {
        driver.close();
    }
}
