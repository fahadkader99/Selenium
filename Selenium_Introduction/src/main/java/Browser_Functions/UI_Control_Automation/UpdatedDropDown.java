package Browser_Functions.UI_Control_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class UpdatedDropDown {

    public static void main(String[] args) throws InterruptedException{

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

//        int i = 1;
//        while (i < 5){
//            plusIcon.click();   // 4 times
//            i++;
//        }

        System.out.println("Before loop "+passengerDropDown.getText());     // to validate the output

        for (int i =1; i<5;i++){    // use any loop for this kind of dropDown
            plusIcon.click();
        }

        System.out.println("After loop "+passengerDropDown.getText());     // to validate the output

        WebElement doneBtn = driver.findElement(By.id("btnclosepaxoption"));
        doneBtn.click();

    }
}
