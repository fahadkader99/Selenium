package April;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class DropDown_Updated {

    @Test
    public void test(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));


        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        WebElement passengerDrop = driver.findElement(By.id("divpaxinfo"));
        passengerDrop.click();
        wait.until(ExpectedConditions.visibilityOf(passengerDrop));

        System.out.println("Before loop: "+ passengerDrop.getText());





    }
}
