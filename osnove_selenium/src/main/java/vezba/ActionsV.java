package vezba;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsV {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        Actions actions = new Actions(driver);

        driver.get("https://www.youtube.com/");

//        actions.keyDown(Keys.CONTROL);
//        actions.keyDown(Keys.SUBTRACT);
//        actions.perform();

//        driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL,Keys.SUBTRACT));

    }
}
