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
}
