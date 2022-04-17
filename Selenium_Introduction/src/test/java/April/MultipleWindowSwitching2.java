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

public class MultipleWindowSwitching2 {

    @Test
    public void multiple_window2(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(59));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));

        driver.get("https://opensource-demo.orangehrmlive.com/");

        WebElement orange = driver.findElement(By.xpath("//div[@id='footer']/div/a[contains(text(),'OrangeHRM, Inc')]"));
        orange.click();
        wait.until(ExpectedConditions.visibilityOf(orange));

        // 1st using set save the window id

        Set<String > windowList = driver.getWindowHandles();
        System.out.println("Window List: "+ windowList);

        Iterator<String> it = windowList.iterator();
        String parent = it.next();
        String child1 = it.next();

        // switching to the new window
        driver.switchTo().window(child1);


        // in the 2nd tab
        WebElement emailBox = driver.findElement(By.xpath("//input[@id = 'myText']"));
        emailBox.sendKeys("101Test@gmail.com");
        WebElement freeTrialBtn = driver.findElement(By.xpath("//input[@id = 'linkadd']"));
        freeTrialBtn.click();

        // switch back to the parent frame
        driver.switchTo().window(parent);
        System.out.println(driver.getTitle());


        //driver.close();

    }
}
