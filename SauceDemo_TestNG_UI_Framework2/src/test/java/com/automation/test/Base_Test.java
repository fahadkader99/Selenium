package com.automation.test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.automation.pages.*;
import com.automation.utils.DriverUtils;

import java.io.File;
import java.io.IOException;

public abstract class Base_Test  {
    //WebDriver driver;

    BikeLightPage bikeLightPage;
    CartPage cartPage;
    HomePage homePage;
    LogInPage logInPage;
    TshirtPage tshirtPage;
    CheckoutPage checkoutPage;
    OverviewPage overviewPage;
    ConfirmationPage confirmationPage;


    @BeforeMethod
    public void startUp(){

        DriverUtils.createDriver();


        bikeLightPage = new BikeLightPage();
        cartPage = new CartPage();
        homePage = new HomePage();
        logInPage = new LogInPage();
        tshirtPage = new TshirtPage();
        checkoutPage = new CheckoutPage();
        overviewPage = new OverviewPage();
        confirmationPage = new ConfirmationPage();



    }

    @AfterMethod
    public void closeUp(){
        DriverUtils.getDriver().close();
    }


}
