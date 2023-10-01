package d28_09_2023;

//●	Ucitati stranicu http://seleniumdemo.com/?product=bdd-cucumber
//●	Klik na korpu iz gornjeg desnog ugla
//●	Sacekati da naslov stranice bude Cart – Selenium Demo Page
//●	Proveriti da li element koji prikazuje stanje korpe ima tekst Your cart is currently empty.

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak5 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("http://seleniumdemo.com/?s=BDD+Cucumber");

        driver.findElement(By.cssSelector("[data-toggle='czr-dropdown']")).click();
        driver.findElement(By.cssSelector("[data-toggle='czr-dropdown']")).click();

        wait.until(ExpectedConditions.textToBe(By.className("cart-empty"),"Your cart is currently empty."));

    }
}
