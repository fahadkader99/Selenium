package automation.steps;

import automation.pages.ProductDetailPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductDetailSteps {

    ProductDetailPage productDetailPage = new ProductDetailPage();

    @Then("verify user is on product detail page")
    public void verify_user_is_on_product_detail_page() {
        productDetailPage.verifyProductDetailPage();
    }
    @When("user clicks on add to cart button")
    public void user_clicks_on_add_to_cart_button() {
        productDetailPage.clickOnAddToCartBtn();
    }
    @When("click on cart icon")
    public void click_on_cart_icon() {
        productDetailPage.clickOnCartIcon();
    }

}
