package Devx.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementExample {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");

        // WebElements is a class in selenium just like chromeDriver

        WebElement searchBox = driver.findElement(By.id("gh-ac"));

        WebElement searchBtn = driver.findElement(By.id("gh-btn"));
        String searchBoxTest = searchBox.getAttribute("placeholder");
        System.out.println(searchBoxTest);

        String footerText = driver.findElement(By.xpath("//td[@class='gf-legal']")).getText();
        System.out.println(footerText);


    }
}
