package utilities;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.ZipOutputStream;
import org.apache.commons.io.FileUtils;
import org.apache.tools.zip.ZipEntry;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class UtilitiesClass {
    // store current working directory path with "user.dir"
    public static String projectPath = System.getProperty("user.dir");
    public String ipaPath;
    public String testDataFilePath = projectPath + "/TestData/";
    public String reportFilePath;
    public Date date;
    static Date dte = new Date();
    static String dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(dte);
    static String reportFileName = "Testing_" + dateFormat;
    public static String screenShotFilePath=projectPath+"/ScreenShots/";
    public String driverPath=projectPath+"/Drivers/";

    // Capture Screen Shot and save in the location
    public static String captureScreenshot(WebDriver driver, String screenshotname) {

        try {

            // Set the Current Date and Time
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");

            Date dt = new Date();
            System.out.println(dateFormat.format(dt));

            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(source, new File(projectPath + "/ScreenShots/"+ dateFormat.format(dt) + "_" + screenshotname + ".jpg"));

            System.out.println("screenshot has taken");
        } catch (Exception e) {
            System.out.println("exception while taking screenshot" + e.getMessage());
        }
        return screenshotname;
    }
}