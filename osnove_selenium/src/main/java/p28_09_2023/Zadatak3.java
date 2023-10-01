package p28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;

public class Zadatak3 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("file:///C:/Users/Korisnik/Downloads/Zadatak4.html");

        driver.findElement(By.id("showInBtn")).click();

        WebElement elementZaCekanje = driver.findElement(By.id("id-0"));

        wait.until(ExpectedConditions.elementToBeClickable(By.id("showInBtn")));


    }
}
