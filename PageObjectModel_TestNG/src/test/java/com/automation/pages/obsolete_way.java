package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class obsolete_way {

    @Test
    public  void main() throws InterruptedException {

        // Setting path to chromedriver.exe
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        // Open the browser
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // 1. To open url in browser
        driver.get("https://www.saucedemo.com/");


        // logIn
        WebElement login = driver.findElement(By.id("user-name"));
        login.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        // click Login
        WebElement loginBtn = driver.findElement(By.id("login-button"));
        loginBtn.click();



        // < Step 2: >



        // verifying after login - we are at the homepage
        WebElement homePageLogo = driver.findElement(By.className("app_logo"));
        WebElement homePageTitle = driver.findElement(By.cssSelector(".title"));

        Assert.assertTrue(homePageLogo.isDisplayed(),"Logo is missing from homepage");
        Assert.assertTrue(homePageTitle.isDisplayed(),"Title is missing from the homepage");



        // Logout after verifying:
        WebElement burgerMenu = driver.findElement(By.id("react-burger-menu-btn"));
        burgerMenu.click();

        WebElement logoutLink = driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
        Thread.sleep(2000);
        logoutLink.click();


        // verify we are back to login page.
        login = driver.findElement(By.id("user-name"));
        password = driver.findElement(By.id("password"));
        Assert.assertTrue(login.isDisplayed(),"UserName field is missing");
        Assert.assertTrue(password.isDisplayed(),"Password field is missing");

        driver.close();







    }
}
