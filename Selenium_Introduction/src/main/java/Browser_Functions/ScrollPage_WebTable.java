package Browser_Functions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ScrollPage_WebTable {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String web = "https://www.rahulshettyacademy.com/AutomationPractice/";
        driver.get(web);

        // 1. go at the middle of the page and count all the values of each row of the web table

        /*Steps: first scroll down and focus on the web table then perform operation. We need JS to scroll*/

        JavascriptExecutor js = (JavascriptExecutor) driver;    // scroll window label
        js.executeScript("window.scrollBy(0,500)");             // hit & try the number based on different web page [chrome - console]
        Thread.sleep(3000);
        /*Now we need call DOM objects to focus and to scroll the dynamic table*/
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");     // scroll table label

        // all values of the amount column
        int sum = 0;
        List<WebElement> amounts = driver.findElements(By.xpath("//div[@class='tableFixHead']//td[4]"));
        for (int i = 0; i< amounts.size();i++){
            sum += Integer.parseInt(amounts.get(i).getText());
        }

        System.out.println("\nSum of all the amount on the table: "+ sum);

        // 2. Now compare the sum with the value given on the web page
        String webText = driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim();                          // breaking the line and just taking the 296 from the web text
        int totalText = Integer.parseInt(webText);

        Assert.assertEquals(sum,totalText,"The total amount is not matching...!");


        System.out.println("All execution is done");

        driver.quit();
    }
}
