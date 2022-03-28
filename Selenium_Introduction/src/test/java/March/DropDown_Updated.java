package March;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class DropDown_Updated {

    @Test
    public static void updated() throws Exception{

        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        // Dynamic dropdown
        WebElement passengerDropDown = driver.findElement(By.id("divpaxinfo"));
        passengerDropDown.click();
        Thread.sleep(2000);

        // selecting number of adults using + icon. (we can repeat the code but not commanded at work) || > so use loop is the best (while / for)

        WebElement plusIcon = driver.findElement(By.id("hrefIncAdt"));
        // keep clicking the icon as per the number of the user

        System.out.println("\nBefore loop: "+ passengerDropDown.getText());

        for (int i = 1; i<5;i++){
            plusIcon.click();
        }
        System.out.println("\nAfter Loop: "+ passengerDropDown.getText());

        WebElement done = driver.findElement(By.id("btnclosepaxoption"));
        done.click();

        driver.close();


    }




}
