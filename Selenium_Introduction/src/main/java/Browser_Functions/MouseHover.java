package Browser_Functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class MouseHover {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(59));

        driver.get("https://www.ebay.com/");

        // Action class helps to simulate mouse and keyboard, before creating action class we need the locator where to move

        WebElement electronics = driver.findElement(By.xpath("//div[@class='hl-cat-nav']/ul/li/a[contains(text(),'Electronics')]"));
        WebElement iPhones = driver.findElement(By.xpath("//a[@class='hl-cat-nav__js-link'][contains(text(),'iPhones')]"));
        Actions action = new Actions(driver);

        action.moveToElement(electronics).perform();
        Thread.sleep(5000);
        action.moveToElement(iPhones).click().build().perform();




    }
}
