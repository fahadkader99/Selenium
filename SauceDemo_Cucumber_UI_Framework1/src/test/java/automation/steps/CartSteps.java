package automation.steps;

import automation.pages.CartPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartSteps {

    CartPage cartPage = new CartPage();

    @Then("verify user is on cart page")
    public void verify_user_is_on_cart_page() {
        cartPage.verifyUserIsAtCartPage();
    }

    @When("user clicks on checkout button")
    public void user_clicks_on_checkout_button() {
        cartPage.clickOnCheckOutButton();
    }

    @When("user clicks on continue shopping")
    public void user_clicks_on_continue_shopping() {
        cartPage.userClickOnContinueShoppingButton();
    }

    @When("Verify two items displayed on cart page")
    public void verify_two_items_displayed_on_cart_page() {
        cartPage.verifyTwoItemDisplayedOnCart();
    }

    @Then("verify one item should be available in Cart")
    public void verify_one_item_should_be_available_in_cart() {
        cartPage.verifyCartQuantityIsOne();
    }

    @Then("user clicks on Bike Light remove button")
    public void user_clicks_on_bike_light_remove_button() {
        cartPage.clickRemoveButtonBikeLight();
    }

    @When("user clicks on burger menu")
    public void user_clicks_on_burger_menu() {
        cartPage.userClickOnBurgerMenuCartPage();
    }

    @Then("user click on logout link")
    public void user_click_on_logout_link() {
        cartPage.clickOnLogOutLinkCartPage();
    }

}
