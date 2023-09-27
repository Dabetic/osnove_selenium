package p26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;
import java.util.ArrayList;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        ArrayList<WebElement>nizElemenata = new ArrayList<>();

        driver.get("https://s.bootsnipp.com/iframe/oV91g");
        driver.findElements(By.cssSelector("ul.pagination a.page_link")).addAll(nizElemenata);

        for (int i = 0; i < nizElemenata.size(); i++) {

            Thread.sleep(1000);
        }
        
        driver.quit();
    }
}
