package d05_10_2023;

import d02_10_2023.LinkVerification;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class SwagLabsTestsHomeWork {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().deleteAllCookies();
        driver.get("https://www.saucedemo.com/");
    }

    @Test(priority = 1)
    public void VerifyErrorIsDisplayedWhenUsernameIsMissing() {
        driver.findElement(By.id("login-button")).click();
        wait.withMessage("Popup window doesn't exist")
                .until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".error-message-container.error"), "Epic sadface: Username is required"));
    }

    @Test(priority = 2)
    public void verifyErrorIsDisplayedWhenPasswordIsMissing() {
        driver.findElement(By.id("user-name")).sendKeys("Miki90");
        driver.findElement(By.id("login-button")).click();
        wait.withMessage("Popup window doesn't exist")
                .until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".error-message-container.error"), "Epic sadface: Password is required"));
    }

    @Test(priority = 3)
    public void verifyErrorIsDisplayedWhenCredentialsAreWrong() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("invalidpassword");
        driver.findElement(By.id("login-button")).click();
        wait.withMessage("Popup window doesn't exist")
                .until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".error-message-container.error"), "Epic sadface: Username and password do not match any user in this service"));
    }

    @Test(priority = 4)
    public void verifyErrorIsDisplayedWhenUserIsLocked() {
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        wait.withMessage("Popup window doesn't exist")
                .until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".error-message-container.error"), "Epic sadface: Sorry, this user has been locked out."));
    }

    @Test(priority = 5)
    public void verifySuccessfulLogin() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://www.saucedemo.com/inventory.html", "URL is not inventory.html");
        driver.findElement(By.cssSelector(".bm-burger-button")).click();
        wait.withMessage("Window doesn't exist")
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".bm-item-list")));
        wait.withMessage("Button doesn't exist")
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#logout_sidebar_link"))).click();
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://www.saucedemo.com/", "URL is not www.saucedemo.com");
    }

    @Test(priority = 6)
    public void addingProductsToCart() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://www.saucedemo.com/inventory.html", "URL is not inventory.html");
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        wait.withMessage("Button is not visible").
                until(ExpectedConditions.presenceOfElementLocated(By.id("remove-sauce-labs-backpack")));
        wait.withMessage("Button is not visible").
                until(ExpectedConditions.numberOfElementsToBeLessThan(By.cssSelector(".shopping_cart_link .shopping_cart_badge"), 2));
    }

    @Test(priority = 7)
    public void viewingProductDetails() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://www.saucedemo.com/inventory.html", "URL is not inventory.html");
        driver.findElement(By.id("item_4_title_link")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".inventory_details_desc_container")));
    }

    @Test(priority = 8, retryAnalyzer = SwagLabsRetry.class)
    public void removingProductsFromCart() throws InterruptedException {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://www.saucedemo.com/inventory.html", "URL is not inventory.html");

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector(".shopping_cart_link .shopping_cart_badge"))
                .getText(), "1", "Number of products is 0");

        wait.withMessage("Button is not visible").
                until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#remove-sauce-labs-backpack"))).click();
        wait.withMessage("Number of products isn't 0").
                until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".shopping_cart_link .shopping_cart_badge")));
    }

    @Test(priority = 9)
    public void productCheckout() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://www.saucedemo.com/inventory.html", "URL is not inventory.html");
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector(".shopping_cart_link .shopping_cart_badge"))
                .getText(), "1", "Number of products is 0");

        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
        driver.findElement(By.cssSelector("#checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("Pera");
        driver.findElement(By.id("last-name")).sendKeys("Peric");
        driver.findElement(By.id("postal-code")).sendKeys("18000");
        driver.findElement(By.id("continue")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector(".summary_info .summary_value_label:nth-child(2)"))
                .getText(), "SauceCard #31337", "Sauce Card info isn't valid");

        Assert.assertEquals(driver.findElement(By.cssSelector(".summary_info .summary_info_label:nth-child(3)"))
                .getText(), "Shipping Information", "No shipping information visible");

        Assert.assertEquals(driver.findElement(By.cssSelector(".summary_info .summary_subtotal_label"))
                .getText(), "Item total: $29.99", "Price isn't valid");

        Assert.assertEquals(driver.findElement(By.cssSelector(".summary_info .summary_total_label"))
                .getText(), "Total: $32.39", "Price isn't valid");

        driver.findElement(By.id("finish")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector(".complete-header"))
                .getText(), "Thank you for your order!", "Message is invalid");

        driver.findElement(By.cssSelector("#back-to-products")).click();

    }

    @Test(priority = 10, retryAnalyzer = SwagLabsRetry.class)
    public void validateSocialLinksInFooter() throws IOException {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://www.saucedemo.com/inventory.html", "URL is not inventory.html");
        WebElement scroolDown = driver.findElement(By.cssSelector(".footer"));
        Actions actions = new Actions(driver);
        actions.scrollToElement(scroolDown);
        actions.perform();

        List<WebElement> links = driver.findElements(By.cssSelector(".social>li>a"));

        for (int i = 0; i < links.size(); i++) {
            try {
                LinkVerification.
                        getHTTPResponseStatusCode(links.get(i).getAttribute("href"));
            } catch (IOException e) {
                System.out.println("Status code is not 200 for the link: " + links.get(i).getAttribute("href"));
            }
        }
    }


    @AfterClass
    public void quit() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
