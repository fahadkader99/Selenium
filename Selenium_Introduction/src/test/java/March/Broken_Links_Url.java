package March;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Broken_Links_Url {

    @Test
    public static void broken() throws Exception {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String web = "https://www.rahulshettyacademy.com/AutomationPractice/";
        driver.get(web);

        // 1 - get all the links in the webpage

        int allLinks = driver.findElements(By.tagName("a")).size();
        System.out.println(allLinks);


        // 2 - get all urls tied up with the links using selenium
        String soapUI = driver.findElement(By.cssSelector("a[href *='soapui']")).getAttribute("href");


        // 3 - get status code for one link

        HttpURLConnection connection = (HttpURLConnection) new URL(soapUI).openConnection();
        connection.setRequestMethod("HEAD");
        connection.connect();
        int responseCode = connection.getResponseCode();
        System.out.println("Code for Soap UI: "+ responseCode);


        // 4 - Test the broken link

        String brokenLink = driver.findElement(By.cssSelector("a[href *='broken']")).getAttribute("href");
        HttpURLConnection connection1 = (HttpURLConnection) new URL(brokenLink).openConnection();
        connection1.setRequestMethod("HEAD");
        connection1.connect();
        int response = connection1.getResponseCode();
        System.out.println("Code for Broken Link: "+ response);


        // 4 - Validate dynamically each link at the footer and identify which is broken

        List<WebElement> allFooterLinks = driver.findElements(By.cssSelector("li[class *= 'gf-li'] a"));
        SoftAssert softAssert = new SoftAssert();           // softAssert will continue the test ....

        for (WebElement links : allFooterLinks){
            String url = links.getAttribute("href");
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int respCode = conn.getResponseCode();
            System.out.println(respCode);
            softAssert.assertTrue(respCode < 400, "\n---> Link with text / "+ links.getText()+" / is broken with code "+ respCode);

            softAssert.assertAll();
        }











        driver.close();

    }
}
