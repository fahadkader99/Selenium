package March;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;

public class Keyboard_Functions {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(59));
        driver.get("https://extendsclass.com/text-compare.html");

        // Task copy text from left and paste it to right

        WebElement lastTest = driver.findElement(By.xpath("//span[@role='presentation'][contains(text(),'they are not sent on the server side.')]"));
        Actions actions = new Actions(driver);
        actions.keyDown(lastTest, Keys.COMMAND).sendKeys("a").sendKeys("c").build().perform();

        // New wait
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(lastTest));

        WebElement destinationBox = driver.findElement(By.xpath("(//div[@class='CodeMirror-scroll'])[2]"));
        actions.keyDown(destinationBox, Keys.COMMAND).sendKeys("a").sendKeys("v").build().perform();

        System.out.println("\nExecuted till end");

    }


}
