package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LeftNavMenuPage extends BasicPage{
    public LeftNavMenuPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getLeftMenuElement () {
        return driver.findElement(By.cssSelector("#react-burger-menu-btn"));
    }

    public void clickOnTheLeftMenuBtn () {
        this.getLeftMenuElement().click();
    }

    public WebElement getLeftMenuVisibilityElement () {
        return driver.findElement(By.cssSelector(".bm-menu"));
    }

    public WebElement getLogOutElement () {
        return driver.findElement(By.cssSelector("#logout_sidebar_link"));
    }

    public void clickOnTheLogOutBtn () {
        this.getLogOutElement().click();
    }

    public WebElement getRemoveBtn () {
        return driver.findElement(By.cssSelector("#remove-sauce-labs-backpack"));
    }

    public WebElement getCartElement () {
        return driver.findElement(By.cssSelector(".shopping_cart_link .shopping_cart_badge"));
    }



}
