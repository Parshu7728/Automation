package com.agc.sel.baseutilities;

import com.agc.sel.loggers.Logger4j;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PopupHandler {

    private WebDriver driver;
    private Logger4j logger;

    // Constructor to initialize WebDriver and Logger
    public PopupHandler(WebDriver driver) {
        this.driver = driver;
        this.logger = new Logger4j();

        // Prevent NullPointerException inside Logger4j
        Logger4j.exceptionDriver = driver;
    }

    public void waitForElementToDisappear(WebElement element) {
        try {
            logger.info("Waiting for popup element to disappear: " + element);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.invisibilityOf(element));

            logger.info("Element disappeared successfully.");
        } catch (TimeoutException e) {
            logger.info("Element still visible, trying to hide it with JS...");

            try {
                ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none';", element);
            } catch (Exception jsEx) {
                logger.info("JavaScript execution failed: " + jsEx.getMessage());
            }
        } catch (Exception ex) {
            logger.info("Unexpected error occurred in waitForElementToDisappear: " + ex.getMessage());
        }
    }
}
