package d25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.artplayer.org/");

        Thread.sleep(3000);

        driver.findElement(By.cssSelector("i[aria-label='Play']")).click();

        driver.findElement(By.cssSelector("div.art-control.art-control-volume")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("i.art-icon.art-icon-pip")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("i.art-icon.art-icon-pip")).click();

        Thread.sleep(2000);

        driver.manage().window().minimize();

        Thread.sleep(1000);

        driver.findElement(By.cssSelector("i.art-icon.art-icon-fullscreenOn")).click();

        Thread.sleep(2000);

        driver.findElement(By.cssSelector("i.art-icon.art-icon-fullscreenOff")).click();

        Thread.sleep(5000);

        driver.quit();

    }
}
