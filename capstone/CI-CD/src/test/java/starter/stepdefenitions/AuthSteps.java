package starter.stepdefenitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.authentication.Post;

public class AuthSteps {
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

    //Scenario 3
    @Given("user set endpoint for register")
    public void userSetEndpointForRegister() {
        post.setEndpointsRegister();
    }

    @When("user send create account with valid data")
    public void userSendCreateAccountWithValidData() {
        post.sendCreateAccountWithValidData();
    }

    @Then("user see status code {int} after send register")
    public void userSeeStatusCodeAfterSendRegister(int arg0) {
        post.seeResponseCodeAfterRegist();
    }
    @And("user see new detail account")
    public void userSeeNewDetailAccount() {
        post.userSeeDetailData();
    }

    //scenario 4
    @Then("user see status code {int} and fail to create account")
    public void userSeeStatusCodeAndFailToCreateAccount(int arg0) {
        post.receiveResponseCode400();
    }

    @When("user send POST HTTP request with empty data register")
    public void userSendPOSTHTTPRequestWithEmptyDataRegister() {
        post.sendPostWithEmptyDataRegister();
    }
}
