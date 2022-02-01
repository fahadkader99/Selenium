package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class GetPasswordDynamically {
    public static void main(String[] args) throws InterruptedException{

        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String name = "Kader";

        // calling the method
        GetPasswordDynamically p = new GetPasswordDynamically();
        String password = p.getPassword(driver);    // saving the return of the method into a new variable


        // We will log in 1st
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys(name);
        driver.findElement(By.name("inputPassword")).sendKeys(password);
        driver.findElement(By.className("signInBtn")).click();
        Thread.sleep(2000);


        // get the login text confirmation
        String loggedIn = driver.findElement(By.xpath("//p[contains(text(),'You are successfully logged in.')]")).getText();
        System.out.println(loggedIn);

        // TEST - 1
        // Now we are checking the assertion.
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
        // so if the test fails in that case, it gives lots of error line explaining lines..

        // TEST - 2
        // validate the username: with the variable name:>
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText(),"Hello "+name+",");

        driver.findElement(By.xpath("//button[contains(text(),'Log Out')]")).click();
        driver.close();



    }

    public String getPassword(WebDriver driver) throws InterruptedException{

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        WebElement forgetLink = driver.findElement(By.xpath("//div[@class='forgot-pwd-container']/a"));
        forgetLink.click();
        Thread.sleep(2000);

        WebElement resetBtn = driver.findElement(By.xpath("//button[@class='reset-pwd-btn']"));
        resetBtn.click();

        // get reset message:
        String passwordText = driver.findElement(By.xpath("//p[@class='infoMsg']")).getText();

        // Now extract the password given within the "...... "  by splitting the string
        // <Please use temporary password 'rahulshettyacademy' to Login.>
        String [] passwordArray = passwordText.split("'");
        String password = passwordArray[1].split("'")[0];


        return password;



    }

}
