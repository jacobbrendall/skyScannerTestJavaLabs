package test.uiTest;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageObjects.Base;

import java.io.IOException;

public class FlightsTravelersSelect extends Base {
    @DisplayName("TC-1005 Flight Page Travelers Should Selected ")
    @Test
    public void flightPageTravelersShouldSelected() throws IOException {
        flightsPage.flightTravelersSelect();
        Assert.assertTrue(flightsPage.getTravelersAndCabinButton().contains("3 travelers"));
    }
}
