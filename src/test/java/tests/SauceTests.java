package tests;

import constants.Creds;
import constants.Urls;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.pompages.CartPage;
import pages.pompages.LogInFormPage;
import pages.pompages.ProductsCataloguePage;

import java.util.concurrent.TimeUnit;

public class SauceTests extends BaseTest {
    @Test
    public void addItemToTheCartTest() {
        LogInFormPage logInFormPage = new LogInFormPage(driver);
        logInFormPage.openMainPage();
        logInFormPage.usernameInput();
        logInFormPage.passwordInput();
        logInFormPage.clickLogin();

        ProductsCataloguePage productsCataloguePage = new ProductsCataloguePage(driver);
        productsCataloguePage.addToCartItemOne();
        productsCataloguePage.goToCart();

        CartPage cartPage = new CartPage(driver);
        String itemTitle = cartPage.getProductTitle();
        String price = cartPage.getPrice();

        Assert.assertEquals(price, "$29.99");
        Assert.assertEquals(itemTitle, "Sauce Labs Backpack");

    }
}
