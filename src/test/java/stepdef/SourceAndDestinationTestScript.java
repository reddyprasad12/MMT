package stepdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import pages.SourceAndDestinationPage;
import utilities.BaseClass;
import utilities.ConfigClass;
import utilities.UtilitiesClass;

public class SourceAndDestinationTestScript extends BaseClass {

    // Object creation for page classes
    SourceAndDestinationPage objSADP = new SourceAndDestinationPage(driver);

    // Object creation for utilities classes
    ConfigClass config=new ConfigClass();
    UtilitiesClass objUtil = new UtilitiesClass();
    BaseClass objBC = new BaseClass();

    Logger logger = Logger.getLogger(SourceAndDestinationTestScript.class);

    @Before
    public void start( ) throws Exception{
        config.loadPropertyFile();
        //PropertyConfigurator.configure("./Log4j/log4j.properties");
    }

    @Given("user is already on makemytrip page")
    public void user_is_already_on_makemytrip_page() {
        launchBrowser(config.getProperty("url"));
        //logs an info message
        logger.info("Browser launched & url opened");
    }
    @When("user select source and destination")
    public void user_select_source_and_destination() {
        objSADP.sendSourcePlace(config.getProperty("from"), driver);
        logger.info("Selected Source place");
        //Thread.sleep(5000);
        objSADP.sendDestinationPlace(config.getProperty("to"), driver);
        logger.info("Selected Destination Place");
    }
    @Then("display source and destination on screen")
    public void display_source_and_destination_on_screen() {
        String source = objSADP.getTextFromSource(driver);
        System.out.println("Return Source Value : " + source);
        Assert.assertEquals(config.getProperty("from"), source);
        //logs an info message with parameter
        logger.info("Entered Source Place : " + source);

        String destination = objSADP.getTextFromDestination(driver);
        Assert.assertEquals(config.getProperty("to"), destination);
        //logs an info message with parameter
        logger.info("Entered Source Place : " + destination);
    }


    @After
    public void browser() throws Throwable {
        driver.close();
    }
}
