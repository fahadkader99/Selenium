package April;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Calender_MM_DD_Dynamic {

    @Test
    public void calender_dynamic(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.path2usa.com/travel-companions");


        /*select specific MM-DD in the calendar based on input
        * grab the common attribute, put it into list and iterate until it match*/

        WebElement dateField = driver.findElement(By.xpath("//input[@id='travel_date']"));
        dateField.click();


        // 1 - select month

        WebElement datePicker = driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='datepicker-switch']"));
        String targetMonth = "May";
        boolean isMonth = datePicker.getText().contains(targetMonth);

        while (isMonth==true){
            driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next']")).click();
        }

        // 2 - click on the date

        List<WebElement> dates = driver.findElements(By.className("day"));
        int countDate = driver.findElements(By.className("day")).size();
        String targetDate = "15";

        for (int i = 0; i<countDate; i++){

            String dateText = driver.findElements(By.className("day")).get(i).getText();

            if (dateText.equalsIgnoreCase(targetDate)){
                driver.findElements(By.className("day")).get(i).click();
                break;
            }

        }

        System.out.println("Month and Date are selected");


    }
}
