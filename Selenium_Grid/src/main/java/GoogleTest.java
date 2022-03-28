import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class GoogleTest {

    /*To runs test on grid we have to pass the driver to the Hub not invoking the chrome or mizila driver.
    * so we need to use RemoteDriver() class, this class takes 2 arguments - {the listening port && the capabilities.}
    *   1. one info is where your hub is listening - the port the router is listening : pass the 1st argument the URL
    *   2. Need Desired Capabilities class (like which browser to use, platform and other capabilities' container) - this class helps us to pass a lot of capabilities*/

    @Test
    public void homePageCheck() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("chrome");
  /*      caps.setPlatform(Platform.BIG_SUR);
        caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);           // there are lots of capability options available
        caps.setCapability(CapabilityType.BROWSER_NAME,"chrome");*/



        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.179:4444"), caps );
        driver.get("https://google.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.out.println(driver.getTitle());
        driver.findElement(By.name("q")).sendKeys("Ashikul Kader Fahad ");
        driver.close();


    }
}
