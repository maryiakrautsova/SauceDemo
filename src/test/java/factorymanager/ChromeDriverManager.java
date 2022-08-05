package factorymanager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.PropertyManager;

public class ChromeDriverManager extends DriverManager {
    @Override
    public void createDriver() {
        String path = "PATH_TO_CHROME_DRIVER";
        PropertyManager propertyManager = new PropertyManager();
        propertyManager.loadData();
        System.setProperty("webdriver.chrome.driver", propertyManager.get(path));
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }
}
