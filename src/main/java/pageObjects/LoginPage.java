package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class LoginPage {
    public Base base = new Base();

    @FindBy(xpath = "//span[@id='authentication-link']")
    private WebElement homeLogin;

    @FindBy(css = "div[class*='emailLogo']")
    private WebElement selectEmailLogo;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(css = "button[class*='bpk-button-aTnwj']")
    private WebElement loginButton;

    @FindBy(xpath = "//span[@id='authentication-link']")
    private WebElement accountTitle;

    @FindBy(xpath = "//span[contains(@class,'email-2aj2p')]")
    private WebElement logInSuccessMessage;

    @FindBy(xpath = "//div[contains(@id,'email_validation_message')]")
    private WebElement logInFailedMessage;

    public String getLogInSuccessMessage() {
        return logInSuccessMessage.getText();
    }

    public String getLogInFailedMessage() {
        return logInFailedMessage.getText();
    }

    public void loginPagePositiveAction() throws Exception {
        homeLogin.click();
        selectEmailLogo.click();
        email.sendKeys(base.properties().getProperty("userPositive"));
        password.sendKeys(base.properties().getProperty("passwordPositive"));
        loginButton.click();
        Thread.sleep(2000);
        accountTitle.click();
    }

    public void LoginPageNegativeAction() throws IOException {
        homeLogin.click();
        selectEmailLogo.click();
        email.sendKeys(base.properties().getProperty("userNegative"));
        password.sendKeys(base.properties().getProperty("passwordPositive"));
        loginButton.click();
    }
}
