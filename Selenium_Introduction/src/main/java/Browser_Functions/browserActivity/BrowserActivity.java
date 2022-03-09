package Browser_Functions.browserActivity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BrowserActivity {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //driver.manage().window().maximize();


        driver.get("https://google.com");

        // move to youtube
        driver.navigate().to("https://youtube.com");

        // move back to google
        driver.navigate().back();

        // forward again
        driver.navigate().forward();

    }
}
