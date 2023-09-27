package p25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com/login");
        driver.findElement(By.xpath("//*[@id='userName']")).sendKeys("itbootcamp");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("ITBootcamp2021!");
//        driver.findElement(By.xpath("//*[@id=\"login\"]")).click();
        driver.findElement(By.cssSelector("#login")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class='text-right button']/button[@id='login']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[text()='submit']")).click();
//        driver.findElement(By.cssSelector("#submit")).click();

        driver.close();



    }
}
