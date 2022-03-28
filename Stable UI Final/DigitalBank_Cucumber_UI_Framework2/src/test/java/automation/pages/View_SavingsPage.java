package automation.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class View_SavingsPage extends BasePage{

    @FindBy(xpath = "//h1[@id='page-title']")
    public WebElement ViewSavingsPageTitle;

    @FindBy (xpath = "(//div[@class='card-body'])[1]")
    public WebElement savingsBox;

    @FindBy(xpath = "//span[@class='switch-handle']")
    public WebElement toggleButton;

    @FindBy(xpath = "(//div[@class='h4 m-0'])[2]")
    public WebElement boxBalance;

    @FindBy(xpath = "//strong[@class='card-title text-light']")
    public WebElement transactionTitle;

    @FindBy(xpath = "//th[@class='sorting'][contains(text(),'Balance')]")
    public WebElement transactionsTableBalance;

    @FindBy(xpath = "//th[@class='sorting'][contains(text(),'Date')]")
    public WebElement transactionsTableDate;

    String Xpath_Table_Structures= "//th[@class='sorting'][contains(text(),'%s')]";





    public void verifyViewSavingsPage() {
        Assert.assertTrue("View Savings page title is Missing", ViewSavingsPageTitle.isDisplayed());
    }

    public void UserCanSeeSavingsBox() {
        Assert.assertTrue("Savings Box not visible",savingsBox.isDisplayed());
    }


    public void verifyToggleButton() {
        Assert.assertTrue("Toggle button is Off",toggleButton.isEnabled());
    }

    public void verifyAccountBalanceIsVisible() {
        Assert.assertTrue("Balance not visible in the box",boxBalance.isDisplayed());
    }

    public void verifyTransactionTable() {
        Assert.assertTrue("Transaction is not visible",transactionTitle.isDisplayed());
    }

    public void verifyTransactionTableFields(String fields) {
        String field = String.format(Xpath_Table_Structures, fields);
        WebElement tableFields = driver.findElement(By.xpath(field));
        tableFields.click();    // or - Assert.isDisplayed
    }

    public void verifyToggleButtonIsDisplayed() {
        Assert.assertTrue("Toggle Button is not displayed", toggleButton.isDisplayed());
    }

    public void transactionsTableFieldsAreDisplayed() {
        Assert.assertTrue("Date field is missing", transactionsTableDate.isDisplayed());
        Assert.assertTrue("Balance field is missing", transactionsTableBalance.isDisplayed());
    }
}
