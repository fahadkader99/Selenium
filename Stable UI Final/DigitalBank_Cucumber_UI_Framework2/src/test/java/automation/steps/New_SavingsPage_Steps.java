package automation.steps;

import automation.pages.New_SavingsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class New_SavingsPage_Steps {

    New_SavingsPage newSavingsPage = new New_SavingsPage();



    @Then("user should be redirected to Create Savings page")
    public void userShouldBeRedirectedToCreateSavingsPage() {
        newSavingsPage.verifySavingsPage();
    }



    @Then("Verify {string} is visible")
    public void verifyIsVisible(String arg0) {
        newSavingsPage.verifySavingsAccType(arg0);
    }

    @And("user should be able to see Savings Account Form Fields")
    public void userShouldBeAbleToSeeSavingsAccountFormFields() {
        newSavingsPage.verifyFieldIsVisible();
    }

    @Then("user should be able to see Select Account Ownership")
    public void userShouldBeAbleToSeeSelectAccountOwnership() {
        newSavingsPage.verifySelectAccountOwnership();
    }

    @And("verify {string} is visible at New Savings Page")
    public void verifyIsVisibleAtNewSavingsPage(String arg0) {
        newSavingsPage.verifySelectAccountOwnershipTypes(arg0);
    }

    @Then("user should be able to see Account Name Field")
    public void userShouldBeAbleToSeeAccountNameField() {
        newSavingsPage.AccountNameField();
    }

    @When("user should sends the following details")
    public void user_should_sends_the_following_details(DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions -- Data table

        newSavingsPage.sendCustom_Data_InNameField(dataTable);

    }


    @Then("user should be able to see line Initial Deposit Amount")
    public void userShouldBeAbleToSeeLineInitialDepositAmount() {
        newSavingsPage.verifyInitialDepositAmount();

    }

    @Then("user should be able to input multiple amount to be deposited")
    public void user_should_be_able_to_input_multiple_amount_to_be_deposited(DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions

    }

    @And("user should be able to input {string} to be deposited")
    public void userShouldBeAbleToInputToBeDeposited(String amounts) {

        newSavingsPage.sendMultipleAmountToDeposit(amounts);
    }


    @When("user is on Create Savings page")
    public void userIsOnCreateSavingsPage() {
        Assert.assertTrue("User is not in Savings Page", newSavingsPage.SavingPageTitle.isDisplayed());

    }

    @Then("user select Savings Account Type")
    public void userSelectSavingsAccountType() {
        newSavingsPage.userSelectSavingsAccountType();
    }

    @And("user select Joint")
    public void userSelectJoint() {
        newSavingsPage.selectJointAccount();
    }

    @Then("user enter TestName on the Account Name field")
    public void userEnterTestNameOnTheAccountNameField() {
        newSavingsPage.sendTestName();
    }

    @And("user should be able to input ${int} to be deposited")
    public void userShouldBeAbleToInput$ToBeDeposited(int arg0) {
        newSavingsPage.sendMinimumDeposit(arg0);

    }

    @When("user clicks on Submit button")
    public void userClicksOnSubmitButton() {
        newSavingsPage.userClickSubmitBtn();
    }



}
