package Udemy.locator;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RahulShetty {
    public static void main(String[] args) throws InterruptedException{

        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("rahul");
        driver.findElement(By.name("inputPassword")).sendKeys("hello123");
        driver.findElement(By.className("signInBtn")).click();
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        driver.findElement(By.xpath("//a[contains(text(),'Forgot your password?')]")).click();

        Thread.sleep(2000);     // java feature of pausing script for 2 sec

        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@rsa.com");
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("john@gmail.com");
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("3479874343");
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());
        driver.findElement(By.xpath("//button[@class='go-to-login-btn']")).click();
            // here we got the missing credential message
        //=================================================================
        // now we are going to log in using valid credential
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
        //driver.findElement(By.xpath("//input[@type='password']")).sendKeys("");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("rahulshettyacademy");   // giving password

        // now selecting checkbox
        driver.findElement(By.id("chkboxOne")).click();
        //driver.findElement(By.id("chkboxTwo")).click();
        driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();    // > Now logged in
        Thread.sleep(2000);
        String loggedIn = driver.findElement(By.xpath("//p[contains(text(),'You are successfully logged in.')]")).getText();

        System.out.println(loggedIn);

        // now clicking logout
        driver.findElement(By.cssSelector("button[class='logout-btn']")).click();
        driver.close();



    }
}
