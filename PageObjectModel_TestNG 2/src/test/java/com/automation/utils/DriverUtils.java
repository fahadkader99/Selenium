package com.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverUtils {

    static WebDriver driver;

    public static void createDriver(){
        //Setting path to chromedriver.exe
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        // Open the browser
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.get(PropertyReader.getProperty("app.url"));


    }

    public static WebDriver getDriver(){
        return driver;
    }

}
