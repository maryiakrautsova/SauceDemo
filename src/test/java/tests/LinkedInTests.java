package tests;

import models.LoginModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.pompages.LinkedInMainPage;
import pages.pompages.LogInFormPage;
import testdata.PrepareLoginData;
import utils.RetryAnalyzer;

public class LinkedInTests extends BaseWithFactoryTest {
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void transferToLinkedinMainPageTest() {
        LogInFormPage logInFormPage = new LogInFormPage(driver);
        logInFormPage.openMainPage();
        LoginModel loginModel = PrepareLoginData.getStandardLogin();
        logInFormPage.usernameInput(loginModel.getUsername());
        logInFormPage.passwordInput(loginModel.getPassword());
        logInFormPage.clickLogin();
        removeImplicitlyWait();
        LinkedInMainPage linkedInMainPage = new LinkedInMainPage(driver);
        linkedInMainPage.clickLinkedInButton();
        linkedInMainPage.switchToNewTab();
        driverManager.setExplicitWait("(//icon)[1]");
        Assert.assertTrue(linkedInMainPage.isLinkedinLogoVisible(), "Logo isn't present.");
        setImplicitlyWait();
    }
}
