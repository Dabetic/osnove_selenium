package d22_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        ArrayList<String> nizLinkova = new ArrayList<>();

        nizLinkova.add("https://www.google.com/");
        nizLinkova.add("https://www.facebook.com/");
        nizLinkova.add("https://www.youtube.com/");
        nizLinkova.add("https://www.ebay.com/");
        nizLinkova.add("https://www.katalon.com/");

        for (int i = 0; i < nizLinkova.size() ; i++) {
            WebDriver driver = new ChromeDriver();
            driver.get(nizLinkova.get(i));
            Thread.sleep(1000);
            driver.quit();
        }
    }
}


