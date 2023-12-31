package d28_09_2023;

//●	Napisati program koji ucitava stranicu https://github.com/orgs/embedly/repositories?q=&type=all&language=&sort=
//●	Klik na Type drawdown
//●	Klik na Public iz drowdowna
//●	Ceka da se Clear dugme u desnom uglu prikaze koristeci explicit wait
//●	Kilk na Clear filter u desnom uglu

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://github.com/orgs/embedly/repositories?q=&type=all&language=&sort=");

        driver.findElement(By.cssSelector("#type-options [aria-haspopup='menu'].btn")).click();

        driver.findElement(By.cssSelector(".SelectMenu-list>label:nth-child(2)")).click();


        wait.withMessage("Element se nije pojavio").until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".issues-reset-query.text-normal>svg"))).click();

        Thread.sleep(2000);
        driver.quit();
    }
}
