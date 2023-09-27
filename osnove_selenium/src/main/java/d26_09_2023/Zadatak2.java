package d26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://s.bootsnipp.com/iframe/Dq2X");

        List<WebElement>nizAlertsAfter = driver.findElements(By.cssSelector("div.alert-dismissable button"));


        for (int i = nizAlertsAfter.size()-1; i >= 0; i--) {

            nizAlertsAfter.get(i).click();
            Thread.sleep(1000);
            WebElement isDisplayed = driver.findElement(By.cssSelector("div.alert-dismissable:nth-child("+(i)+")"));

            if(isDisplayed != null){
                System.out.println("Alert is closed");
            } else {
                System.out.println("Still visible");
            }
        }
        driver.quit();
  }
}
