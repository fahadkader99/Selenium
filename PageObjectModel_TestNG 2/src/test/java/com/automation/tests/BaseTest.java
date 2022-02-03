package com.automation.tests;

import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class BaseTest {

    WebDriver driver;

    LoginPage loginPage;    // creating object of that class
    HomePage homePage;


    @BeforeMethod
    public void startUp(){
        //Setting path to chromedriver.exe
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        // Open the browser
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        // 1. To open url in browser
        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);


    }

    @AfterMethod
    public void closeUp(){
        driver.quit();
    }




}
