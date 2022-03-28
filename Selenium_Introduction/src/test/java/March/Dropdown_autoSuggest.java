package March;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Dropdown_autoSuggest {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        // Auto suggest Box
        WebElement countryBox = driver.findElement(By.xpath("//input[@id='autosuggest']"));
        countryBox.click();
        countryBox.sendKeys("Ban");

        // Explicitly wait
        WebDriverWait exWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        exWait.until(ExpectedConditions.visibilityOf(countryBox));


        // For auto-suggest we have to scan the items first
        List<WebElement> countryList = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
        for (WebElement e : countryList){
            if (e.getText().equalsIgnoreCase("Bangladesh")){
                e.click();
                break;
            }
        }
        System.out.println("Bangladesh selected");


    }
}
