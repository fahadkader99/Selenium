package automation.steps;

import automation.pages.View_SavingsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class View_SavingsPage_Steps {

    View_SavingsPage viewSavingsPage = new View_SavingsPage();




    @Then("verify user is redirected to the View Savings Page")
    public void verifyUserIsRedirectedToTheViewSavingsPage() {
        viewSavingsPage.verifyViewSavingsPage();
    }

    @When("user can see Savings box on the page")
    public void userCanSeeSavingsBoxOnThePage() {
        viewSavingsPage.UserCanSeeSavingsBox();
    }

    @Then("verify on button is toggled on")
    public void verifyOnButtonIsToggledOn() {
        viewSavingsPage.verifyToggleButton();
    }

    @And("also verify user is able to see the current balance on the box")
    public void alsoVerifyUserIsAbleToSeeTheCurrentBalanceOnTheBox() {
        viewSavingsPage.verifyAccountBalanceIsVisible();
    }

    @And("Transactions table are displayed")
    public void TransactionsTableAreDisplayed() {
        viewSavingsPage.verifyTransactionTable();
    }

    @And("verify user is able to see {string}")
    public void verifyUserIsAbleToSee(String fields) {
        viewSavingsPage.verifyTransactionTableFields(fields);
    }

    @And("verify on off button is displayed on MySaving box")
    public void verifyOnOffButtonIsDisplayedOnMySavingBox() {
        viewSavingsPage.verifyToggleButtonIsDisplayed();
    }

    @Then("verify on button is selected")
    public void verifyOnButtonIsSelected() {
        viewSavingsPage.verifyToggleButton();
    }

    @And("verify user is able to see the Transactions table on the page")
    public void verifyUserIsAbleToSeeTheTransactionsTableOnThePage() {
        viewSavingsPage.transactionsTableFieldsAreDisplayed();
    }
}
