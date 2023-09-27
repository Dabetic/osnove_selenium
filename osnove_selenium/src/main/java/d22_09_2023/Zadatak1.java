package d22_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        ArrayList<String> nizLinkova = new ArrayList<>();

        nizLinkova.add("https://www.google.com/");
        nizLinkova.add("https://www.facebook.com/");
        nizLinkova.add("https://www.youtube.com/");
        nizLinkova.add("https://www.ebay.com/");
        nizLinkova.add("https://www.katalon.com/");

        for (int i = 0; i < nizLinkova.size() ; i++) {
            driver.get(nizLinkova.get(i));
            Thread.sleep(2000);
        }

        driver.quit();
    }
}

