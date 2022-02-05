package com.automation.tests;

import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.utils.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class BaseTest {


    LoginPage loginPage;    // creating object of that class
    HomePage homePage;


    @BeforeMethod
    public void startUp(){

        // 1. To open url in browser
        DriverUtils.createDriver();

        loginPage = new LoginPage();
        homePage = new HomePage();


    }

    @AfterMethod
    public void closeUp(){
        DriverUtils.getDriver().quit();
    }




}
