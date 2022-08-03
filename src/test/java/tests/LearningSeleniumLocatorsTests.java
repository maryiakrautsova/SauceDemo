package tests;

import constants.Creds;
import constants.Urls;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.PropertyManager;

public class LearningSeleniumLocatorsTests {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        PropertyManager propertyManager = new PropertyManager();
        propertyManager.loadData();
        System.setProperty("webdriver.Safari.driver", propertyManager.get("PATH_TO_CHROME_DRIVER"));
        driver = new SafariDriver();

        driver.get(Urls.MAIN_PAGE_URL);
    }

    // using abstract By class
    @Test
    public void findElementsTest() {
        WebElement logo = driver.findElement(By.className("login_logo"));
    }

    @Test
    public void findAcceptedUsernamesTest() {
        WebElement acceptedUserNames = driver.findElement(By.tagName("h4"));
    }

    @Test
    public void findTwitterLinkTest() {
        driver.findElement(By.name("user-name")).sendKeys(Creds.LOGIN);
        driver.findElement(By.name("password")).sendKeys(Creds.PASSWORD);
        driver.findElement(By.cssSelector("[value=Login]")).click();
        WebElement twitterLink = driver.findElement(By.linkText("Twitter"));
    }

    @Test
    public void findLinkedInLinkTest() {
        driver.findElement(By.id("user-name")).sendKeys(Creds.LOGIN);
        driver.findElement(By.id("password")).sendKeys(Creds.PASSWORD);
        driver.findElement(By.cssSelector("[value=Login]")).click();
        WebElement linkedInLink = driver.findElement(By.partialLinkText("Linked"));
    }

    // via By.xpath
    @Test
    public void findUserNameFieldTest() {
        //search using Attr
        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
    }

    @Test
    public void findProblemUserTest() {
        //search using text
        WebElement problemUser = driver.findElement(By.xpath("//div[text()='problem_user']"));
    }

    @Test
    public void findLoginCredentialsWrapTest() {
        //search using partial Attr name match
        WebElement loginCredentialsWrap = driver.findElement(By.xpath("//div[contains(@class,'wrap')]"));
    }

    @Test
    public void findUserNamesTest() {
        //search using partial text match
        WebElement userNamesField = driver.findElement(By.xpath("//h4[contains(text(),'Accepted')]"));
    }

    @Test
    public void findUserNameTest() {
        //search via ancestor
        WebElement userNameFld = driver.findElement(By.xpath("//input[@id='user-name']/ancestor::div"));
    }

    @Test
    public void findLoginWrapperAreaTest() {
        //search via parent
        WebElement loginWrapperArea =
                driver.findElement(By.xpath("//div[@class='login_wrapper-inner']/parent::div"));
    }

    @Test
    public void findLoginContainerTest() {
        //search using element with condition AND
        WebElement loginContainer =
                driver.findElement(By.xpath("//div[@id='login_button_container' and @class='form_column']"));
    }

    // via By.cssSelector

    @Test
    public void findCopyRightTest() {
        //search using .class
        driver.findElement(By.id("user-name")).sendKeys(Creds.LOGIN);
        driver.findElement(By.id("password")).sendKeys(Creds.PASSWORD);
        driver.findElement(By.cssSelector("[value=Login]")).click();
        WebElement copyRight = driver.findElement(By.cssSelector("div[class='footer_copy']"));
    }

    @Test
    public void findContentsWrapperTest() {
        //search using #id
        driver.findElement(By.id("user-name")).sendKeys(Creds.LOGIN);
        driver.findElement(By.id("password")).sendKeys(Creds.PASSWORD);
        driver.findElement(By.cssSelector("[value=Login]")).click();
        WebElement contentsWrapper = driver.findElement(By.cssSelector("div[id='contents_wrapper']"));
    }

    @Test
    public void findSwagLabsTitleTest() {
        //search using tag name
        WebElement swagLabsTitle = driver.findElement(By.cssSelector("title"));
    }

    @Test
    public void findAppleTouchIconTest() {
        //using [attribute^=value]
        WebElement appleTouchIcon = driver.findElement(By.cssSelector("link[href^='/icon/']"));
    }

    @Test
    public void findFormColumnTest() {
        //using [attribute$=value]
        WebElement fomColumn = driver.findElement(By.cssSelector("div[class$='column']"));
    }

    @Test
    public void findLoginPasswordsTest() {
        //using [attribute*=value]
        WebElement loginPassword = driver.findElement(By.cssSelector("[class*=login_password]"));
    }

    @Test
    public void findUsernamePasswordFormsTest() {
        //using element:first-child
        WebElement usernamePasswordForms = driver.findElement(By.cssSelector("form:first-child"));
    }

    @Test
    public void findIconTest() {
        //using element:nth-child(0)
        WebElement icon = driver.findElement(By.cssSelector("link:nth-child(2)"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
