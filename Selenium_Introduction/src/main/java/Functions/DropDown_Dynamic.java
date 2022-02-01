package Functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DropDown_Dynamic {
    public static void main(String[] args) throws InterruptedException{

        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        // From -    // a[@value='BLR']
        // To -     (//a[@value='MAA'])[2]
        // we have to tell selenium explicitly to select the index.

        // From menu
        WebElement fromMenu = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
        fromMenu.click();
        Thread.sleep(2000);
        WebElement Bengaluru = driver.findElement(By.xpath("// a[@value='BLR']"));
        Bengaluru.click();

        // To Menu
        WebElement toMenu = driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT"));
        toMenu.click();
        Thread.sleep(2000);
        WebElement Chennai = driver.findElement(By.xpath("(//a[@value='MAA'])[2]"));
        // without index xpath: //div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']
            // using parent to child xpath

        Chennai.click();



    }
}
