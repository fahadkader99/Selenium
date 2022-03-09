package Browser_Functions.UI_Control_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DropDown_AutoSuggestion {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        // Auto suggesting box
        WebElement country = driver.findElement(By.id("autosuggest"));
        country.sendKeys("ban");
        Thread.sleep(2000);

        // for auto-suggestion we must scan the auto-suggestion first, then use a condition if that match then click! //

        List<WebElement> menuOptions = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        for (WebElement option: menuOptions){
            if (option.getText().equalsIgnoreCase("Bangladesh")){
                option.click();
                break;
                // so when we find our search with the auto suggestion it will click
            }
        }


    }
}
