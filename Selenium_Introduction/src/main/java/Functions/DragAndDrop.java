package Functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DragAndDrop {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(59));

        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");

        // For drag and drop, we need which element to drag and which and where to drop, so we
        // need source and destination locator

        WebElement iFrame = driver.findElement(By.xpath("//iFrame[@class='demo-frame lazyloaded']"));
        driver.switchTo().frame(iFrame);

        WebElement dragE = driver.findElement(By.xpath("//h5[@class='ui-widget-header']/following-sibling::img[@alt='The peaks of High Tatras']"));
        WebElement trash = driver.findElement(By.xpath("//div[@id='trash']"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragE,trash).build().perform();

        driver.switchTo().defaultContent();
        System.out.println(driver.getTitle());






    }
}
