package com.automation.pages;

import com.automation.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends BasePage {
    @FindBy(id= "user-name")
    WebElement login;

    @FindBy(id= "password")
    WebElement password;

    @FindBy(id= "login-button")
    WebElement loginBtn;




    public void doLogin(){
       // all the action will be here and the elements will be at the top
        login.sendKeys(PropertyReader.getProperty("login.username"));
        password.sendKeys(PropertyReader.getProperty("login.password"));
        loginBtn.click();

    }

    public void verifyLoginPage(){
        // verify with assert that we are at the homepage after logging in
        Assert.assertTrue(login.isDisplayed(),"Logo is missing from homepage");
        Assert.assertTrue(password.isDisplayed(),"Title is missing from the homepage");
    }



}
