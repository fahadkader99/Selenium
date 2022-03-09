package Browser_Functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class iFrame_Demo {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(59));

        driver.get("http://the-internet.herokuapp.com/iframe");

        // switching to iframe
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);

        // putting my text to the iframe
        WebElement text = driver.findElement(By.xpath("//body[@id='tinymce']/p"));
        text.sendKeys(" Fahad Kader");

        // exiting the iframe
        driver.switchTo().parentFrame();
        System.out.println(driver.getTitle());      // verifying swtich to parent by getting the parent title of the page

        driver.close();






    }
}
