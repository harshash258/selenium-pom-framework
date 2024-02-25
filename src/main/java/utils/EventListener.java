package utils;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static utils.Constants.*;

public class EventListener {
    public WebElement findWebElement(String locator, String locatorValue){
        return switch (locator) {
            case XPATH -> BaseTest.driver.findElement(By.xpath(locatorValue));
            case ID -> BaseTest.driver.findElement(By.id(locatorValue));
            case CSS -> BaseTest.driver.findElement(By.cssSelector(locatorValue));
            case TAGNAME -> BaseTest.driver.findElement(By.tagName(locatorValue));
            case CLASSNAME -> BaseTest.driver.findElement(By.className(locatorValue));
            default -> null;
        };
    }

    public List<WebElement> findWebElements(String locator, String locatorValue){
        return switch (locator) {
            case XPATH -> BaseTest.driver.findElements(By.xpath(locatorValue));
            case ID -> BaseTest.driver.findElements(By.id(locatorValue));
            case CSS -> BaseTest.driver.findElements(By.cssSelector(locatorValue));
            case TAGNAME -> BaseTest.driver.findElements(By.tagName(locatorValue));
            case CLASSNAME -> BaseTest.driver.findElements(By.className(locatorValue));
            default -> null;
        };
    }

    public void waitForElement(String locator, String locatorValue){
        WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(30));
        switch (locator){
            case XPATH -> wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
            case ID -> wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
            case CSS -> wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorValue)));
            case TAGNAME -> wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locatorValue)));
            case CLASSNAME -> wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locatorValue)));
            default -> System.out.println("Element not Found");
        }
    }
}
