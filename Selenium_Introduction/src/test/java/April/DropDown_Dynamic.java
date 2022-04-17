package April;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class DropDown_Dynamic {

    @Test
    public void dropDown_Dynamic(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        // From Menu

        WebElement fromField = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
        fromField.click();
        wait.until(ExpectedConditions.visibilityOf(fromField));

        WebElement bhopal = driver.findElement(By.xpath("//a[@value='BHO']"));
        bhopal.click();
        wait.until(ExpectedConditions.visibilityOf(bhopal));


        // To Menu

        WebElement toMenu = driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT"));
        toMenu.click();
        wait.until(ExpectedConditions.visibilityOf(toMenu));

        WebElement jaipur = driver.findElement(By.xpath("(//a[@value='JAI'])[2]"));
        jaipur.click();


        System.out.println("All state selected");



        // Dropdown Multiselect - Currency

        WebElement currency = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

        Select select = new Select(currency);
        //select.selectByIndex(3);
        select.selectByVisibleText("USD");












    }
}
