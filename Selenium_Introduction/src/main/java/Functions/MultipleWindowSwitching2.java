package Functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

// in this program we are switching to new window and coming back to previous window.
// Window Handle - methods > Task: go the the website, click to the footer link, give your email to the new window click try and come back to the previous page.
/*
1. get the current window id
2. click the link to open 2nd window
3. put your email id, click try for free
4. go back to the parent and get the title.
3.
 */

public class MultipleWindowSwitching2 {

    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(59));

        driver.get("https://opensource-demo.orangehrmlive.com/");


        WebElement footerLink = driver.findElement(By.xpath("//div[@id='footer']/div/a[contains(text(),'OrangeHRM, Inc')]"));
        footerLink.click();
        Thread.sleep(4000);

        // Now on the new window:

        // 1st using set to save the windows
        Set<String> windowList = driver.getWindowHandles();
        System.out.println("All window Id: "+ windowList);

        // Saving all the window id using iterator:
        Iterator<String> iterator = windowList.iterator();
        String parent = iterator.next();
        String child1 = iterator.next();

        // Switching to the new window:
        driver.switchTo().window(child1);


        WebElement emailBox = driver.findElement(By.xpath("//input[@id='myText']"));
        emailBox.sendKeys("Test@gmail.com");
        WebElement tryBtn = driver.findElement(By.className("home-tril-email-btn"));
        tryBtn.click();


        // switching to the parent window:
        driver.switchTo().window(parent);
        System.out.println(" Parent Title: "+ driver.getTitle());








    }
}
