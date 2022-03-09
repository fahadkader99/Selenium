package Browser_Functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class CheckBox_RadioButton {
    public static void main(String[] args)throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://www.sugarcrm.com/au/request-demo/");

        // for checkBox we need to click to select or we can check they are disable / enable!!!


        // radio button
        WebElement radioBtn = driver.findElement(By.xpath("//input[@id='doi0']"));

        Actions actions = new Actions(driver);      // with action class we can perform the work we do with keyboard, mouse
        actions.moveToElement(radioBtn).perform();



        // checkbox
        WebElement cBox1 = driver.findElement(By.name("interest_market_c"));
        cBox1.click();      // this will select

        Thread.sleep(3000);

        WebElement checkBox = driver.findElement(By.name("interest_market_c"));
        checkBox.click();      // clicking again will de-select!

        /*
        we can us, is Selected, isEnable / isDisable to check there status
         */

    }
}
