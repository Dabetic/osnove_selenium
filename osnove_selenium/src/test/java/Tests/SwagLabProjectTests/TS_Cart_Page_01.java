package Tests.SwagLabProjectTests;

import SwagLabProject.Retry.SwagLabRetry;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TS_Cart_Page_01 extends BasicTest {

    @Test (priority = 1, retryAnalyzer = SwagLabRetry.class)
    public void verifyTheUrl () {
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://www.saucedemo.com/cart.html",
                "URL doesn't match expected URL");
    }




}
