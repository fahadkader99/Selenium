package Devx.class4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class DropDown {

    public static void main(String[] args) throws InterruptedException {

        // setting path to chrome driver
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver");

        // open the browser
        ChromeDriver driver = new ChromeDriver();

        // 1. to open url in browser
        driver.get("https://www.ebay.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Select class is only used for dropDown menu

        // creating a webElement pointing to the dropdown menu
        WebElement catButton = driver.findElement(By.id("gh-cat"));
        Thread.sleep(2000);

        // Now use select class to select the menus.
        Select dropSelect = new Select(catButton);
        dropSelect.selectByIndex(2);

        // to view all the available dropdown menus

        List<WebElement> listOfMenu = dropSelect.getOptions();      // the return of getOption is list so we are savin into list
        for (WebElement elements : listOfMenu){
            System.out.println(elements.getText());
        }

        driver.close();



    }
}
