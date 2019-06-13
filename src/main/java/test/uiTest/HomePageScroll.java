package test.uiTest;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import pageObjects.Base;

import java.awt.*;

public class HomePageScroll extends Base {

    @Test
    public void scrollDownOnHomePageAndHotelsShouldBeDisable() throws AWTException, InterruptedException {
        homePage.ScrollDown();
        Assert.assertTrue(homePage.hotels.isDisplayed());
    }
}
