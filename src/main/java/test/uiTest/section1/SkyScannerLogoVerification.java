package test.uiTest.section1;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageObjects.Base;

public class SkyScannerLogoVerification extends Base {
    @DisplayName("TC-1001 Home Page SkyScanner Logo Should Displayed")
    @Test
    public void skyScannerLogoShouldDisplayed() {
        Assert.assertTrue("SkyScanner Logo is displayed", homePage.logo.isDisplayed());
    }
}
