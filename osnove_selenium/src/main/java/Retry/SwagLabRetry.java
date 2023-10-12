package Retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class SwagLabRetry implements IRetryAnalyzer {

    private int counter = 0;
    private int maxRetry = 3;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if(counter < maxRetry) {
            counter++;
            return true;
        }
        return false;
    }
}
