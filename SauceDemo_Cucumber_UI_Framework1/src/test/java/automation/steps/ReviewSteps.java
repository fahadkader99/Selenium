package automation.steps;

import automation.pages.ReviewPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReviewSteps {

    ReviewPage reviewPage = new ReviewPage();

    @Then("verify user is on review page")
    public void verify_user_is_on_review_page() {
        //reviewPage.verifyReviewPage();
        reviewPage.verifyOverViewPage();
    }

    @When("user click on finish button")
    public void user_click_on_finish_button() {
        reviewPage.clickFinishButton();
    }

    @When("user clicks on cancel button")
    public void user_clicks_on_cancel_button() {
        reviewPage.clickOnCancelButton();
    }


}
