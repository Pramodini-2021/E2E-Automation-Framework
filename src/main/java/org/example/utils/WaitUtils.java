package org.example.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private WebDriver driver;
    private WebDriverWait wait;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(ConfigReader.get("timeout"))));
    }

    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void safeClick(By locator) {
        int attempts = 0;
        while (attempts < 3) {
            try {
                waitForClickable(locator).click();
                return;
            } catch (StaleElementReferenceException e) {
                attempts++;
            }
        }
        throw new RuntimeException("Element remained stale after 3 attempts: " + locator);
    }

    public void jsClick(By locator) {
        WebElement element = waitForVisibility(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void jsType(By locator, String text) {
        WebElement element = waitForVisibility(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "var nativeInputValueSetter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value').set;" +
                        "nativeInputValueSetter.call(arguments[0], arguments[1]);" +
                        "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));",
                element, text
        );
    }
}