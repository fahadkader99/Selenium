package Functions;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ScreenShot {
    public static void main(String[] args) throws IOException {

       /*
       Take screenShot is an interface,
            Very important to keep prove of any issue.
        */

        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(59));

        driver.get("https://www.w3schools.com/");

        // Screen Shot
        TakesScreenshot sc = (TakesScreenshot) driver;

        File srcFile = sc.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("target/screenshot/firstshot.png"));

        driver.quit();

    }
}
