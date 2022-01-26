package Udemy.browserSetUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SeleniumIntroSafari {

    public static void main(String[] args) {

        System.setProperty("webdriver.safari.driver","/usr/bin/safaridriver");
        WebDriver driver = new SafariDriver();
        driver.get("https://www.rahulshettyacademy.com/");
        System.out.println("Title: "+ driver.getTitle());
        System.out.println("Current Url: "+ driver.getCurrentUrl());
        System.out.println("Last page loaded "+ driver.getPageSource());
        driver.close();
    }
}
