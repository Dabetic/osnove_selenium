package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage{
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getLoginElement () {
        return driver.findElement(By.id("login-button"));
    }

    public void clickOnTheLoginButton () {
        this.getLoginElement().click();
    }

    public WebElement getErrorMessage () {
        return driver.findElement(By.cssSelector(".error-message-container"));
    }

    public String getErrorMessageText () {
        return this.getErrorMessage().getText();
    }

    public WebElement getUsernameElement () {
        return driver.findElement(By.cssSelector("#user-name"));
    }

    public void enterAUsername (String username) {
        this.getUsernameElement().clear();
        this.getUsernameElement().sendKeys(username);
    }

    public WebElement getPasswordElement () {
        return driver.findElement(By.cssSelector("#password"));
    }

    public void enterAPassword (String password) {
        this.getPasswordElement().clear();
        this.getPasswordElement().sendKeys(password);
    }

}
