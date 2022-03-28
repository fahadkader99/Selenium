package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {


    // Page Locators
    private By userName = By.id("username");
    private By password = By.id("password");
    private By loginButton = By.id("submit");
    private By header = By.className("login-logo");


    // Getters
    public WebElement getUserName() {                                                                                   // we are using the getElement method to return webElement so that we can perform action on them
        return getElement(userName);
    }

    public WebElement getPassword() {
        return getElement(password);
    }

    public WebElement getLoginButton() {
        return getElement(loginButton);
    }

    public WebElement getHeader() {
        return getElement(header);
    }


    // Constructor
    public LoginPage(WebDriver driver){
        super(driver);
    }


    public String  get_LoginPage_Title(){
        return getPageTitle();
    }

    public String get_LoginPage_Header(){
        return getPageHeader(header);
    }

    // login method
    public HomePage do_Login(String userName, String password){
        getUserName().sendKeys(userName);
        getPassword().sendKeys(password);
        getLoginButton().click();

        return getInstance(HomePage.class);
    }

    // Method overloading + Negative testing
    public HomePage do_Login(){                                                  // same method as previous with any Parameter + for negative test case
        getUserName().sendKeys("");
        getPassword().sendKeys("");
        getLoginButton().click();

        return getInstance(HomePage.class);
    }

    public void do_Login(String userCred){                                  // Just an Example of custom method with method overloading + for negative test case

        if (userCred.contains("username")){
            getUserName().sendKeys(userCred.split(":")[1].trim());      // username: kader@gmail.com
        }
        else if (userCred.contains("password")){
            getUserName().sendKeys(userCred.split(":")[1].trim());
        }
        getLoginButton().click();
    }



}
