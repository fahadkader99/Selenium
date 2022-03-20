package March;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class CaptureMessage_Task {

    @Test
    public void captureMessage() throws Exception{

        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        // try to sign in
        driver.findElement(By.id("inputUsername")).sendKeys("rahul");
        driver.findElement(By.name("inputPassword")).sendKeys("Ash123");
        driver.findElement(By.className("signInBtn")).click();

        // get the error message about Sing in
        driver.findElement(By.xpath("//p[@class='error']")).getText();

        // Now click forget your password and try reset you password and  get the Screen Message under forgot password

        driver.findElement(By.xpath("//div[@class='forgot-pwd-container']/a")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@type='text' and @placeholder='Name']")).sendKeys("abc");
        driver.findElement(By.xpath("//input[@type='text' and @placeholder='Email']")).sendKeys("test@gmail.com");
        driver.findElement(By.xpath("//input[@type='text' and @placeholder='Phone Number']")).sendKeys("1234567890");
        driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
        String newPass= driver.findElement(By.xpath("//p[@class='infoMsg']")).getText();
        System.out.println(newPass);

        // now click Go to Login and login with valid credentials

        String name = "rahul";
        String password = getPassword(driver);

        driver.findElement(By.className("go-to-login-btn")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("inputUsername")).sendKeys(name);
        driver.findElement(By.name("inputPassword")).sendKeys(password);
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.id("chkboxTwo")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String welcome = driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText();
        System.out.println(welcome);
        driver.findElement(By.className("logout-btn")).click();



        System.out.println("Signed In....!");
        driver.close();




    }
    public static String getPassword(WebDriver driver) throws Exception{
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.xpath("//div[@class='forgot-pwd-container']/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
        String passwordText= driver.findElement(By.cssSelector("form p")).getText();

        // extract the password dynamically
        String [] passArr = passwordText.split("'");
        String [] passArr2 = passArr[1].split("'");
        String password = passArr2[0];

        return password;

    }

}
