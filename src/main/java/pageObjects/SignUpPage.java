package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class SignUpPage extends Base {

    @FindBy(className = "login")
    private WebElement homeLogin;

    @FindBy(css = "div[class*='emailLogo']")
    private WebElement selectEmailLogo;

    @FindBy(xpath = "//span[@class='bpk-text-2vXC5 bpk-text--sm-rXRL9 bpk-text--bold-3Zyx2']")
    private WebElement signUp;

    @FindBy(id = "email")
    private WebElement signUpEmail;

    @FindBy(css = "button[class*='ProgressionButton__button']")
    private WebElement signUpContinue;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement signUpPassword;

    @FindBy(xpath = "//span[@class='PasswordPolicy__passwordMessage-2Kwo9']")
    private WebElement signUpSuccessfulPasswordEntry;

    @FindBy(xpath = "//span[@class='PasswordPolicy__passwordMessage--someVerified-1p441']")
    public WebElement signUpFailedPasswordEntry;

    @FindBy(xpath = "//button[@class='bpk-button-aTnwj ProgressionButton__button-3U-H6']")
    private WebElement createAccountButton;

    public String signUpSuccessfulPasswordEntry() {
        return signUpSuccessfulPasswordEntry.getText();
    }

    public boolean createAccountFailed() {
        return createAccountButton.isDisplayed();
    }

    public void successfulSignUp() throws IOException {
        homeLogin.click();
        selectEmailLogo.click();
        signUp.click();
        signUpEmail.sendKeys(properties().getProperty("userPositive"));
        signUpContinue.click();
        signUpPassword.sendKeys("Abcd1234");

    }

    public void failedSignUp() throws IOException {
        homeLogin.click();
        selectEmailLogo.click();
        signUp.click();
        signUpEmail.sendKeys(properties().getProperty("userPositive"));
        signUpContinue.click();
        signUpPassword.sendKeys("Abcd123");
    }
}