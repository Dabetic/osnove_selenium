package p26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://s.bootsnipp.com/iframe/z80en");

        List<WebElement>nizRedova = driver.findElements(By.cssSelector("table.table-bordered tbody>tr"));

        for (int i = 0; i < nizRedova.size(); i++) {
            String s = nizRedova.get(i).getText();
            System.out.println(" " + s);
        }

        Thread.sleep(5000);
        driver.quit();
    }
}
