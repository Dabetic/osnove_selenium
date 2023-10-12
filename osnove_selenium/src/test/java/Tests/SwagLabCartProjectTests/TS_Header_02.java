package Tests.SwagLabCartProjectTests;

import SwagLabCartProject.Retry.SwagLabRetry;
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

    @Test(priority = 6, retryAnalyzer = SwagLabRetry.class)
    public void verifyIfTheHamburgerButtonIsWorking () {
        addToCartPage.getShoppingCartBtn().click();
        addToCartPage.getHamburgerMenuBtn().click();
        addToCartPage.waitForHamburgerMenuToBeVisible();
    }

    @Test(priority = 7, retryAnalyzer = SwagLabRetry.class)
    public void verifyIfTheCartIconIsWorking () {
        addToCartPage.getShoppingCartBtn().click();
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://www.saucedemo.com/cart.html",
                "Cart icon isn't working");
    }

    @Test(priority = 8, retryAnalyzer = SwagLabRetry.class)
    public void verifyIfTheCartIconHasCorrectNumberOfAddedItems () {
        addToCartPage.getAddToCartBackpackBtn().click();
        addToCartPage.getShoppingCartBtn().click();
       Assert.assertEquals(addToCartPage.getProductsAddedToTheCart().size(),
               1,
               "Number of products is in cart is different form the added products");

    }

}
