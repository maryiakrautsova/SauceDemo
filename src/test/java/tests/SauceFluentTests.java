package tests;

import constants.Creds;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.fluentpage.CartFluentPage;
import pages.fluentpage.LogInFormFluentPage;

public class SauceFluentTests extends BaseWithFactoryTest {
    @Test
    public void addItemToTheCartTest() {
        LogInFormFluentPage logInFormFluentPage = new LogInFormFluentPage(driver);
        logInFormFluentPage.
                openMainPage().
                usernameInput(Creds.LOGIN).
                passwordInput(Creds.PASSWORD).
                clickLogin().addToCartItemOne().goToCart();
        CartFluentPage cartFluentPage = new CartFluentPage(driver);
        String actualPrice = cartFluentPage.getPrice();
        String title = cartFluentPage.getProductTitle();
        Assert.assertEquals(actualPrice, "$29.99");
        Assert.assertEquals(title, "Sauce Labs Backpack");
    }
}
