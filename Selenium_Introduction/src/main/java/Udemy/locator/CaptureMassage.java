package Udemy.locator;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CaptureMassage {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        // 1st we go to the link
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        // 2nd login to the site by giving username and password.
        driver.findElement(By.id("inputUsername")).sendKeys("rahul");
        driver.findElement(By.name("inputPassword")).sendKeys("Ash123");
        driver.findElement(By.className("signInBtn")).click();

        // it will get the text from the web and print on the terminal
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());

        // Now we are trying to log in using right credentials
        driver.findElement(By.linkText("Forgot your password?")).click();       // it will open the new create password window

        // now provide user name , password, email
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("rahul");
        driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("abc@gmail.com");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();   // after putting one email, i am clearing it and going to input another email
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("rahul@gmail.com");  // sending email twice just for learning purpose
        // driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("3479164444");
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("3479164444");
        driver.findElement(By.xpath("//div/button[@class='reset-pwd-btn']")).click();
        System.out.println(driver.findElement(By.xpath("//p[@class='infoMsg']")).getText());
        driver.close();     // after all the test we are going to close the browser as a last command
    }
}
