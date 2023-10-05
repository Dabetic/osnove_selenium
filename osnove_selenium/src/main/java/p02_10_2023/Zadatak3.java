package p02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class Zadatak3 {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://en.wikipedia.org/wiki/Lion#/media/File:Lion_waiting_in_Namibia.jpg");

        FileDownload.downloadUsingNIO("https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Lion_waiting_in_Namibia.jpg/1024px-Lion_waiting_in_Namibia.jpg", "C:\\BootCamp IntelliJ Projekti\\osnove_selenium\\osnove_selenium\\downloads\\slikaLavaDown.jpg");

    }
}
