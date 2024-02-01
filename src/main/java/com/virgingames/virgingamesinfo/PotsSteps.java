package com.virgingames.virgingamesinfo;

import com.virgingames.constants.EndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Assert;

import static org.hamcrest.Matchers.hasEntry;

public class PotsSteps {

    static ValidatableResponse response;

    @Step("Getting all pots with id : {0},name : {1}, currency : {2},amount : {3}")   //Step shows the step info in Serenity Report
    public ValidatableResponse getAllPotsInfo()
    {
        return SerenityRest.given()
                .log().all()
                .contentType(ContentType.JSON)
                .header("Connection" , "keep-alive")                          //Execution under test using these info
                .when()
                .get(EndPoints.GET_ALL_POTS)
                .then().log().all().statusCode(200);
    }
    @Step("Getting all pots information where currency is GBP")
    public ValidatableResponse getAllPotsGBP()
    {
        return SerenityRest.given()
                .log().all()
                .when()
                .queryParam("currency" ,"GBP")
                .get(EndPoints.GET_ALL_POTS)
                .then().log().all().statusCode(200);
    }

    @Step("Getting all pots information where currency is EUR")
    public ValidatableResponse getAllPotsEUR()
    {
        return SerenityRest.given()
                .log().all()
                .when()
                .queryParam("currency" , "EUR")
                .get(EndPoints.GET_ALL_POTS)
                .then().log().all().statusCode(200);
    }

    @Step("Getting all pots information where currency is SEK")
    public ValidatableResponse getAllPotsSEK()
    {
        return SerenityRest.given()
                .log().all()
                .when()
                .queryParam("currency" , "SEK")
                .get(EndPoints.GET_ALL_POTS)
                .then().log().all().statusCode(200);
    }

 /*   @Step("Verify id,name,currency and amount of different pots")
    public void getToVerifyDifferentsPots()
    {
        response = getAllPotsInfo();
        response
                .body("data.pots[1]" , hasEntry("id" ,"bouncy_bubbles_id"))
                .body("data.pots[9]" , hasEntry("name" , "play-double-bubble-jp-mini"))
                .body("data.pots[14]" ,hasEntry("currency" ,"GBP"))
                .body("data.pots[18]", hasEntry("amount" ,114777.83))
                .log().all().statusCode(200);
    }

    @Step("Print the size of the data")
    public void getTotalRecords()
    {
        response = getAllPotsInfo();
        int total = 43;
        int size = response.extract().path("data.pots.size");
        Assert.assertEquals(total,size);*/

}
