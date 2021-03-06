package com.udemy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    public WebDriver driver;



    @FindBy(xpath = "//i[@class='fa fa-lock fa-lg'] // following-sibling::span")
    WebElement login;




    public LandingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public WebElement getLogin(){
        return login;
    }

}
