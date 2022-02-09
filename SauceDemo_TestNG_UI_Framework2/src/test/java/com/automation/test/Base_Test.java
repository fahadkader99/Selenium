package com.automation.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.automation.pages.*;
import com.automation.utils.DriverUtils;

public abstract class Base_Test  {

    BikeLightPage bikeLightPage;
    CartPage cartPage;
    HomePage homePage;
    LogInPage logInPage;
    TshirtPage tshirtPage;


    @BeforeMethod
    public void startUp(){

        DriverUtils.createDriver();


        bikeLightPage = new BikeLightPage();
        cartPage = new CartPage();
        homePage = new HomePage();
        logInPage = new LogInPage();
        tshirtPage = new TshirtPage();



    }

    @AfterMethod
    public void closeUp(){
        DriverUtils.getDriver().close();
    }


}
