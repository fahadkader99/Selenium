package automation.steps;

import automation.pages.BikeLightPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BikeLightSteps {

    BikeLightPage bikeLightPage = new BikeLightPage();


    @Then("verify user is on Bike Light product detail page")
    public void verify_user_is_on_bike_light_product_detail_page() {
        bikeLightPage.verifyUserAtBikeLightProductPage();
    }

    @When("user clicks on Bike Light add to cart button")
    public void user_clicks_on_bike_light_add_to_cart_button() {
        bikeLightPage.clickAddToCartButtonBikeLight();
    }

    @Then("user clicks on Bike Light cart icon")
    public void user_clicks_on_bike_light_cart_icon() {
        bikeLightPage.clickOnCartIcon_bikeLight();
    }

}
