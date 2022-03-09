package Browser_Functions.locator2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ParentToChildToParent {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");


        // Parent to child
        WebElement logInBtn = driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]"));
        System.out.println(logInBtn.getText());

        // child to parent
        WebElement allBtn = driver.findElement(By.xpath("//header/div/button[1]/parent::div"));
        System.out.println(allBtn.getText());
        System.out.println(allBtn.isDisplayed());

        driver.close();


    }
}
