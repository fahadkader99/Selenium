import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class RSATest {

    @Test
    public void rahulShettyPageTest() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        //caps.setBrowserName("firefox");
//        caps.setPlatform(Platform.BIG_SUR);
//        caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);           // there are lots of capability options available
        caps.setCapability(CapabilityType.BROWSER_NAME,"firefox");



        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.179:4444"), caps );
        driver.get("http://rahulshettyacademy.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.out.println("\nRahul Shetty Academy:"+driver.getTitle());
        
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println("\nTotal links on the page: "+ allLinks.size());
        driver.close();


    }
}
