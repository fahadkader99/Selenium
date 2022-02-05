package com.udemy.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


    @FindBy(id = "login1")
    WebElement usernameEle;

    @FindBy(id = "password")
    WebElement passwordEle;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement sinInBtn;

    @FindBy(xpath = "//div[@class='cell logo']/a")
    WebElement homeBtn;

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement EmailId(){
       return usernameEle;
    }

    public WebElement Password(){
        return passwordEle;
    }

    public WebElement SignIn(){
       return sinInBtn;
    }

    public WebElement HomeBtn(){
        return homeBtn;
    }



}
