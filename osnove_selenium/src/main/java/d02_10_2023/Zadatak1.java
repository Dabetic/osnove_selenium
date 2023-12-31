package d02_10_2023;

//Napisati program koji:
//●	Podesava:
//○	implicitno cekanje za trazenje elemenata od 10s
//○	implicitno cekanje za ucitavanje stranice od 10s
//○	eksplicitno cekanje podeseno na 10s
//●	Podaci:
//○	Potrebno je u projektu ukljuciti 4 slike:
//■	front.jpg
//■	left.jpg
//■	right.jpg
//■	back.jpg
//●	Koraci:
//○	Ucitava stranicu https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you
//○	Maksimizuje prozor
//○	Klik na edit ikonicu
//○	Klik na delete iz iskacuceg dijaloga
//○	Klik na Add Image dugme
//○	Sacekajte da se pojavi desni meni
//○	Uploadujte front.jpg sliku
//○	Sacekajte da je ispod uploada slike, broj slika 1.
//○	Klik na sliku
//○	Klik na Done dugme
//○	Sacekajte 2s
//○	Klik na Add Image dugme
//○	Sacekajte da se pojavi desni meni
//○	Uploadujte right.jpg sliku
//○	Sacekajte da je ispod uploada slike, broj slika 2.
//○	Klik na sliku
//○	Klik na Done dugme
//○	Sacekajte 2s
//○	Klik na Add Image dugme
//○	Sacekajte da se pojavi desni meni
//○	Uploadujte back.jpg sliku
//○	Sacekajte da je ispod uploada slike, broj slika 3.
//○	Klik na sliku
//○	Klik na Done dugme
//○	Sacekajte 2s
//○	Klik na Add Image dugme
//○	Sacekajte da se pojavi desni meni
//○	Uploadujte back.jpg sliku
//○	Sacekajte da je ispod uploada slike, broj slika 3.
//○	Klik na sliku
//○	Klik na Done dugme
//○	Sacekajte 2s
//○	Sacekajte da Next dugme bude klikljivo
//○	Klik na Next dugme
//○	Unesite tekst
//○	Klik na Next
//○	Klik na Preview
//○	Klik na Add to cart
//○	Sacekajte 5s
//○	Quit

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you");

        driver.findElement(By.cssSelector(".edit-image")).click();

        driver.findElement(By.cssSelector("#image-option-remove")).click();


        for (int i = 0; i < 4; i++) {

            driver.findElement(By.cssSelector(".edit-image")).click();


            wait.withMessage("Upload box is not visible").
                    until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".sc-hAYhfR")));

            driver.findElement(By.cssSelector("#imageUpload")).sendKeys("C:\\BootCamp IntelliJ Projekti\\osnove_selenium\\osnove_selenium\\picturesToUpload\\image" + (i+1) + ".jpg");

            wait.withMessage("Picture is not visible").
                    until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".sc-gLDzan:nth-child(" + (i+1) + ")")));

            wait.withMessage("Picture is not visible").
                    until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#image-option-0"))).click();


            wait.withMessage("Picture is not visible").
                    until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[type='submit']"))).click();

            Thread.sleep(2000);

        }

        wait.withMessage("Next button is not clickable").until(ExpectedConditions.elementToBeClickable(By.id("next-button"))).click();

        driver.findElement(By.id("textareaID")).sendKeys("Mnogo lepe slike");

        wait.withMessage("Next button is not clickable").until(ExpectedConditions.elementToBeClickable(By.id("next-button"))).click();

        Thread.sleep(5000);

        driver.quit();
    }
}
