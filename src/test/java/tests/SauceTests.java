package tests;

import constants.Creds;
import constants.Urls;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SauceTests extends BaseTest {
    @Test
    public void addItemToTheCartTest() {
        driver.get(Urls.MAIN_PAGE_URL);

        //input username
        driver.findElement(By.id("user-name")).sendKeys(Creds.LOGIN);

        //input password
        driver.findElement(By.id("password")).sendKeys(Creds.PASSWORD);

        //click login
        driver.findElement(By.cssSelector("[value=Login]")).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //add an item to the cart
        driver.findElement(By.cssSelector("button[name='add-to-cart-sauce-labs-backpack']")).click();

        //navigate to the cart
        driver.findElement(By.cssSelector("a[class='shopping_cart_link']")).click();

        //check price and item title
        String price =
                driver.findElement(By.xpath("//*[@id='cart_contents_container']/div/div[1]/div[3]/div[2]/div[2]/div")).getText();
        Assert.assertEquals(price, "$29.99");

        String itemTitle = driver.findElement(By.xpath("//*[@id='item_4_title_link']/div")).getText();
        Assert.assertEquals(itemTitle, "Sauce Labs Backpack");
    }
}
