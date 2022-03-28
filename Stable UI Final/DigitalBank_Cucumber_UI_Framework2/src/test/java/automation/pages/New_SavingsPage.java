package automation.pages;

import automation.utils.PropertyReader;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class New_SavingsPage extends BasePage{

    @FindBy(id = "page-title")
    public WebElement SavingPageTitle;

    @FindBy(xpath = "//label[@class='form-control-label']/strong[contains(text(),'Select Savings Account Type')]")
    private WebElement accTypeField;

    @FindBy(xpath = "//label[@class='form-control-label']/strong[contains(text(),'Select Account Ownership')]")
    private WebElement selectAccOwnership;

    @FindBy(xpath = "//label[@class='form-control-label']/strong[contains(text(),'Account Name')]")
    private WebElement accountNameField;

    @FindBy(xpath = "//label[@class='form-control-label']/strong[contains(text(),'Initial Deposit')]")
    private WebElement initialDepositText;

    @FindBy(xpath = "//input[@id='openingBalance']")
    private WebElement initialDepositAMount;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement nameField;

    @FindBy(xpath = "//input[@id='Savings']")
    public WebElement savingsButton;

    @FindBy(xpath = "//input[@id='Joint']")
    public WebElement jointAccountType;

    @FindBy(xpath = "//button[@id='newSavingsSubmit']")
    public WebElement submitButton;




    String Xpath_Sav_Acc_Type = "//input[@id='%s']" ;
    String Xpath_Account_Ownership_Types = "//input[@id='%s']";



    public void verifySavingsPage() {
        Assert.assertTrue("User is not at Savings Page", SavingPageTitle.isDisplayed());
    }


    public void verifyFieldIsVisible() {
        Assert.assertTrue("Acc Field type is Not visible", accTypeField.isDisplayed());
    }


    public void verifySavingsAccType(String arg0) {
        String acc = String.format(Xpath_Sav_Acc_Type,arg0);
        WebElement checkingAccType = driver.findElement(By.xpath(acc));
        checkingAccType.click();

    }


    public void verifySelectAccountOwnership() {
        Assert.assertTrue("Account ownership is not visible",selectAccOwnership.isDisplayed());
    }

    public void verifySelectAccountOwnershipTypes(String arg0) {
        String ownership = String.format(Xpath_Account_Ownership_Types, arg0);
        WebElement ownershipTypes = driver.findElement(By.xpath(ownership));
        ownershipTypes.click();
    }


    public void AccountNameField() {
        Assert.assertTrue("Account name field is not displayed", accTypeField.isDisplayed());
    }


    public void sendCustom_Data_InNameField(DataTable dataTable) {

        /*Custom build class to send files to the Name Filed*/
        StringBuilder build1 = new StringBuilder();
        StringBuilder build2 = new StringBuilder();
        StringBuilder build3 = new StringBuilder();
        build1.append("Fahad 123 ");
        build1.append(" ");
        build1.append("Kader 45&#@");
        build2.append("Esrat Jahan");
        build2.append(" ");
        build2.append("Sania Jahan");
        build3.append("J&*#hn is Not HA$$Y");
        build3.append(" ");
        build3.append("alphanumeric and special character");

        List<List<String >> userNames = dataTable.asLists(String.class);
        for (List<String> names : userNames){

            nameField.sendKeys(build1, build2, build3);
        }
    }

    public void verifyInitialDepositAmount() {
        Assert.assertTrue("Initial Deposit Amount is not visible", initialDepositText.isDisplayed());
    }


    public void sendMultipleAmountToDeposit(String amounts) {

        // Sending amounts using Actions class:
        /* Actions actions = new Actions(driver);
        actions.sendKeys(initialDepositAMount, amounts);*/

        initialDepositAMount.sendKeys(amounts);     // Both methods work.

    }

    public void userSelectSavingsAccountType() {
        savingsButton.click();
    }


    public void selectJointAccount() {
        jointAccountType.click();
    }

    public void sendTestName() {
        nameField.sendKeys("Test1234567890");
    }


    public void sendMinimumDeposit(int arg0) {
        initialDepositAMount.sendKeys(PropertyReader.getProperties("deposit"));
    }


    public void userClickSubmitBtn() {
        submitButton.click();

    }
}
