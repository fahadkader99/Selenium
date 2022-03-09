package Browser_Functions.locator2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class GetPasswordDynamically {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String name = "Kader";
        String pass = getPassword(driver);

        // We will log in 1st
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys(name);
        driver.findElement(By.name("inputPassword")).sendKeys(pass);
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

    // now we will get the password dynamically using method

    public static String getPassword(WebDriver driver) throws InterruptedException{

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.xpath("//a[contains(text(),'Forgot your password?')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        String passwordText= driver.findElement(By.cssSelector("form p")).getText();

        // now we have to extract the password string with in single quote ' ' (Please use temporary password 'rahulshettyacademy' to Login.)
        String[]passwordArr= passwordText.split("'");    // it will break on the single quote ' and return an Array
        // 0th index - Please use temporary password
        // 1st index - rahulshettyacademy' to Login.
        String[] passwordArr2 = passwordArr[1].split("'");  // again we are spiriting in 2 different value
        // [0] index -  rahulshettyacademy  > we need this 0 index
        // [1] index - to Login
        String password = passwordArr2[0];      //String password = passwordArr[1].split("'")[0];

        return password;
    }

}