package com.agc.sel.baseutilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.NoSuchElementException;
import com.agc.sel.loggers.Logger4j;

import java.time.Duration;

/**
 * ApplicationLoader utility class for waiting for application elements to load
 * This class provides methods to wait for various application loading conditions
 */
public class ApplicationLoader {
    
    private WebDriver driver;
    private WebDriverWait wait;
    private static final int DEFAULT_TIMEOUT = 30; // seconds
    
    /**
     * Constructor to initialize ApplicationLoader with WebDriver
     * @param driver WebDriver instance
     */
    public ApplicationLoader(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
    }
    
    /**
     * Constructor to initialize ApplicationLoader with WebDriver and custom timeout
     * @param driver WebDriver instance
     * @param timeoutInSeconds custom timeout in seconds
     */
    public ApplicationLoader(WebDriver driver, int timeoutInSeconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    }
    
    /**
     * Wait for application to load by checking if a specific element is present and visible
     * @param element WebElement to wait for
     * @return true if element is loaded successfully, false otherwise
     */
    public boolean waitForApplicationToLoad(WebElement element) {
        try {
            Logger4j.info("Waiting for application to load - checking element visibility");
            wait.until(ExpectedConditions.visibilityOf(element));
            Logger4j.info("Application loaded successfully - element is visible");
            return true;
        } catch (TimeoutException e) {
            Logger4j.error("Timeout waiting for application to load: " + e.getMessage());
            return false;
        } catch (NoSuchElementException e) {
            Logger4j.error("Element not found while waiting for application to load: " + e.getMessage());
            return false;
        } catch (Exception e) {
            Logger4j.error("Unexpected error while waiting for application to load: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Wait for application to load by checking if a specific element is clickable
     * @param element WebElement to wait for
     * @return true if element is clickable, false otherwise
     */
    public boolean waitForElementToBeClickable(WebElement element) {
        try {
            Logger4j.info("Waiting for element to be clickable");
            wait.until(ExpectedConditions.elementToBeClickable(element));
            Logger4j.info("Element is now clickable");
            return true;
        } catch (TimeoutException e) {
            Logger4j.error("Timeout waiting for element to be clickable: " + e.getMessage());
            return false;
        } catch (Exception e) {
            Logger4j.error("Unexpected error while waiting for element to be clickable: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Wait for page to load completely by checking document ready state
     * @return true if page is loaded, false otherwise
     */
    public boolean waitForPageToLoad() {
        try {
            Logger4j.info("Waiting for page to load completely");
            wait.until(webDriver -> 
                ((org.openqa.selenium.JavascriptExecutor) webDriver)
                    .executeScript("return document.readyState").equals("complete")
            );
            Logger4j.info("Page loaded successfully");
            return true;
        } catch (TimeoutException e) {
            Logger4j.error("Timeout waiting for page to load: " + e.getMessage());
            return false;
        } catch (Exception e) {
            Logger4j.error("Unexpected error while waiting for page to load: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Wait for loader/spinner elements to disappear
     * @param loaderElement WebElement representing the loader/spinner
     * @return true if loader disappeared, false otherwise
     */
    public boolean waitForLoaderToDisappear(WebElement loaderElement) {
        try {
            Logger4j.info("Waiting for loader to disappear");
            wait.until(ExpectedConditions.invisibilityOf(loaderElement));
            Logger4j.info("Loader disappeared successfully");
            return true;
        } catch (TimeoutException e) {
            Logger4j.error("Timeout waiting for loader to disappear: " + e.getMessage());
            return false;
        } catch (Exception e) {
            Logger4j.error("Unexpected error while waiting for loader to disappear: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Wait for application to load with custom loading conditions
     * @param element WebElement to wait for
     * @param additionalWaitTime additional wait time in milliseconds after element is found
     * @return true if application loaded successfully, false otherwise
     */
    public boolean waitForApplicationToLoad(WebElement element, long additionalWaitTime) {
        try {
            Logger4j.info("Waiting for application to load with additional wait time");
            wait.until(ExpectedConditions.visibilityOf(element));
            Thread.sleep(additionalWaitTime);
            Logger4j.info("Application loaded successfully with additional wait");
            return true;
        } catch (TimeoutException e) {
            Logger4j.error("Timeout waiting for application to load: " + e.getMessage());
            return false;
        } catch (InterruptedException e) {
            Logger4j.error("Thread interrupted while waiting: " + e.getMessage());
            Thread.currentThread().interrupt();
            return false;
        } catch (Exception e) {
            Logger4j.error("Unexpected error while waiting for application to load: " + e.getMessage());
            return false;
        }
    }
}