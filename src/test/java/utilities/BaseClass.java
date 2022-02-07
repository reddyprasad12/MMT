package utilities;
//Importing packages
import java.io.File;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

//import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseClass {

    private String frameworkDir = System.getProperty("user.dir");
    private String webDriverPath = frameworkDir + File.separator + "resources" + File.separator + "chromedriver.exe";

    // create instance for webdriver
    public static WebDriver driver;

    // to launch chrome browser
    public void launchBrowser(String url) {
        System.out.println("Framework Directory : " + frameworkDir);
        System.out.println("WebDriver Path : " + webDriverPath);
        System.out.println("Entered Base Class : " + url);

        System.setProperty("webdriver.chrome.driver", webDriverPath);
        //WebDriver driver = new ChromeDriver();

        //DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability("acceptInsecureCerts", true); // no dedicated method

        //WebDriver driver = new ChromeDriver();

        //WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver = new ChromeDriver(capabilities);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // launch chrome and direct it to the Base URL
        driver.get(url);
    }



    // Explicit wait method for element
    public WebElement waitForExpectedElement(WebDriver driver, final By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
