package Browser_Functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class DropDown_SelectClass {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(59));

        driver.get("http://ebay.com/");

        /*
        Select class:
            - Is mostly used for < Select Tag & Input Tag > DropDown menu.

            - DropDown - starts with < Select tag in DOM and multiple dropdown will have <option tag
         */

        WebElement categoryMenu = driver.findElement(By.id("gh-cat"));

        Select sc = new Select(categoryMenu);   // pass the WebElement Argu.

        Thread.sleep(4000);
        sc.selectByIndex(2);

        Thread.sleep(4000);
        sc.selectByValue("2984");


        Thread.sleep(4000);
        sc.selectByVisibleText("Consumer Electronics");



        // For getting all the available dropdown menu list, we will use List and for each loop
        List<WebElement> listOfMenu = sc.getOptions();
        for (WebElement list : listOfMenu){
            System.out.println(list.getText());
        }

        driver.close();


    }
}
