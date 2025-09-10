package com.agc.sel.baseutilities;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import com.agc.sel.loggers.Logger4j;
public class JavaScriptUtil {

    WebDriver driver;
    WebWait time;

    public JavaScriptUtil(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Scrolls to the given element using JavaScript.
     */
    public void scrollToElement(WebElement element) {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Scrolls to the top of the page.
     */
    public void scrollToTop() {
       // ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
        ((JavascriptExecutor) driver).executeScript(
                "document.querySelector('html, body').scrollTop = 0;" +
                        "window.scrollTo({ top: 0, behavior: 'auto' });"
        );
    }

    /**
     * Scrolls to the bottom of the page.
     */
    public void scrollToBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    /**
     * Clicks on the element using JavaScript.
     */
    public void clickElementByJS(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    /**
     * Sets the value of an input field using JavaScript.
     */
    public void setValueByJS(WebElement element, String value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='" + value + "';", element);
    }

    /**
     * Flashes an element (for debugging).
     */
    public void flashElement(WebElement element) {
        String bgColor = element.getCssValue("backgroundColor");
        for (int i = 0; i < 5; i++) {
            changeColor("rgb(255,0,0)", element); // red
            changeColor(bgColor, element);        // original
        }
    }

    private void changeColor(String color, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the page title using JavaScript.
     */
    public String getTitleByJS() {
        return ((JavascriptExecutor) driver).executeScript("return document.title;").toString();
    }

    /**
     * Generates an alert with given message.
     */
    public void generateAlert(String message) {
        ((JavascriptExecutor) driver).executeScript("alert('" + message + "');");
    }

    /**
     * Refreshes the page using JavaScript.
     */
    public void refreshBrowserByJS() {
        ((JavascriptExecutor) driver).executeScript("history.go(0);");
    }

    /**
     * Highlights an element with border (for debugging).
     */
    public void drawBorder(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
    }
    public void scrollUntilVisible(WebElement container, WebElement element, int maxScrolls) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        int scrollCount = 0;

        while (scrollCount < maxScrolls) {
            try {
                if (element.isDisplayed()) {
                    Logger4j.info("Element is visible after " + scrollCount + " scrolls.");
                    return;
                }
            } catch (Exception e) {
                // ignore element not found yet
            }

            js.executeScript("arguments[0].scrollTop = arguments[0].scrollTop + 150;", container);
            scrollCount++;
        }
        Logger4j.error("Element not found after scrolling " + maxScrolls + " times.");
    }
    // Is element fully inside the container's visible viewport?
    public boolean isInContainerViewport(WebElement container, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (Boolean) js.executeScript(
                "const c = arguments[0], e = arguments[1];" +
                        "const cr = c.getBoundingClientRect();" +
                        "const er = e.getBoundingClientRect();" +
                        "return er.top >= cr.top && er.bottom <= cr.bottom;",
                container, element
        );
    }

    // Scroll element into view inside the container (no page scroll)
    public void scrollElementIntoContainer(WebElement container, WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollTop = arguments[1].offsetTop - arguments[0].offsetTop;",
                container, element
        );
    }

    // Robust: keep scrolling the container until the element is in its viewport
    public void scrollUntilVisibleInContainer(WebElement container, WebElement element, int maxScrolls, int stepPx) {
        for (int i = 0; i < maxScrolls; i++) {
            try {
                if (isInContainerViewport(container, element)) return;
            } catch (StaleElementReferenceException ignored) { /* re-find outside */ }

            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollTop = arguments[0].scrollTop + arguments[1];",
                    container, stepPx
            );
        }
        Logger4j.error("Element not visible inside container after " + maxScrolls + " scrolls.");
    }

}