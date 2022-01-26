package Devx.class4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class iFrame {
    public static void main(String[] args) {

        // write selenium code to enter your name into the textbox:
        // http://the-internet.herokuapp.com/iframe

        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver");

        // open the browser
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // 1. to open url in browser
        driver.get("http://the-internet.herokuapp.com/iframe");

        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);

        // after using iFrame we abe able to send keys
        WebElement text = driver.findElement(By.xpath("//body[@id='tinymce']/p"));
        text.sendKeys(" Fahad Kader");

        // when using iFrame we have get back to previous page.
        driver.switchTo().defaultContent();     // this cmd  brings us into the default page .

        WebElement isText = driver.findElement(By.xpath("//body[@id='tinymce']/p"));        // why i can't get text!!!!
        System.out.println(isText.getText());


        driver.close();






    }
}
