package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends BasePage{

    @FindBy(className = "app_logo")
    WebElement homePageLogo;

    @FindBy(css = ".title")
    WebElement homePageTitle;

    @FindBy(id = "react-burger-menu-btn")
    WebElement burgerMenu;

    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    WebElement logoutLink;


    public void verifyHomePageAfterLogin(){
        // verifying after login - we are at the homepage
        Assert.assertTrue(homePageLogo.isDisplayed(),"Logo is missing from homepage");
        Assert.assertTrue(homePageTitle.isDisplayed(),"Title is missing from the homepage");
    }

    public void clickBurgerMenu(){
        // clicking burger menu will open logout link
        burgerMenu.click();
    }

    public void clickLogoutLink(){
        // clicking logout Btn
        logoutLink.click();
    }

}
