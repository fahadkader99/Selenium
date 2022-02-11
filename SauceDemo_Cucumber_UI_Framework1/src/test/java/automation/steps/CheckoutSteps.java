package automation.steps;

import automation.pages.CheckoutPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutSteps {

    CheckoutPage checkoutPage = new CheckoutPage();

    @Then("verify user is on checkout page")
    public void verify_user_is_on_checkout_page() {
        checkoutPage.verifyCheckoutPage();
    }
    @When("user fill all details on checkout page")
    public void user_fill_all_details_on_checkout_page() {
        checkoutPage.fillOutCheckoutDetail();
    }

    @When("click on continue button on checkout page")
    public void click_on_continue_button_on_checkout_page() {
        checkoutPage.clickContinueButton();
    }

}
