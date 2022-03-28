package March;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;

public class DropDown_Static {

    @Test
    public static void staticDropDown(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");


        // Static drop-down with Select class:   (currency)

        WebElement currency = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

        Select select = new Select(currency);
        //select.selectByVisibleText("AED");
        select.selectByIndex(2);
        String optionChosen = select.getFirstSelectedOption().getText();   // it will get text of the selected option
        System.out.println(optionChosen);

        driver.close();

        // different between select by text is  visible on the user side and select by value is in the html dom structure

    }
}
