package Functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Most_Used {

    public static void main(String[] args) throws InterruptedException{
 // Setup
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(59));

        driver.get("http://ebay.com/");

// Check Box - Radio Button
        WebElement checkBx1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        if (checkBx1.isSelected()==false){
            checkBx1.click();
        }

        // similar way we can check radio button
        WebElement checkBx2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));
        if (!checkBx2.isSelected()){    // both way we can write, either with false or using !
            checkBx2.click();
        }

// selecting the dropDown menu using Select class
        WebElement catElement = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select catDropDownSelect = new Select(catElement);
        Thread.sleep(2000);
        catDropDownSelect.selectByIndex(2);     // selecting by index

        // printing or getting all the web element using for each loop
        List<WebElement> listOfOption = catDropDownSelect.getOptions();  // the return of getOption is list so we are savin into list
        for (WebElement option: listOfOption){      /// this loop will treverse through the all the elements
            System.out.println(option.getText());
        }

        // to check is the elements is displayed on the webpage or not?
        System.out.println(checkBx1.isDisplayed());


        // to check is the elements are enabled or disable, sometime they are disabled
        System.out.println(checkBx1.isEnabled());


        // to check is the element are selected or not?
        System.out.println(checkBx1.isSelected());


// Hover mouse on job menu
        WebElement adminMenu = driver.findElement(By.id("menu_admin_viewAdminModule"));
        WebElement jobMenuEle = driver.findElement(By.id("menu_admin_Job"));
        Actions action = new Actions(driver);
        action.moveToElement(adminMenu).moveToElement(jobMenuEle).build().perform();

        // For getting the list of the menu
        List<WebElement> listOfJobMenu = driver.findElements(By.xpath("//a[@id='menu_admin_Job']/following-sibling::ul/li/a"));

        for (WebElement jobMenu : listOfJobMenu){
            System.out.println(jobMenu.getText());      // getText is selenium method
        }




    }
}
