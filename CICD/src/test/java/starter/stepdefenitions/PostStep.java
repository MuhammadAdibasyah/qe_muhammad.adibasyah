package starter.stepdefenitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Post;

public class PostStep {
    @Steps
    Post post;

    @Given("I set POST api endpoints")
    public void setPostApiEndpoints(){
        post.setPostApiEndpoints();

    }
    @When("I send POST HTTP request")
    public void sendPostHttpRequest(){
        post.sendPostHttpRequest();

    }
    @Then("I receive valid HTTP response code 201")
    public void receiveValidResponseCode(){
        post.receiveValidResponseCode();

    }
    @And("I receive valid data for new user")
    public void receiveValidData(){
        post.receiveValidData();
    }
}
