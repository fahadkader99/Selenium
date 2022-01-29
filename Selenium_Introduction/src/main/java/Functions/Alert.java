package Functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Alert {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(59));

        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");

        // follow the steps on the web to your code.


        // 1st switching to iframe
        WebElement frame = driver.findElement(By.id("iframeResult"));
        driver.switchTo().frame(frame);

        //clicking to the button
        WebElement tryBtn = driver.findElement(By.xpath("//button[text()='Try it']"));
        tryBtn.click();

        // alert pops out - now handle it.
        org.openqa.selenium.Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.sendKeys("ASH rocks");
        alert.accept();
        System.out.println(driver.findElement(By.xpath("//p[@id='demo']")).getText());

        driver.switchTo().parentFrame();
        System.out.println(driver.getTitle());

        driver.close();



    }
}
