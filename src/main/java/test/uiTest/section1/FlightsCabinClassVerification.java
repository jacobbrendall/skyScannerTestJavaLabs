package test.uiTest.section1;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import pageObjects.Base;

import java.io.IOException;

public class FlightsCabinClassVerification extends Base {
    @DisplayName("TC-1006-1 Flights Page Business Class Should Displayed")
    @Test
    public void cabinBusinessClassShouldDisplayed() throws IOException {
        flightsPage.cabinClass();
        Assert.assertTrue(flightsPage.getTravelersAndCabinButton().contains("Business"));
    }

    @DisplayName("TC-1006-2 Flights Page All Cabin Class Should Displayed")
    @Test
    public void allCabinClassShouldDisplayed() throws IOException {
        flightsPage.allCabinClass();
        Assert.assertTrue(flightsPage.allCabinClassIsDisplayed());
    }
}
