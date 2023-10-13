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
        Assert.assertEquals(addToCartPage.getProductsAddedToTheCart().size(),
                2,
                "Items aren't present");
    }

    @Test
            (priority = 2, retryAnalyzer = SwagLabRetry.class)
    public void verifyIfTheItemsTitleIsVisible() {
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
    @Test
            (priority = 3, retryAnalyzer = SwagLabRetry.class)
    public void verifyIfTheItemsDescriptionIsPresented() {
        addToCartPage.getAddToCartBackpackBtn().click();
        itemListPage.getAddToCartBoltTShirt().click();
        addToCartPage.getShoppingCartBtn().click();
        itemListPage.getInvertoryBoltTShirtDesc().isDisplayed();
        itemListPage.getInvertoryBackpackDesc().isDisplayed();
    }

    @Test
            (priority = 4, retryAnalyzer = SwagLabRetry.class)
    public void verifyIfTheItemsPriceIsPresented() {
        addToCartPage.getAddToCartBackpackBtn().click();
        itemListPage.getAddToCartBoltTShirt().click();
        addToCartPage.getShoppingCartBtn().click();
        Assert.assertEquals(itemListPage.getInvertoryBackpackPrice().getText(),
                "$29.99",
                "Actual price doesn't match expected price");

    }

}
