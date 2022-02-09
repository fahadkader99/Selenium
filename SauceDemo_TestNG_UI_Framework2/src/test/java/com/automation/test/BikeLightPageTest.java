package com.automation.test;

import org.testng.annotations.Test;

public class BikeLightPageTest extends Base_Test{

    @Test
    public void verifyUserIsAbleToClickOnBikeLightItem(){
        logInPage.doLogin();

        homePage.verifyUserAtHomePage();

        homePage.clickOnItemBikeLight();

        bikeLightPage.verifyUserAtBikeLightProductPage();

        bikeLightPage.clickAddToCartButtonBikeLight();

        bikeLightPage.clickOnCartIcon_bikeLight();
    }
}
