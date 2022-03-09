package Browser_Functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleDisableElement {

    public static void main(String[] args) {

        // setting path to chrome driver
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver");

        // open the browser
        ChromeDriver driver = new ChromeDriver();

        // 1. to open url in browser
        driver.get("https://www.ebay.com/sch/ebayadvsearch");

        //driver.manage().window().maximize();      // for maximizing the screen

        // from multiple checkbox
        WebElement checkBx1 = driver.findElement(By.id("LH_TitleDesc"));
        WebElement checkBx2 = driver.findElement(By.id("LH_Complete"));
        WebElement checkBx3 = driver.findElement(By.id("LH_Sold"));


        checkBx1.click();

        // to check is the elements is displayed on the webpage or not?
        System.out.println(checkBx1.isDisplayed());
        System.out.println(checkBx2.isDisplayed());
        System.out.println(checkBx3.isDisplayed());


        // to check is the elements are enabled or disable, sometime they are disabled
        System.out.println(checkBx1.isEnabled());
        System.out.println(checkBx2.isEnabled());
        System.out.println(checkBx3.isEnabled());


        // to check is the element are selected or not?
        System.out.println(checkBx1.isSelected());
        System.out.println(checkBx2.isSelected());
        System.out.println(checkBx3.isSelected());

        checkBx2.click();
        checkBx3.click();


    }
}
