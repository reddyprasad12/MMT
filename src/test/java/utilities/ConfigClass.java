package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigClass {

    public File src;
    public FileInputStream fis;
    public static Properties prop;

    // Method for get the config property file
    public void loadPropertyFile() throws Exception {
        String filepath= System.getProperty("user.dir") + "/Config/config.properties";

        src = new File(filepath);
        fis = new FileInputStream(src);
        prop = new Properties();
        prop.load(fis);
    }

    // Method for Getting the values from config property file
    public String getProperty(String propKey) {
        return prop.getProperty(propKey);
    }
}
