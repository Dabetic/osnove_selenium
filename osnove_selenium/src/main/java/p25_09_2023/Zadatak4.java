package p25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com/webtables");
        Thread.sleep(2000);

        driver.findElement(By.cssSelector(".mr-2>svg")).click();
        driver.findElement(By.cssSelector("#firstName")).clear();
        driver.findElement(By.cssSelector("#firstName")).sendKeys("Milos");
        driver.findElement(By.cssSelector("#lastName")).clear();
        driver.findElement(By.cssSelector("#lastName")).sendKeys("Dab");
        driver.findElement(By.cssSelector("#userEmail")).clear();
        driver.findElement(By.cssSelector("#userEmail")).sendKeys("m@gmail.com");
        driver.findElement(By.cssSelector("#age")).clear();
        driver.findElement(By.cssSelector("#age")).sendKeys("33");
        driver.findElement(By.cssSelector("#salary")).clear();
        driver.findElement(By.cssSelector("#salary")).sendKeys("300");
        driver.findElement(By.cssSelector("#department")).clear();
        driver.findElement(By.cssSelector("#department")).sendKeys("Nis");

        Thread.sleep(3000);

        driver.findElement(By.cssSelector("#submit")).click();

        Thread.sleep(3000);

        driver.quit();

    }
}
