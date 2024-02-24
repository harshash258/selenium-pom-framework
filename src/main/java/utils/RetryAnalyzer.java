package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    int count = 1;
    int retryCount = 2;
    @Override
    public boolean retry(ITestResult result) {
        while(count < retryCount){
            count++;
            return true;
        }
        return false;
    }
}
