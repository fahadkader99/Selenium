package com.automation.tests;

import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void verifyUserCanLogoutFromHomePage(){

        // 1st login - method belong to login page
        loginPage.doLogin();

        // 2 - verify on the homepage
        homePage.verifyHomePageAfterLogin();

        // 3- chick on the menu btn
        homePage.clickBurgerMenu();

        // 4- click on the logout btn
        homePage.clickLogoutLink();

        // 5 - verify after logout back to login page, method belong to login page
        loginPage.verifyLoginPage();
    }
}
