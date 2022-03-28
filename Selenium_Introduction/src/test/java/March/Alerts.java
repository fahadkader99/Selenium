package March;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Alerts {

    @Test
    public static void alertAndIframe(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(59));

        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");

        // 1st switch to iframe
        WebElement frame = driver.findElement(By.id("iframeResult"));
        driver.switchTo().frame(frame);     // now inside the iframe

        // Click the ty button
        WebElement tryBtn = driver.findElement(By.xpath("//button[text()='Try it']"));
        tryBtn.click();

        // Now handle the alert
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.sendKeys("Fahad");
        alert.accept();


        // Get the text from the text box:
        WebElement textBox = driver.findElement(By.xpath("//p[@id = 'demo']"));
        System.out.println(textBox);

        // Switch back to main frame || exit from iFrame
        driver.switchTo().parentFrame();


        System.out.println(driver.getTitle());
        driver.close();





    }
}
