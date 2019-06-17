package test.uiTest.section2;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageObjects.Base;

import java.io.IOException;

public class SignUpPageVerification extends Base {
    @DisplayName("TC-2004-1 SignUp Page With Proper User’s Password Should Displayed 'That’s it you are good to go'")
    @Test
    public void signUpShouldSuccessfulWithProperPassword() throws IOException {
        signUpPage.successfulSignUp();
        Assert.assertTrue(signUpPage.signUpSuccessfulPasswordEntry().contains("You're good to go"));
    }

    @DisplayName("TC-2004-1 SignUp Page Create Account Button Should Be Unclickable With Improper User’s Password")
    @Test
    public void signUpShouldFailWithProperPassword() throws IOException {
        signUpPage.failedSignUp();
        Assert.assertTrue(signUpPage.createAccountFailed());
    }
}