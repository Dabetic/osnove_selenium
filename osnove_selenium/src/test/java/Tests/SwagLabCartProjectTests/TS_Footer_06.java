package Tests.SwagLabCartProjectTests;

import SwagLabCartProject.Retry.SwagLabRetry;
import org.testng.annotations.Test;

public class TS_Footer_06 extends  BasicTest {

    @Test (priority = 1, retryAnalyzer = SwagLabRetry.class)
    public void verifyIfTheTwitterButtonIsPresented () {

        footerPage.getTwitterPage().isDisplayed();

    }




}
