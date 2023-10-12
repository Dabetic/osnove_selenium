package Tests.SwagLabCartProjectTests;

import SwagLabCartProject.Retry.SwagLabRetry;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TS_Cart_Page_01 extends BasicTest {

    @Test (priority = 1, retryAnalyzer = SwagLabRetry.class)
    public void verifyTheUrl () {
        addToCartPage.getShoppingCartBtn().click();
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://www.saucedemo.com/cart.html",
                "URL doesn't match expected URL");
    }

    @Test (priority = 2, retryAnalyzer = SwagLabRetry.class)
    public void verifyTheTitlePage () {
        addToCartPage.getAddToCartBtn().click();
        addToCartPage.getShoppingCartBtn().click();
        Assert.assertEquals(driver.getTitle(),
                "Swag Labs",
                "URL doesn't match expected title");
    }




}
