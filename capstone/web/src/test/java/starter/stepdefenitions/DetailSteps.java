package starter.stepdefenitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import starter.pages.DetailPage;

public class DetailSteps {

    @Steps
    DetailPage detailPage;

    @Given("I am on the home page")
    public void onTheHomePage(){
        detailPage.openPage();
        detailPage.onHomePage();
    }

    @And("I click detail in items product")
    public void iClickDetailInItemsProduct() {
        detailPage.clickDetailProduct();
    }

    @Then("I can see detail product")
    public void iCanSeeDetailProduct() {
        detailPage.seeDetailProduct();
    }
}
