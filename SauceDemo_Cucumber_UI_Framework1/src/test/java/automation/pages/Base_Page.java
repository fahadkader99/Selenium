package automation.pages;

import automation.utils.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class Base_Page {

    WebDriver driver;

    Base_Page(){
        this.driver = DriverUtils.getDriver();
        PageFactory.initElements(driver,this);
    }

}
