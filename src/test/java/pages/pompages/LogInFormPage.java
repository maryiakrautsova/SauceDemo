package pages.pompages;

import constants.Creds;
import constants.Urls;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInFormPage extends BasePage {
    private By USERNAME_INPUT = By.id("user-name");

    private By PASSWORD_INPUT = By.id("password");

    private By LOGIN_BUTTON = By.cssSelector("[value=Login]");

    public LogInFormPage(WebDriver driver) {
        super(driver);
    }

    public void openMainPage() {
        driver.get(Urls.MAIN_PAGE_URL);
    }

    public void usernameInput() {
        driver.findElement(USERNAME_INPUT).sendKeys(Creds.LOGIN);
    }

    public void passwordInput() {
        driver.findElement(PASSWORD_INPUT).sendKeys(Creds.PASSWORD);
    }

    public void clickLogin() {
        driver.findElement(LOGIN_BUTTON).click();
    }
}
