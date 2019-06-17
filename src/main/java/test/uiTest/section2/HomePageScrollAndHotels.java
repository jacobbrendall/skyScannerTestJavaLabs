package test.uiTest.section2;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageObjects.Base;

import java.io.IOException;

public class HomePageScrollAndHotels extends Base {
    @DisplayName("TC-2005 Home Page Scroll Down And Hotels Title Should Displayed")
    @Test
    public void scrollDownOnHomePageAndHotelsShouldBeDisable() throws InterruptedException {
        homePage.scrollDown(homePage.pageDownHotelsTitle);
        Assert.assertTrue(homePage.pageDownHotelsTitle.isDisplayed());
    }

    @DisplayName("TC-2005 Home Page Scroll Down And Links Under The Hotels Title Should Export To File")
    @Test
    public void scrollDownOnHomePageAndHotelsLinksShouldBeDisplayed() throws InterruptedException, IOException {
        homePage.scrollDown(homePage.pageDownHotelsTitle);
        Assert.assertTrue(homePage.pageDownHotels.isDisplayed());
        homePage.getDownPageHotelLinks();
    }
}
