package Devx.class3;

import io.cucumber.java.bs.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ListOfWebElementText {
    public static void main(String[] args) throws InterruptedException{

        // setting path to chrome driver
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver");

        // open the browser
        ChromeDriver driver = new ChromeDriver();

        // 1. to open url in browser
        driver.get("https://opensource-demo.orangehrmlive.com/");


        //1st logging in to the website::::::: Login and password
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();  // after putting username and password, we have to click login

        Thread.sleep(2000);

        // Hover mouse on job menu
        WebElement adminMenu = driver.findElement(By.id("menu_admin_viewAdminModule"));
        WebElement jobMenuEle = driver.findElement(By.id("menu_admin_Job"));
        Actions action = new Actions(driver);
        action.moveToElement(adminMenu).moveToElement(jobMenuEle).build().perform();

        List<WebElement> listOfJobMenu = driver.findElements(By.xpath("//a[@id='menu_admin_Job']/following-sibling::ul/li/a"));

        for (WebElement jobMenu : listOfJobMenu){
            System.out.println(jobMenu.getText());      // getText() is selenium method
        }



    }
}
