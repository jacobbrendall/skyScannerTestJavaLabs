package test.uiTest;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageObjects.Base;

import java.io.IOException;

public class FlightsOneWay extends Base {
    @DisplayName("TC-1004 Flights Page  One Way Button Should Activated")
    @Test
    public void flightsPageOneWayButtonShouldActivated() throws IOException {
        flightsPage.fligtsOneWay();
        Assert.assertTrue(flightsPage.getReturnDateText().contains("One way"));
    }
}
