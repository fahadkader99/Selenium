package March;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Calender_MM_DD {

    @Test
    public static void calenderFunction(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.path2usa.com/travel-companions");

        WebElement dateField = driver.findElement(By.id("travel_date"));
        dateField.click();

      // 1. Select the month

        WebElement monthPicker = driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']"));
        String myMonth = "May";
        boolean isMonth = monthPicker.getText().contains(myMonth);

        while (isMonth==true){
            driver.findElement(By.className("[@class='datepicker-days'] [@class='next']")).click();
        }




        // 2 select the date from the calendar

        List<WebElement> dateList = driver.findElements(By.className("day"));
        int countDates = driver.findElements(By.className("day")).size();
        System.out.println(countDates);
        String myDay = "19";

        for (int i = 0; i<countDates; i++){
            String dateText = driver.findElements(By.className("day")).get(i).getText();

            if (dateList.equals(myDay)){
                driver.findElements(By.className("day")).get(i).click();
                break;
            }
        }

        System.out.println("date selected");








       // driver.close();

    }
}
