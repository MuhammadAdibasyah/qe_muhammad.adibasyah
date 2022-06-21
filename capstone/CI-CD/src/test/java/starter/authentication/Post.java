package starter.authentication;

import com.github.javafaker.Faker;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class Post {

    protected static String url = "https://be-qa.alta.id/api/";
    public static String fullname="";
    public static String email="";
    protected static String password="pass123";

    //scenario 1
    @Step("user set endpoint for login")
    public String setEndpointsLogin(){
        return url + "auth/login";
    }
    @Step("I send POST HTTP request")
    public void sendPostHttpRequest(){
        JSONObject requestBody = new JSONObject();
        requestBody.put( "email","debbb@gmail.com");
        requestBody.put( "password","123");

      SerenityRest.given().header("Content-Type","application/json").body(requestBody.toJSONString()).post(setEndpointsLogin());
    }
    @Step("I receive valid HTTP response code 200")
    public void receiveValidResponseCode(){
        restAssuredThat(response -> response.statusCode(200));

    }
    @Step("I receive valid data for new user")
    public void receiveValidData(){
        restAssuredThat(response -> response.body("data",equalTo("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6ImRlZGViIiwiRW1haWwiOiJkZWJiYkBnbWFpbC5jb20ifQ.izbWFg02k2mQg6jXb_mzVNtT4-YAQ8DKJk9HkyncAHY")));
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
        restAssuredThat(response -> response.body("error",equalTo("email is required")));
    }
    //scenario 3
    @Step("user set endpoint for register")
    public String setEndpointsRegister(){
        return url + "auth/register";
    }
    @Step("user send create account with valid data")
    public void sendCreateAccountWithValidData(){
        Faker faker = new Faker();
        fullname = faker.name().fullName();
        email = faker.internet().emailAddress();
        JSONObject requestBody = new JSONObject();
        requestBody.put( "fullname",fullname );
        requestBody.put( "email",email );
        requestBody.put( "password", password);

        SerenityRest.given().header("Content-Type","application/json").body(requestBody.toJSONString()).post(setEndpointsRegister());
    }
    @Step("user see response code 200 after send register")
    public void seeResponseCodeAfterRegist(){
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step("user see detail data")
    public void userSeeDetailData(){
        restAssuredThat(response -> response.body("'data'.'Fullname'",equalTo(fullname)));
        restAssuredThat(response -> response.body("'data'.'Email'",equalTo(email)));
    }
    @Step("user send post HTTP with empty data register")
    public void sendPostWithEmptyDataRegister(){
        JSONObject requestBody = new JSONObject();
        requestBody.put( "fullname","");
        requestBody.put( "email","" );
        requestBody.put( "password", "");

        SerenityRest.given().header("Content-Type","application/json").body(requestBody.toJSONString()).post(setEndpointsLogin());
    }
}
