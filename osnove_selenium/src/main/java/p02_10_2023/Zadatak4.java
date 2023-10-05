package p02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import com.google.common.io.Files;

public class Zadatak4 {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.google.com/webhp?hl=en&sa=X&ved=0ahUKEwiYqdHTjNiBAxWSP-wKHQbyBigQPAgJ");

//        File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//
//        Files.copy(f,new File("C:\\BootCamp IntelliJ Projekti\\osnove_selenium\\osnove_selenium\\downloads\\google"));

        Helper.takeAScreenshot(driver,"C:\\\\BootCamp IntelliJ Projekti\\\\osnove_selenium\\\\osnove_selenium\\\\screenshots\\\\google.png");

    }
}
