package Browser_Functions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WebLinks_MultipleTab_Dynamically {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String web = "https://www.rahulshettyacademy.com/AutomationPractice/";
        driver.get(web);

        // 1 . get all the links in the webpage
        int webLinks = driver.findElements(By.tagName("a")).size();
        System.out.println("All links: "+ webLinks);

        // 2. get all the footer links
        WebElement footerLinks = driver.findElement(By.id("gf-BIG"));
        int footerWebLinks = footerLinks.findElements(By.tagName("a")).size();
        System.out.println("All footer links: "+ footerWebLinks);


        // 3. all links of the 1st columns of the footer
        WebElement footerColumnDriver = footerLinks.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        int columnLinks = footerColumnDriver.findElements(By.tagName("a")).size();
        System.out.println("Column Web Links: "+ columnLinks);

        //4 . Click on each link on the footer and verify

        for (int i = 1; i<columnLinks;i++){

            String clickLinkTab = Keys.chord(Keys.COMMAND,Keys.ENTER);              // hitting command + enter
            footerColumnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickLinkTab);         // by sending keys and hitting Ctrl + enter , it will open all the links in separate tab
            Thread.sleep(3000);

        }

        // 5. Now get the title of each tab and print them:  so we have to switch to that window and get the title (window handler)

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();

        while (it.hasNext()){                             // if the next page is present, then move to the next, starts from 0 and keep going
            driver.switchTo().window(it.next());         // once it moves to new window then print the title
            System.out.println(driver.getTitle());      // getTitle() will get the title
        }

















        //driver.close();


    }
}
