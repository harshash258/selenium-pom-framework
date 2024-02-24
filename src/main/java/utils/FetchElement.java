package utils;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FetchElement {
    public WebElement findWebElement(String locator, String locatorValue){
        return switch (locator) {
            case "xpath" -> BaseTest.driver.findElement(By.xpath(locatorValue));
            case "id" -> BaseTest.driver.findElement(By.id(locatorValue));
            case "css" -> BaseTest.driver.findElement(By.cssSelector(locatorValue));
            case "tagName" -> BaseTest.driver.findElement(By.tagName(locatorValue));
            case "className" -> BaseTest.driver.findElement(By.className(locatorValue));
            default -> null;
        };
    }

    public List<WebElement> findWebElements(String locator, String locatorValue){
        return switch (locator) {
            case "xpath" -> BaseTest.driver.findElements(By.xpath(locatorValue));
            case "id" -> BaseTest.driver.findElements(By.id(locatorValue));
            case "css" -> BaseTest.driver.findElements(By.cssSelector(locatorValue));
            case "tagName" -> BaseTest.driver.findElements(By.tagName(locatorValue));
            case "className" -> BaseTest.driver.findElements(By.className(locatorValue));
            default -> null;
        };
    }

    public void waitForElement(String locator, String locatorValue){
        WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(30));
        switch (locator){
            case "xpath" -> wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
            case "id" -> wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
            case "css" -> wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorValue)));
            case "tagName" -> wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locatorValue)));
            case "className" -> wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locatorValue)));
            default -> System.out.println("Element not Found");
        }
    }
}