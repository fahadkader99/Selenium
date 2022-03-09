package Browser_Functions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class JSExecutor_HighLight_Scroll {
    public static void main(String[] args) throws InterruptedException{

        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(59));


        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert2");


        // for JS executor we have to cast our driver.

        // JS script ends with semicolon and has to be in double quote.


        // get the title of the page using JS executor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String getTitle = "return document.title;";

        // js.executeScript(getTitle)  > now we will print the title.
        System.out.println(js.executeScript(getTitle));

        // switch to iFrame
        WebElement iframe = driver.findElement(By.id("iframeResult"));
        driver.switchTo().frame(iframe);

        // click on the button.
        WebElement tryBtn = driver.findElement(By.xpath("//button[contains(text(),'Try it')]"));
        tryBtn.click();
        Thread.sleep(2000);


        // handle the alert
        Alert alert = driver.switchTo().alert();
        System.out.println( alert.getText());
        alert.accept();

        // highlight the button:
        js.executeScript("arguments[0].style.border='4px solid red'",tryBtn);

         // Scroll Down > lets say we are directing to new page from here and click somewhere.
         driver.navigate().to("https://www.w3schools.com/");
         WebElement freeBtn = driver.findElement(By.xpath("//a[@class='ws-btn tut-button']"));
         js.executeScript("arguments[0].scrollIntoView(true);",freeBtn);
        System.out.println(freeBtn.getText());




    }
}
