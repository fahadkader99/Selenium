package com.udemy.testcases;

import com.udemy.objectrepository.HomePage;
import com.udemy.objectrepository.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {

    @Test
    public void login(){

        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");


        // if we want to access login page methods from the test class , 1st we need to create the object of that class here.

        LoginPage loginPage = new LoginPage(driver);  // when we create an object of any class, by default there constructor will be called.
        loginPage.EmailId().sendKeys("test@gmail.com");
        loginPage.Password().sendKeys("Test@gmail.com");
        loginPage.SignIn().click();
        loginPage.HomeBtn().click();


        HomePage homePage = new HomePage(driver);
        homePage.SearchBox().sendKeys("TV");
        homePage.SearchBtn().click();
    }

}
