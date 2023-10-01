package d29_09_2023;

//Napisati program koji:
//●	Pre nego sto krenete u automatizaciju prvo sve korake uradite rucno
//●	Implicitno cekanje za trazenje elemenata je maksimalno 10s
//●	Implicitno cekanje za ucitavanje stranice je 5s
//●	Ucitava stranicu https://docs.katalon.com/
//●	Maksimizuje prozor
//●	Od html elementa cita data-theme atribut.
//●	Proverava da li je sadrzaj u tom atributu light i ispisuje odgovarajuce poruke
//●	Klikce na dugme za zamenu tema
//●	Ponovo cita data-theme atribut html elementa i validira da u atributu stoji vrednost dark
//●	Izvrsava kombinaciju tastera CTRL + K. Koristan link  za keyboard actions…kako izvrsavati precice preko Actions objekta
//●	Ceka da se dijalog za pretragu pojavi
//●	Zatim od inputa za pretragu cita atribut type i proverava da je vrednost tog atributa search
//●	Zatvara pretrazivac



import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://docs.katalon.com/");

        driver.manage().window().maximize();

        String bojaTeme = driver.findElement(By.tagName("html")).getAttribute("data-theme");

        if(bojaTeme.equals("light")) {
            System.out.println("Theme is light");
        } if(bojaTeme.equals("dark")) {
            System.out.println("Theme is not light");
        }

        driver.findElement(By.cssSelector(".toggleButton_rCf9")).click();

        wait.
                withMessage("Theme is not dark")
                .until(ExpectedConditions.attributeToBe(By.tagName("html"),"data-theme", "dark"));

        System.out.println("Theme is dark");

        new Actions(driver)
        .keyDown(Keys.CONTROL)
        .sendKeys("k")
        .perform();

        wait.
                withMessage("Value of the attribute is not search ")
                .until(ExpectedConditions.attributeToBe(By.cssSelector("[type='search']"),"type" , "search"));
        System.out.println("Value of the attribute is search");

        driver.quit();


    }
}
