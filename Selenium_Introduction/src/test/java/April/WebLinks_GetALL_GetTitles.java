package April;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class WebLinks_GetALL_GetTitles {

    @Test
    public void getLinkTitle(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://apple.com/");

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println("Number of Links: "+ allLinks.size());


        for (int i = 0; i<allLinks.size();i++){

            System.out.println(allLinks.get(i).getAttribute("href"));
            System.out.println(allLinks.get(i).getText());
        }


    }
}
