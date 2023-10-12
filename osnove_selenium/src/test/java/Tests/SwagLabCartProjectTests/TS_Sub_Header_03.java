package Tests.SwagLabCartProjectTests;

import SwagLabCartProject.Retry.SwagLabRetry;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TS_Sub_Header_03 extends BasicTest {


    @Test(priority = 1, retryAnalyzer = SwagLabRetry.class)
    public void verifyTheSubHeaderTitle  () {
        addToCartPage.getShoppingCartBtn().click();
        Assert.assertEquals(addToCartPage.getSubHeaderElement().getText(),
                "Your Cart",
                "Name doesn't match expected name");
    }


}
