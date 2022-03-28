package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.sound.sampled.FloatControl;

public class BasePage extends Page{


    public BasePage(WebDriver driver){
        super(driver);
    }


    @Override
    public String getPageTitle() {
       return driver.getTitle();
    }


    @Override
    public String getPageHeader(By locator) {
       return getElement(locator).getText();
    }


    @Override
    public WebElement getElement(By locator) {                                                                          // wrapper function (GetElement) naveen created
        WebElement element = null;

        try {                                                                                                            // this is how naveen handle exception in his framework, by using try catch block, not by using throws keyword
            element = driver.findElement(locator);
            return element;
        }
        catch (Exception e){
            System.out.println("Some error occurred while creating element "+ locator.toString());
            e.printStackTrace();
        }

        return element;

    }


    @Override
    public void waitForElementPresent(By locator) {                                                                     // wrapper function for all the waits for elements present || explicit wait
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }
        catch (Exception e){
            System.out.println("Error occurred while waiting for the element: "+ locator.toString());
            e.printStackTrace();
        }
    }


    @Override
    public void waitForPageTitle(String title) {                                                                        // wrapper function for explicit wait for page title to load
        try {
            wait.until(ExpectedConditions.titleContains(title));
        }
        catch (Exception e){
            System.out.println("Error occurred when waiting for the element: "+ title.toString());
            e.printStackTrace();
        }
    }
}
