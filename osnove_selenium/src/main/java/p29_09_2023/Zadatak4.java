package p29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");
        driver.findElement(By.id("basic-primary-trigger")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.toast-header.toast-primary")));
        System.out.println("Element se pojavio");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.toast-header.toast-primary")));
        System.out.println("Element se izgubio");
        Thread.sleep(2000);
        driver.findElement(By.id("basic-primary-trigger")).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.toast-header.toast-primary .btn-close")));
        driver.findElement(By.cssSelector("div.toast-header.toast-primary .btn-close")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.toast-header.toast-primary .btn-close")));
        System.out.println("Element se izgubio");

        Thread.sleep(2000);
        driver.quit();




    }
}
