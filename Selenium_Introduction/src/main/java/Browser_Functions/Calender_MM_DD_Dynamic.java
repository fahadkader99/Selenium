package Browser_Functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Calender_MM_DD_Dynamic {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String web = "https://www.path2usa.com/travel-companions";
        driver.get(web);

        /*select specific MM -DD  in the calendar based on input
         * Ans: Grab the common attribute, put it into list and iterate until it match*/

        WebElement dateField = driver.findElement(By.id("travel_date"));
        dateField.click();                                                                                              // opening the Date Filed


        // 1st: Select Month

        WebElement datePicker = driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']"));
        String myMonth = "May";
        boolean isMonth = datePicker.getText().contains(myMonth);                                                        // getting the text from the date field and checking it contains the month i am looking for, it will return false, as default is March

        while (isMonth==true) {                                                                                               // !False means true, then go inside the loop and click next to find April. coz while loop keep executing until it is false

            driver.findElement(By.cssSelector("[class='datepicker-days'] [class='next']")).click();                     // css for next button for month, keep going next until it find the month i am looking for

        }


        // 2nd: we will click on date                                                                                   // saving all the dates into list ---> Then compare with the expected value and if match then click


        List<WebElement> dates = driver.findElements(By.className("day"));
        int countDates = driver.findElements(By.className("day")).size();
        String myDate = "8";

        for (int i = 0; i < countDates; i++) {
            String dateText = driver.findElements(By.className("day")).get(i).getText();                                // we are getting all the dates into a string text to compare with our input date

            if (dateText.equals(myDate)) {
                driver.findElements(By.className("day")).get(i).click();                                                // if the date match with my date then clink
                break;
            }

        }
        System.out.println("Month & Date Clicked Successful");

        //driver.close();
    }
}
