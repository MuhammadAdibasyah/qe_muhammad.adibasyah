package starter.stepdefenitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.TransactionPage;

public class TransactionSteps {
    @Steps
    TransactionPage transactionPage;

    //scenario 1
    @And("user click items")
    public void userClickItems() {
        transactionPage.clickItems();
        transactionPage.clickItems();
        transactionPage.clickItems2();
        transactionPage.clickItems2();
        transactionPage.clickItems3();
        transactionPage.clickItems3();
    }

    @And("user click icon basket")
    public void userClickIconBasket() {
        transactionPage.clickIconBasket();
    }

    @And("user click pay button")
    public void userClickPayButton() {
        transactionPage.clickPayButton();
    }

    @Then("user success to pay all items")
    public void userSuccessToPayAllItems() {
        transactionPage.successPay();
    }

    //scenario 2
    @Given("i am on home page")
    public void iAmOnHomePage() {
        transactionPage.openPage();
        transactionPage.onHome();
    }

    @Then("Then user is moved to the login page")
    public void thenUserIsMovedToTheLoginPage() {
        transactionPage.moveToLoginPage();
    }
}
