package p25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com/text-box");

        for (int i = 0; i < 3; i++) {
            driver.findElement(By.cssSelector("#userName")).sendKeys("User");
            driver.findElement(By.cssSelector("#userEmail")).sendKeys("email");
            driver.findElement(By.cssSelector("#currentAddress")).sendKeys("12");
            driver.findElement(By.cssSelector("#permanentAddress")).sendKeys("13");
            driver.findElement(By.cssSelector("#submit")).click();

            Thread.sleep(2000);
            driver.navigate().refresh();

        }

        driver.quit();



    }
}
