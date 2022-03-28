package com.myTest;

import com.mypages.BasePage;
import com.mypages.HomePage;
import com.mypages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @Test(priority = 1)
    public void verifyLoginPage_TitleTest(){
        String title = page.getInstance(LoginPage.class).get_LoginPage_Title();
        System.out.println("--> LoginPage Title: "+title);
        // I can also do Assert here to verify


    }

    @Test(priority = 2)
    public void verifyLoginPage_HeaderTest(){
        String header = page.getInstance(LoginPage.class).get_LoginPage_Header();
        System.out.println("--> Login Page Header: "+header);
        // I can also do Assert here to verify


    }

    @Test(priority = 3)
    public void do_LoginTest(){
        HomePage homePage= page.getInstance(LoginPage.class).do_Login("jahan@gmail.com","Jahan12345");
        String homePageHeader = homePage.getHomePageHeader();
        System.out.println("--> Home Page Header: "+homePageHeader);
        // I can also do Assert here to verify

    }






}
