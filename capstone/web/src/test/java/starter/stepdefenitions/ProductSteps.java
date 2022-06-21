package starter.stepdefenitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import starter.pages.ProductPage;

public class ProductSteps {
    @Steps
    ProductPage productPage;

    //scenario 1
    @Given("user on the home page")
    public void onTheHomePage(){
        productPage.openPage();
    }

    @Then("user success to buy items")
    public void userSuccessToBuyItems() {
        productPage.clickIconBasket();
    }

    //scenario 2
    @And("user to basket page")
    public void userToBasketPage() {
        productPage.clickIconBasket();
    }

    @And("user increases the number of items")
    public void userIncreasesTheNumberOfItems() {
        productPage.clickIncreaseItems();
        productPage.clickDecreaseItems();
    }

    @Then("user success to increases items")
    public void userSuccessToIncreasesItems() {
    }
}
