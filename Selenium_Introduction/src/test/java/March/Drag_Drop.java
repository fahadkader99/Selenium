package March;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Drag_Drop {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");

        // 1st switch to iframe
        WebElement frame = driver.findElement(By.xpath("//iFrame[@class='demo-frame lazyloaded']"));
        driver.switchTo().frame(frame);


        // 2nd find the elements to move || drag and drops
        WebElement pic1 = driver.findElement(By.xpath("//h5[@class='ui-widget-header']/following-sibling::img[@alt='The peaks of High Tatras']"));
        WebElement pic3 = driver.findElement(By.xpath("//h5[@class='ui-widget-header']/following-sibling::img[@alt='Planning the ascent']"));
        WebElement destination = driver.findElement(By.id("trash"));

        // 3rd do the drag and drop
        Actions actions = new Actions(driver);
        actions.dragAndDrop(pic1,destination).build().perform();
        actions.dragAndDrop(pic3,destination).build().perform();

        // get back to default
        driver.switchTo().defaultContent();         // Default content goes one level back || Parent frame goes back to the root frame
        System.out.println(driver.getTitle());



    }
}
