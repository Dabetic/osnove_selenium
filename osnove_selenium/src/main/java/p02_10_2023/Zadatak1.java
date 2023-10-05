package p02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));


        driver.get("https://tus.io/demo");

        WebElement srollDown = driver.findElement(By.id("P0-0"));

        Actions actions = new Actions(driver);

        actions.scrollToElement(srollDown);
        actions.perform();

        System.out.println("passed");

//        driver.findElement(By.cssSelector("[type='file']")).sendKeys("C:\\BootCamp IntelliJ Projekti\\osnove_selenium\\osnove_selenium\\test_data\\Lion.jpg");

//        System.out.println("Proslo");
//
//        wait.withMessage("Fajl se nije uplodovao").until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("._heading_gq6c0_21"),"The upload is complete!"));
//        System.out.println("Fajl je uplodovan");

        driver.quit();


    }
}
