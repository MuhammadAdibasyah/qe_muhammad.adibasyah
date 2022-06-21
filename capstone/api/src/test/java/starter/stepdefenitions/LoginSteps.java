package starter.stepdefenitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.login.Post;

public class LoginSteps {
    @Steps
    Post post;

    @Given("user set endpoint for login")
    public void setEndpointsLogin(){
        post.setEndpointsLogin();
    }

    @When("user send POST HTTP request with valid data")
    public void userSendPOSTHTTPRequestWithValidData() {
        post.sendPostHttpRequest();
    }

    @Then("user see status code {int}")
    public void userSeeStatusCode(int arg0) {
        post.receiveValidResponseCode();
    }

    @And("get valid data")
    public void getValidData() {
        post.receiveValidData();
    }

    //scenario 2
    @When("user send POST HTTP request with empty data")
    public void userSendPOSTHTTPRequestWithEmptyData() {
        post.sendPostWithEmptyData();
    }

    @Then("user see status code {int} and fail to login")
    public void userSeeStatusCodeAndFailToLogin(int arg0) {
        post.receiveResponseCode400();
    }

    @And("user get error message")
    public void userGetErrorMessage() {
        post.getErrorMessage();
    }
}
