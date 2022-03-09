package Browser_Functions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class KeyBoardFunctions {

    public static void main(String[] args) throws InterruptedException{

        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(59));

        driver.get("https://extendsclass.com/text-compare.html");


        // we are going to copy text and past it to another place.
        WebElement sourceText = driver.findElement(By.xpath("//span[@role='presentation'][contains(text(),'and differences will be highlighted, ')]"));

        // for performing keyboard action we need to create object of action class:
        Actions actions = new Actions(driver);
        // we are performing: (cmd + a) cmd is still down so (cmd + c)
        actions.keyDown(sourceText, Keys.COMMAND).sendKeys("a").sendKeys("c").build().perform();        // text are selected and copied
        Thread.sleep(44000);
        WebElement destination = driver.findElement(By.xpath("//*[@id=\"dropZone2\"]/div[2]//div[5]/div[8]/pre/span"));
        actions.keyDown(destination,Keys.COMMAND).sendKeys("a").sendKeys("v").build().perform();    // selecting all and pasting the text





    }
}
