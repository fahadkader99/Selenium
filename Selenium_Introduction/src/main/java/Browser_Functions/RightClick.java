package Browser_Functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class RightClick {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(59));

        driver.get("https://www.ebay.com/");

        // Many keyboard and Mouse work is done using Actions class.


        WebElement signIn = driver.findElement(By.xpath("//span[@id='gh-ug']/a"));
        Thread.sleep(4000);


        Actions action = new Actions(driver);

        //  Right click
        action.contextClick(signIn).perform();


    }
}
