package Browser_Functions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WebLinks_MultipleTabs_Dynamically2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String web = "http://jktourism.jk.gov.in/Home/Home.aspx";
        driver.get(web);

        // 1. Get all links
        int allLinks = driver.findElements(By.tagName("a")).size();
        System.out.println("All links"+allLinks);

        // 2. Get any footer columns links
        WebElement footer = driver.findElement(By.xpath("//div[@class='footer-block no-separ']"));
        System.out.println("Footer column: "+ footer.findElements(By.tagName("a")).size());

        // 3. Iterate over all the links and verify by clicking them and open in separate tabs

        for (int i = 0; i< footer.findElements(By.tagName("a")).size();i++){
            String openTabs = Keys.chord(Keys.COMMAND,Keys.ENTER);
            footer.findElements(By.tagName("a")).get(i).sendKeys(openTabs);
            Thread.sleep(4000);
        }


        // 5. Now get the title of each tab and print them

        Set<String> tabs = driver.getWindowHandles();
        Iterator<String> it = tabs.iterator();

        while (it.hasNext()){
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }

        driver.quit();
    }
}
