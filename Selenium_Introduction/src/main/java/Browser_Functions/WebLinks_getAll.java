package Browser_Functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class WebLinks_getAll {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(59));

        driver.get("http://ebay.com/");

        /*

        Since all the links starts with Anker tag, we can use findlements with anker tag

         */

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println("Total Links are: "+ allLinks.size());


//        for (WebElement total : allLinks){
//            System.out.println(total.getAttribute("href"));
//            System.out.println(total.getText());
//        }



        System.out.println("\nLinks are given below with the Tag\n");
        for (int i = 0; i <allLinks.size();i++){
            System.out.println("Link: "+ allLinks.get(i).getAttribute("Href"));
            System.out.println(allLinks.get(i).getText());
        }

        driver.close();


    }
}
