package March;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class DropDown_Dynamic {

    @Test
    public static void dynamicDropDown()throws Exception{
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        // From menu
        WebElement from = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
        from.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("// a[@value='JAI']")).click();

        // most importat when dealing with dynamic dropdown is that we have to be careful which selecting css / xpath
        // most important factor is to selecting the xpath, by using contains, contains text / starts with / using relationship / choosing a common attribute ext


        // To menu
        WebElement toMenu = driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT"));
        toMenu.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[@value='PYG'])[2]")).click();     // have to pick by index here ..>!

        System.out.println("Both place are selected");

        driver.close();
    }
}
