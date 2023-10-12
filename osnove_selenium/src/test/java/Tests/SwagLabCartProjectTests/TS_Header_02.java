package Tests.SwagLabCartProjectTests;

import SwagLabCartProject.Retry.SwagLabRetry;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TS_Header_02 extends BasicTest {

    @Test(priority = 1, retryAnalyzer = SwagLabRetry.class)
    public void verifyTheTitleInHeader () {
        addToCartPage.getShoppingCartBtn().click();
        Assert.assertEquals(addToCartPage.getHeaderElement().getText(),
                "Swag Labs",
                "Header title doesn't match expected header title");
    }


    @Test(priority = 2, retryAnalyzer = SwagLabRetry.class)
    public void verifyIfTheHamburgerMenuButtonIsPresented () {
        addToCartPage.getShoppingCartBtn().click();
        addToCartPage.presenceOfTheHamburgerMenyBtn();

    }

    @Test(priority = 3, retryAnalyzer = SwagLabRetry.class)
    public void verifyIfCartIconIsPresented () {
        addToCartPage.getShoppingCartBtn().click();
        addToCartPage.presenceOfCartIcon();
    }

    @Test(priority = 4, retryAnalyzer = SwagLabRetry.class)
    public void verifyIfTheHamburgerMenuButtonIsEnabled () {
        addToCartPage.getShoppingCartBtn().click();
        addToCartPage.presenceOfTheHamburgerMenyBtn();
        Assert.assertTrue(addToCartPage.isHamburgerMenuBtnEnabled(),
                "Button isn't enabled");
    }
    @Test(priority = 5, retryAnalyzer = SwagLabRetry.class)
    public void verifyIfCartIconIsEnabled () {
        addToCartPage.getShoppingCartBtn().click();
        Assert.assertTrue(addToCartPage.isCartIconIsEnabled(),
                "Icon isn't enabled");
    }

}
