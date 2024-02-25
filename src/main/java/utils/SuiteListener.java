package utils;

import base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class SuiteListener implements ITestListener, IAnnotationTransformer {
    @Override
    public void onTestFailure(ITestResult result) {
        String fileName = System.getProperty("user.dir") + "/src/screenshots/" + result.getMethod().getMethodName();
        try {
            File file = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File(fileName + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(RetryAnalyzer.class);
    }
}
