package pages.fluentpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class CartFluentPage extends BaseFluentPage {
    private By PRICE = By.xpath("//*[@id='cart_contents_container']/div/div[1]/div[3]/div[2]/div[2]/div");

    private By PRODUCT_TITLE = By.xpath("//*[@id='item_4_title_link']/div");

    public CartFluentPage(WebDriver driver) {
        super(driver);
    }

    public CartFluentPage getPrice() {
        driver.findElement(PRICE).getText();
        return this;
    }

    public CartFluentPage getProductTitle() {
        driver.findElement(PRODUCT_TITLE).getText();
        return this;
    }
}
