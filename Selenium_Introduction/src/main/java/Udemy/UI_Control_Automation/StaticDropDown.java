package Udemy.UI_Control_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class StaticDropDown {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");


        // Dropdown with select class.

        WebElement staticDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

        Select dropDown = new Select(staticDropDown);
        dropDown.selectByIndex(2);
        System.out.println(dropDown.getFirstSelectedOption().getText());        // it will extract the tex for the default selected.


        driver.close();


    }
}
