package Functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RadioButtons {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://www.singaporeair.com/en_UK/us/home#/book/bookflight");

        WebElement RBtn1= driver.findElement(By.xpath("//input[@id='bookFlights']"));
//        RBtm.click();
//        System.out.println(RBtm.isSelected());
//        System.out.println(RBtm.isDisplayed());
//        System.out.println(RBtm.isEnabled());

        WebElement RBtn2 = driver.findElement(By.xpath("//input[@id='redeemFlights']"));
        RBtn2.click();

        System.out.println(RBtn1.isSelected());
        System.out.println(RBtn2.isSelected());


    }
}
