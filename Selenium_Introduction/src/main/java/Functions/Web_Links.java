package Functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Web_Links {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String page = "https://www.rahulshettyacademy.com/AutomationPractice/";
        driver.get(page);

        // 1 Get the count of links on the page:
        int webLinks = driver.findElements(By.tagName("a")).size();             // anker tag [a] holds all the links and size will give its count
        System.out.println("\nThe Number of Links on the page: "+ webLinks);


        // 2 count of links in the footer section of the page -> for this i have to limit my driver to that section only by creating a mini-driver and its scope will be limited / given by me
                                                                                // So we have to create driver subset - and we can give scope of out driver subset

        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));          // this footerDriver can also work as sub-driver even though it is a webelement but the socpe of the element is in the whole footer
        int footerLinks = footerDriver.findElements(By.tagName("a")).size();    // here footerDriver is a subsection for the whole footer not a single element
        System.out.println("\nLink Numbers in the footer: "+ footerLinks);


        // 3. count the links of the 1st columns on the footer ----- since the column is under the footerDriver, we can go from there

        WebElement columnOneFooterDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        int firstColumnLinks = columnOneFooterDriver.findElements(By.tagName("a")).size();
        System.out.println("\nNum of Links in 1st column of the Footer: "+ firstColumnLinks);


        /*
        4. CLick on each link in the column and check if the pages are opening ---- since links can be added anytime, so we need to use dynamic methods' coz it can be 4 links today and 10 tomorrow
                we will follow the process of counting the numbers of links and click those individual links, this way test will pass many number of links 10,20 || 50
         */

        for (int i =1; i<firstColumnLinks;i++){                                             // taking i = 1 coz 1st link is not working

            columnOneFooterDriver.findElements(By.tagName("a")).get(i).click();             // it will get into loop and get the i index each time and click until loop ends

        }












        driver.close();

    }
}
