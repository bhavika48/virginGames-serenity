package com.virgingames.jackpotinfo;

import com.virgingames.constants.EndPoints;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;

public class JackpotSteps {

    public ValidatableResponse getAllBingoInfo() {
        return SerenityRest.given()
                .when().get(EndPoints.GET_ALL_BINGO)
                .then();
    }
}
