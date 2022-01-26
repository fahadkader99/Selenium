package Devx.class3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingDisabledElement {
    public static void main(String[] args) throws InterruptedException{

        // setting path to chrome driver
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver");

        // open the browser
        ChromeDriver driver = new ChromeDriver();

        // 1. to open url in browser
        driver.get("https://www.ebay.com/sch/ebayadvsearch");


        WebElement checkBox1 = driver.findElement(By.id("LH_TitleDesc"));
        WebElement checkBox2 = driver.findElement(By.id("LH_Complete"));
        WebElement checkBox3 = driver.findElement(By.id("LH_Sold"));



        checkBox1.click();

        // to check is the element is display on the webpage or not
        System.out.println("Are the checkboxes are Displayed or not");
        System.out.println(checkBox1.isDisplayed());
        System.out.println(checkBox2.isDisplayed());
        System.out.println(checkBox3.isDisplayed());


        // to check is the checkBox elements are enabled or not
        System.out.println("\nAre the checkboxes are enabled or disabled");
        System.out.println(checkBox1.isEnabled());
        System.out.println(checkBox2.isEnabled());
        System.out.println(checkBox3.isEnabled());


        // to check is the checkBox elements are selected or not?
        System.out.println("\nAre the checkboxes are selected or not");
        System.out.println(checkBox1.isSelected());
        System.out.println(checkBox2.isSelected());
        System.out.println(checkBox3.isSelected());
    }
}
