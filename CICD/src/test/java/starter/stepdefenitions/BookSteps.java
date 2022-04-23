package starter.stepdefenitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.book.Get;

public class BookSteps {
    @Steps
    Get get;

    @Given("I set GET api endpoints")
    public void setGetApiEndpoints(){
        get.setGetApiEndpoints();

    }
    @When("I send GET HTTP request")
    public void sendGetHttpRequest(){
        get.sendGetHttpRequest();

    }
    @Then("I receive valid HTTP response code 200")
    public void receiveValidHttpResponseCode(){
        get.receiveValidHttpResponseCode();

    }
    @And("I receive valid data for detail book")
    public void receiveValidDataForDetailUser(){
        get.receiveValidDataForDetailBook();

    }
    @Given("I set GET Book api endpoints")
    public void setApiEndpoints(){
        get.setApiEndpoints();
    }

    @When("I send GET Book HTTP request")
    public void sendRequest(){
        get.sendRequest();
    }

    @Then("I receive valid HTTP response code 400")
    public void receiveValidCode400(){
        get.receiveValidCode400();
    }

    @And("I receive error message")
    public void receiveErrorMessage(){
        get.receiveErrorMessage();
    }
}
