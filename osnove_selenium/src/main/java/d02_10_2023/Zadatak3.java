package d02_10_2023;

//Napisati program koji:
//●	Ucitava stranicu https://demoqa.com/broken
//●	Hvata oba linka sa stranice i
//●	Za svaki link proverava status da je veci ili jednak od 200 i manji od 400
//●	Koristan link za citanje status koda nekog url-a

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class Zadatak3 {
    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        driver.get("https://demoqa.com/broken");

        int firstLink = LinkVerification.getHTTPResponseStatusCode("https://demoqa.com/");

        if(firstLink>=200 && firstLink < 400) {
            System.out.println("Link is valid");
        } else {
            System.out.println("Invalid link");
        }

        int secondLink = LinkVerification.getHTTPResponseStatusCode("http://the-internet.herokuapp.com/status_codes/500");

        if(secondLink>=200 && secondLink < 400) {
            System.out.println("Link is valid");
        } else {
            System.out.println("Invalid link");
        }

        Thread.sleep(2000);
        driver.quit();

    }
}
