package d02_10_2023;

//Napisati program koji:
//●	Ucitava stranu https://itbootcamp.rs/
//●	Misem prelazi preko Vesti iz navigacionog menija
//●	Ceka da se prikaze padajuci meni za Vesti
//●	Misem prelazi preko Kursevi iz navigacionog menija
//●	Ceka da se prikaze padajuci meni za Kursevi
//●	Misem prelazi preko Prijava i pravilnik iz navigacionog menija
//●	Ceka da se prikaze padajuci meni za Prijava i pravilnik

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        driver.get("https://itbootcamp.rs/");

        WebElement vesti = driver.findElement(By.id("menu-item-6408"));
        Actions actions = new Actions(driver);
        actions.moveToElement(vesti);
        actions.perform();

        wait.withMessage("Element isn't visible").until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#menu-item-9740")));

        WebElement kursevi = driver.findElement(By.id("menu-item-5362"));

        actions.moveToElement(kursevi);
        actions.perform();

        wait.withMessage("Element isn't visible").until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#menu-item-5713")));

        WebElement prijava = driver.findElement(By.id("menu-item-5453"));

        actions.moveToElement(prijava);
        actions.perform();

        wait.withMessage("Element isn't visible").until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#menu-item-9232")));

        Thread.sleep(2000);

        driver.quit();

    }
}
