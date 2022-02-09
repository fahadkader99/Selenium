package com.udemy.test;

import com.udemy.pages.LandingPage;
import com.udemy.pages.LoginPage;
import com.udemy.utils.Base;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class landingPageTest extends Base {

    @Test
    public void basePageNavigation() throws IOException {
        driver=initializeDriver();
        driver.get("http://qaclickacademy.com");

        LandingPage land = new LandingPage(driver);
        land.getLogin().click();


        LoginPage login = new LoginPage(driver);
        login.getEmailBox().sendKeys("abc@gmail.com");
        login.getPasswordBox().sendKeys("Abc12345");
        login.getLoginBtn().click();


    }

//    @DataProvider
//    public void getData(){
//        Object[][] data = new Object[1][2];
//        // [r]row is for how many data types test should run
//        // [c]colum is for how many values we are sending per test
//
//    }

}
