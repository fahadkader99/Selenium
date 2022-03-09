package Browser_Functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class ActionClassListOfWebElementText {

    public static void main(String[] args) throws InterruptedException{


        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(59));

        driver.get("https://opensource-demo.orangehrmlive.com/");

        //1st logging in to the website::::::: Login and password
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();  // after putting username and password, we have to click login

        Thread.sleep(4000);


            // Hover Mouse on the job Menu  \\

        // Admin menu -> Job  menu -> get all the list
        WebElement adminMenu = driver.findElement(By.id("menu_admin_viewAdminModule"));
        WebElement jobMenu = driver.findElement(By.id("menu_admin_Job"));

        // We have Action class where we have to pass driver as arguments
            // end of action .build.perform must be there to finish the build.

        Actions action = new Actions(driver);
        action.moveToElement(adminMenu).moveToElement(jobMenu).build().perform();

        // getting the list of Job titles.
        List<WebElement> listOfJobTitle = driver.findElements(By.xpath("//a[@id='menu_admin_Job']/following-sibling::ul/li/a"));
        for (WebElement title : listOfJobTitle){
            System.out.println(title.getText());
        }

        driver.close();


    }
}
