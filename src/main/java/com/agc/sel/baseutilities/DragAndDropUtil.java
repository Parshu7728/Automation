package com.agc.sel.baseutilities;

import com.agc.sel.loggers.Logger4j;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.InputEvent;
import java.time.Duration;

/**
 * Utility class for performing drag and drop actions using Selenium Actions class.
 */
public class DragAndDropUtil {

    /**
     * Drags an element from source and drops it on the target element.
     *
     * @param driver The WebDriver instance.
     * @param source The element to drag.
     * @param target The element to drop onto.
     */
    public static void dragAndDrop(WebDriver driver, WebElement sourceElement, WebElement destinationElement) {
        try {

            if(sourceElement.isDisplayed() && sourceElement.isEnabled() && destinationElement.isDisplayed() && destinationElement.isEnabled()) {
                Actions actions = new Actions(driver);
//                Thread.sleep(4000);
                Logger4j.info("Performing drag-and-drop for: " + sourceElement.getText());
                Logger4j.info("Performing drag-and-drop for: " + destinationElement.getText());
                actions.clickAndHold(sourceElement)
                        .moveToElement(destinationElement)
                        .pause(Duration.ofSeconds(2))  // small pause helps
                        .release()
                        .build()
                        .perform();
//                Thread.sleep(4000);  // Give it some time to process the drag-and-drop
                Logger4j.info("Successfully dragged source element to destination.");
            } else {
                Logger4j.info("Either source or destination element is not interactable.");
            }



//            actions.dragAndDrop(source, target).build().perform();
//            Logger4j.info("Dragged element from source: " + source + " to target: " + target);
        } catch (Exception e) {
            Logger4j.error("Failed to drag and drop element.", e);
        }
    }

    /**
     * Drags an element and drops it at a given offset.
     *
     * @param driver  The WebDriver instance.
     * @param source  The element to drag.
     * @param xOffset X offset to drop at.
     * @param yOffset Y offset to drop at.
     */
    public static void dragAndDropByOffset(WebDriver driver, WebElement source, int xOffset, int yOffset) {
        try {
            Actions actions = new Actions(driver);
            actions.dragAndDropBy(source, xOffset, yOffset).build().perform();
            Logger4j.info("Dragged element " + source + " to offset X: " + xOffset + ", Y: " + yOffset);
        } catch (Exception e) {
            Logger4j.error("Failed to drag element by offset.", e);
        }
    }

    /**
     * Clicks and holds an element, moves to target, then releases.
     *
     * @param driver The WebDriver instance.
     * @param source The element to drag.
     * @param target The element to drop onto.
     */
    public static void clickHoldMoveRelease(WebDriver driver, WebElement source, WebElement target) {
        try {
            Actions actions = new Actions(driver);
            actions.clickAndHold(source).moveToElement(target).release().build().perform();
            Logger4j.info("Click-hold moved element from source: " + source + " to target: " + target);
        } catch (Exception e) {
            Logger4j.error("Failed to perform click-hold-move-release.", e);
        }
    }

    public static void dragAndDropHTML5(WebDriver driver, WebElement source, WebElement target) {


        Actions actions = new Actions(driver);
        actions
                .clickAndHold(source)   // click & hold the source block
                .moveToElement(target)  // move to the target block
                .release(target)        // release on target
                .build()
                .perform();
    }

    public static void dragAndDropRobot(WebDriver driver, WebElement source, WebElement target) throws Exception {
        // Scroll both elements into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", source);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", target);

        // Small wait
        Thread.sleep(1000);

        // Get source location
        Point sourceLocation = source.getLocation();
        Dimension sourceSize = source.getSize();
        int sourceX = sourceLocation.getX() + (sourceSize.getWidth() / 2);
        int sourceY = sourceLocation.getY() + (sourceSize.getHeight() / 2);

        // Get target location
        Point targetLocation = target.getLocation();
        Dimension targetSize = target.getSize();
        int targetX = targetLocation.getX() + (targetSize.getWidth() / 2);
        int targetY = targetLocation.getY() + (targetSize.getHeight() / 2);

        // Adjust with browser position
        Point browserPosition = driver.manage().window().getPosition();
        int offsetX = browserPosition.getX();
        int offsetY = browserPosition.getY() + driver.manage().window().getSize().getHeight() - driver.findElement(By.tagName("body")).getRect().getHeight();

        Robot robot = new Robot();
        robot.setAutoDelay(200);

        // Move to source
        robot.mouseMove(sourceX + offsetX, sourceY + offsetY);

        // Click & hold
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);

        // Drag in steps (smoother, avoids skipping)
        int steps = 20;
        for (int i = 0; i < steps; i++) {
            int moveX = sourceX + ((targetX - sourceX) * i / steps);
            int moveY = sourceY + ((targetY - sourceY) * i / steps);
            robot.mouseMove(moveX + offsetX, moveY + offsetY);
            Thread.sleep(30);
        }

        // Release
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

}
