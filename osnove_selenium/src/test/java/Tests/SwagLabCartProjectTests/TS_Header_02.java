package Tests.SwagLabCartProjectTests;

import SwagLabCartProject.Retry.SwagLabRetry;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TS_Header_02 extends BasicTest {

    @Test(priority = 1, retryAnalyzer = SwagLabRetry.class)
    public void verifyTheUrl () {
        addToCartPage.getShoppingCartBtn().click();
        Assert.assertEquals(addToCartPage.getHeaderElement().getText(),
                "Your Cart",
                "Header title doesn't match expected header title");
    }

}
