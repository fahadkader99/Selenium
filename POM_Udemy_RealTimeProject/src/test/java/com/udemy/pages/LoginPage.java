package com.udemy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;

    @FindBy(id = "user_email")
    WebElement emailBox;

    @FindBy(id = "user_password")
    WebElement passwordBox;

    @FindBy(xpath = "//input[@value='Log In']")
    WebElement loginBtn;

    public  LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public WebElement getEmailBox(){
        return emailBox;
    }
    public WebElement getPasswordBox(){
        return passwordBox;
    }
    public WebElement getLoginBtn(){
        return loginBtn;
    }



}
