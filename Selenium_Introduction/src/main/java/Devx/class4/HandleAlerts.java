package Devx.class4;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandleAlerts {
    /*
    we have javascript alert in the web page, and we have separate alert class to handle them.

    Alert alert = driver.switchT0.alert().
    alert.getText()     - read the text
    alert.sendText()    - send text to the text bob
    alert.accept()      - clicking ok
    alert.dismiss()     - clicking cancel
     */

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver");

        // open the browser
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // 1. to open url in browser
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // Alert class:
        WebElement alertJS = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        alertJS.click();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        alert.dismiss();
        alert.sendKeys("Hii");



    }
}
