package test.mobile.pages;

import io.appium.java_client.MobileBy;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import test.mobile.pageobject.BasePageObject;

public class RegisterPage extends BasePageObject {
    private By loginButton(){
        return MobileBy.xpath("//android.widget.Button[@content-desc=\"Login\"]");
    }
    private By toRegister(){
        return MobileBy.xpath("//android.view.View[@content-desc=\"Register\"]");
    }
    private By nameField(){
        return MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]");
    }
    private By usernameFieldRegist() {
        return MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]");
    }
    private By emailFieldRegist() {
        return MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[3]");
    }
    private By passFieldRegist(){
        return MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[4]");
    }
    private By confimrPassFieldRegist(){
        return MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[5]");
    }
    private By registerButton(){
        return MobileBy.xpath("//android.widget.Button[@content-desc=\"Register\"]");
    }
    private By clickVerifyEmail(){
        return MobileBy.xpath("//android.widget.Button[@content-desc=\"Open email app\"]");
    }
    private By homePage(){
        return MobileBy.xpath("//android.view.View[@content-desc=\"Products\"]");
    }
    private By errorNoEmail(){
        return MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]");
    }
    private By errorNoFullname(){
        return MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]");
    }
    private By errorNoPassword(){
        return MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[3]");
    }
    private By errorRegistered(){
        return MobileBy.xpath("//android.view.View[@content-desc=\"Gagal :(\"]");
    }

    @Step
    public void onTheLoginPage(){
        waitUntilPresence(loginButton()).isDisplayed();
    }
    @Step
    public void clickToRegister(){
        onClick(toRegister());
    }
    @Step
    public void inputName(String name){
        onClick(nameField());
        onType(nameField(),name);
    }
    @Step
    public void inputUsername(String username){
        onClick(usernameFieldRegist());
        onType(usernameFieldRegist(),username);
    }
    @Step
    public void inputEmail(String email){
        onClick(emailFieldRegist());
        onType(emailFieldRegist(),email);
    }
    @Step
    public void inputPassword(String password){
        onClick(passFieldRegist());
        onType(passFieldRegist(),password);
    }
    @Step
    public void inputConfirmPassword(String password){
        onClick(confimrPassFieldRegist());
        onType(confimrPassFieldRegist(),password);
    }
    @Step
    public void clickRegisterButton(){
        onClick(registerButton());
    }

    @Step
    public void verifyEmail(){
        onClick(clickVerifyEmail());
    }
    @Step
    public boolean backOnTheHomePage(){
        return waitUntilVisible(homePage()).isDisplayed();
    }
    @Step
    public boolean errorMessageNoEmail(){
        return waitUntilVisible(errorNoEmail()).isDisplayed();
    }
    @Step
    public boolean errorMessageNoPassword(){
        return waitUntilVisible(errorNoPassword()).isDisplayed();
    }
    @Step
    public boolean errorMessageNoName(){
        return waitUntilVisible(errorNoFullname()).isDisplayed();
    }
    @Step
    public boolean errorMessageRegistered(){
        return waitUntilVisible(errorRegistered()).isDisplayed();
    }
}
