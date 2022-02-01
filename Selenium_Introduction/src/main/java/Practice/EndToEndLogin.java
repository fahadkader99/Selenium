package Practice;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class EndToEndLogin {

    @Test
    public  void main() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String name = "Kader";

        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        // trying to log in
        driver.findElement(By.id("inputUsername")).sendKeys(name);
        driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
        Thread.sleep(2000);

        // now get the text after login
        String loginMessage = driver.findElement(By.xpath("//p[contains(text(),'You are successfully logged in.')]")).getText();
        System.out.println(loginMessage);


        // Test1
        // now checking the assertion
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");


        // test 2
        // validate the username with the variable name:
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText(),"Hello "+name+",");

        // Log out and close
        WebElement logOut = driver.findElement(By.xpath("//button[@class='logout-btn']"));
        logOut.click();

        driver.close();


    }
}
