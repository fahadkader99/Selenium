package Udemy.browserSetUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SeleniumIntroEdge {
    public static void main(String[] args) {

        System.setProperty("webdriver.edge.driver","src/test/resources/driver/msedgedriver");
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.rahulshettyacademy.com/");
        System.out.println("Title: "+ driver.getTitle());
        System.out.println("Current Url: "+ driver.getCurrentUrl());
        driver.close();

    }
}
