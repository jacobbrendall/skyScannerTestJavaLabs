package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HotelsPage {
    Base base = new Base();

    @FindBy(xpath = "//span[@class='HeaderTab_HeaderTab__text__3d-aG'][text()='Hotels']")
    private WebElement hotelsLogo;

    @FindBy(xpath = "//input[@id='destination-autosuggest']")
    private WebElement hotelFind;

    @FindBy(xpath = "//button[@data-test-id='search-button']")
    private WebElement hotelsSearchButton;

    @FindBy(xpath = "//select[@id='hotel-cards-sorting-selector']")
    private WebElement hotelSorting;

    @FindBy(xpath = "//option[contains(text(),'Price (low to high)')]")
    private WebElement sortingLowToHigh;

    @FindBys(@FindBy(xpath = "//div[contains(@class,'HotelCard_HotelCard__price')]"))
    private List<WebElement> hotelsPrices;

    public void selectPricesFromLowToHigh() throws IOException, InterruptedException {
        hotelsLogo.click();
        hotelFind.sendKeys(base.properties().getProperty("hotelFind"));
        Thread.sleep(2000);
        hotelsSearchButton.click();
        Thread.sleep(11000);
        hotelSorting.click();
        sortingLowToHigh.click();
        Thread.sleep(8000);
    }

    public ArrayList<Integer> lowToHighHotelPrices() {
        List<WebElement> element = hotelsPrices;
        List<String> prices = new ArrayList<>();
        ArrayList<Integer> listPrcesIntegers = new ArrayList<Integer>(prices.size());
        for (WebElement pri : element) {
            prices.add(pri.getText().substring(1));
        }
        for (String price : prices) {
            listPrcesIntegers.add(Integer.parseInt(price));
        }
        return listPrcesIntegers;
    }

    public ArrayList<Integer> sortHotelPrices() {
        ArrayList<Integer> sortList = lowToHighHotelPrices();
        Collections.sort(sortList);
        return sortList;
    }
}
