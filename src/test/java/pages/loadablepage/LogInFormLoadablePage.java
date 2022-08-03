package pages.loadablepage;

import constants.Creds;
import constants.Urls;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInFormLoadablePage extends BaseLoadablePage {
    private By USERNAME_INPUT = By.id("user-name");

    private By PASSWORD_INPUT = By.id("password");

    private By LOGIN_BUTTON = By.cssSelector("[value=Login]");

    public LogInFormLoadablePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return driver.findElement(LOGIN_BUTTON).isDisplayed();
    }

    public void openMainPage() {
        driver.get(Urls.MAIN_PAGE_URL);
    }

    public void usernameInput(String username) {
        driver.findElement(USERNAME_INPUT).sendKeys(Creds.LOGIN);
    }

    public void passwordInput(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(Creds.PASSWORD);
    }

    public void clickLogin() {
        driver.findElement(LOGIN_BUTTON).click();
    }
}
