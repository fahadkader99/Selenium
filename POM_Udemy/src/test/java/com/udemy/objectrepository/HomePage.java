package com.udemy.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(id = "srchword")
    WebElement searchBox;

    @FindBy(xpath = "//input[@class='newsrchbtn']")
    WebElement searchBtn;












    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement SearchBox(){
        return searchBox;
    }

    public WebElement SearchBtn(){
        return searchBtn;
    }


}
