package automation.steps;

import automation.pages.HomePage;
import automation.utils.Common_Methods;
import automation.utils.DriverUtils;
import automation.utils.PropertyReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {


    @Before
    public void setUp(){

        PropertyReader.initProperties();

        String platform = PropertyReader.getProperties("platform");

        if (platform.equals("local")){
            DriverUtils.createDriver();
        }
        else if (platform.equals("grid")){
            DriverUtils.selenium_Grid_Driver();
        }
        else {
            throw new RuntimeException("<-- Invalid platform selected @Before Hooks | check driver settings -- >");
        }


    }



    @After
    public void closeUp(Scenario scenario){

        byte[] data = Common_Methods.takeScreenShot();
        scenario.attach(data,"image/png","Cucumber ScreenShot");


        HomePage homePage = new HomePage();
        homePage.userClicksSignOutButton();         // Logout function.

        DriverUtils.getDriver().close();
    }


}
