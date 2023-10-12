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


}
