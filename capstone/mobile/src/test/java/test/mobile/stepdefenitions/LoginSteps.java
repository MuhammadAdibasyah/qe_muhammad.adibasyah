package test.mobile.stepdefenitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import test.mobile.pages.LoginPage;

public class LoginSteps {
    @Steps
    LoginPage loginPage;

    //scenario1
    @Given("android user on landing screen")
    public void onLandingPage(){
        loginPage.clickIconLogin();
        boolean actual = loginPage.onLoginPage();
        Assert.assertTrue(actual);
    }

    @When("android user input valid email")
    public void inputValidEmail(){
        loginPage.inputEmail("debbb@gmail.com");
    }

    @And("android user input valid password")
    public void inputValidPassword(){
        loginPage.inputPassword("123");
    }

    @And("android user click login button")
    public void clickLoginButton(){
        loginPage.clickLoginButton();
    }

    @Then("android user see homepage")
    public void seeHomepage(){
        boolean actual = loginPage.onHomePage();
        Assert.assertTrue(actual);
    }

    //scenario2
    @When("android user input unregistered email")
    public void androidUserInputUnregisteredEmail() {
        loginPage.inputEmail("ucok123@gmail.com");
    }

    @And("android user input password")
    public void androidUserInputPassword() {
        loginPage.inputPassword("123");
    }

    @And("android user tap login button")
    public void androidUserTapLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("android user see {string} message")
    public void androidUserSeeMessage(String message) {
        loginPage.getErrorMessage();
    }

    //scenario 3
    @When("android user not input email")
    public void androidUserNotInputEmail() {
        loginPage.inputEmail("");
    }

    @And("android user not input password")
    public void androidUserNotInputPassword() {
        loginPage.inputPassword("");
    }

    @Then("android user see error message")
    public void androidUserSeeErrorMessage() {
        loginPage.getErrorMessageEmptyEmail();
        loginPage.getErrorMessageEmptyPassword();
    }

    //scenario 4
    @And("android user input invalid password")
    public void androidUserInputInvalidPassword() {
        loginPage.inputPassword("password12");
    }

    //scenario 5
    @Then("android user see error message empty email")
    public void androidUserSeeErrorMessageEmptyEmail() {
        loginPage.getErrorMessageEmptyEmail();
    }

    //scenario 6
    @Then("android user see error message empty password")
    public void androidUserSeeErrorMessageEmptyPassword() {
        loginPage.getErrorMessageEmptyPassword();
    }
}
