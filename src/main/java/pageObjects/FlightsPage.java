package pageObjects;

import com.google.common.collect.Lists;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.List;

public class FlightsPage {
    public Base base = new Base();

    @FindBy(id = "fsc-trip-type-selector-one-way")
    private WebElement oneWayButton;

    @FindBy(xpath = "//input[@id='fsc-origin-search']")
    private WebElement from;

    @FindBy(id = "fsc-destination-search")
    private WebElement destination;

    @FindBy(xpath = "//button[@id='depart-fsc-datepicker-button']/span[1]")
    private WebElement departDate;

    @FindBy(xpath = "//button[@id='return-fsc-datepicker-button']/span[1]")
    private WebElement returnDate;

    @FindBy(id = "CabinClassTravellersSelector_fsc-class-travellers-trigger__18yAY")
    private WebElement travelers;

    @FindBy(xpath = "//div[2]//div[1]//button[2]")
    private WebElement child;

    @FindBy(xpath = "//div[2]//div[1]//button[2]")
    private WebElement adult;

    @FindBy(xpath = "//button[@class='BpkLink_bpk-link__2e_PE']")
    private WebElement travelersDone;

    @FindBy(xpath = "//button[contains(@type,'submit')]")
    private WebElement flightSearchButton;

    @FindBy(xpath = "//p[@class='places-R9WxN']")
    private WebElement destinationValidate;

    @FindBy(xpath = "//select[@id='search-controls-cabin-class-dropdown']")
    private WebElement cabinClassWindow;

    @FindBys(@FindBy(xpath = "//select[@id='search-controls-cabin-class-dropdown']"))
    private List<WebElement> allCabinClasses;

    public String getReturnDateText() {
        return returnDate.getText();
    }

    public String getTravelersAndCabinButton() {
        return travelers.getText();
    }

    public String getFlightsSearchPageDestinationText() {
        return destinationValidate.getText();
    }

    public void flightsSearch() throws InterruptedException, IOException {
        from.click();
        from.sendKeys(base.properties().getProperty("from"));
        destination.click();
        destination.sendKeys(base.properties().getProperty("to"));
        Thread.sleep(3000);
        flightSearchButton.click();
        Thread.sleep(9000);
    }

    public void fligtsOneWay() throws IOException {
        from.click();
        from.sendKeys(base.properties().getProperty("from"));
        destination.click();
        destination.sendKeys(base.properties().getProperty("to"));
        oneWayButton.click();
    }

    public void flightTravelersSelect() throws IOException {
        from.click();
        from.sendKeys(base.properties().getProperty("from"));
        destination.click();
        destination.sendKeys(base.properties().getProperty("to"));
        travelers.click();
        child.click();
        child.click();
        travelersDone.click();
    }

    public void cabinClass() throws IOException {
        from.click();
        from.sendKeys(base.properties().getProperty("from"));
        destination.click();
        destination.sendKeys(base.properties().getProperty("to"));
        travelers.click();
        Select select = new Select(cabinClassWindow);
        select.selectByValue("Business");
    }

    public void allCabinClass() throws IOException {
        from.click();
        from.sendKeys(base.properties().getProperty("from"));
        destination.click();
        destination.sendKeys(base.properties().getProperty("to"));
        travelers.click();
    }

    public boolean allCabinClassIsDisplayed() {
        List<String> allCabinClasses = Lists.newArrayList("Economy", "Premium economy", "Business class", "First-class");
        Select select = new Select(cabinClassWindow);
        List<WebElement> cabinDropDownValues = select.getOptions();
        for (int i = 0; i < cabinDropDownValues.size(); i++) {
            if (cabinDropDownValues.get(i).getText().equals(allCabinClasses.get(i))) {
                System.out.println(allCabinClasses.get(i));
            } else {
                return false;
            }
        }
        return true;
    }
}

