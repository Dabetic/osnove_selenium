package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartPage extends BasicPage{
    public AddToCartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

public WebElement getProductElement () {
        return driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack"));
}

public void clickOnTheGetToCartBtn () {
        this.getProductElement().click();
}



}
