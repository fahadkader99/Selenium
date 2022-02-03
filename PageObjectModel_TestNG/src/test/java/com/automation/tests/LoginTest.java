package com.automation.tests;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void verifyUserCanLogin(){
        loginPage.doLogin();
        // it will execute for all login function

        homePage.verifyHomePageAfterLogin();
        // it will execute verifyLogin steps


    }

}
