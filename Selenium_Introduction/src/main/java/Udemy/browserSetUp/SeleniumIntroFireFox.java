package Udemy.browserSetUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumIntroFireFox {

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver","src/test/resources/driver/geckodriver");

        // for irefox we have gecko driver.
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.rahulshettyacademy.com/");
        System.out.println("Title: "+ driver.getTitle());
        System.out.println("Current Url: "+ driver.getCurrentUrl());
        driver.close();



    }
}
