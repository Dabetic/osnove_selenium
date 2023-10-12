package Tests.SwagLabCartProjectTests;

import SwagLabCartProject.Retry.SwagLabRetry;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TS_Item_List_05 extends BasicTest {

    @Test
            (priority = 1, retryAnalyzer = SwagLabRetry.class)
    public void verifyIfTheItemsAddedArePresented() {
        addToCartPage.getAddToCartBackpackBtn().click();
        itemListPage.getAddToCartBoltTShirt().click();
        addToCartPage.getShoppingCartBtn().click();
        Assert.assertEquals(itemListPage.getInventoryIntemBackpack().getText(),
                "Sauce Labs Backpack",
                "Actual item desc doesn't match expected item desc");
        Assert.assertEquals(itemListPage.getInventoryIntemBoltTShirt().getText(),
                "Sauce Labs Bolt T-Shirt",
                "Actual item desc doesn't match expected item desc");

    }




}
