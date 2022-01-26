package Udemy.funTimes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHrm {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/");


        // 1st login with username and password
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();

        // going to the My TimeSheet tab
        driver.findElement(By.xpath("//div[@class='quickLaunge']/a/span[@class='quickLinkText'][contains(text(),'My Timesheet')]")).click();
        System.out.println(driver.findElement(By.id("noRecordsColumn")).getText());

    }

}
