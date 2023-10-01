package d29_09_2023;

//Napisati program koji:
//-	Ucitava stranicu https://tus.io/demo.html
//-	Hvata sve linkove sa stranice
//-	Skrola do svakog h3 elementa
//-	Od svakog h3 elementa cita text

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Zadatak7 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://tus.io/demo");

        List<WebElement> nizH3 = driver.findElements(By.xpath("//h3"));

        for (int i = 0; i <nizH3.size() ; i++) {
            Actions actions = new Actions(driver);
            actions.scrollToElement(nizH3.get(i)).perform();
            System.out.println(nizH3.get(i).getText());
        }
    }
}
