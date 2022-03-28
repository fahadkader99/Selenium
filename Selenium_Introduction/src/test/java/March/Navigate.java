package March;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Navigate {

    @Test
    public void navigate(){

        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // go to google
        driver.get("https://google.com");

        // driver navigating from google to youtube
        driver.navigate().to("https://youtube.com");

        // navigate back
        driver.navigate().back();

        // navigate forward
        driver.navigate().forward();




    }
}
