package SwagLabCartProject.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FooterPage extends BasicPage {
    public FooterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getTwitterPage () {
        return driver.findElement(By.cssSelector("[href='https://twitter.com/saucelabs']"));
    }

    public WebElement getFacebookPage () {
        return driver.findElement(By.cssSelector("[href='https://www.facebook.com/saucelabs']"));
    }
    public WebElement getLinkdinPage () {
        return driver.findElement(By.cssSelector("[href='https://www.linkedin.com/company/sauce-labs/']"));
    }

    public void switchToNewWidnow () {
        driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
    }

    public WebElement getCopyRightMessageElement () {
        return driver.findElement(By.cssSelector(".footer_copy"));
    }


}
