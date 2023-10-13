package Tests.SwagLabCartProjectTests;

import SwagLabCartProject.Retry.SwagLabRetry;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

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
        Assert.assertEquals(itemListPage.getInventoryBlotShirtPrice().getText(),
                "$15.99",
                "Actual price doesn't match expected price");
    }

    @Test
            (priority = 4, retryAnalyzer = SwagLabRetry.class)
    public void verifyIfTheQuantityOfItemIsPresented() {
        addToCartPage.getAddToCartBackpackBtn().click();
        itemListPage.getAddToCartBoltTShirt().click();
        addToCartPage.getShoppingCartBtn().click();
        List<WebElement> quantities = itemListPage.getInventoryQuantityElement();
        for (int i=0; i<quantities.size(); i++) {
            quantities.get(i).isDisplayed();
        }

    }


}
