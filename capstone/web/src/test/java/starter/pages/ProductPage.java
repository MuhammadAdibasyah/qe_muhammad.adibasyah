package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class ProductPage extends PageObject {
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
    private By increaseItems(){
        return By.xpath("(//button[@class='v-btn v-btn--icon v-btn--outlined v-btn--round theme--light v-size--default'])[2]");
    }
    private By decreaseItems(){
        return By.xpath("(//button[@class='v-btn v-btn--icon v-btn--outlined v-btn--round theme--light v-size--default'])[3]");
    }

    @Step
    public void openPage(){
        open();
    }
    @Step
    public void clickDecreaseItems(){
        $(decreaseItems()).click();
    }
    @Step
    public void clickIconBasket(){
        $(basketIcon()).click();
    }
    @Step
    public void clickIncreaseItems(){
        $(increaseItems()).click();
    }
}

