package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.event.KeyEvent;

public class HomePage {
    @FindBy(className = "Logo_Logo___j29p")
    public WebElement logo;

    @FindBy(className = "CultureSelectorButton_CultureSelectorButton__labels__bCs5I")
    public WebElement Currency;

    @FindBy(xpath = "//h4[contains(text(),'Hotels')]")
    public WebElement hotels;

    public void ScrollDown() throws AWTException, InterruptedException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        Thread.sleep(2000);
    }
}
