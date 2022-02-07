package pages;//Importing packages

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BaseClass;

public class SourceAndDestinationPage extends BaseClass {
    public WebDriver driver;

    public SourceAndDestinationPage(WebDriver driver) {
        this.driver = driver;
    }

    // Storing required MakeMyTrip home page web elements
    public static final By HANDLE_POPUP = By.xpath("//li[@class='makeFlex hrtlCenter font10 makeRelative lhUser userLoggedOut']");
    public static final By FROM = By.xpath("//input[@id='fromCity']");
    public static final By FROM_TEXT_FIELD = By.xpath("//input[@class='react-autosuggest__input react-autosuggest__input--open']");
    public static final By FROM_LABLE = By.xpath("//div[@class='fsw_inputBox searchCity inactiveWidget ']/label/input");
    public static final By LIST_ITEM_FROM = By.xpath("//li[@id='react-autowhatever-1-section-0-item-0']");
    public static final By TO = By.xpath("//input[@id='toCity']");
    public static final By TO_TEXT_FIELD = By.xpath("//div[@class='react-autosuggest__container react-autosuggest__container--open']/input");
    public static final By LIST_ITEM_TO = By.xpath("(//div[@class='makeFlex hrtlCenter']/div/p[1])[position()=1]");
    public static final By ROUND_TRIP = By.xpath("(//ul[@class='fswTabs latoBlack greyText']/li)[position()=2]");


    public void sendSourcePlace(String sourcePlace, WebDriver driver) {
        try {
            Thread.sleep(5000);
            driver.findElement(HANDLE_POPUP).click();
            driver.findElement(ROUND_TRIP).click();
            waitForExpectedElement(driver, FROM);
            driver.findElement(FROM).click();
            Thread.sleep(5000);
            waitForExpectedElement(driver, FROM_TEXT_FIELD);
            driver.findElement(FROM_TEXT_FIELD).sendKeys(sourcePlace);
            waitForExpectedElement(driver, LIST_ITEM_FROM);
            Thread.sleep(5000);
            driver.findElement(LIST_ITEM_FROM).click();
            Thread.sleep(5000);

        } catch (Exception e) {
            e.getMessage();
        }

    }

    public String getTextFromSource(WebDriver driver) {
        String source = null;
        try {
            waitForExpectedElement(driver, FROM);
            WebElement sourceTextField = driver.findElement(FROM_LABLE);
            source = sourceTextField.getAttribute("value");
            //source = textbox.getText();
        } catch (Exception e) {
            e.getMessage();
        }
        return source;
    }

    public void sendDestinationPlace(String destinationPlace, WebDriver driver) {
        try {
            waitForExpectedElement(driver, TO);
            driver.findElement(TO).click();
            Thread.sleep(5000);
            driver.findElement(TO_TEXT_FIELD).sendKeys(destinationPlace);
            Thread.sleep(3000);
            driver.findElement(LIST_ITEM_TO).click();
            Thread.sleep(30000);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public String getTextFromDestination(WebDriver driver) {
        String destination = null;
        try {
            waitForExpectedElement(driver, TO);
            WebElement destinationtTextField = driver.findElement(TO);
            destination = destinationtTextField.getAttribute("value");
        } catch (Exception e) {
            e.getMessage();
        }
        return destination;
    }
}
