package automation.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class CartPage extends Base_Page{

    @FindBy(id = "react-burger-menu-btn")
    WebElement burgerMenuCart;

    @FindBy(id="logout_sidebar_link")
    WebElement logOutLink;

    @FindBy(xpath = "//div[@class='app_logo']")
    WebElement pageLogo;

    @FindBy(id="remove-sauce-labs-backpack")
    WebElement removeBtn;

    @FindBy (xpath = "//span[@class='title']")
    WebElement cartPageTitle;

    @FindBy(xpath="//div[@class='inventory_item_name']")
    WebElement itemName;

    @FindBy(id = "continue-shopping")
    WebElement continueShoppingBtn;

    @FindBy(id = "checkout")
    WebElement checkoutBtn;

    @FindBy(xpath = "//div[@class='cart_item']")
    List<WebElement> listOfCartItems;

    @FindBy(xpath = "//div[@class='cart_quantity']")
    WebElement cartQuantity;


    @FindBy(id = "remove-sauce-labs-bike-light")
    WebElement removeBtnBikeLight;


    public void verifyUserIsAtCartPage(){
        Assert.assertTrue("Page logo is missing from the cart page", pageLogo.isDisplayed());
        String actual = cartPageTitle.getText();
        String expected = "YOUR CART";
        Assert.assertEquals("Cart page title is miss-matching",actual,expected);
    }

    public void userClickOnContinueShoppingButton(){
        continueShoppingBtn.click();
    }

    public void verifyTwoItemDisplayedOnCart(){
        int actualSize = listOfCartItems.size();
        int expectedSize = 2;
        Assert.assertEquals("Cart Items are not matching up at the final cart page. ",actualSize,expectedSize);


    }

    public void verifyCartPage() {
        Assert.assertTrue("Remove button is missing from cart page", removeBtn.isDisplayed());
        Assert.assertTrue("Item name is missing from cart page page", itemName.isDisplayed());
        Assert.assertEquals("Checkout button is missing from cart page page", checkoutBtn.isDisplayed(), true);
    }


    public void clickOnCheckOutButton(){
        checkoutBtn.click();
    }

    public void verifyCartQuantityIsOne(){
        String  original = cartQuantity.getText();
        String expected = "1";
        Assert.assertEquals("The quantity is not matching at the cart page", expected, original);
    }

    public void clickRemoveButtonBikeLight(){
        removeBtnBikeLight.click();
    }

    public void userClickOnBurgerMenuCartPage(){
        burgerMenuCart.click();
    }
    public void clickOnLogOutLinkCartPage(){
        logOutLink.click();
    }



}
