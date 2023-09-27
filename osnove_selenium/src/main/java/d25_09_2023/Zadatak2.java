package d25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        ArrayList<String>nizToDoa = new ArrayList<>();

        nizToDoa.add("Visit Paris");
        nizToDoa.add("Visit Prague");
        nizToDoa.add("Visit London");
        nizToDoa.add("Visit New York");
        nizToDoa.add("Visit Belgrade");

        driver.get("https://example.cypress.io/todo");

        for (int i = 0; i < nizToDoa.size(); i++) {
            driver.findElement(By.cssSelector("input.new-todo")).sendKeys(nizToDoa.get(i));
            driver.findElement(By.cssSelector("input.new-todo")).sendKeys(Keys.ENTER);
        }

        Thread.sleep(1000);

        driver.findElement(By.cssSelector("label[for='toggle-all']")).click();

        Thread.sleep(5000);

        driver.quit();

    }
}
