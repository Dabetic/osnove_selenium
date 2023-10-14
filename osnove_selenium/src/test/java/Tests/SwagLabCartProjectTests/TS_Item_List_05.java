package Tests.SwagLabCartProjectTests;

import SwagLabCartProject.Retry.SwagLabRetry;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
            (priority = 5, retryAnalyzer = SwagLabRetry.class)
    public void verifyIfTheQuantityOfItemIsPresented() {
        addToCartPage.getAddToCartBackpackBtn().click();
        itemListPage.getAddToCartBoltTShirt().click();
        addToCartPage.getShoppingCartBtn().click();
        List<WebElement> quantities = itemListPage.getInventoryQuantityElement();
        for (int i=0; i<quantities.size(); i++) {
            quantities.get(i).isDisplayed();
        }

    }

    @Test
            (priority = 6, retryAnalyzer = SwagLabRetry.class)
    public void verifyIfTheItemTitleIsClickable () {
        addToCartPage.getAddToCartBackpackBtn().click();
        itemListPage.getAddToCartBoltTShirt().click();
        addToCartPage.getShoppingCartBtn().click();
        wait.withMessage("Button isn't clickable").
                until(ExpectedConditions.elementToBeClickable(itemListPage.getInvertoryBackpackTitle()));
        wait.withMessage("Button isn't clickable").
                until(ExpectedConditions.elementToBeClickable(itemListPage.getInventoryBlotShirtTitle()));
    }

    @Test
            (priority = 7, retryAnalyzer = SwagLabRetry.class)
    public void verifyIfTheItemTitleIsWorking () {
        addToCartPage.getAddToCartBackpackBtn().click();
        itemListPage.getAddToCartBoltTShirt().click();
        addToCartPage.getShoppingCartBtn().click();
        itemListPage.getInvertoryBackpackTitle().click();
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://www.saucedemo.com/inventory-item.html?id=4",
                "URL doesn't match expected URL");
        driver.navigate().back();
        itemListPage.getInventoryBlotShirtTitle().click();
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://www.saucedemo.com/inventory-item.html?id=1",
                "URL doesn't match expected URL");
    }

    @Test
            (priority = 7, retryAnalyzer = SwagLabRetry.class)
    public void verifyIfTheRemoveButtonIsPresented () {

        addToCartPage.getAddToCartBackpackBtn().click();
        itemListPage.getAddToCartBoltTShirt().click();
        addToCartPage.getShoppingCartBtn().click();
        List<WebElement>removeButtons = itemListPage.getInventoryRemoveBtn();
        for (int i = 0; i < removeButtons.size(); i++) {
            removeButtons.get(i).isDisplayed();
        }
    }


    @Test
            (priority = 7, retryAnalyzer = SwagLabRetry.class)
    public void verifyIfTheRemoveButtonIsWorking () {

        addToCartPage.getAddToCartBackpackBtn().click();
        itemListPage.getAddToCartBoltTShirt().click();
        addToCartPage.getShoppingCartBtn().click();
        List<WebElement>removeButtons = itemListPage.getInventoryRemoveBtn();
        for (int i = 0; i < removeButtons.size(); i++) {
            removeButtons.get(i).click();
        }
        Assert.assertEquals(addToCartPage.getProductsAddedToTheCart().size(),
                0,
                "Number of products is in cart is different form the added products");

    }
    @Test
            (priority = 8, retryAnalyzer = SwagLabRetry.class)
    public void verifyIfTheContinueShoppingButtonIsPresented () {

        addToCartPage.getAddToCartBackpackBtn().click();
        itemListPage.getAddToCartBoltTShirt().click();
        addToCartPage.getShoppingCartBtn().click();
        itemListPage.getContinueShoping().isDisplayed();
    }


}
