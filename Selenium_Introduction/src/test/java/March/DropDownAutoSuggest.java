package March;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DropDownAutoSuggest {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        WebElement countryBox = driver.findElement(By.id("autosuggest"));
        countryBox.click();
        countryBox.sendKeys("Aus");


        WebDriverWait ex = new WebDriverWait(driver,Duration.ofSeconds(5));
        ex.until(ExpectedConditions.visibilityOf(countryBox));


        List<WebElement> countryList = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
        for (WebElement option : countryList){
            if (option.getText().equalsIgnoreCase("Austria")){
                option.click();
                break;
            }

        }

    }
}

//