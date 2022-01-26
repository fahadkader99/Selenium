package Devx.class3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ClassAssignment {
    public static void main(String[] args) throws InterruptedException{

        // login to the given page and select from the dropdown price low to high!!!!!

        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver");
        ChromeDriver driver = new ChromeDriver();

        // 1st we have to go to the link and login:
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();      // now logged in

        WebElement dropMenu = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select dropDownMenu = new Select(dropMenu);
        Thread.sleep(2000);
        dropDownMenu.selectByIndex(2);      // selecting by index 2



    }
}
