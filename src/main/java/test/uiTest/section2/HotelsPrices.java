package test.uiTest.section2;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageObjects.Base;

import java.io.IOException;

public class HotelsPrices extends Base {
    @DisplayName("TC-2006 Hotel Page Prices Should Displayed From Low To High")
    @Test
    public void hotelPricesShouldDisplayedFromLowToHigh() throws IOException, InterruptedException {
        hotelsPage.selectPricesFromLowToHigh();
        Assert.assertEquals(hotelsPage.lowToHighHotelPrices(),hotelsPage.sortHotelPrices());
    }
}
