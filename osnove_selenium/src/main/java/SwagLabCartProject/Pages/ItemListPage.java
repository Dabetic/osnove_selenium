package SwagLabCartProject.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemListPage extends BasicPage{
    public ItemListPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getAddToCartBoltTShirt () {
        return driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-bolt-t-shirt"));
    }
    public WebElement getInventoryIntemBoltTShirt () {
        return driver.findElement(By.cssSelector("#item_1_title_link>div"));
    }

    public WebElement getInventoryIntemBackpack () {
        return driver.findElement(By.cssSelector("#item_4_title_link>div"));
    }

}
