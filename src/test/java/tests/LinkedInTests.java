package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.pompages.LinkedInMainPage;
import pages.pompages.LogInFormPage;

public class LinkedInTests extends BaseTest {
    @Test
    public void transferToLinkedinMainPageTest() {
        LogInFormPage logInFormPage = new LogInFormPage(driver);
        logInFormPage.openMainPage();
        logInFormPage.usernameInput();
        logInFormPage.passwordInput();
        logInFormPage.clickLogin();
        removeImplicitlyWait();
        LinkedInMainPage linkedInMainPage = new LinkedInMainPage(driver);
        linkedInMainPage.clickLinkedInButton();
        linkedInMainPage.switchToNewTab();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("icon > svg")));
        setImplicitlyWait();
    }
}
