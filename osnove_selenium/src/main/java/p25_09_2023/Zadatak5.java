package p25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.util.ArrayList;

public class Zadatak5 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        ArrayList<String> nizLinkova = new ArrayList<>();

        nizLinkova.add("www.google.com");
        nizLinkova.add("www.youtube.com");
        nizLinkova.add("www.ebay.com");
        nizLinkova.add("www.kupujemprodajem.com");


        for (int i = 0; i < nizLinkova.size(); i++) {

            driver.navigate().to(nizLinkova.get(i));
            System.out.println(driver.getTitle());


            Thread.sleep(3000);
        }

        driver.quit();
    }
}




