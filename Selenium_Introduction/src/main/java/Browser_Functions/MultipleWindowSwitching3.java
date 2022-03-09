package Browser_Functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class MultipleWindowSwitching3 {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(59));

        driver.get("https://opensource-demo.orangehrmlive.com/");

        // get the current window id:
        String currentId = driver.getWindowHandle();
        System.out.println("Current window Id: "+ currentId);

        WebElement footerLink = driver.findElement(By.xpath("//div[@id='footer']/div/a[contains(text(),'OrangeHRM, Inc')]"));
        footerLink.click();
        Thread.sleep(4000);

        // Handle the new window: with condition: > good more multiple, but using iterator is better and easier.
        Set<String> windowList = driver.getWindowHandles();
        for (String window: windowList){
            if (!window.equals(currentId)){
                driver.switchTo().window(window);
            }
        }



        WebElement emailBox = driver.findElement(By.xpath("//input[@id='myText']"));
        emailBox.sendKeys("Test@gmail.com");
        WebElement tryBtn = driver.findElement(By.className("home-tril-email-btn"));
        tryBtn.click();

        // switching back to parent:
        driver.switchTo().window(currentId);
        System.out.println("Parent Title: "+driver.getTitle());










    }
}
