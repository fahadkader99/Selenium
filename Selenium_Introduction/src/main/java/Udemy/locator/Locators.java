package Udemy.locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        // logging in using username and password selectors and by sending keys
        driver.findElement(By.id("inputUsername")).sendKeys("rahul");
        driver.findElement(By.name("inputPassword")).sendKeys("Ash123");
        driver.findElement(By.className("signInBtn")).click();
        driver.close();


    }
}
