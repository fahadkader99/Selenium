package Udemy.browserSetUp;

import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumIntroChrome {
    public static void main(String[] args) {

        // 1st we have to invoke browser.
        // Chrome - ChromeDriver -> Methods

        // we are setting the property. (to invoke the driver)
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver");

        // webdriver.chrome.driver > value of path

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/");

        // Test - check the title of the page
        System.out.println("\nTitle: "+driver.getTitle());

        // Test - am I on the proper page || redirecting to other page, if hacked!
        System.out.println("Current url: "+driver.getCurrentUrl());
        driver.quit();


    }
}
