package March;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class MouseHover_ActionClass {

    @Test
    public void mouseHover(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(59));

        driver.get("https://opensource-demo.orangehrmlive.com/");

        // 1st log in to the website
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();

        // Hover Mouse on the job Menu  \\
        // move to job -> move to job -> get all the list of jobs
        WebElement adminMenu = driver.findElement(By.id("menu_admin_viewAdminModule"));
        WebElement jobMenu = driver.findElement(By.id("menu_admin_Job"));

        Actions actions = new Actions(driver);
        actions.moveToElement(adminMenu).moveToElement(jobMenu).build().perform();

        // get the list of job titles:
        List<WebElement> jobTitles = driver.findElements(By.xpath("// a[@id='menu_admin_Job']/following-sibling::ul/li/a"));
        for (WebElement title : jobTitles ){
            System.out.println(title.getText());
        }

        driver.close();

    }
}
