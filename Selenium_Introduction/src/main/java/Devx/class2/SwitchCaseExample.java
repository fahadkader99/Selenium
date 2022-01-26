package Devx.class2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Scanner;

public class SwitchCaseExample {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter Browser Name: ");
        String browser = sc.nextLine();

        WebDriver driver;

        switch (browser){
            case "safari":
                System.setProperty("webdriver.safari.driver","/usr/bin/safaridriver");
                driver = new SafariDriver();
                driver.get("https://www.google.com");
                break;

            case "chrome":
                System.setProperty("webdriver.chrome.driver","ssrc/test/resources/driver/chromedriver");
                driver = new ChromeDriver();
                driver.get("https://www.google.com");
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver","src/test/resources/driver/geckodriver");
                driver = new ChromeDriver();
                driver.get("https://www.google.com");
                break;

            case "edge":
                System.setProperty("webdriver.edge.driver","src/test/resources/driver/msedgedriver");
                driver = new EdgeDriver();
                driver.get("https://www.google.com");
                break;

            default:
                throw new RuntimeException("Invalid Browser. Try again");
        }

    }

}
