package Devx.class3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxAndRadioButton {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver");
        ChromeDriver driver = new ChromeDriver();

        driver.get("http://the-internet.herokuapp.com/checkboxes");



        // here we are putting condition if not selected then click...

        WebElement checkBox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        if (checkBox1.isSelected()==false){
            checkBox1.click();
        }

        WebElement checkBox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));
        if (!checkBox2.isSelected()){
            checkBox2.click();
        }


    }
}
