package test.uiTest;

import org.junit.jupiter.api.Test;
import pageObjects.Base;

public class CarRentalPage extends Base {
    @Test
    public void carRentalShouldFiltered(){
        homePage.carRentalPage();
    }
}
