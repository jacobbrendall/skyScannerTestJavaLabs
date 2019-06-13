package pageObjects;

import org.junit.jupiter.api.*;
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

    public LoginPage loginPage;
    public FlightsPage flightsPage;
    public SignUpPage signUpPage;
    public HomePage homePage;

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
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        loginPage = new PageFactory().initElements(driver, LoginPage.class);
        flightsPage = new PageFactory().initElements(driver, FlightsPage.class);
        signUpPage = new PageFactory().initElements(driver, SignUpPage.class);
        homePage = new PageFactory().initElements(driver, HomePage.class);
    }

    @AfterEach
    public void driverQuit() throws Exception {
        driver.close();
        driver.quit();
    }
}
