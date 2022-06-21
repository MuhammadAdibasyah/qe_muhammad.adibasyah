package starter.stepdefenitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.LoginPage;

public class LoginSteps {

    @Steps
    LoginPage loginPage;

    //scenario 1

    @Given("i am on the login page")
    public void onLoginPage(){
        loginPage.openPage();
        loginPage.clickLoginIcon();
    }

    @When("i input valid email")
    public void inputValidEmail(){
        loginPage.inputEmail("debbb@gmail.com");
    }

    @And("i input valid password")
    public void inputValidPassword(){
        loginPage.inputPassword("123");
    }

    @And("i click login button")
    public void clickLoginButton(){
        loginPage.clickLoginButton();
    }

    @Then("i success login")
    public void successLogin(){
        loginPage.validationOnHomepage();
    }

    //scenario 2
    @When("i input invalid password")
    public void inputInvalidPassword(){
        loginPage.inputPassword("dedeb140700");
    }

    @Then("i failed to login and get error message {string}")
    public void iFailedToLoginAndGetErrorMessage(String message) {
        loginPage.getInvalidMessage();
    }

    //scenario 3

    @When("i input invalid email")
    public void iInputInvalidEmail() {
        loginPage.inputEmail("debb@fsg");
    }

    @Then("i fail to login and get error message {string}")
    public void iFailToLoginAndGetErrorMessage(String message) {
        loginPage.getMessageNoRecord();
    }


    //scenario 4
    @When("i not input username and password")
    public void notInputUsernamePassword(){
        loginPage.inputPassword("");
        loginPage.inputEmail("");
    }

    @Then("i get error message {string}")
    public void iGetErrorMessage(String message) {
        loginPage.getErrorMessage();
    }

}
