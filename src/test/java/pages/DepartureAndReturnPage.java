package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BaseClass;

import java.util.List;

public class DepartureAndReturnPage extends BaseClass {
    public WebDriver driver;

    public DepartureAndReturnPage(WebDriver driver) {
        this.driver = driver;
    }

    // Storing required MakeMyTrip home page web elements
    public static final By SELECT_DEPARTURE_DATE = By.xpath("(//div[@class='dateInnerCell']/p)[position()=15]");
    public static final By SELECT_RETURN_DATE = By.xpath("(//div[@class='DayPicker-Week']/div)[position()=21]");
    public static final By GET_DEPARTURE_DATE = By.xpath("//div[@class='fsw_inputBox dates inactiveWidget ']/label/p/span");
    public static final By GET_RETURN_DATE = By.xpath("//div[@class='fsw_inputBox dates reDates inactiveWidget  ']/label/p/span");

    public void selectDepartureDate(WebDriver driver) {
        try {
            waitForExpectedElement(driver, SELECT_DEPARTURE_DATE);
            Thread.sleep(5000);
            driver.findElement(SELECT_DEPARTURE_DATE).click();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void selectReturnDate(WebDriver driver) {
        try {
            //waitForExpectedElement(driver, SELECT_RETURN_DATE);
            //Thread.sleep(5000);
           // WebElement m=driver.findElement(By.xpath("//div[@class='fsw ']/div/div[4]"));
            //div[@class='fsw_inputBox dates reDates inactiveWidget ']/div/label
            //JavascriptExecutor js = (JavascriptExecutor) driver;
            //js.executeScript("arguments[0].click();", m);
            //driver.findElement(By.xpath("//div[@class='fsw ']/div/div[4]")).click();
            Thread.sleep(5000);
            //driver.findElement(By.xpath("(//ul[@class='fswTabs latoBlack greyText']/li)[position()=2]")).click();
            //Thread.sleep(3000);
            //driver.findElement(By.xpath("(//div[@class='fsw_inputBox dates reDates inactiveWidget  shiftModal']/label/p)[position()=1]")).click();
            Thread.sleep(2000);
            driver.findElement(SELECT_RETURN_DATE).click();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public String getDepartureDate(WebDriver driver) {
        String getDepartureDate = "";
        try {
            waitForExpectedElement(driver, GET_DEPARTURE_DATE);
            Thread.sleep(3000);
            List<WebElement> elementList = driver.findElements(GET_DEPARTURE_DATE);

            for (WebElement a : elementList) {
                getDepartureDate = getDepartureDate + a.getText();
            }
            System.out.println("Departure Date: " + getDepartureDate);
        } catch (Exception e) {
            e.getMessage();
        }
        return getDepartureDate;
    }

    public String getReturnDate(WebDriver driver) {
        String getReturnDate = "";
        try {
            waitForExpectedElement(driver, GET_RETURN_DATE);
            Thread.sleep(3000);
            List<WebElement> elementList = driver.findElements(GET_DEPARTURE_DATE);

            for (WebElement a : elementList) {
                getReturnDate = getReturnDate + a.getText();
            }
            System.out.println("Departure Date: " + getReturnDate);
        } catch (Exception e) {
            e.getMessage();
        }
        return getReturnDate;
    }

}
