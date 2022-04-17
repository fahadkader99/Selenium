package April;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Dropdown_Select {

    @Test
    public void select_Class(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        driver.get("http://ebay.com/");


        // get all the categories

        WebElement category = driver.findElement(By.xpath("//select[@id='gh-cat']"));
        Select select = new Select(category);

        select.selectByIndex(2);

        wait.until(ExpectedConditions.visibilityOf(category));
        select.selectByValue("20081");


        wait.until(ExpectedConditions.visibilityOf(category));
        select.selectByVisibleText("Cameras & Photo");



        // Get all the available dropdown list



        List<WebElement> allCategories = select.getOptions(); //------------------------------- Both works the same way, getOptions() - is amazing
        //List<WebElement> allCategories = driver.findElements(By.xpath("//select[@id='gh-cat']"));

        for (WebElement lists : allCategories){
            System.out.println(lists.getText());
        }

        System.out.println("\nAll test passed");
    }
}
