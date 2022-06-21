package starter.stepdefenitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.register.PostRegist;


public class RegistStep {
    @Steps
    PostRegist postRegist;

    @Given("admin set endpoint for register")
    public void adminSetEndpointForRegister() {
        postRegist.setEndpointsRegister();
    }

    @When("admin send create account with valid data")
    public void adminSendCreateAccountWithValidData() {
        postRegist.sendCreateAccountWithValidData();
    }

    @Then("admin see status code {int} after send register")
    public void adminSeeStatusCodeAfterSendRegister(int arg0) {
        postRegist.seeResponseCodeAfterRegist();
    }
    @And("admin see new detail account")
    public void adminSeeNewDetailAccount() {
        postRegist.userSeeDetailData();
    }

    //scenario 2
    @When("admin send POST HTTP request with empty data register")
    public void adminSendPOSTHTTPRequestWithEmptyDataRegister() {
        postRegist.sendPostWithEmptyDataRegister();
    }
    @Then("admin see status code {int} and fail to create account")
    public void adminSeeStatusCodeAndFailToCreateAccount(int arg0) {
        postRegist.receiveResponseCode400();
    }
    @And("admin get error message after regist")
    public void adminGetErrorMessageAfterRegist() {
        postRegist.getErrorMessageRegist();
    }

    //scenario 3
    @When("admin send POST HTTP request with empty email")
    public void adminSendPOSTHTTPRequestWithEmptyEmail() {
        postRegist.sendPOSTHTTPRequestWithEmptyEmail();
    }

    //scenario 4
    @When("admin send POST HTTP request with invalid email register")
    public void adminSendPOSTHTTPRequestWithInvalidEmailRegister() {
        postRegist.sendPOSTHTTPRequestWithInvalidEmailRegister();
    }

    //scenario 5
    @When("admin send POST HTTP request with not use domain email")
    public void adminSendPOSTHTTPRequestWithNotUseDomainEmail() {
        postRegist.sendPOSTHTTPRequestWithNotUseDomainEmail();
    }

    //scenario 6
    @When("admin send POST HTTP request with empty username")
    public void adminSendPOSTHTTPRequestWithEmptyUsername() {
        postRegist.sendPOSTHTTPRequestWithEmptyUsername();
    }

    //scenario 7
    @When("admin send POST HTTP request with fill number on username field")
    public void adminSendPOSTHTTPRequestWithFillNumberOnUsernameField() {
        postRegist.sendPOSTHTTPRequestWithFillNumberOnUsernameField();
    }

    @When("admin send POST HTTP request with fill letter on username field")
    public void adminSendPOSTHTTPRequestWithFillLetterOnUsernameField() {
        postRegist.SendPOSTHTTPRequestWithFillLetterOnUsernameField();
    }

    @When("admin send POST HTTP request with empty password")
    public void adminSendPOSTHTTPRequestWithEmptyPassword() {
        postRegist.SendPOSTHTTPRequestWithEmptyPassword();
    }

    @When("admin send POST HTTP request with invalid password")
    public void adminSendPOSTHTTPRequestWithInvalidPassword() {
        postRegist.SendPOSTHTTPRequestWithInvalidPassword();
    }

    @When("admin send POST HTTP request with fill password with number")
    public void adminSendPOSTHTTPRequestWithFillPasswordWithNumber() {
        postRegist.SendPOSTHTTPRequestWithFillPasswordWithNumber();
    }

    @When("admin send POST HTTP request with fill password with letter")
    public void adminSendPOSTHTTPRequestWithFillPasswordWithLetter() {
        postRegist.SendPOSTHTTPRequestWithFillPasswordWithLetter();
    }

    @When("admin send POST HTTP request with fill password with combination char")
    public void adminSendPOSTHTTPRequestWithFillPasswordWithCombinationChar() {
        postRegist.SendPOSTHTTPRequestWithFillPasswordWithCombinationChar();
    }
}
