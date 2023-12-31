package p26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.ebay.com/");

        driver.findElement(By.cssSelector("#gh-ac")).sendKeys("crafts");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#gh-btn")).click();

        driver.quit();
    }
}
