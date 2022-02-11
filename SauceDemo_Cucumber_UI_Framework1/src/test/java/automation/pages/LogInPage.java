package automation.pages;

import automation.utils.DriverUtils;
import automation.utils.PropertyReader;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;



public class LogInPage extends Base_Page{

    @FindBy(id = "user-name")
    WebElement userNameBox;

    @FindBy(id = "password")
    WebElement passwordBox;

    @FindBy(id = "login-button")
    WebElement logInBtn;



    public void doLogin() {
        userNameBox.sendKeys(PropertyReader.getProperty("login.username"));
        passwordBox.sendKeys(PropertyReader.getProperty("login.password"));
        logInBtn.click();
    }

    public void verifyUserAtLoginPage(){
        Assert.assertTrue("UserName field is Missing at login page", userNameBox.isDisplayed());
        Assert.assertEquals("Password box is missing at the login page", passwordBox, true);
    }

    public void openWebsite(){
        driver.get(PropertyReader.getProperty("app.url"));
    }


}
