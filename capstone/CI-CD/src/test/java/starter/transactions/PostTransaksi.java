package starter.transactions;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class PostTransaksi {

    protected String baseUrl = "https://be-qa.alta.id/api/";
    protected static String token = "";

    @Step("user login with valid account")
    public void userLogin(){

        JSONObject requestBody = new JSONObject();
        requestBody.put( "email","debbb@gmail.com");
        requestBody.put( "password","123");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(baseUrl+"auth/login");
        Response resp = SerenityRest.lastResponse();
        token = resp.getBody().jsonPath().get("data");
    }

    @Step("user set endpoints transactions")
    public String userSetEndpointTransactions() {

        return baseUrl+"orders";

    }
    @Step("user send request transaction")
    public void userSendRequestTransaction() {

        JSONObject requestBody = new JSONObject();
        requestBody.put( "product_id",1);
        requestBody.put( "quantity",3);

        JSONArray bodyArray = new JSONArray();
        bodyArray.add(requestBody);
        SerenityRest.given().header("Authorization", "Bearer "+token).body(bodyArray.toJSONString()).post(userSetEndpointTransactions());
    }

    @Step("user see transaction")
    public void userSeeTransaction() {
        Response resp = SerenityRest.lastResponse();
        String Fullname = resp.getBody().jsonPath().get("data[0].User.Fullname");

        Assert.assertEquals(Fullname,"dedeb");
    }

    //scenario 2
    @Step("user send request transaction with not input token")
    public void userSendRequestTransactionWithNotInputToken() {

        JSONObject requestBody = new JSONObject();
        requestBody.put( "product_id",1);
        requestBody.put( "quantity",3);

        JSONArray bodyArray = new JSONArray();
        bodyArray.add(requestBody);
        SerenityRest.given().header("Authorization", "Bearer ").body(bodyArray.toJSONString()).post(userSetEndpointTransactions());
    }

}
