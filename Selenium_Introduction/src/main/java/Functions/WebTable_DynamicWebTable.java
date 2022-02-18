package Functions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebTable_DynamicWebTable {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(59));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");





        /*to handle webtable the focus of the screen must be on the webtable , so scroll to the place where
        * the webTable is. Then start working with the table and only then it will pass the test. */

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,500)"); // 1st scroll where the Dynamic webtable is
        Thread.sleep(3000);
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");     // 2nd it will scroll bottom of the inside dynamic web table

    }
}
