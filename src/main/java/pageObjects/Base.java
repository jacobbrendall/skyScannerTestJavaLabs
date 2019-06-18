package pageObjects;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public WebDriver driver;

    public FlightsPage flightsPage;
    public HomePage homePage;
    public HotelsPage hotelsPage;
    public LoginPage loginPage;
    public SignUpPage signUpPage;

    public Properties properties() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("resources/data.properties");
        prop.load(fis);
        return prop;
    }

    @BeforeEach
    public void systemSetup() throws IOException {
        //TODO add chromeOptions-options.addArguments
        switch (properties().getProperty("browser")) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
                this.driver = new ChromeDriver();
                driver.get(properties().getProperty("url"));
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
                this.driver = new FirefoxDriver();
                driver.get(properties().getProperty("url"));
                break;
        }
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        flightsPage = new PageFactory().initElements(driver, FlightsPage.class);
        homePage = new PageFactory().initElements(driver, HomePage.class);
        hotelsPage = new PageFactory().initElements(driver, HotelsPage.class);
        loginPage = new PageFactory().initElements(driver, LoginPage.class);
        signUpPage = new PageFactory().initElements(driver, SignUpPage.class);
    }

   /* @AfterEach
    public void driverQuit() throws Exception {
        driver.close();
        driver.quit();
    }*/
}
