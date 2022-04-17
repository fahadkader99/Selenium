package April;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class iFrame_JSAlert_Demo {

    @Test
    public void test(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(59));

        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");

        WebElement iFrame = driver.findElement(By.id("iframeResult"));
        driver.switchTo().frame(iFrame);

        WebElement tryBtn = driver.findElement(By.xpath("//button[@onclick='myFunction()']"));
        tryBtn.click();

/*        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();*/

        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText);
        driver.switchTo().alert().accept();

        driver.switchTo().parentFrame();
        System.out.println(driver.getTitle());

        driver.close();


    }
}
