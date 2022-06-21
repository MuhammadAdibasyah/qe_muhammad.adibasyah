package starter.register;

import com.github.javafaker.Faker;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class PostRegist {
    private String username = "";
    private String email = "" ;
    private String url = "http://3.88.14.239:80/";

    @Step("admin set endpoint for register")
    public String setEndpointsRegister(){
        return url + "api/auth/signup";
    }
    @Step("admin send create account with valid data")
    public void sendCreateAccountWithValidData(){
        Faker faker = new Faker();
        username = faker.name().username();
        email = faker.internet().emailAddress();
        JSONObject requestBody = new JSONObject();
        requestBody.put( "email",email );
        requestBody.put( "password", "password!2");
        requestBody.put( "username",username );

        SerenityRest.given().header("Content-Type","application/json").body(requestBody.toJSONString()).post(setEndpointsRegister());
    }
    @Step("admin see response code 200 after send register")
    public void seeResponseCodeAfterRegist(){
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step("admin see detail data")
    public void userSeeDetailData(){
        restAssuredThat(response -> response.body("message",equalTo("User registered successfully!")));
    }
    //scenario 2
    @Step("admin send post HTTP with empty data register")
    public void sendPostWithEmptyDataRegister(){
        JSONObject requestBody = new JSONObject();
        requestBody.put( "email","" );
        requestBody.put( "password", "");
        requestBody.put( "username","" );

        SerenityRest.given().header("Content-Type","application/json").body(requestBody.toJSONString()).post(setEndpointsRegister());
    }
    @Step("admin get respone code 400")
    public void receiveResponseCode400() {
        restAssuredThat(response -> response.statusCode(400));
    }
    @Step("admin get error message")
    public void getErrorMessageRegist(){
        restAssuredThat(response -> response.body("error",equalTo("Bad Request")));
    }

    //scenario 3
    @Step("admin send POST HTTP request with empty email")
    public void sendPOSTHTTPRequestWithEmptyEmail() {
        JSONObject requestBody = new JSONObject();
        requestBody.put( "email","" );
        requestBody.put( "password", "password!2");
        requestBody.put( "username","user01" );

        SerenityRest.given().header("Content-Type","application/json").body(requestBody.toJSONString()).post(setEndpointsRegister());
    }

    //scenario 4
    @Step("admin send POST HTTP request with invalid email register")
    public void sendPOSTHTTPRequestWithInvalidEmailRegister() {
        JSONObject requestBody = new JSONObject();
        requestBody.put( "email","user111.gmail.com" );
        requestBody.put( "password","password!2");
        requestBody.put( "username","user111" );

        SerenityRest.given().header("Content-Type","application/json").body(requestBody.toJSONString()).post(setEndpointsRegister());
    }

    //scenario 5
    @Step("admin send POST HTTP request with not use domain email")
    public void sendPOSTHTTPRequestWithNotUseDomainEmail() {
        JSONObject requestBody = new JSONObject();
        requestBody.put( "email","user111" );
        requestBody.put( "password", "password!2");
        requestBody.put( "username","user111" );

        SerenityRest.given().header("Content-Type","application/json").body(requestBody.toJSONString()).post(setEndpointsRegister());
    }

    //scenario 6
    @Step("admin send POST HTTP request with empty username")
    public void sendPOSTHTTPRequestWithEmptyUsername() {
        JSONObject requestBody = new JSONObject();
        requestBody.put( "email","user111@gmail,com");
        requestBody.put( "password", "password!2");
        requestBody.put( "username","" );

        SerenityRest.given().header("Content-Type","application/json").body(requestBody.toJSONString()).post(setEndpointsRegister());
    }

    //scenario 7
    @Step("admin send POST HTTP request with fill number on username field")
    public void sendPOSTHTTPRequestWithFillNumberOnUsernameField() {
        Faker faker = new Faker();
        email = faker.internet().emailAddress();
        JSONObject requestBody = new JSONObject();
        requestBody.put( "email",email );
        requestBody.put( "password", "password!2");
        requestBody.put( "username","12344567" );

        SerenityRest.given().header("Content-Type","application/json").body(requestBody.toJSONString()).post(setEndpointsRegister());
    }

    //scenario 8
    @Step("admin send POST HTTP request with fill letter on username field")
    public void SendPOSTHTTPRequestWithFillLetterOnUsernameField() {
        Faker faker = new Faker();
        email = faker.internet().emailAddress();
        JSONObject requestBody = new JSONObject();
        requestBody.put( "email", email);
        requestBody.put( "password", "password!2");
        requestBody.put( "username","nagabonarr" );

        SerenityRest.given().header("Content-Type","application/json").body(requestBody.toJSONString()).post(setEndpointsRegister());
    }

    //scenario 9
    @Step("admin send POST HTTP request with empty password")
    public void SendPOSTHTTPRequestWithEmptyPassword() {
        JSONObject requestBody = new JSONObject();
        requestBody.put( "email","user66@gmail.com" );
        requestBody.put( "password", "");
        requestBody.put( "username","user66" );

        SerenityRest.given().header("Content-Type","application/json").body(requestBody.toJSONString()).post(setEndpointsRegister());
    }

    //scenario 10
    @Step("admin send POST HTTP request with invalid password")
    public void SendPOSTHTTPRequestWithInvalidPassword() {
        JSONObject requestBody = new JSONObject();
        requestBody.put( "email","user55@gmail.com" );
        requestBody.put( "password", "pass");
        requestBody.put( "username","user55" );

        SerenityRest.given().header("Content-Type","application/json").body(requestBody.toJSONString()).post(setEndpointsRegister());
    }

    //scenario 11
    @Step("admin send POST HTTP request with fill password with number")
    public void SendPOSTHTTPRequestWithFillPasswordWithNumber() {
        Faker faker = new Faker();
        username = faker.name().username();
        email = faker.internet().emailAddress();
        JSONObject requestBody = new JSONObject();
        requestBody.put( "email",email);
        requestBody.put( "password", "12345678");
        requestBody.put( "username",username );

        SerenityRest.given().header("Content-Type","application/json").body(requestBody.toJSONString()).post(setEndpointsRegister());
    }

    //scenario 12
    @Step("admin send POST HTTP request with fill password with letter")
    public void SendPOSTHTTPRequestWithFillPasswordWithLetter() {
        Faker faker = new Faker();
        username = faker.name().username();
        email = faker.internet().emailAddress();
        JSONObject requestBody = new JSONObject();
        requestBody.put( "email",email );
        requestBody.put( "password", "password");
        requestBody.put( "username",username );

        SerenityRest.given().header("Content-Type","application/json").body(requestBody.toJSONString()).post(setEndpointsRegister());
    }

    //scenario 13
    @Step("admin send POST HTTP request with fill password with combination char")
    public void SendPOSTHTTPRequestWithFillPasswordWithCombinationChar() {
        Faker faker = new Faker();
        username = faker.name().username();
        email = faker.internet().emailAddress();
        JSONObject requestBody = new JSONObject();
        requestBody.put( "email",email);
        requestBody.put( "password", "Password!2");
        requestBody.put( "username",username);

        SerenityRest.given().header("Content-Type","application/json").body(requestBody.toJSONString()).post(setEndpointsRegister());
    }
}
