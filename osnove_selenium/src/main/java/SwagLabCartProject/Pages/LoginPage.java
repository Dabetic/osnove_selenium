package SwagLabCartProject.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage{


    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getUsernameInput () {
        return driver.findElement(By.cssSelector("#user-name"));
    }

    public WebElement getPasswordInput () {
        return driver.findElement(By.cssSelector("#password"));
    }

    public void clickOnTheLoginBtn () {
        driver.findElement(By.cssSelector("#login-button")).click();
    }


    public void addAndClearCredentials (String username, String password) {
        this.getUsernameInput().clear();
        this.getUsernameInput().sendKeys(username);

        this.getPasswordInput().clear();
        this.getPasswordInput().sendKeys(password);
    }

}
