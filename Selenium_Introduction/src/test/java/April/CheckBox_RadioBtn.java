package April;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckBox_RadioBtn {

    @Test
    public void checkBox_RadioButton(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");


        // radio button
        WebElement radio1 = driver.findElement(By.xpath("//input[@value='radio1']"));
        radio1.click();
        System.out.println(radio1.isSelected());

        // checkbox
        WebElement check1 = driver.findElement(By.id("checkBoxOption1"));
        check1.click();
        System.out.println(check1.isEnabled());




    }
}
