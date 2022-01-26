package Udemy.locator2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class AssertionInto {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String name = "Kader";

        // We will log in 1st
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys(name);
        driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
        driver.findElement(By.className("signInBtn")).click();
        Thread.sleep(2000);
        String loggedIn = driver.findElement(By.xpath("//p[contains(text(),'You are successfully logged in.')]")).getText();
        System.out.println(loggedIn);


        // TEST - 1
        // Now we are checking the assertion.
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
            // so if the test fails in that case, it gives lots of error line explaining lines..

        // TEST - 2
        // validate the username: with the variable name:>
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText(),"Hello "+name+",");


    }
}
