package pages.pompages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class LinkedInMainPage extends BasePage {

    private By LINKEDIN_BUTTON = By.partialLinkText("Linked");

    public LinkedInMainPage(WebDriver driver) {
        super(driver);
    }

    public void clickLinkedInButton() {
        driver.findElement(LINKEDIN_BUTTON).click();
    }

    public void switchToNewTab() {
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(0));
    }
}
