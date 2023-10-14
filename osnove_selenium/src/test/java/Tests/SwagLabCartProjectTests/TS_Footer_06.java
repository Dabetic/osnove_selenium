package Tests.SwagLabCartProjectTests;

import SwagLabCartProject.Retry.SwagLabRetry;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TS_Footer_06 extends  BasicTest {

    @Test (priority = 1, retryAnalyzer = SwagLabRetry.class)
    public void verifyIfTheTwitterButtonIsPresented () {

        Assert.assertTrue(footerPage.getTwitterPage().isDisplayed());
    }

    @Test (priority = 2, retryAnalyzer = SwagLabRetry.class)
    public void verifyIfTheFacebookButtonIsPresented () {

        Assert.assertTrue(footerPage.getFacebookPage().isDisplayed());
    }

    @Test (priority = 3, retryAnalyzer = SwagLabRetry.class)
    public void verifyIfTheLinkdinButtonIsPresented () {

        Assert.assertTrue(footerPage.getLinkdinPage().isDisplayed());
    }

    @Test (priority = 4, retryAnalyzer = SwagLabRetry.class)
    public void verifyIfTheTwitterButtonIsWokring () {

        footerPage.getTwitterPage().click();
        footerPage.switchToNewWidnow();
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://twitter.com/saucelabs",
                "URL doesn't match expected URL");
    }

    @Test (priority = 5, retryAnalyzer = SwagLabRetry.class)
    public void verifyIfTheFacebookButtonIsWokring () {

        footerPage.getFacebookPage().click();
        footerPage.switchToNewWidnow();
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://www.facebook.com/saucelabs",
                "URL doesn't match expected URL");
    }






}
