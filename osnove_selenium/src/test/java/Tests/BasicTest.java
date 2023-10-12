package Tests;

import Pages.AddToCartPage;
import Pages.LeftNavMenuPage;
import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class BasicTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl = "https://www.saucedemo.com/";
    protected LeftNavMenuPage leftNavMenuPage;

    protected AddToCartPage addToCartPage;

    protected LoginPage loginPage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        leftNavMenuPage = new LeftNavMenuPage(driver, wait);
        loginPage = new LoginPage(driver, wait);
        addToCartPage = new AddToCartPage(driver,wait);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.navigate().to(baseUrl);
    }

    @AfterMethod
    public void afterMethod() {

    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
