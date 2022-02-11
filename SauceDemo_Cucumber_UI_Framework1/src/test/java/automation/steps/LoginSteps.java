package automation.steps;

import automation.pages.LogInPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class LoginSteps {


    LogInPage logInPage = new LogInPage();

    @Given("user open websites")
    public void user_open_websites() {
        logInPage.openWebsite();
    }
    @When("user do login")
    public void user_do_login() {
        logInPage.doLogin();
    }


}
