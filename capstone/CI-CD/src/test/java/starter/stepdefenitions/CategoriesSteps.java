package starter.stepdefenitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.categories.Get;
import starter.categories.Post;

public class CategoriesSteps {
    @Steps
    Get get;

    @Steps
    Post post;

    @Given("user set endpoint for see categories")
    public void setEndpointsCategories(){
        get.setEndpointsCategories();
    }

    @When("user send request categories")
    public void userSendRequestCategories() {
        get.sendRequestCategories();
    }

    @And("user see all categories")
    public void userSeeAllCategories() {
        get.seeAllCategories();
    }

    //scenario 2
    @Given("Given user set endpoint for add categories")
    public void givenUserSetEndpointForAddCategories() {
        post.userSetEndpointForAddCategories();
    }

    @When("user send POST HTTP request with valid data categories")
    public void userSendPOSTHTTPRequestWithValidDataCategories() {
        post.userSendPOSTHTTPRequestWithValidDataCategories();
    }

    @And("user see new detail categories")
    public void userSeeNewDetailCategories() {
        post.userSeeNewDetailCategories();
    }
}
