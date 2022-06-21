package starter.stepdefenitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.RegisterPage;

import java.util.Random;

public class RegisterSteps {
    @Steps
    RegisterPage registerPage;

    //scenario 1
    @Given("user on the register page")
    public void onRegisterPage(){
        registerPage.openPage();
        registerPage.clickLoginIcon();
        registerPage.clickRegisterIcon();
    }

    @When("user input valid name")
    public void userInputValidName(){
        registerPage.inputFullName("aseb");
    }

    @And("user input valid email")
    public void userInputValidEmail(){
        Random rand = new Random();
        int number = rand.nextInt(100000);
        registerPage.inputEmail("User"+String.valueOf(number)+"@gmail.com");
    }

    @And("user input valid password")
    public void userInputValidPassword(){
        registerPage.inputPassword("Password!2");
    }

    @And("user click register button")
    public void userClickRegisterButton(){
        registerPage.clickRegisterButton();
    }

    @Then("user success to create account")
    public void userSuccessToCreateAccount(){
        registerPage.validationSuccessRegister();
    }

    //scenario 2
    @When("user input registered name")
    public void userInputRegisteredName(){
        registerPage.inputFullName("asep");
    }

    @And("user input registered email")
    public void userInputRegisteredEmail() {
        registerPage.inputEmail("asep@gmail.com");
    }

    @Then("user fail to create account and get error message {string}")
    public void userFailToCreateAccountAndGetErrorMessage(String message) {
        registerPage.getErrorMessage();
    }

    //scenario 3
    @And("user not input password")
    public void userNotInputPassword() {
        registerPage.inputPassword("");
    }

    @Then("user fail to create account and get error message")
    public void userFailToCreateAccountAndGetErrorMessage() {
        registerPage.getErrorNoPassword();
    }
}
