package com.virgingames.Test;

import com.virgingames.testbase.TestBase;
import com.virgingames.virgingamesinfo.PotsSteps;
import io.cucumber.junit.CucumberSerenityRunner;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasItem;

@RunWith(SerenityRunner.class)
public class VirginGamesRoxorTest extends TestBase {

    static ValidatableResponse response;

    @Steps
    PotsSteps steps;

    @Title("This will fetch all games data")
    @Test
    public void fetchAllData()
    {
        response = steps.getAllPotsInfo().log().all().statusCode(200);
    }

    @Title("This will get all the information about Pots where currency is GBP")
    @Test
    public void potsWithCurrencyGBP()
    {
        response = steps.getAllPotsGBP().log().all().statusCode(200);
        response.body("data.pots.currency" , hasItem("GBP"));
    }

    @Title("This will get all the information about Pots where currency is EUR")
    @Test
    public void potsHavingCurrencyEUR()
    {
        response = steps.getAllPotsEUR().log().all().statusCode(200);
        response.body("data.pots.currency" ,hasItem("EUR"));
    }

    @Title("This will get all the information about Pots where currency is SEK")
    @Test
    public void potsHavingCurrencySEK()
    {
        response = steps.getAllPotsSEK().log().all().statusCode(200);
        response.body("data.pots.currency" ,hasItem("SEK"));
    }

    @Title("This will verify id,name,currency and amount of different pots")
    @Test
    public void  getToVerifyDifferentPots()
    {
        response = steps.getAllPotsInfo();
        response
                .body("data.pots[6]", hasEntry("id", "diamondbonanza100"))
                .body("data.pots[19]", hasEntry("name", "play-legendary-queen"));
        response.log().all().statusCode(200);
    }

    @Title("This will print the size of the data")
    @Test
    public void sizeOfTheData()
    {
        response = steps.getAllPotsInfo();
        List<Integer> length =  response.extract().path("data.pots.length");
        System.out.println("Size of the data :" +length.size());
    }
}


