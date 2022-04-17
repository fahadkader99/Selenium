package April;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Alerts {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");

        // go inside the iframe
        WebElement iframe = driver.findElement(By.id("iframeResult"));
        driver.switchTo().frame(iframe);

        // get  the try button & click it
        WebElement tryIt = driver.findElement(By.xpath("//button[@onclick='myFunction()']"));
        tryIt.click();

        // not handle the pop_up
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.sendKeys("Fahad 101");
        alert.accept();

        WebElement alertText = driver.findElement(By.xpath("//p[@id='demo']"));
        System.out.println(alertText);

        driver.switchTo().parentFrame();
        System.out.println(driver.getTitle());




    }
}
