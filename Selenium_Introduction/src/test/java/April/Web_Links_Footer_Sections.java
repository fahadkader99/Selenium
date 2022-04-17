package April;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Web_Links_Footer_Sections {

    @Test
    public void test_Footer_Links(){

        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        //driver.manage().window().maximize();


        // 1 - get all the links there number and print all of them

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        int links = driver.findElements(By.tagName("a")).size();
        System.out.println("Total Links: "+ links);


        for (int i = 0; i<allLinks.size(); i++){
            System.out.println(allLinks.get(i).getAttribute("href"));
            System.out.println(allLinks.get(i).getText());
        }


        // 2 count the links of the footer sections of the page:

        WebElement footerDriver = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
        int footerLinks = footerDriver.findElements(By.tagName("a")).size();
        System.out.println("\nAll footer links: "+ footerLinks);

        // 3- count the links of 1st columns of the footer sections, since we are already under footer driver we can go from there.

        WebElement firstColumFooterDriver = driver.findElement(By.xpath("//table[@class='gf-t']/tbody/tr/td[1]/ul"));
        int firstColumFooterLinks = firstColumFooterDriver.findElements(By.tagName("a")).size();
        System.out.println("\n1st column footer Links "+ firstColumFooterLinks);


        // 4 - click all the links and verify (since links can be added anytime in the footer sections so wee need to build a dynamic solutions)

        for (int i = 0; i<firstColumFooterDriver.findElements(By.tagName("a")).size(); i++){

            String clickLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            firstColumFooterDriver.findElements(By.tagName("a")).get(i).sendKeys(clickLinkTab);

        }







        //driver.close();


    }
}
