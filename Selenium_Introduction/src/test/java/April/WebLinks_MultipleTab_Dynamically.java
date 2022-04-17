package April;

import io.cucumber.java.eo.Se;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WebLinks_MultipleTab_Dynamically {

    @Test
    public void webLinks_MultipleTabs() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

        //1 get all the number of links in the page

        int allLinks = driver.findElements(By.tagName("a")).size();
        System.out.println("All links number: "+ allLinks);


        //2 get all the footer links

        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
        int allFooterLinks = footerDriver.findElements(By.tagName("a")).size();
        System.out.println("All footer: "+ allFooterLinks);



        // 3. all the links of the first columns

        WebElement firstColumnFooterDriver = footerDriver.findElement(By.xpath("//table[@class='gf-t']/tbody/tr/td[1]/ul"));
        int firstColumnLinks = firstColumnFooterDriver.findElements(By.tagName("a")).size();
        System.out.println("1st column links "+ firstColumnLinks);


        // 4. click on each link on the footer and verify

        for (int i = 0; i<firstColumnLinks; i++){

            String clickLink = Keys.chord(Keys.COMMAND, Keys.ENTER);
            firstColumnFooterDriver.findElements(By.tagName("a")).get(i).sendKeys(clickLink);

            // explicit wait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.visibilityOf(firstColumnFooterDriver.findElements(By.tagName("a")).get(i)));

        }



        // 5. get all the title of each tab and print them: -> so we have to switch to each window after clicking and get the title


        /*-Since we are going to handle multiple window----use the concept of window handles---*/

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();

        while (it.hasNext()){
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }



        //driver.close();
        driver.quit();



    }
}
