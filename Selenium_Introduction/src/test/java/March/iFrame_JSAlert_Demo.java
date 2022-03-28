package March;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class iFrame_JSAlert_Demo {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");

        // switch to iFrame
        WebElement frame = driver.findElement(By.xpath("//iFrame[@id='iframeResult']"));
        driver.switchTo().frame(frame);

        // click the button
        WebElement clickBtn = driver.findElement(By.xpath("//button[@onclick='myFunction()']"));
        clickBtn.click();

        // Handle the Alert
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

        // back to previous frame
        driver.switchTo().defaultContent();
        System.out.println(driver.getTitle());
        System.out.println("\nAll action performed");








    }
}
