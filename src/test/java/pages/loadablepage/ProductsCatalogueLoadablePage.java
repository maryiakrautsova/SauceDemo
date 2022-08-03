package pages.loadablepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.pompages.BasePage;

public class ProductsCatalogueLoadablePage extends BaseLoadablePage {
    //adds an item from card #1
    private By ADD_TO_CART_BUTTON = By.cssSelector("button[name='add-to-cart-sauce-labs-backpack']");

    private By GO_TO_CART_BUTTON = By.cssSelector("a[class='shopping_cart_link']");

    public ProductsCatalogueLoadablePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return driver.findElement(GO_TO_CART_BUTTON).isDisplayed();
    }

    public void addToCartItemOne() {
        driver.findElement(ADD_TO_CART_BUTTON).click();
    }

    public void goToCart() {
        driver.findElement(GO_TO_CART_BUTTON).click();
    }
}
