package starter.categories;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class Post {
    protected static String url = "https://be-qa.alta.id/api/";

    @Step("user set endpoint for add categories")
    public String userSetEndpointForAddCategories() {
        return url + "categories";
    }

    @Step("user send POST HTTP request with valid data categories")
    public void userSendPOSTHTTPRequestWithValidDataCategories() {
        JSONObject requestBody = new JSONObject();
        requestBody.put( "name","kesehatan");

        SerenityRest.given().header("Content-Type","application/json").body(requestBody.toJSONString()).post(userSetEndpointForAddCategories());
    }

    @Step("user see new detail categories")
    public void userSeeNewDetailCategories() {
        restAssuredThat(response -> response.body("'data'.'Name'",equalTo("kesehatan")));
    }
}
