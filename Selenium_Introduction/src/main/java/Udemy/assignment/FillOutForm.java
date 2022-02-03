package Udemy.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class FillOutForm {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        // send name:
        WebElement name = driver.findElement(By.xpath("(//input[@name='name'])[1]"));
        name.sendKeys("Kader");

        // email
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("ash@gmail.com");

        // password
        WebElement pass = driver.findElement(By.id("exampleInputPassword1"));
        pass.sendKeys("Abc1234567890");

        // clicking checkbox 1
        WebElement chkBx1 = driver.findElement(By.id("exampleCheck1"));
        chkBx1.click();

        // Gender dropDown
        WebElement genderMenu  = driver.findElement(By.id("exampleFormControlSelect1"));
        Select s = new Select(genderMenu);
        s.selectByVisibleText("Male");

        // radio btn
        WebElement rBtn1 = driver.findElement(By.id("inlineRadio1"));
        rBtn1.click();

        // calender
        WebElement dob = driver.findElement(By.xpath("(//div[@class='form-group']//input[@class='form-control'])[2]"));
        dob.sendKeys("04/10/1994");

        // submit
        WebElement submit = driver.findElement(By.xpath("//input[@class='btn btn-success']"));
        submit.click();
        Thread.sleep(2000);

        // get
        WebElement bannerText = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']//strong"));
        System.out.println(bannerText.getText());

        driver.close();






    }
}
