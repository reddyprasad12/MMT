package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseClass;

public class TravellersAndClassPage extends BaseClass {

    public WebDriver driver;

    public TravellersAndClassPage(WebDriver driver) {
        this.driver = driver;
    }

    // Storing required MakeMyTrip Travellers And Class web elements
    public static final By TRAVELLERS_AND_CLASS = By.xpath("//input[@id='travellers']");
    public static final By ADULTS = By.xpath("(//div[@class='appendBottom20']/ul/li)[position()=2]");
    public static final By CHILDRENS = By.xpath("(//div[@class='makeFlex column childCounter']/ul/li)[position()=2]");
    public static final By APPLY_BTN = By.xpath("//div[@class='right makeFlex hrtlCenter']/button");
    public static final By TOTAL_PASSENGERS = By.xpath("//p[@class='blackText font20 code']/span/span");

    public void navigateToTravellersAndClassScreen(WebDriver driver) {
        try {
            //waitForExpectedElement(driver, TRAVELLERS_AND_CLASS);
            Thread.sleep(5000);
            Actions actions = new Actions(driver);
            //Retrieve WebElement to perform mouse hover
            WebElement webElement = driver.findElement(TRAVELLERS_AND_CLASS);
            //Mouse hover '
            actions.moveToElement(webElement).perform();
            actions.click().build().perform();
            //webElement.click();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void selectAdults(WebDriver driver) {
        try {
            waitForExpectedElement(driver, ADULTS);
            Thread.sleep(3000);
            driver.findElement(ADULTS).click();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void selectChildrens(WebDriver driver) {
        try {
            waitForExpectedElement(driver, CHILDRENS);
            Thread.sleep(3000);
            driver.findElement(CHILDRENS).click();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void clickOnApplyButton(WebDriver driver) {
        try {
            waitForExpectedElement(driver, APPLY_BTN);
            Thread.sleep(3000);
            driver.findElement(APPLY_BTN).click();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public String getNumberOfPassengers(WebDriver driver) {
        String passengersCount = null;
        try {
            waitForExpectedElement(driver, TOTAL_PASSENGERS);
            Thread.sleep(3000);
            passengersCount = driver.findElement(TOTAL_PASSENGERS).getText();
        } catch (Exception e) {
            e.getMessage();
        }
        return passengersCount;
    }


}
