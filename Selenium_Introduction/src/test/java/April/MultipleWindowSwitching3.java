package April;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class MultipleWindowSwitching3 {

    @Test
    public void test(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(59));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
        driver.get("https://opensource-demo.orangehrmlive.com/");

        // get the current window id:
        String currentWindowID = driver.getWindowHandle();
        System.out.println("Current window Id "+ currentWindowID);

        // click on the bottom link
        WebElement footerLink = driver.findElement(By.xpath("//div[@id='footer']/div/a[contains(text(),'OrangeHRM, Inc')]"));
        footerLink.click();
        wait.until(ExpectedConditions.visibilityOf(footerLink));

        /*
        Set<String > windowList = driver.getWindowHandles();
        System.out.println("Window List: "+ windowList);

        Iterator<String> it = windowList.iterator();
        String parent = it.next();
        String child1 = it.next();

        // switching to the new window
        driver.switchTo().window(child1);*/


        // Handle the Multiple tab with condition
        Set<String> windowList = driver.getWindowHandles();
        for (String window : windowList){
            if (!window.equals(currentWindowID)){
                driver.switchTo().window(window);
            }
        }


        WebElement email = driver.findElement(By.xpath("//input[@id='myText']"));
        email.sendKeys("test@gmail.com");
        WebElement free = driver.findElement(By.xpath("//input[@id='linkadd']"));
        free.click();


        // switch back to previous frame
        driver.switchTo().window(currentWindowID);
        System.out.println(driver.getTitle());


    }
}
