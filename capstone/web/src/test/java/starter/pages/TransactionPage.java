package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class TransactionPage extends PageObject {
    private By onHomePage(){
        return By.className("container");
    }
    private By items(){
        return By.xpath("(//button[@class='button-beli ml-3 v-btn v-btn--outlined theme--light v-size--small primary--text'])[1]");
    }
    private By items2(){
        return By.xpath("(//button[@class='button-beli ml-3 v-btn v-btn--outlined theme--light v-size--small primary--text'])[2]");
    }
    private By items3(){
        return By.xpath("(//button[@class='button-beli ml-3 v-btn v-btn--outlined theme--light v-size--small primary--text'])[3]");
    }
    private By basketIcon(){
        return By.xpath("(//button[@class='v-btn v-btn--icon v-btn--round theme--dark v-size--default'])[1]");
    }
    private By payButton(){
        return By.id("button-bayar");
    }
    private By transactionPage(){
        return By.className("container");
    }
    private By loginPage(){
        return By.className("v-card__title");
    }
    private By altaShop(){
        return By.className("v-toolbar__title");
    }

    @Step
    public void openPage(){
        open();
    }
    @Step
    public boolean onHome(){
        return $(onHomePage()).isDisplayed();
    }
    @Step
    public void clickItems(){
        $(items()).click();
    }
    @Step
    public void clickItems2(){
        $(items2()).click();
    }
    @Step
    public void clickItems3(){
        $(items3()).click();
    }
    @Step
    public void clickIconBasket(){
        $(basketIcon()).click();
    }
    @Step
    public void clickPayButton(){
        $(payButton()).click();
    }
    @Step
    public boolean successPay(){
        return $(transactionPage()).isDisplayed();
    }
    @Step
    public boolean moveToLoginPage(){
        return $(loginPage()).isDisplayed();
    }
    @Step
    public void clickAltaShop(){
        $(altaShop()).click();
    }

}
