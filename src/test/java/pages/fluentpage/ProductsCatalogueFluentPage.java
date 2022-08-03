package pages.fluentpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsCatalogueFluentPage extends BaseFluentPage {
    //adds an item from card #1
    private By ADD_TO_CART_BUTTON = By.cssSelector("button[name='add-to-cart-sauce-labs-backpack']");

    private By GO_TO_CART_BUTTON = By.cssSelector("a[class='shopping_cart_link']");

    public ProductsCatalogueFluentPage(WebDriver driver) {
        super(driver);
    }

    public ProductsCatalogueFluentPage addToCartItemOne() {
        driver.findElement(ADD_TO_CART_BUTTON).click();
        return new ProductsCatalogueFluentPage(driver);
    }

    public CartFluentPage goToCart() {
        driver.findElement(GO_TO_CART_BUTTON).click();
        return new CartFluentPage(driver);
    }
}
