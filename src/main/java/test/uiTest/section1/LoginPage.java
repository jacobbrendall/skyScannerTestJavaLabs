package test.uiTest.section1;

import org.junit.Assert;
import org.junit.jupiter.api.*;
import pageObjects.Base;

import java.io.IOException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginPage extends Base {
    @DisplayName("TC -1002 Login Page Login Should Successful With positive Input")
    @Test
    @Order(1)
    public void loginShouldSuccessfulWithPositiveData() throws Exception {
        loginPage.loginPagePositiveAction();
        Assert.assertEquals("javatest@gmx.net", loginPage.getLogInSuccessMessage());
    }

    @DisplayName("TC -1002 Login Page Login Should Fail With Negative Input")
    @Test
    @Order(2)
    public void loginShouldFailWithNegativeData() throws IOException {
        loginPage.LoginPageNegativeAction();
        Assert.assertTrue(loginPage.getLogInFailedMessage().contains("Ensure email address is valid"));
    }
}
