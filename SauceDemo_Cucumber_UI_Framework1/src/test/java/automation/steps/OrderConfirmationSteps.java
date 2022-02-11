package automation.steps;

import automation.pages.OrderConfirmationPage;
import io.cucumber.java.en.Then;

public class OrderConfirmationSteps {

    OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage();

    @Then("verify user is on order confirmation page")
    public void verify_user_is_on_order_confirmation_page() {
        orderConfirmationPage.verifyConfirmationPage();
    }

    @Then("verify order confirmation message")
    public void verify_order_confirmation_message() {
        orderConfirmationPage.printOderCompleteMessage();
    }


}
