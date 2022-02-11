package automation.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Base_Page {

    @FindBy(xpath = "//div[@class='app_logo']")
    WebElement homePageLogo;

    @FindBy(xpath = "//span[@class='title']")
    WebElement homePageTitle;

    @FindBy(xpath = "//div[@class='inventory_item_name'][contains(text(),'Sauce Labs Bike Light')]")
    WebElement bikeLightLink;

    @FindBy(xpath = "//div[@class='inventory_item_name'][contains(text(),'Sauce Labs Bolt T-Shirt')]")
    WebElement T_shirtLink;

    @FindBy(id = "react-burger-menu-btn")
    WebElement burgerMenu;

    @FindBy(id = "logout_sidebar_link")
    WebElement logoutLink;

    @FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
    WebElement itemLink;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement cartBtn;


    public void verifyUserAtHomePage(){
        Assert.assertTrue("Home page logo is not displayed", homePageLogo.isDisplayed());
        Assert.assertTrue("Home page title is not displayed", homePageTitle.isDisplayed());
    }

    public void clickOnItemBikeLight(){
        bikeLightLink.click();
    }

    public void clickOnItemT_shirt(){
        T_shirtLink.click();
    }

    public void clickOnBurgerMenu(){
        burgerMenu.click();
    }

    public void clickOnLogoutLink(){
        logoutLink.click();
    }

    public void clickOnItem() {
        itemLink.click();
    }

    public void clickOnCartButtonHomePage(){
        cartBtn.click();
    }

}
