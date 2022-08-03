package pages.fluentpage;

import constants.Creds;
import constants.Urls;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInFormFluentPage extends BaseFluentPage {
    private By USERNAME_INPUT = By.id("user-name");

    private By PASSWORD_INPUT = By.id("password");

    private By LOGIN_BUTTON = By.cssSelector("[value=Login]");

    public LogInFormFluentPage(WebDriver driver) {
        super(driver);
    }

    public LogInFormFluentPage openMainPage() {
        driver.get(Urls.MAIN_PAGE_URL);
        return this;
    }

    public LogInFormFluentPage usernameInput(String username) {
        driver.findElement(USERNAME_INPUT).sendKeys(Creds.LOGIN);
        return this;
    }

    public LogInFormFluentPage passwordInput(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(Creds.PASSWORD);
        return this;
    }

    public ProductsCatalogueFluentPage clickLogin() {
        driver.findElement(LOGIN_BUTTON).click();
        return new ProductsCatalogueFluentPage(driver);
    }
}
