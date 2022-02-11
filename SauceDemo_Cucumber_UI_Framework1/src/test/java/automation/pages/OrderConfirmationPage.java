package automation.pages;


import automation.utils.PropertyReader;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class OrderConfirmationPage extends Base_Page{

    @FindBy(className = "title")
    WebElement completeTitle;

    @FindBy(className = "complete-header")
    WebElement confirmationTitle;

    @FindBy(className = "complete-text")
    WebElement orderCompleteText;

    @FindBy(xpath = "//h2[@class='complete-header']")
    WebElement orderConfirmationTitle;


    public void verifyOrderConfirmationPage(){
        Assert.assertTrue("Complete title is missing from confirmation page", completeTitle.isDisplayed());

        String actual = confirmationTitle.getText();
        String expected = "THANK YOU FOR YOUR ORDER";
        Assert.assertEquals(actual,expected);

    }

    public void verifyConfirmationPage() {
        Assert.assertTrue("Order confirmation title is missing from order confirmation page", orderConfirmationTitle.isDisplayed());
        String actText = orderConfirmationTitle.getText();
        String expText = PropertyReader.getProperty("order.confirmation.title");
        Assert.assertTrue("Expected confirmation text is "+expText+" : Actual  "+actText, actText.equals(expText));
    }


    public void printOderCompleteMessage(){
        System.out.println("\n\n"+orderCompleteText.getText());
    }



}
