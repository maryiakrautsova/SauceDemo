package pages.fluentpage;

import org.openqa.selenium.WebDriver;

public class BaseFluentPage {
    public WebDriver driver;

    public BaseFluentPage(WebDriver driver) {
        this.driver = driver;
    }
}
