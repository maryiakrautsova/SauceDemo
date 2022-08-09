package tests;

import models.LoginModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.pompages.CartPage;
import pages.pompages.LogInFormPage;
import pages.pompages.ProductsCataloguePage;
import testdata.PrepareLoginData;
import utils.RetryAnalyzer;

public class SauceTests extends BaseWithFactoryTest {
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void addItemToTheCartTest() {
        LogInFormPage logInFormPage = new LogInFormPage(driver);
        logInFormPage.openMainPage();

        LoginModel loginModel = PrepareLoginData.getStandardLogin();
        logInFormPage.usernameInput(loginModel.getUsername());
        logInFormPage.passwordInput(loginModel.getPassword());
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
