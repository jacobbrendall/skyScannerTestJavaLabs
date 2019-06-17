package test.uiTest.section1;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageObjects.Base;

import java.io.IOException;

public class FlightsSearchValidation extends Base {
    @DisplayName("TC-1003 Flights Search Page Should Displayed")
    @Test
    public void flightsSearchPageShouldDisplayed() throws InterruptedException, IOException {
        flightsPage.flightsSearch();
        Assert.assertTrue(flightsPage.getFlightsSearchPageDestinationText().contains("Munich"));
    }
}
