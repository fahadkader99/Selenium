package Browser_Functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWait1 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();


        driver.get("https://www.ebay.com/");

        WebElement electronics = driver.findElement(By.xpath("//div[@class='hl-cat-nav']//a[text()='Electronics'][1]"));

        Actions action = new Actions(driver);
        action.moveToElement(electronics).perform();

        // it will throw "element not interactable" without wait

        // Explicit wait: comes with condition
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));

        WebElement smartSpeaker = driver.findElement(By.xpath("//a[@class='hl-cat-nav__js-link'][contains(text(),'Smart Speakers')]"));
        wait.until(ExpectedConditions.visibilityOf(smartSpeaker));   // condition for explicit wait
        smartSpeaker.click();

        driver.close();


    }
}
