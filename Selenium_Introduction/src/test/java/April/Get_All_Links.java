package April;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Get_All_Links extends Hooks {

    @Test
    public void test1(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.apple.com/");


        // 1 - get all the links in the webpage + the number of links in the website

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println("Number of Links: "+ allLinks.size());


        // 2 - print all the links on the page

        for (int i = 0; i<allLinks.size(); i++){
            System.out.println(allLinks.get(i).getAttribute("href"));
            System.out.println(allLinks.get(i).getText());
        }

        driver.close();




    }



}
