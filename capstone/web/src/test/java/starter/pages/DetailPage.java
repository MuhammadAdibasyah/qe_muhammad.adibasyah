package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class DetailPage extends PageObject {
    private By items(){
        return By.xpath("(//button[@class='button-beli ml-3 v-btn v-btn--outlined theme--light v-size--small primary--text'])[1]");
    }
    private By items2(){
        return By.xpath("(//button[@class='button-beli ml-3 v-btn v-btn--outlined theme--light v-size--small primary--text'])[2]");
    }
    private By items3(){
        return By.xpath("(//button[@class='button-beli ml-3 v-btn v-btn--outlined theme--light v-size--small primary--text'])[3]");
    }
    private By Product1(){
        return By.xpath("(//button[@class='button-beli v-btn v-btn--outlined theme--light v-size--small primary--text'])[2]");
    }
    private By detailProduct(){
        return By.className("v-card__text");
    }
    private By HomePage(){
        return By.className("container");
    }

    @Step
    public void openPage(){
        open();
    }

    @Step
    public void clickDetailProduct(){
        $(Product1()).click();
    }
    @Step
    public boolean seeDetailProduct(){
        return $(detailProduct()).isDisplayed();
    }
    @Step
    public void onHomePage(){
        $(HomePage()).isDisplayed();
    }
}
