package starter.categories;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class Get {
    protected static String url = "https://be-qa.alta.id/api/";

    @Step("user set endpoints categories")
    public String setEndpointsCategories(){
        return url + "categories";
    }
    @Step("user send request categories")
    public void sendRequestCategories(){
        SerenityRest.given().get(setEndpointsCategories());
    }
    @Step("user see all categories")
    public void seeAllCategories(){
    }
}
