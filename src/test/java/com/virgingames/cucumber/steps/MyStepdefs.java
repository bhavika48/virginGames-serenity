package com.virgingames.cucumber.steps;


import com.virgingames.jackpotinfo.JackpotSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.ArrayList;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasValue;


public class MyStepdefs {

    static ValidatableResponse response;

    @Steps
    JackpotSteps jackpotSteps;

    @When("^User sends a GET request with currency as GBP$")
    public void userSendsAGETRequestWithCurrencyAsGBP() {
        response=jackpotSteps.getAllBingoInfo();
    }

    @Then("^User must get back a valid status code 200$")
    public void userMustGetBackAValidStatusCode() {
        response.statusCode(200);
    }

    @And("^User must get back response with currency as GBP$")
    public void userMustGetBackResponseWithCurrencyAsGBP() {
      ArrayList<String>  listOfCurrency = response.extract().path("data.pots.currency");
        System.out.println(listOfCurrency);
        for(String e : listOfCurrency){
            Assert.assertThat(e, equalTo("GBP"));
        }
    }




}