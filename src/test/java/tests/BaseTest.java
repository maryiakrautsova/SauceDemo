package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.PropertyManager;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        PropertyManager propertyManager = new PropertyManager();
        propertyManager.loadData();
        System.setProperty("webdriver.Safari.driver", propertyManager.get("PATH_TO_DRIVER"));
        driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
