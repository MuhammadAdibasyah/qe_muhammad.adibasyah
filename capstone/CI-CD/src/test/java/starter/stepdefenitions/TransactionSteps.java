package starter.stepdefenitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.transactions.PostTransaksi;

public class TransactionSteps {
    @Steps
    PostTransaksi postTransaksi;

    @Given("user user success login with valid account")
    public void userUserSuccessLoginWithValidAccount() {
        postTransaksi.userLogin();
    }

    @When("user input token in authorization")
    public void userInputTokenInAuthorization() {
        postTransaksi.userSetEndpointTransactions();
    }

    @And("user send request transaction")
    public void userSendRequestTransaction() {
        postTransaksi.userSendRequestTransaction();
    }

    @And("user see transaction")
    public void userSeeTransaction() {
        postTransaksi.userSeeTransaction();
    }

    //scenario 2
    @When("user not input token in authorization")
    public void userNotInputTokenInAuthorization() {
        postTransaksi.userSendRequestTransactionWithNotInputToken();
    }
}
