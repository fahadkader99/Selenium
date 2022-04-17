package April;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class DragAndDrop {

    @Test
    public void drag_drop(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");


        //1. switch to iframe
        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']"));
        driver.switchTo().frame(iframe);


        // perform drag and drop
        WebElement one = driver.findElement(By.xpath("//h5[@class='ui-widget-header'] /following-sibling::img[@alt='The peaks of High Tatras']"));
        WebElement four = driver.findElement(By.xpath("//h5[@class='ui-widget-header']/following-sibling::img[@alt='On top of Kozi kopka']"));
        WebElement trashCan = driver.findElement(By.xpath("//div[@id='trash']"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(one,trashCan).build().perform();
        actions.dragAndDrop(four,trashCan).build().perform();


        // get out of the iframe
        driver.switchTo().defaultContent();
        System.out.println(driver.getTitle());


    }
}
