package d25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Thread.sleep(1000);

        driver.findElement(By.cssSelector("[name='username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("[name='password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("[type='submit']")).click();

        Thread.sleep(2000);

        driver.findElement(By.cssSelector("[placeholder='Search']")).sendKeys("me");

        Thread.sleep(1000);

        driver.findElement(By.cssSelector("[href='/web/index.php/time/viewTimeModule']")).click();

        Thread.sleep(1000);

        driver.findElement(By.cssSelector("p.oxd-userdropdown-name")).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[contains(text(),'Logout')]")).click();

        Thread.sleep(5000);

        driver.quit();


    }
}
