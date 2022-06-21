package starter.Product;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class Post {

    protected static String url = "https://be-qa.alta.id/api/";

    @Step("user set endpoint for add product")
    public String userSetEndpointForAddProduct() {
        return url + "products";
    }

    @Step("user send POST HTTP request with valid data product")
    public void userSendPOSTHTTPRequestWithValidDataProduct() {
        JSONObject requestBody = new JSONObject();
        requestBody.put( "name","Tensi Darah Wireless");
        requestBody.put( "price",2900000);

        SerenityRest.given().header("Content-Type","application/json").body(requestBody.toJSONString()).post(userSetEndpointForAddProduct());
    }

    @Step("user see new detail product")
    public void userSeeNewDetailProduct() {
        restAssuredThat(response -> response.body("'data'.'Name'",equalTo("Tensi Darah Wireless")));
        restAssuredThat(response -> response.body("'data'.'Price'",equalTo(2900000)));
    }
}
