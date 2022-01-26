package Devx.class4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HomeWork {
    /*
    Open Ebay.com
Search with keyword TV
click on first search result
print seller name into console
close the new window
close the first window as well
     */

    public static void main(String[] args) throws InterruptedException{

        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        //Open Ebay.com
        driver.get("https://www.ebay.com/");

        //Search with keyword TV
        WebElement searchBar = driver.findElement(By.xpath("//input[@id='gh-ac']"));
        searchBar.sendKeys("tv");

        // clicking search Button
        driver.findElement(By.xpath("//input[@id='gh-btn']")).click();
        Thread.sleep(2000);

        //click on first search result



    }
}
