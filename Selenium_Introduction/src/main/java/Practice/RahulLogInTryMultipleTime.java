package Practice;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RahulLogInTryMultipleTime {

    @Test
    public void main() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        // 1st login with wrong password and get the error message
        String name = "Ash";
        driver.findElement(By.id("inputUsername")).sendKeys(name);
        driver.findElement(By.name("inputPassword")).sendKeys("asdadadasdasd");
        driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
        Thread.sleep(2000);

        System.out.println(driver.findElement(By.xpath("//p[@class='error']")).getText());

        // now sending the text and filling up the text box
        Thread.sleep(2000);

        WebElement forgetLink = driver.findElement(By.xpath("//div[@class='forgot-pwd-container']/a"));
        forgetLink.click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Ash");
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("john@gmail.com");
        driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("3479474541");
        WebElement resetBtn = driver.findElement(By.xpath("//button[@class='reset-pwd-btn']"));
        resetBtn.click();   // reset button clicked.

        // get reset message:
        WebElement resetMessage = driver.findElement(By.xpath("//p[@class='infoMsg']"));
        System.out.println(resetMessage.getText());

        // click back to login page:
        driver.findElement(By.xpath("//button[@class='go-to-login-btn']")).click();
        Thread.sleep(2000);



        // Now login with real credentials
        driver.findElement(By.id("inputUsername")).sendKeys(name);
        driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//input[@id='chkboxTwo']")).click();   // clicking the checkbox
        driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
        Thread.sleep(2000);

        // now get the text after login
        String loginMessage = driver.findElement(By.xpath("//p[contains(text(),'You are successfully logged in.')]")).getText();
        System.out.println(loginMessage);



        WebElement logOut = driver.findElement(By.xpath("//button[@class='logout-btn']"));
        logOut.click();

        driver.close();









    }
}
