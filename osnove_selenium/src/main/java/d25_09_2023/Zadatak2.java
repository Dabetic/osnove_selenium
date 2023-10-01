package d25_09_2023;

//●	Niz todo-a (niz stringova) koje treba da uneti. Niz je:
//○	Visit Paris
//○	Visit Prague
//○	Visit London
//○	Visit New York
//○	Visit Belgrade
//●	Maksimizirati prozor
//●	Ucitati stranicu https://example.cypress.io/todo
//●	Program petljom prolazi kroz niz todo-a i svaki unosi na stranicu
//○	Nakon svakog unosa todo-a, unosi se enter. Koristan link
//●	Nakon svih unosa proci petljom kroz svaki todo koji je na stranici i za svaki cekirati da je completed.
//●	Cekanje od 5s
//●	Zatvorite pretrazivac

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

        List<WebElement>nizVerifikovanih = driver.findElements(By.cssSelector("input.toggle"));

        for (int i = nizVerifikovanih.size()-1; i >= nizVerifikovanih.size()-nizToDoa.size() ; i--) {
            nizVerifikovanih.get(i).click();

        }

        Thread.sleep(5000);

        driver.quit();

    }
}
