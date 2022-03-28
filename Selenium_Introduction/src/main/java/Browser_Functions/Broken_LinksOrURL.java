package Browser_Functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import javax.print.DocFlavor;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.time.Duration;
import java.util.List;

public class Broken_LinksOrURL {

    @Test
    public static void BrokenLinks() throws IOException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String web = "https://www.rahulshettyacademy.com/AutomationPractice/";
        driver.get(web);

        /*Test in the above webpage footer any of the Links is broken? A broken link will throw an error | link/url is not working | broken URL
        * We can find the Broken link either manually going to each of them or by using Selenium automation scripts */

        // if the response for the URL status code >  400 level then they are broken, so check the API status code, will use java method to get the url

        // Step 1 - get all urls tied up with the links using selenium
        String soapUI = driver.findElement(By.cssSelector("a[href *= 'soapui']")).getAttribute("href");             // get attribute will get the links


        // Step 2 - get status code for one link

        HttpURLConnection connection = (HttpURLConnection) new URL(soapUI).openConnection();        // here HTTP is a class and opeConnection is the method
        connection.setRequestMethod("HEAD");                                 // sending API 'HEAD' call
        connection.connect();                                               // connection will be made
        int responseCode = connection.getResponseCode();                   // getting and saving the response code
        System.out.println("Response code for Soap UI link: "+responseCode);


        // Test the broken link
        String brokenLink = driver.findElement(By.cssSelector("a[href *= 'brokenlink']")).getAttribute("href");
        HttpURLConnection connection1 = (HttpURLConnection) new URL(brokenLink).openConnection();
        connection1.setRequestMethod("HEAD");
        connection1.connect();;
        int responseCode1 = connection1.getResponseCode();
        System.out.println("Code for Broken link: "+responseCode1);



        // Step 3 - Validate dynamically each link at the footer and identify which is broken

        List<WebElement> footerLinks = driver.findElements(By.cssSelector("li[class*='gf-li'] a"));
        SoftAssert softAssert = new SoftAssert();                                 // soft assertion is verifying the links and if fails it will keep executing without throwing exception

        for (WebElement link : footerLinks){

            String url = link.getAttribute("href");
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int respCode = conn.getResponseCode();
            System.out.println(respCode);
            softAssert.assertTrue(respCode < 400,"\n--> Link with text /"+ link.getText()+ "/ is broken with code "+ respCode);

            /*if (respCode > 400){
                System.out.println("\nLink with text /"+ link.getText()+ "/ is broken with code "+ respCode);
                Assert.assertTrue(false);
            }*/

        }

        softAssert.assertAll();                 // at the end it will fail the test - if any condition is false, and if no false found then it will pass all. If this line is not present then even any test fails it will not report
        // this is how we can user soft assertion and continue running the test. The last line will execute all the test collect info, and finally it will report which one fails




    }
}
