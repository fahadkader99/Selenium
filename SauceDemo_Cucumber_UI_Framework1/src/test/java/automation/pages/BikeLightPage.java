package automation.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class BikeLightPage extends Base_Page{

    @FindBy(xpath = "//div[@class='app_logo']")
    WebElement pageLogo;

    @FindBy(xpath = "//div[@class='inventory_details_name large_size']")
    WebElement bikeLightTitle;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement bikeLightAddToCartBtn;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement cartIcon;





    public void verifyUserAtBikeLightProductPage(){
        Assert.assertTrue("Page logo is missing from Bike Light page", pageLogo.isDisplayed());
        Assert.assertTrue("Bike Light Title is missing from the product page", bikeLightTitle.isDisplayed());
    }

    public void clickAddToCartButtonBikeLight(){
        bikeLightAddToCartBtn.click();
    }

    public void clickOnCartIcon_bikeLight(){
        cartIcon.click();
    }






}
