package Devx.class1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelBasic {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");
        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();     // delete all the cookies
        driver.manage().window().minimize();
        driver.close();


    }
}
