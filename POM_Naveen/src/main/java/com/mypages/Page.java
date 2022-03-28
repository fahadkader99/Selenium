package com.mypages;
// https://www.youtube.com/watch?v=g3r5KK2Acx8&t=655s


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

    WebDriver driver;
    WebDriverWait wait;


    public Page(WebDriver driver) {                                                                                      // constructor allowed in Abstract class not in Interface
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 15);                                                   // explicitly wait
    }


    // abstract methods:                        -> EveryPage will have this number of methods

    public abstract String getPageTitle();

    public abstract String getPageHeader(By locator);

    public abstract WebElement getElement(By locator);

    public abstract void waitForElementPresent(By locator);

    public abstract void waitForPageTitle(String title);


    // Use concepts of Generics

    public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {


        try {
            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
        } catch (Exception e) {
            e.fillInStackTrace();
            return null;
        }

    }



}
