package SwagLabCartProject.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AddToCartPage extends BasicPage {
    public AddToCartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getShoppingCartBtn () {
        return driver.findElement(By.cssSelector(".shopping_cart_link"));
    }

    public WebElement getAddToCartBackpackBtn() {
        return driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack"));
    }

    public WebElement getHeaderElement () {
        return driver.findElement(By.cssSelector(".header_label"));
    }

    public WebElement getHamburgerMenuBtn () {
        return driver.findElement(By.cssSelector("#react-burger-menu-btn"));
    }

    public void presenceOfTheHamburgerMenyBtn () {
        wait.withMessage("Element isn't present").
                until(ExpectedConditions.presenceOfElementLocated
                        (By.cssSelector("#react-burger-menu-btn")));
    }

    public WebElement getCartIcon () {
        return driver.findElement(By.cssSelector(".shopping_cart_link"));
    }

    public void presenceOfCartIcon () {
        wait.withMessage("Icon isn't present").
                until(ExpectedConditions.presenceOfElementLocated
                        (By.cssSelector(".shopping_cart_link")));
    }

    public boolean isHamburgerMenuBtnEnabled () {
       return this.getHamburgerMenuBtn().isEnabled();
    }

    public boolean isCartIconIsEnabled () {
        return this.getCartIcon().isEnabled();
    }

    public void waitForHamburgerMenuToBeVisible () {
        wait.withMessage("Menu should be visible").until
                (ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-hidden='false']")));
    }

    public void waitForHamburgerMenuToBeInvisible () {
        wait.withMessage("Menu should be visible").until
                (ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[aria-hidden='false']")));
    }

   public List<WebElement> getProductsAddedToTheCart() {
        return driver.findElements(By.cssSelector("div.cart_item"));
   }

   public WebElement getSubHeaderElement () {
        return driver.findElement(By.cssSelector(".header_secondary_container"));
   }

   public List<WebElement> getNumberOfMenuOptions () {
        return driver.findElements(By.cssSelector(".bm-item"));
   }

   public WebElement getAllItemsMenuOption () {
        return driver.findElement(By.cssSelector("#inventory_sidebar_link"));
   }
    public WebElement getAboutMenuOption () {
        return driver.findElement(By.cssSelector("#about_sidebar_link"));
    }

    public WebElement getLogOutMenuOption () {
        return driver.findElement(By.cssSelector("#logout_sidebar_link"));
    }

    public WebElement getResetMenuOption () {
        return driver.findElement(By.cssSelector("#reset_sidebar_link"));
    }

    public WebElement getExitBtn () {
        return driver.findElement(By.cssSelector("#react-burger-cross-btn"));
    }

    public void presenceOfTheExitBtn () {
        wait.withMessage("Button isn't present").
                until(ExpectedConditions.visibilityOf(getExitBtn()));
    }

}
