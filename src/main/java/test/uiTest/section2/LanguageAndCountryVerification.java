package test.uiTest.section2;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageObjects.Base;

import java.io.IOException;

public class LanguageAndCountryVerification extends Base {
    @DisplayName("TC-2003_1 Home Page Selected Language Should Be Verified On Login Button")
    @Test
    public void selectedLanguageShouldBeVerified() throws InterruptedException, IOException {
        homePage.selectLanguageAndCountry ();
        Assert.assertEquals ( "Oturum aç", homePage.login.getText () );
    }

    @DisplayName("TC-2003_2 Home Page Selected Country Should Be Verified On Home Page")
    @Test
    public void selectedCountryShouldBeVerified() throws InterruptedException, IOException {
        homePage.selectLanguageAndCountry ();
        Assert.assertTrue ( homePage.selectedFlag.isDisplayed () );
    }
}
