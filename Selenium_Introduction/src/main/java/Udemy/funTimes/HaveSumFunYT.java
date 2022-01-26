package Udemy.funTimes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class HaveSumFunYT {
    public static void main(String[] args) {

        System.setProperty("webdriver.edge.driver","src/test/resources/driver/msedgedriver");
        WebDriver driver = new EdgeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //1st go to the link
        driver.navigate().to("https://www.youtube.com/");

        //2nd login to the youtube

        // clicking the sing in button
        driver.findElement(By.xpath("//yt-formatted-string[@class='style-scope ytd-button-renderer style-suggestive size-small']")).click();

        // sending email id
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("ashikulf@gmail.com");

        // clicking the next button
        driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']/following-sibling::span")).click();


        //>>>>>> At this point test is failing, browser is unable to move password page.

        // putting the password
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Ashikul123");
        driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']/following-sibling::span")).click();


    }
}
