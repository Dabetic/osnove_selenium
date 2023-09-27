package d25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php");

        for (int i = 0; i <5; i++) {
            driver.findElement(By.cssSelector("button[type='button']")).click();
            driver.findElement(By.cssSelector("input[name=\"name\"]")).sendKeys("Milos");
            driver.findElement(By.id("department")).sendKeys("Dep");
            driver.findElement(By.id("phone")).sendKeys("063");
            driver.findElement(By.cssSelector("table.table a.add[style=\"display: inline;\"]")).click();
            Thread.sleep(500);
        }
        driver.quit();
    }
}
