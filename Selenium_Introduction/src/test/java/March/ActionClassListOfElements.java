package March;

import org.codehaus.classworlds.DuplicateRealmException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ActionClassListOfElements {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://opensource-demo.orangehrmlive.com/");

        WebElement userName = driver.findElement(By.id("txtUsername"));
        WebElement pass = driver.findElement(By.id("txtPassword"));
        userName.sendKeys("Admin");
        pass.sendKeys("admin123");

        WebElement login = driver.findElement(By.id("btnLogin"));
        login.click();

    }
}
