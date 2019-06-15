package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class HomePage {
    public WebDriver driver;
    Properties properties = new Properties();
    @FindBy(className = "Logo_Logo___j29p")
    public WebElement logo;

    @FindBy(className = "CultureSelectorButton_CultureSelectorButton__labels__bCs5I")
    private WebElement Currency;

    @FindBy(xpath = "//h4[contains(text(),'Hotels')]")
    public WebElement hotelsTitle;

    @FindBy(xpath = "//span[contains(text(),'Hotels in')]")
    public WebElement pageDownHotels;

    @FindBys({@FindBy(xpath = "//a[contains(@href,'hotels/')]")})
    private List<WebElement> pageDownHotelLinks;

    @FindBy(xpath = "//span[text()='Car Rental']")
    public WebElement carRental;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void ScrollDown() throws InterruptedException {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", hotelsTitle);
        Thread.sleep(2000);

//        js.executeScript("window.scrollBy(0,1300)", "");
        /*Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);*/
    }

    public HashMap<String, String> getDownPageHotelLinks() throws IOException {
        HashMap<String,String> list = new HashMap<String,String>();
        List<WebElement> allLinks = pageDownHotelLinks;
        for (WebElement link : allLinks) {
//            System.out.println(link.getText() + " - " + link.getAttribute("href"));
            list.put(link.getText(),link.getAttribute("href"));
        }
        for (Map.Entry<String,String> entry : list.entrySet()) {
            properties.put(entry.getKey(), entry.getValue());
        }
        properties.store(new FileOutputStream("C:\\Users\\mfaydin\\Desktop\\CityLinks.txt"),null);
        return list;
    }

    public void carRentalPage() {
        carRental.click();
    }
}
