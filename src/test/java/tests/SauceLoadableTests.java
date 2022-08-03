package tests;

import constants.Creds;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.loadablepage.CartLoadablePage;
import pages.loadablepage.LogInFormLoadablePage;
import pages.loadablepage.ProductsCatalogueLoadablePage;

public class SauceLoadableTests extends BaseWithFactoryTest {
    @Test
    public void addItemToTheCartTest() {
        LogInFormLoadablePage logInFormLoadablePage = new LogInFormLoadablePage(driver);
        logInFormLoadablePage.openMainPage();
        Assert.assertTrue(logInFormLoadablePage.isPageOpened(), "Page isn't opened.");

        logInFormLoadablePage.usernameInput(Creds.LOGIN);
        logInFormLoadablePage.passwordInput(Creds.PASSWORD);
        logInFormLoadablePage.clickLogin();

        ProductsCatalogueLoadablePage productsCatalogueLoadablePage = new ProductsCatalogueLoadablePage(driver);
        Assert.assertTrue(productsCatalogueLoadablePage.isPageOpened(), "Page isn't opened.");
        productsCatalogueLoadablePage.addToCartItemOne();
        productsCatalogueLoadablePage.goToCart();

        CartLoadablePage cartLoadablePage = new CartLoadablePage(driver);
        Assert.assertTrue(cartLoadablePage.isPageOpened(), "Page isn't opened.");
        String itemTitle = cartLoadablePage.getProductTitle();
        String price = cartLoadablePage.getPrice();

        Assert.assertEquals(price, "$29.99");
        Assert.assertEquals(itemTitle, "Sauce Labs Backpack");
    }
}
