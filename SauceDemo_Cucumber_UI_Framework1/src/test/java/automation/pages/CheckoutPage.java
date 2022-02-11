package automation.pages;



import automation.utils.PropertyReader;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CheckoutPage extends Base_Page{

    @FindBy(id = "first-name")
    WebElement firstNameBox;

    @FindBy(id = "last-name")
    WebElement lastNameBox;

    @FindBy(id = "postal-code")
    WebElement zipCodeBox;

    @FindBy(id = "continue")
    WebElement continueBtn;




    public void fillOutCheckoutDetail(){
        firstNameBox.sendKeys(PropertyReader.getProperty("user.firstname"));
        lastNameBox.sendKeys(PropertyReader.getProperty("user.lastname"));
        zipCodeBox.sendKeys(PropertyReader.getProperty("user.zipcode"));
    }

    public void clickContinueButton(){
        continueBtn.click();
    }

    public void verifyCheckoutPage() {
        Assert.assertTrue( "First name is missing from checkout page", firstNameBox.isDisplayed());
        Assert.assertTrue("last name is missing from cart checkout page",lastNameBox.isDisplayed());
        Assert.assertEquals("Zip code is missing from checkout page", zipCodeBox.isDisplayed(), true);
    }


}
