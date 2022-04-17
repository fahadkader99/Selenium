package April;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Dropdown_AutoSuggest {

    @Test
    public void drop_autoSuggest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");


        // 1 - auto suggest box

        WebElement countryBox = driver.findElement(By.xpath("//input[@id='autosuggest']"));
        countryBox.click();
        countryBox.sendKeys("in");

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(countryBox));


        // 2 for auto suggestions we must scan all for the matching, if found then click

        List<WebElement> menuOptions = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
        for (WebElement element : menuOptions){
            if (element.getText().equalsIgnoreCase("India")){
                element.click();
                break;
            }
        }

        System.out.println("Country Selected");


    }
}
