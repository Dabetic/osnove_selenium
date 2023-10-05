package d02_10_2023;

//Napisati program koji:
//●	Ucitava stranicu https://itbootcamp.rs/
//●	Skrola do slajdera na dnu stranice (u kome su slike Java, Php, Selenium, …)
//●	Cita sve linkove slika iz slajdera
//●	Proverava url svake slike, i za sve slike koje imaju status veci i jednak od 200 a manji od 300, skida i smesta u folder itbootcamp_slider u okviru projekta
//●	Azurirajte gitignore da ignorise itbootcamp_slider folder

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import p02_10_2023.FileDownload;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Zadatak4 {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.navigate().to("https://itbootcamp.rs/");

        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(By.cssSelector(".vc_row.wpb_row.vc_row-fluid.slider_bkgd")));
        actions.perform();

        List<WebElement> listOfPictures = driver.findElements(By.cssSelector(".carousel-item>img"));


        for (int i = 0; i < listOfPictures.size(); i++) {

           int picturesVerificator =  LinkVerification.getHTTPResponseStatusCode(listOfPictures.get(i).getAttribute("src"));

            if(picturesVerificator >=200 && picturesVerificator < 300) {
                FileDownload.downloadUsingNIO(listOfPictures.get(i).getAttribute("src"),"itbootcamp_slider/" + i + ".jpg");
            }
        }

        driver.quit();
    }
}
