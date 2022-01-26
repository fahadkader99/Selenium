package Devx;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class BaseTest {

    private WebDriver driver;

    @BeforeEach
    void beforeEach(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().deleteAllCookies();
    }

    @AfterEach
    void afterEach(){
        driver.close();
        //driver.quit();
    }


}
