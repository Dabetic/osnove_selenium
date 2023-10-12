package Tests;

import Retry.SwagLabRetry;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwagLabTestsSuit extends BasicTest{

    @Test (priority = 1, retryAnalyzer = SwagLabRetry.class)
    public void verifyIfPageIsOpened (){
        Assert.assertEquals(driver.getTitle(),
                "Swag Labs",
                "Error message");
    }
    @Test (priority = 2, retryAnalyzer = SwagLabRetry.class)
    public void verifyErrorIsDisplayedWhenUsernameIsMissing () {
        loginPage.clickOnTheLoginButton();
        Assert.assertEquals(loginPage.getErrorMessageText(),
                "Epic sadface: Username is required",
                "Error message");
    }

    @Test (priority = 3, retryAnalyzer = SwagLabRetry.class)
    public void verifyErrorIsDisplayedWhenPasswordIsMissing () {
        String username = "standard_user";
        loginPage.enterAUsername(username);
        loginPage.clickOnTheLoginButton();
        Assert.assertEquals(loginPage.getErrorMessageText(),
                "Epic sadface: Password is required",
                "Error message");
    }

    @Test (priority = 4, retryAnalyzer = SwagLabRetry.class)
    public void verifyErrorIsDisplayedWhenCredentialsAreWrong () {
        String username = "standard_user";
        String password = "invalidpassword";
        loginPage.enterAUsername(username);
        loginPage.enterAPassword(password);
        loginPage.clickOnTheLoginButton();
        Assert.assertEquals(loginPage.getErrorMessageText(),
                "Epic sadface: Username and password do not match any user in this service",
                "Error message");
    }

    @Test (priority = 5, retryAnalyzer = SwagLabRetry.class)
    public void verifyErrorIsDisplayedWhenUserIsLocked () {
        String username = "locked_out_user";
        String password = "secret_sauce";
        loginPage.enterAUsername(username);
        loginPage.enterAPassword(password);
        loginPage.clickOnTheLoginButton();
        Assert.assertEquals(loginPage.getErrorMessageText(),
                "Epic sadface: Sorry, this user has been locked out.",
                "Error message");
    }

    @Test (priority = 6, retryAnalyzer = SwagLabRetry.class)
    public void verifySuccessfulLogin () {
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.enterAUsername(username);
        loginPage.enterAPassword(password);
        loginPage.clickOnTheLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "inventory.html", "URL doesn't match" );
        leftNavMenuPage.clickOnTheLeftMenuBtn();
        wait.withMessage("Menu page is not visible").
                until(ExpectedConditions.visibilityOf(leftNavMenuPage.getLeftMenuVisibilityElement()));
        leftNavMenuPage.clickOnTheLogOutBtn();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl, "URL doesn't match");

    }

    @Test (priority = 7, retryAnalyzer = SwagLabRetry.class)
    public void addingToCart () {
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.enterAUsername(username);
        loginPage.enterAPassword(password);
        loginPage.clickOnTheLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "inventory.html", "URL doesn't match");
        addToCartPage.clickOnTheGetToCartBtn();
        wait.withMessage("button isn't visible").until(ExpectedConditions.visibilityOf(leftNavMenuPage.getRemoveBtn()));
        Assert.assertEquals(leftNavMenuPage.getCartElement().getText(),
                "1", "Number of products is 0");

    }

}
