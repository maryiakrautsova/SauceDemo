package tests;

import constants.Creds;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.fluentpage.CartFluentPage;
import pages.fluentpage.LogInFormFluentPage;
import utils.RetryAnalyzer;

public class SauceFluentTests extends BaseWithThreadLocalTest {
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void addItemToTheCartTest() {
        LogInFormFluentPage logInFormFluentPage = new LogInFormFluentPage(getDriver());
        logInFormFluentPage.
                openMainPage().
                usernameInput(Creds.LOGIN).
                passwordInput(Creds.PASSWORD).
                clickLogin().addToCartItemOne().goToCart();
        CartFluentPage cartFluentPage = new CartFluentPage(getDriver());
        String actualPrice = cartFluentPage.getPrice();
        String title = cartFluentPage.getProductTitle();
        Assert.assertEquals(actualPrice, "$29.99");
        Assert.assertEquals(title, "Sauce Labs Backpack");
    }
}
