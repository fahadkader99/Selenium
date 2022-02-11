package automation.steps;

import automation.pages.TshirtPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TshirtSteps {

    TshirtPage tshirtPage = new TshirtPage();

    @Then("verify user is on T-Shirt product detail page")
    public void verify_user_is_on_t_shirt_product_detail_page() {
        tshirtPage.verifyUserIsAtT_shirtPage();
    }

    @Then("user clicks on add to T-Shirt cart button")
    public void user_clicks_on_add_to_t_shirt_cart_button() {
        tshirtPage.clickOnAddToCartButtonT_shirt();
    }

    @When("user clicks on T-Shirt cart icon")
    public void user_clicks_on_t_shirt_cart_icon() {
        tshirtPage.userClickOnCartIcon_tShirt();
    }
}
