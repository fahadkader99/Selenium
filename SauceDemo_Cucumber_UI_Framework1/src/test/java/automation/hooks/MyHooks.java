package automation.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class MyHooks {

    @Before("@Assignment")
    public void startUp1(){
        System.out.println("\nRunning the Home Based Assignment Test");
    }
    @Before("@Smoke")
    public void startUp2(){
        System.out.println("\nRunning the Smoke test");
    }

    @Before("@Regression")
    public void startUp3(){
        System.out.println("\nRunning the Regression Suit from TestNG Project");
    }

    @After("@Assignment")
    public void cleanUp1(){
        System.out.println("Closing up Home_Assignment");
    }

    @After("@Smoke")
    public void cleanUp2(){
        System.out.println("Smoke test Ends, See the Cucumber Report...!");
    }

    @After("@Regression")
    public void cleanUp3(){
        System.out.println("TestNG Regression Suite complete. ");
    }

}
