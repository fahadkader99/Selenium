package Udemy.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class one {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement checkBoxOne = driver.findElement(By.id("checkBoxOption1"));
        checkBoxOne.click();
        System.out.println(checkBoxOne.isSelected());
        Thread.sleep(2000);

        checkBoxOne.click();
        System.out.println(checkBoxOne.isSelected());

        // find the number of checkbox
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        System.out.println(checkBoxes.size());

        driver.close();


    }
}
