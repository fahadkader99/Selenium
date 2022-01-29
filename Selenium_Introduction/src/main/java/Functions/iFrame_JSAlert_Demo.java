package Functions;

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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(59));

        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");

        // Now we are switching into the iFram from parent.

        driver.switchTo().frame("iframeResult");

        // Since the Try button is in iFram so we will need to the switch to

        WebElement tryBtn = driver.findElement(By.xpath("//button[text()='Try it']"));
        tryBtn.click();     // clicking will show a JS alert. So we have to handle the JS alert.


        /*
        Alert:
        Alert alert = driver.switchTo.alert();
            - alert.sendText
            - alert.getText
            - alert.accept
            -alert.dismiss
         */

        String alertTxt = driver.switchTo().alert().getText();  // 1st we are getting the text , printing it then accepting the alert
        System.out.println(alertTxt);
        driver.switchTo().alert().accept();


        // After using iFrame we always have to come back to Parent and get the title.
        driver.switchTo().parentFrame();
        //driver.switchTo().defaultContent();
        System.out.println(driver.getTitle());

    }
}
