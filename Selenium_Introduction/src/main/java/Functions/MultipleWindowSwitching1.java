package Functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class MultipleWindowSwitching1 {
    public static void main(String[] args) throws InterruptedException{

        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(59));


        driver.get("https://www.salesforce.com/au/");

        // Get the current WindowID: / not necessary!!
        String currentWindowId = driver.getWindowHandle();
        System.out.println("Current window id: "+currentWindowId);


        // clicking the free trial button.
        WebElement freeTrial = driver.findElement(By.xpath("//a[@class='btn btn-lg btn-nav salesforce-sans-regular ']"));
        freeTrial.click();  // will open the new page.
        Thread.sleep(5000);


        // Handling windows: using set and iterator with method.

        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("\nwindows: "+windowHandles);

        Iterator<String> it = windowHandles.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();

        driver.switchTo().window(childWindow);  // switching to child window since all the elements are on the child



        // Sending info to the new window
        driver.findElement(By.name("UserFirstName")).sendKeys("Academy");
        driver.findElement(By.name("UserLastName")).sendKeys("Test");


        driver.switchTo().window(parentWindow);
        System.out.println("\n Parent Title: "+driver.getTitle());


    }
}
