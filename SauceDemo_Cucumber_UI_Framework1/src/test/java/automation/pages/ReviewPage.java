package automation.pages;


import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ReviewPage extends Base_Page{

    @FindBy(xpath = "//span[@class='title']")
    WebElement overViewPageTitle;

    @FindBy(className = "cart_desc_label")
    WebElement productDescription;

    @FindBy(className = "summary_info_label")
    WebElement shippingInfo;

    @FindBy(xpath = "//button[@id='finish']")
    WebElement finishBtn;

    @FindBy(xpath = "//div[text()='Payment Information:']/following-sibling::div[@class='summary_value_label'][1]")
    WebElement paymentInfo;

    @FindBy(xpath="//div[@class='inventory_item_name']")
    WebElement itemName;

    @FindBy(id = "cancel")
    WebElement cancelBtn;



    public void verifyOverViewPage(){
        Assert.assertTrue("Overview page title is missing", overViewPageTitle.isDisplayed());
        //Assert.assertTrue("Overview description is not matching.", productDescription.isDisplayed());
        Assert.assertTrue("Shipping info is not displayed in Overview page", shippingInfo.isDisplayed());
    }

    public void verifyReviewPage() {
        Assert.assertTrue("Payment info is missing from review page", paymentInfo.isDisplayed());
        Assert.assertTrue("item name is missing from cart review page", itemName.isDisplayed());
        Assert.assertEquals("Finish button is missing from review page", finishBtn.isDisplayed(), true);
    }

    public void clickFinishButton(){
        finishBtn.click();
        driver.navigate().refresh();
    }

    public void clickOnCancelButton(){
        cancelBtn.click();
    }








}
