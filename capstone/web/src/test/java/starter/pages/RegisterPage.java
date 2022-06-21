package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class RegisterPage extends PageObject {
    private By fullNameField(){
        return By.xpath("//label[contains(text(),'Nama Lengkap')]//following-sibling::input");
    }

    private By emailField(){
        return By.xpath("//label[contains(text(),'Email')]//following-sibling::input");
    }

    private By passFiled(){
        return By.xpath("//label[contains(text(),'Password')]//following-sibling::input");
    }

    private By registerButton(){
        return By.xpath("//span[contains(text(),'Register')]//parent::button");
    }

    private By toRegisterPage(){
        return By.xpath("//a");
    }
    private By loginIcon(){
        return By.xpath("(//button[@class='v-btn v-btn--icon v-btn--round theme--dark v-size--default'])[2]");
    }
    private By loginDisplay(){
        return By.className("container");
    }
    private By errorMessage(){
        return By.className("v-alert__wrapper");
    }
    private By errorNoPassword(){
        return By.className("v-alert__content");
    }
    @Step
    public void openPage(){
        open();
    }
    @Step
    public void clickLoginIcon(){
        $(loginIcon()).click();
    }

    @Step
    public void clickRegisterIcon(){
        $(toRegisterPage()).click();
    }

    @Step
    public void inputFullName(String fullName){
        $(fullNameField()).type(fullName);
    }
    @Step
    public void inputEmail(String email){
        $(emailField()).type(email);
    }
    @Step
    public void inputPassword(String Password){
        $(passFiled()).type(Password);
    }
    @Step
    public void clickRegisterButton(){
        $(registerButton()).click();
    }
    @Step
    public boolean validationSuccessRegister(){
        return $(loginDisplay()).isDisplayed();
    }
    @Step
    public boolean getErrorMessage(){
        return $(errorMessage()).isDisplayed();
    }

    @Step
    public boolean getErrorNoPassword(){
        return $(errorNoPassword()).isDisplayed();
    }
}
