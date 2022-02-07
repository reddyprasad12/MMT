package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BaseClass;

import java.util.List;

public class FlightPage extends BaseClass {

    public WebDriver driver;

    public FlightPage(WebDriver driver) {
        this.driver = driver;
    }

    public static final By SEARCH = By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']");
    public static final By EXPAND_LIST = By.xpath("//span[@class='linkText pointer']");
    public static final By FARE_LIST = By.xpath("//label[@class='makeFlex spaceBtwCenter appendBottom12 pointer ']/span");
    public static final By LOW_FARE = By.xpath("(//label[@class='makeFlex spaceBtwCenter appendBottom12 pointer '])[position()=15]");
    public static final By BOOK_NOW_BUTTON = By.xpath("//button[@id='bookbutton-RKEY:5777fa91-0a2f-47f2-bdcd-6adfd2e4a792:12_0~~~RKEY:5777fa91-0a2f-47f2-bdcd-6adfd2e4a792:61_0']");

    public void clickOnSearchButton(WebDriver driver) {
        try {
            waitForExpectedElement(driver, SEARCH);
            Thread.sleep(3000);
            driver.findElement(SEARCH).click();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void clickOnExpandFareList(WebDriver driver) {
        try {
            waitForExpectedElement(driver, EXPAND_LIST);
            Thread.sleep(3000);
            WebElement expandList = driver.findElement(EXPAND_LIST);
            expandList.findElement(EXPAND_LIST).click();

        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void selectLowPriceArilines(WebDriver driver) {
        try {
            // to scroll upto element found
            waitForExpectedElement(driver, LOW_FARE);
            WebElement element = driver.findElement(LOW_FARE);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,500)", "");
            Thread.sleep(6000);
            element.click();
            js.executeScript("window.scrollBy(0,1000)", "");
            Thread.sleep(6000);

        } catch (Exception e) {
            e.getMessage();
        }
    }

    public  void clickOnBookNowButton(WebDriver driver){
        try {
            waitForExpectedElement(driver, BOOK_NOW_BUTTON);
            Thread.sleep(5000);
            WebElement element = driver.findElement(BOOK_NOW_BUTTON);
            Thread.sleep(5000);
            //driver.switchTo().frame(element);
            //Thread.sleep(5000);
            element.click();
           // element.submit();

        } catch (Exception e) {
            e.getMessage();
        }
    }
}
