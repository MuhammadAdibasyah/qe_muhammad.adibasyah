package starter.login;

import com.github.javafaker.Faker;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class Post {

    protected static String url = "3.88.14.239:80/";

    //scenario 1
    @Step("user set endpoint for login")
    public String setEndpointsLogin(){
        return url + "api/auth/signin";
    }
    @Step("I send POST HTTP request")
    public void sendPostHttpRequest(){
        JSONObject requestBody = new JSONObject();
        requestBody.put( "email","user1@gmail.com");
        requestBody.put( "password","user!2");

      SerenityRest.given().header("Content-Type","application/json").body(requestBody.toJSONString()).post(setEndpointsLogin());
    }
    @Step("I receive valid HTTP response code 200")
    public void receiveValidResponseCode(){
        restAssuredThat(response -> response.statusCode(200));

    }
    @Step("I receive valid data for new user")
    public void receiveValidData(){
        restAssuredThat(response -> response.body("username",equalTo("user000")));
    }

    //scenario 2
    @Step("user send POST HTTP request with empty data")
    public void sendPostWithEmptyData(){
        JSONObject requestBody = new JSONObject();
        requestBody.put( "email","");
        requestBody.put( "password","");

        SerenityRest.given().header("Content-Type","application/json").body(requestBody.toJSONString()).post(setEndpointsLogin());
    }
    @Step("user receive HTTP response code 400")
    public void receiveResponseCode400(){
        restAssuredThat(response -> response.statusCode(400));

    }
    @Step("user get error message")
    public void getErrorMessage(){
        restAssuredThat(response -> response.body("error",equalTo("Bad Request")));
    }
}
