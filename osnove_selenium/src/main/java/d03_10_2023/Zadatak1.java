package d03_10_2023;

//Kreirati BootstrapTableTests klasu koja ima:
//Base url: https://s.bootsnipp.com/iframe/K5yrx
//Test #1: Edit Row
//Podaci:
//●	First Name: ime polaznika
//●	Last Name: prezime polaznika
//●	Middle Name: srednje ime polanzika
//Koraci:
//●	Ucitati stranu /iframe/K5yrx
//●	Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//●	Klik na Edit dugme prvog reda
//●	Sacekati da dijalog za Editovanje bude vidljiv
//●	Popuniti formu podacima.
//○	Bice potrebno da pre unosa tekst pobrisete tekst koji vec postoji, za to se koristi metoda clear. Koristan link
//●	Klik na Update dugme
//●	Sacekati da dijalog za Editovanje postane nevidljiv
//●	Verifikovati da se u First Name celiji prvog reda tabele javlja uneto ime
//●	Verifikovati da se u Last Name celiji prvog reda tabele javlja uneto prezime
//●	Verifikovati da se u Middle Name celiji prvog reda tabele javlja uneto srednje ime
//●	Za sve validacije ispisati odgovarajuce poruke u slucaju greske
//
//Test #2: Delete Row
//Podaci:
//●	First Name: ime polaznika
//●	Last Name: prezime polaznika
//●	Middle Name: srednje ime polanzika
//Koraci:
//●	Ucitati stranu /iframe/K5yrx
//●	Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//●	Klik na Delete dugme prvog reda
//●	Sacekati da dijalog za brisanje bude vidljiv
//●	Klik na Delete dugme iz dijaloga
//●	Sacekati da dijalog za Editovanje postane nevidljiv
//●	Verifikovati da je broj redova u tabeli za jedan manji
//●	Za sve validacije ispisati odgovarajuce poruke u slucaju greske
//
//Test #3: Take a Screenshot
//Koraci:
//●	Ucitati stranu  /iframe/K5yrx
//●	Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//●	Kreirati screenshot stranice.
//●	Fajl cuvajte na putanji gde su vam bile slike od proslog domaceg. Na putanji: screenshots/slike.png

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;


public class Zadatak1 {

    private WebDriver driver;
    private WebDriverWait wait;


    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void visitPage() {
        driver.get("https://s.bootsnipp.com/iframe/K5yrx");
        Assert.assertTrue(driver.getTitle().contains("Table with Edit and Update Data - Bootsnipp.com"),
                "Page title is different");
    }

    @Test (priority = 1)
    public void editRow () {

        driver.findElement(By.cssSelector("[data-target=\"#edit\"][data-uid=\"1\"]")).click();

        wait.withMessage("Pop up doesn't appeared").
                until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-body")));

        driver.findElement(By.cssSelector("#fn")).clear();
        driver.findElement(By.cssSelector("#fn")).sendKeys("Milos");

        driver.findElement(By.cssSelector("#ln")).clear();
        driver.findElement(By.cssSelector("#ln")).sendKeys("Dabetic");

        driver.findElement(By.cssSelector("#mn")).clear();
        driver.findElement(By.cssSelector("#mn")).sendKeys("R");

        driver.findElement(By.id("up")).click();

        wait.withMessage("Message is still visible").
                until(ExpectedConditions.invisibilityOfElementLocated(By.id("up")));

        wait.withMessage("Entered name doesn't match expected name").
                until(ExpectedConditions.textToBe(By.cssSelector("#f1"),"Milos"));

        wait.withMessage("Entered name doesn't match expected name").
                until(ExpectedConditions.textToBe(By.cssSelector("#l1"),"Dabetic"));

        wait.withMessage("Entered name doesn't match expected name").
                until(ExpectedConditions.textToBe(By.cssSelector("#m1"),"R"));

    }

    @Test (priority = 2)
    public void deleteRow () {

        driver.findElement(By.cssSelector("[data-target='#delete'][data-uid='1']")).click();

        wait.withMessage("Pop up doesn't appeared").
                until(ExpectedConditions.visibilityOfElementLocated(By.id("del")));

        driver.findElement(By.id("del")).click();

        wait.withMessage("Actual number of elements don't match expected number").
                until(ExpectedConditions.numberOfElementsToBeLessThan(By.xpath("//tbody/tr"),3));
    }

    @Test (priority = 3)
    public void takeAScreenshot() throws IOException {
        Helper.takeAScreenshot(driver,"C:\\BootCamp IntelliJ Projekti\\osnove_selenium\\osnove_selenium\\downloads\\screenshotBootsnipp.png");
    }

    @AfterClass
    public void end () throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }


}