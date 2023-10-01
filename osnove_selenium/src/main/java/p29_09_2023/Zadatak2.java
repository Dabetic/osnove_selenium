package p29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Zadatak2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://www.youtube.com/");

        driver.findElement(By.id("search")).sendKeys("Breskvica");

        List<WebElement> nizBreskvica = driver.findElements(By.xpath("//*[contains (text(), 'breskvica')]"));

//        for (int i = 0; i < 3; i++) {
//
//            }
//        }




    }
}
