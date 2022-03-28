package automation.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//li[@class='active'][contains(text(),'Welcome')]")
    public WebElement welcomeMessage;

    @FindBy(xpath = "//div[@class='user-area dropdown']/a/img")
    public WebElement userMenuBtn;

    @FindBy(xpath = "//div[@class='user-menu dropdown-menu show']/a[3]")
    public WebElement logoutLink;

    @FindBy(id = "home-menu-item")
    public WebElement homeTitle;

    @FindBy(id = "checking-menu")
    public WebElement checkInCategory;

    @FindBy(id = "savings-menu")
    public WebElement savingsCategory;

    @FindBy(id = "external-accounts-menu")
    public WebElement externalCategory;

    @FindBy(className = "menu-title")
    public WebElement transactionTitle;

    @FindBy(id = "deposit-menu-item")
    public WebElement depositCategory;

    @FindBy(id = "withdraw-menu-item")
    public WebElement withdrawCategory;

    @FindBy(id = "transfer-menu-item")
    public WebElement transferBetweenAccCategory;

    @FindBy(id = "visa-transfer-menu-item")
    public WebElement visaDirectTransferCategory;

    @FindBy(id = "home-menu-item")
    public WebElement homePageMenuItem;

    @FindBy(id = "page-title")
    public WebElement homePageTitle;

    @FindBy(xpath = "//img[@class='user-avatar rounded-circle']")
    public WebElement userProfileDropDown;

    @FindBy(xpath = "//div[@class='user-menu dropdown-menu show']/a[3]")
    public WebElement logOutBtn;

    String XPATH_CHECKING_DROPDOWN = "//a[@id='%s-menu']";
    String XPATH_VIEW_CHECKING = "//a[@id='%s-menu-item']";

    public String XPATH_SAVINGS_DROPDOWN = "//a[@id='%s-menu']";
    public String XPATH_SAVINGS_CATEGORY = "//a[@id='%s-menu-item']";
    public String Xpath_Saving_Menu_Category = "//a[@id='%s-menu-item']";



    public void userLogout(){
        userMenuBtn.click();
        logoutLink.click();
    }

    public void verifyUserClickOnDropDownButton(String arg0) {
        String dropDown = String.format(XPATH_CHECKING_DROPDOWN, arg0);
        WebElement clickOnDropDown = driver.findElement(By.xpath(dropDown));
        clickOnDropDown.click();
    }

    public void viewCheckingIsVisible(String arg0) {
        String view = String.format(XPATH_VIEW_CHECKING,arg0);
        WebElement viewChecking = driver.findElement(By.xpath(view));
        viewChecking.click();
    }


    public void userSelectNewChecking(String arg0) {
        String view = String.format(XPATH_VIEW_CHECKING,arg0);
        WebElement newChecking = driver.findElement(By.xpath(view));
        newChecking.click();
    }


    public void verifyUserAtHomePage() {
        Assert.assertTrue("Home Page is not displayed",homePageTitle.isDisplayed());
    }


    public void userClicksSignOutButton() {
        userProfileDropDown.click();
        logOutBtn.click();
    }


    public void userClicksOnDropDownBtn(String args) {
        String savDropdown = String.format(XPATH_SAVINGS_DROPDOWN, args);
        WebElement savDrop = driver.findElement(By.xpath(savDropdown));
        savDrop.click();
    }

    public void verifySavingsCategory(String args) {
        String category = String.format(XPATH_SAVINGS_CATEGORY, args);
        WebElement savCategory = driver.findElement(By.xpath(category));
        savCategory.click();
    }

    public void userSelectNewSavings(String arg0) {
        String options = String.format(XPATH_SAVINGS_CATEGORY,arg0);
        WebElement savingMenu = driver.findElement(By.xpath(options));
        savingMenu.click();
    }

    public void verifySavingsAccCategory(String arg0) {
        String savings = String.format(Xpath_Saving_Menu_Category, arg0);
        WebElement savCat = driver.findElement(By.xpath(savings));
        savCat.click();
    }
}
