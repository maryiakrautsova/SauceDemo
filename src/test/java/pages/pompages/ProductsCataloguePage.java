package pages.pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsCataloguePage extends BasePage {
    //adds an item from card #1
    private By ADD_TO_CART_BUTTON = By.cssSelector("button[name='add-to-cart-sauce-labs-backpack']");

    private By GO_TO_CART_BUTTON = By.cssSelector("a[class='shopping_cart_link']");

    public ProductsCataloguePage(WebDriver driver) {
        super(driver);
    }

    public void addToCartItemOne() {
        driver.findElement(ADD_TO_CART_BUTTON).click();
    }

    public void goToCart() {
        driver.findElement(GO_TO_CART_BUTTON).click();
    }
}
