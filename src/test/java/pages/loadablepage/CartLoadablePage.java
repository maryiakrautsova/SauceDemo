package pages.loadablepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.pompages.BasePage;

public class CartLoadablePage extends BaseLoadablePage {
    private By PRICE = By.xpath("//*[@id='cart_contents_container']/div/div[1]/div[3]/div[2]/div[2]/div");

    private By PRODUCT_TITLE = By.xpath("//*[@id='item_4_title_link']/div");

    public CartLoadablePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return driver.findElement(PRICE).isDisplayed();
    }

    public String getPrice() {
        return driver.findElement(PRICE).getText();
    }

    public String getProductTitle() {
        return driver.findElement(PRODUCT_TITLE).getText();
    }
}
