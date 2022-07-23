package pages.pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private By PRICE = By.xpath("//*[@id='cart_contents_container']/div/div[1]/div[3]/div[2]/div[2]/div");

    private By PRODUCT_TITLE = By.xpath("//*[@id='item_4_title_link']/div");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getPrice() {
        return driver.findElement(PRICE).getText();
    }

    public String getProductTitle() {
        return driver.findElement(PRODUCT_TITLE).getText();
    }
}
