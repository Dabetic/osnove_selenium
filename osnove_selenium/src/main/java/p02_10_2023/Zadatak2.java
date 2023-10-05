package p02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));


        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        driver.findElement(By.cssSelector("[name='files[]']")).sendKeys("C:\\BootCamp IntelliJ Projekti\\osnove_selenium\\osnove_selenium\\test_data\\Lion.jpg");

        wait.withMessage("Fajl se nije uplodovao").
                until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("i.glyphicon.glyphicon-upload"))).click();

        wait.withMessage("Broj fajlova nije jedan").
                until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".template-upload"),1));

        wait.withMessage("Broj fajlova nije nula").
                until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-type='DELETE']"))).click();

        wait.withMessage("Fajl se nije obrisao").
                until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".template-upload"),0));


        driver.quit();

    }
}
