package test.mobile.pages;

import io.appium.java_client.MobileBy;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import test.mobile.pageobject.BasePageObject;


public class LoginPage extends BasePageObject {
    private By homePage(){
        return MobileBy.xpath("//android.view.View[@content-desc=\"Products\"]");
    }
    private By loginPage(){
        return MobileBy.xpath("//android.view.View[@content-desc=\"Login\"]");
    }

    private By iconLogin(){
        return MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button");
    }
    private By emailField(){
        return MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]");
    }

    private By passwordField(){
        return MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]");
    }

    private By loginButton(){
        return MobileBy.xpath("//android.widget.Button[@content-desc=\"Login\"]");
    }

    private By errorMessage(){
        return MobileBy.xpath("//android.view.View[@content-desc=\"Email atau password tidak valid.\"]");
    }
    private By errorMessageEmptyemail(){
        return MobileBy.xpath( "//android.view.View[@content-desc=\"email can not empty\"]");
    }
    private By errorMessageEmptypassword(){
        return MobileBy.xpath("//android.view.View[@content-desc=\"password can not empty\"]");
    }

    @Step
    public boolean onHomePage(){
        return waitUntilVisible(homePage()).isDisplayed();
    }

    @Step
    public void clickIconLogin(){
        onClick(iconLogin());
    }

    @Step
    public boolean onLoginPage(){
        return waitUntilVisible(loginPage()).isDisplayed();
    }

    @Step
    public void clickLoginButton() {
        onClick(loginButton());
    }

    @Step
    public void inputEmail(String email){
        onClick(emailField());
        onType(emailField(),email);
    }

    @Step
    public void inputPassword(String password){
        onClick(passwordField());
        onType(passwordField(),password);
    }

    @Step
    public String getErrorMessage(){
        return waitUntilVisible(errorMessage()).getText();
    }
    @Step
    public String getErrorMessageEmptyEmail(){
        return waitUntilVisible(errorMessageEmptyemail()).getText();
    }
    @Step
    public String getErrorMessageEmptyPassword(){
        return waitUntilVisible(errorMessageEmptypassword()).getText();
    }
}
