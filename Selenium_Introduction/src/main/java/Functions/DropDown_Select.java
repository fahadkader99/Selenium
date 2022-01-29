package Functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class DropDown_Select {
    public static void main(String[] args) {

        // handling dropdown:
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://www.sugarcrm.com/au/request-demo/");


        // to handle regular dropdown with select class on DOM, we use select class
        WebElement employeeDropDown = driver.findElement(By.name("employees_c"));
        Select select = new Select(employeeDropDown);

        select.selectByIndex(2);
        select.selectByVisibleText("51 - 100 employees");



    }
}
