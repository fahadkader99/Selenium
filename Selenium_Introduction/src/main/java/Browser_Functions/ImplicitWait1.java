package Browser_Functions;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ImplicitWait1 {

    @Test
    public void main() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();

        // implicit wait - Global
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(59));

        driver.get("https://www.ebay.com/");

        WebElement electronics = driver.findElement(By.xpath("//div[@class='hl-cat-nav']//a[text()='Electronics'][1]"));

        Actions action = new Actions(driver);
        action.moveToElement(electronics).perform();

        // it will throw "element not interactable" without implicit wait
        WebElement smartSpeaker = driver.findElement(By.xpath("//a[@class='hl-cat-nav__js-link'][contains(text(),'Smart Speakers')]"));
        smartSpeaker.click();

        driver.close();


    }
}
