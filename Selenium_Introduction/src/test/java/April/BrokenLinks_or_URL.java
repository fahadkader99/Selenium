package April;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class BrokenLinks_or_URL {

    @Test
    public void broken_links_urls() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");


        // 1. get the link ties up with Soap UI and get the status code for the link
        String soapUI = driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");

        HttpURLConnection conn = (HttpURLConnection) new URL(soapUI).openConnection();      // http is the class and open connection is the method
        conn.setRequestMethod("HEAD");
        conn.connect();
        int responseCode = conn.getResponseCode();
        System.out.println("Soap UI code: "+ responseCode);



        // 3. dynamically validate each link at the footer and identify which is broken:

        List<WebElement> footerLinks = driver.findElements(By.xpath("//li[@class='gf-li']/a"));

        SoftAssert soft = new SoftAssert();         // testNG class;

        for (WebElement link : footerLinks){

            String url = link.getAttribute("href");
            HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
            con.setRequestMethod("HEAD");
            con.connect();
            int statusCode = con.getResponseCode();
            System.out.println("\n"+statusCode);

            soft.assertTrue(statusCode < 400,"\nLink with text >"+ link.getText()+"< is broken "+ statusCode);

        }

        soft.assertAll();
        // soft assert will keep the test moving forward even if any step fails and at the end it will show the report

    }
}
