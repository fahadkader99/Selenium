package Devx.class3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownMenu {
    public static void main(String[] args) throws InterruptedException{
        // setting path to chrome driver
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver");

        // open the browser
        ChromeDriver driver = new ChromeDriver();

        // 1. to open url in browser
        driver.get("https://www.ebay.com/");



        // create web element pointing <Select> tag
        WebElement catElement = driver.findElement(By.id("gh-cat"));

        // for dropDown we have so many class:
        // create object of select class and pass web element as constructor argument
        Select catDropDownSelect = new Select(catElement);

        Thread.sleep(2000);     // wait for 5 sec and execute the next step.
        catDropDownSelect.selectByIndex(4);              // index starts with 0

        Thread.sleep(3000);     // wait for 5 sec and execute the next step.
        catDropDownSelect.selectByValue("11116");               // each dropdown has a value attribute on the web

        Thread.sleep(4000);     // wait for 5 sec and execute the next step.
        catDropDownSelect.selectByVisibleText("Books");     // name of the text which is displayed


        // printing or getting all the web element using for each loop
        List<WebElement> listOfOption = catDropDownSelect.getOptions();  // the return of getOption is list so we are savin into list
        for (WebElement option: listOfOption){      /// this loop will treverse through the all the elements
            System.out.println(option.getText());
        }

//        // printing or getting all the web element using for  loop
//        for (int i = 0; i <listOfOption;i++){       // using for loop. we can use fpr each loop as loop.
//            System.out.println(listOfOption.get(i).getText());
//        }
    }
}
