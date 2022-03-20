package March;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class CheckBox_RadioButton {

    @Test
    public static void checkBod(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

        WebElement radio1 = driver.findElement(By.xpath("//input[@value='radio1']"));
        WebElement radio2 = driver.findElement(By.xpath("//input[@value='radio2']"));

        radio1.click();

        // number of radio buttons
        List<WebElement> allRadio = driver.findElements(By.className("radioButton"));
        int size = allRadio.size();
        System.out.println(size);


        // checkbox:

        WebElement check1 = driver.findElement(By.id("checkBoxOption1"));
        WebElement check2 = driver.findElement(By.id("checkBoxOption2"));

        check1.click();
        System.out.println(check1.isSelected());

        check2.click();
        System.out.println(check2.isSelected());





    }

}
