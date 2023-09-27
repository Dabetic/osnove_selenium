package d26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        Scanner s = new Scanner(System.in);

        driver.manage().window().maximize();

        System.out.println("Unesite ime");
        String ime = s.next();

        System.out.println("Unesite prezime");
        String prezime = s.next();

        System.out.println("Unesite email");
        String email = s.next();

        System.out.println("Izaberite pol: muski, zenski ili ostali");
        String pol = s.next();

        System.out.println("Unesite mobilni telefon");
        String telefon = s.next();

        System.out.println("Unesite predmet");
        String predmet = s.next();

        System.out.println("Unesite hobi");
        String hobi = s.next();

        System.out.println("Unesite adresu");
        String adresa = s.next();

        driver.get("https://demoqa.com/automation-practice-form");

        driver.findElement(By.id("firstName")).sendKeys(ime);
        driver.findElement(By.id("lastName")).sendKeys(prezime);
        driver.findElement(By.id("userEmail")).sendKeys(email);

        Thread.sleep(2000);

        if(pol.equals("muski")) {
            System.out.println("ulazi");
            driver.findElement(By.id("gender-radio-1")).click();

        } else if (pol.equals("zenski")) {
            driver.findElement(By.cssSelector("input[value='Female']")).click();
        } else {
            driver.findElement(By.cssSelector("input[value='Other']")).click();
        }

        driver.findElement(By.id("userNumber")).sendKeys(telefon);
        driver.findElement(By.cssSelector("div.subjects-auto-complete__control")).sendKeys(predmet);
        driver.findElement(By.id("userNumber")).sendKeys(telefon);

        if(hobi.equals("sport")){
            driver.findElement(By.id("hobbies-checkbox-1")).click();
        }
        if(hobi.equals("citanje")) {
            driver.findElement(By.id("hobbies-checkbox-2")).click();
        }
        if(hobi.equals("muzika")){
            driver.findElement(By.id("hobbies-checkbox-3")).click();
        }

        driver.findElement(By.id("currentAddress")).sendKeys(adresa);

        Thread.sleep(3000);

        driver.findElement(By.id("submit")).click();

        driver.quit();
    }
}
