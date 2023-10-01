package p28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Zadatak1 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(12));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demoqa.com/modal-dialogs");

//        driver.findElement(By.id("showLargeModal")).click();
//
//        try {
//            driver.findElement(By.cssSelector("div.modal-body>p"));
//            System.out.println("Element je nadjen");
//        } catch (Exception e) {
//            System.out.println("Element nije nadjen");
//        }

        driver.findElement(By.cssSelector("smallModal")).click();

        List<WebElement>nizModals = driver.findElements(By.id("div.modal-header"));

        boolean daLiPostoji = false;

        if(!nizModals.isEmpty()) {
            for (int i = 0; i < nizModals.size(); i++) {
                daLiPostoji = true;
            }
        } else {
            daLiPostoji = false;
        }

        if(daLiPostoji) {
            System.out.println("Element je nadjen");
        } else {
            System.out.println("Element nije najden");
        }
    }
}
