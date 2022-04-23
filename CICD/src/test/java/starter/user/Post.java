package starter.user;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class Post {

    protected static String url = "https://demoqa.com/Account/";
    public static String username="";
    protected static String password="Password!2";
    public static String userID="";

    @Step("I set POST api endpoints")
    public String setPostApiEndpoints(){
        return url + "v1/User";
    }
    @Step("I send POST HTTP request")
    public void sendPostHttpRequest(){
        Faker faker = new Faker();
        username = faker.name().username();
        JSONObject requestBody = new JSONObject();
        requestBody.put( "userName", username);
        requestBody.put( "password", password);

        SerenityRest.given().header("Content-Type","application/json").body(requestBody.toJSONString()).post(setPostApiEndpoints());
        Response response = SerenityRest.lastResponse();
        response.getBody().jsonPath().get(userID);
    }
    @Step("I receive valid HTTP response code 201")
    public void receiveValidResponseCode(){
        restAssuredThat(response -> response.statusCode(201));
    }
    @Step("I receive valid data for new user")
    public void receiveValidData(){
        restAssuredThat(response -> response.body("username", equalTo(username)));

    }
}
