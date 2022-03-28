package March;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Dropdown_AutoSuggestion {

    @Test
    public void autoSuggestion_Dropdown() throws Exception{
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        // Autosuggestion Box
        WebElement country = driver.findElement(By.id("autosuggest"));
        country.sendKeys("ban");
        Thread.sleep(2000);

        // for auto-suggestion we must scan the auto-suggestion first, then use a condition if that match then click

        List<WebElement> menuOptions = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        for (WebElement countries: menuOptions){
            if (countries.getText().equalsIgnoreCase("Bangladesh")){
                countries.click();
                break;
            }
        }

        System.out.println("Bangladesh Selected");
        driver.close();


    }
}
