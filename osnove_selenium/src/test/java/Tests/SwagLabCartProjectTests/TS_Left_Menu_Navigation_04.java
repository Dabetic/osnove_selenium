package Tests.SwagLabCartProjectTests;

import SwagLabCartProject.Retry.SwagLabRetry;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TS_Left_Menu_Navigation_04 extends BasicTest {


    @Test(priority = 1, retryAnalyzer = SwagLabRetry.class)
    public void verifyTheTotalNumberOfMenuOptions () {
        addToCartPage.getShoppingCartBtn().click();
        addToCartPage.getHamburgerMenuBtn().click();
        addToCartPage.waitForHamburgerMenuToBeVisible();
        Assert.assertEquals(addToCartPage.getNumberOfMenuOptions().size(),
                4,
                "Menu doesn't contain 4 options");
    }

    @Test(priority = 2, retryAnalyzer = SwagLabRetry.class)
    public void verifyTheSpellingOfAllOptionsInMenu () {

        addToCartPage.getShoppingCartBtn().click();
        addToCartPage.getHamburgerMenuBtn().click();
        addToCartPage.waitForHamburgerMenuToBeVisible();
        Assert.assertEquals(addToCartPage.getAllItemsMenuOption().getText(),
                "All Items",
                "Actual text doesn't match expected text");
        Assert.assertEquals(addToCartPage.getAboutMenuOption().getText(),
                "About",
                "Actual text doesn't match expected text");
        Assert.assertEquals(addToCartPage.getLogOutMenuOption().getText(),
                "Logout",
                "Actual text doesn't match expected text");
        Assert.assertEquals(addToCartPage.getResetMenuOption().getText(),
                "Reset App State",
                "Actual text doesn't match expected text");
    }

    @Test(priority = 3, retryAnalyzer = SwagLabRetry.class)
    public void verifyIfAllItemsOptionIsWorking () {

        addToCartPage.getShoppingCartBtn().click();
        addToCartPage.getHamburgerMenuBtn().click();
        addToCartPage.waitForHamburgerMenuToBeVisible();
        addToCartPage.getAllItemsMenuOption().click();
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://www.saucedemo.com/inventory.html",
                "URL doesn't match expected URL");
    }

    @Test(priority = 4, retryAnalyzer = SwagLabRetry.class)
    public void verifyIfAboutOptionIsWorking () {

        addToCartPage.getShoppingCartBtn().click();
        addToCartPage.getHamburgerMenuBtn().click();
        addToCartPage.waitForHamburgerMenuToBeVisible();
        addToCartPage.getAboutMenuOption().click();
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://saucelabs.com/",
                "URL doesn't match expected URL");
    }

    @Test(priority = 5, retryAnalyzer = SwagLabRetry.class)
    public void verifyIfLogOutOptionIsWorking () {

        addToCartPage.getShoppingCartBtn().click();
        addToCartPage.getHamburgerMenuBtn().click();
        addToCartPage.waitForHamburgerMenuToBeVisible();
        addToCartPage.getLogOutMenuOption().click();
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://www.saucedemo.com/",
                "URL doesn't match expected URL");
    }

    @Test(priority = 5, retryAnalyzer = SwagLabRetry.class)
    public void verifyIfResetOptionIsWorking () {

        addToCartPage.getAddToCartBackpackBtn().click();
        addToCartPage.getShoppingCartBtn().click();
        addToCartPage.getHamburgerMenuBtn().click();
        addToCartPage.waitForHamburgerMenuToBeVisible();
        addToCartPage.getResetMenuOption().click();
        driver.navigate().refresh();
        Assert.assertEquals(addToCartPage.getProductsAddedToTheCart().size(),
                0,
                "Number of products is in cart is different form the number of added products");
    }

    @Test(priority = 6, retryAnalyzer = SwagLabRetry.class)
    public void verifyIfTheExitButtonIsPresented () {

        addToCartPage.getShoppingCartBtn().click();
        addToCartPage.getHamburgerMenuBtn().click();
        addToCartPage.waitForHamburgerMenuToBeVisible();
        addToCartPage.presenceOfTheExitBtn();
    }

    @Test(priority = 7, retryAnalyzer = SwagLabRetry.class)
    public void verifyIfTheExitButtonIsWorking () {

        addToCartPage.getShoppingCartBtn().click();
        addToCartPage.getHamburgerMenuBtn().click();
        addToCartPage.waitForHamburgerMenuToBeVisible();
        addToCartPage.getExitBtn().click();
        addToCartPage.waitForHamburgerMenuToBeInvisible();
    }





}
