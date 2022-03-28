package March;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Dropdown_Dynamic2 {

    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        // 1 -  select country
        WebElement county = driver.findElement(By.id("autosuggest"));
        county.click();
        county.sendKeys("india");

        // explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(county));

        // now choose the country
        List<WebElement> countryList = driver.findElements(By.xpath("//li[@class='ui-menu-item'] /a"));

        for (WebElement c : countryList){
            if (c.getText().equalsIgnoreCase("India")){
                c.click();
                break;
            }
        }

        // 2 - Select departure city

        WebElement departureCity = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']"));
        departureCity.click();
        // put wait
        wait.until(ExpectedConditions.visibilityOf(departureCity));

        WebElement fromCity = driver.findElement(By.xpath("// a[@value='JAI']"));
        fromCity.click();


        WebElement arrivalCity = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']"));
        arrivalCity.click();
        // put wait
        wait.until(ExpectedConditions.visibilityOf(arrivalCity));

        WebElement toCity = driver.findElement(By.xpath("(//a[@value='IXJ'])[2]"));
        toCity.click();


        System.out.println("\nAll steps are completed");


    }
}
