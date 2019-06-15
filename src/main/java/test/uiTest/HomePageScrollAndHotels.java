package test.uiTest;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import pageObjects.Base;

import java.io.IOException;

public class HomePageScrollAndHotels extends Base {

    @Test
    public void scrollDownOnHomePageAndHotelsShouldBeDisable() throws InterruptedException {
        homePage.ScrollDown();
        Assert.assertTrue(homePage.hotelsTitle.isDisplayed());
    }
    @Test
    public void scrollDownOnHomePageAndHotelsLinksShouldBeDisplayed() throws InterruptedException, IOException {
        homePage.ScrollDown();
        Assert.assertTrue(homePage.pageDownHotels.isDisplayed());
        homePage.getDownPageHotelLinks();
    }
}
