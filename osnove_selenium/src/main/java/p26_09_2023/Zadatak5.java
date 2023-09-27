package p26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak5 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demoqa.com/automation-practice-form");

        Thread.sleep(1000);
//
//        driver.findElement(By.cssSelector("#firstName")).sendKeys("Milos");
//        driver.findElement(By.cssSelector("#lastName")).sendKeys("D");
//        driver.findElement(By.cssSelector("#userEmail")).sendKeys("m@gmail.com");

//            driver.findElement(By.cssSelector("#currentAddress-label")).sendKeys("Mis");


        driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']"));

        WebElement checkBox = driver.findElement(By.cssSelector("#hobbies-checkbox-1"));

        if(!checkBox.isSelected()) {
            checkBox.click();
        }

        driver.quit();

    }
}
