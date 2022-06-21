package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {

    //element
    private By emailField(){
        return By.xpath("//label[contains(text(),'Email')]/following-sibling::input");
    }

    private By passwordField(){
        return By.xpath("//label[contains(text(),'Password')]/following-sibling::input");
    }

    private By loginButton(){
        return By.xpath("(//span[@class='v-btn__content'])[3]");
    }

    private By loginIcon(){
        return By.xpath("(//button[@class='v-btn v-btn--icon v-btn--round theme--dark v-size--default'])[2]");
    }

    private By onHomePage(){
        return By.className("v-toolbar__title");
    }

    private By errorMessage(){
        return By.className("v-alert__wrapper");
    }

    private By errorMessageInvalid(){
        return By.className("v-alert__content");
    }

    private By errorMessageNotRecord(){
        return By.className("v-alert__content");
    }

    //function

    @Step
    public void openPage(){
        open();
    }

    @Step
    public void clickLoginIcon(){
        $(loginIcon()).click();
    }

    @Step
    public void inputEmail(String email){
        $(emailField()).type(email);
    }

    @Step
    public void inputPassword(String password){
        $(passwordField()).type(password);
    }

    @Step
    public void clickLoginButton(){
        $(loginButton()).click();
    }

    @Step
    public boolean validationOnHomepage(){
        return $(onHomePage()).isDisplayed();
    }

    @Step
    public boolean getErrorMessage(){
        return $(errorMessage()).isDisplayed();
    }

    @Step
    public boolean getInvalidMessage(){
        return $(errorMessageInvalid()).isDisplayed();
    }

    @Step
    public boolean getMessageNoRecord(){
        return $(errorMessageNotRecord()).isDisplayed();
    }
}
