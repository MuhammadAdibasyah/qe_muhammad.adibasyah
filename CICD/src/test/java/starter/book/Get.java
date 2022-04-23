package starter.book;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;


public class Get {

    protected static String url = "https://demoqa.com/BookStore/";
    protected static String url2 = "https://demoqa.com/BookStore/";


    @Step("I set GET api endpoints")
    public String setGetApiEndpoints(){
        return url + "v1/Books";

    }
    @Step("I send GET HTTP request")
    public void sendGetHttpRequest(){
        SerenityRest.given().get(setGetApiEndpoints());

    }
    @Step("I receive valid HTTP response code 200")
    public void receiveValidHttpResponseCode(){
        restAssuredThat(response -> response.statusCode(200));

    }
    @Step("I receive valid data for detail book")
    public void receiveValidDataForDetailBook(){
        Response response = SerenityRest.lastResponse();
        String isbn = response.getBody().jsonPath().get("books.isbn[0]");
        String title = response.getBody().jsonPath().get("books.title[0]");
        Assert.assertEquals(isbn,"9781449325862");
        Assert.assertEquals(title,"Git Pocket Guide");
    }

//    @Step("I set GET Book api endpoints")
//    public String setApiEndpoints(){
//        return url2 + "v1/Book?ISBN=tess";
//
//    }
//    @Step("I send GET Book HTTP request")
//    public void sendRequest(){
//        SerenityRest.given().get(setGetApiEndpoints());
//    }
//
//    @Step("I receive valid HTTP response code 400")
//    public void receiveValidCode400(){
//        restAssuredThat(response -> response.statusCode(400));
//    }
//
//    @Step("I receive error message")
//    public void receiveErrorMessage(){
//        Response response = SerenityRest.lastResponse();
//        int code = response.getBody().jsonPath().get("code");
//        String message = response.getBody().jsonPath().get("message");
//        Assert.assertEquals(code,"1205");
//        Assert.assertEquals(message,"ISBN supplied is not available in Books Collection!");
//    }
}
