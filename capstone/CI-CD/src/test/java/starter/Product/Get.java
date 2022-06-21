package starter.Product;


import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class Get {

    protected static String url = "https://be-qa.alta.id/api/";

    @Step("user set endpoint for see product")
    public String setEndpointsProduct(){
        return url + "products";

    }
    @Step("user send Get request")
    public void sendGetRequest(){
        SerenityRest.given().get(setEndpointsProduct());

    }
    @Step("user receive valid HTTP response code 200")
    public void receiveValidHttpResponseCode(){
        restAssuredThat(response -> response.statusCode(200));

    }
    @Step("user see detail product")
    public void receiveDetailProduct(){
        Response response = SerenityRest.lastResponse();
        String Name = response.getBody().jsonPath().get("data.Name[0]");
        int Price = response.getBody().jsonPath().get("data.Price[0]");
        Assert.assertEquals(Name,"Tensi Darah Elektrik");
        Assert.assertEquals(Price,240000);
    }
    @Step("user set wrong endpoint for see product")
    public String setWrongEndpointsProduct(){
        return url + "productsssss";
    }
    @Step("user get error message \"not found\"")
    public void getErrorMessageNotFound(){
        restAssuredThat(response -> response.equals("not found"));
    }
//    @Step("user receive response code 404")
//    public void receiveResponseCode404() {
//        restAssuredThat(response -> response.statusCode(404));
//    }
}
