package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class HomePage {
    public WebDriver driver;
    public Base base = new Base();

    @FindBy(className = "Logo_Logo___j29p")
    public WebElement logo;

    @FindBy(xpath = "//img[@alt='DE']")
    public WebElement selectedFlag;

    @FindBy(xpath = "//span[@id='authentication-link']")
    public WebElement login;

    @FindBy(xpath = "(//button[contains(@class,'gHH4q')])[1]")
    private WebElement flagCurrency;

    @FindBy(xpath = "//select[@name='locale']")
    private WebElement language;

    @FindBy(xpath = "//select[@id='culture-selector-market']")
    private WebElement country;

    @FindBy(xpath = "//button[@id='culture-selector-save']")
    private WebElement regionalSettingsSave;

    @FindBy(xpath = "//h4[contains(text(),'Hotels')]")
    public WebElement pageDownHotelsTitle;

    @FindBy(xpath = "//span[contains(text(),'Hotels in')]")
    public WebElement pageDownHotels;

    @FindBys({@FindBy(xpath = "//a[contains(@href,'hotels/')]")})
    private List<WebElement> pageDownHotelLinks;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollDown(WebElement webElement) {
        JavascriptExecutor js = ((JavascriptExecutor) this.driver);
        js.executeScript("arguments[0].scrollIntoView(true);", webElement);

//        js.executeScript("window.scrollBy(0,1300)", "");
        /*Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);*/
    }

    public HashMap<String, String> getDownPageHotelLinks() throws IOException {
        Properties properties = new Properties();
        HashMap<String, String> list = new HashMap<String, String>();
        List<WebElement> allLinks = pageDownHotelLinks;
        for (WebElement link : allLinks) {
//            System.out.println(link.getText() + " - " + link.getAttribute("href"));
            list.put(link.getText(), link.getAttribute("href"));
        }
        for (Map.Entry<String, String> entry : list.entrySet()) {
            properties.put(entry.getKey(), entry.getValue());
        }
        properties.store(new FileOutputStream("C:\\Users\\mfaydin\\Desktop\\CityLinks.txt"), null);
        return list;
    }

    public Select select(WebElement webElement) {
        Select select = new Select(webElement);
        return select;
    }

    public void selectLanguageAndCountry() throws InterruptedException, IOException {
        flagCurrency.click();
        language.click();
        select(language).selectByValue(base.properties().getProperty("languages"));
        country.click();
        select(country).selectByValue(base.properties().getProperty("countries"));
        regionalSettingsSave.click();
        Thread.sleep(4000);
    }
}
