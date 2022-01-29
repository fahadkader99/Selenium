package Functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class DropDown_MultiSelect {
    public static void main(String[] args) {
        // handling dropdown:
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
        // the link is invalid, however, we are doing multi-select, where we can select multiple options together


        // this website allow to select multiple options
        WebElement down= driver.findElement(By.id("multi-select"));
        Select select = new Select(down);
        select.selectByValue("California");
        select.selectByIndex(5);

        List<WebElement> allItems = select.getAllSelectedOptions();
        System.out.println(allItems.size());    // will print number of item that are selected.
        select.deselectAll();       // we can also deselect all or specific item as well.






    }
}
