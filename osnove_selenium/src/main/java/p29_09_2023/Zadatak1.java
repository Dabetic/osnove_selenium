package p29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        long start = System.currentTimeMillis();
        driver.get("https://s.bootsnipp.com/iframe/klDWV");


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.withMessage("Stranica se nije ucitala").until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class = 'container']//*[contains (text(), '100%')]")));
        long finish = System.currentTimeMillis();

        long totalTime = finish - start;

        System.out.println("Total Time for page load - " + totalTime + " millis");


        System.out.println("KRAJ");

        driver.quit();



    }
}
