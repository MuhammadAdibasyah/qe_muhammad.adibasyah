package starter.stepdefenitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Product.Get;
import starter.Product.Post;

public class ProductSteps {
    @Steps
    Get get;

    @Steps
    Post post;

    //scenario 1
    @Given("user set endpoint for see product")
    public void setEndpointsProduct(){
        get.setEndpointsProduct();
    }

    @When("user send request")
    public void userSendRequest() {
        get.sendGetRequest();
    }

    @And("user see product")
    public void userSeeProduct() {
        get.receiveDetailProduct();
    }

    //scenario 2
    @Given("user set wrong endpoint for see product")
    public void userSetWrongEndpointForSeeProduct() {
        get.setWrongEndpointsProduct();

    }

    @And("user get error message {string}")
    public void userGetErrorMessage(String arg0) {
        get.getErrorMessageNotFound();

    }

    //scenario 3
    @Given("user set endpoint for add product")
    public void userSetEndpointForAddProduct() {
        post.userSetEndpointForAddProduct();
    }

    @When("user send POST HTTP request with valid data product")
    public void userSendPOSTHTTPRequestWithValidDataProduct() {
        post.userSendPOSTHTTPRequestWithValidDataProduct();
    }

    @And("user see new detail product")
    public void userSeeNewDetailProduct() {
        post.userSeeNewDetailProduct();
    }
}
