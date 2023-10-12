package Tests.SwagLabCartProjectTests;

import SwagLabCartProject.Pages.AddToCartPage;
import SwagLabCartProject.Pages.ItemListPage;
import SwagLabCartProject.Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BasicTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl = "https://www.saucedemo.com/";

    protected LoginPage loginPage;
    protected AddToCartPage addToCartPage;
    protected ItemListPage itemListPage;



    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver,wait);
        addToCartPage = new AddToCartPage(driver,wait);
        itemListPage = new ItemListPage(driver, wait);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().deleteAllCookies();
        String username = "standard_user";
        String password = "secret_sauce";
        driver.navigate().to(baseUrl);
        loginPage.addAndClearCredentials(username,password);
        loginPage.clickOnTheLoginBtn();
    }

    @AfterMethod
    public void afterMethod() {

    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}


