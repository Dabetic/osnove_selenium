package p03_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;


public class KatalonLoginTests {

    private WebDriver driver;
    private WebDriverWait wait;


    @BeforeClass
    public void setup () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void visitPage () {
        driver.get("https://cms.demo.katalon.com/");
        driver.findElement(By.cssSelector("[href='https://cms.demo.katalon.com/my-account/']")).click();
    }
    @Test
    public void verifyTitleAndUrl () {
        Assert.assertEquals(driver.getTitle(), "My account – Katalon Shop" ,"Titles don't match");
        Assert.assertEquals(driver.getCurrentUrl(), "https://cms.demo.katalon.com/my-account/", "URLs don't match ");
    }
    @Test
    public void test2 () {
    }
    @AfterClass
    public void quit () {
        driver.quit();
    }


}
