package com.agc.sel.baseutilities;

import java.awt.*;
import java.awt.event.KeyEvent;

import com.agc.sel.loggers.Logger4j;

public class RobotUtil  {

    Robot robot;
Logger4j Logger4j = new Logger4j();
    public RobotUtil() {
        try {
            robot = new Robot();
            Logger4j.info("Robot initialized successfully.");
        } catch (AWTException e) {
            Logger4j.error("Failed to initialize Robot: " + e.getMessage());
            throw new RuntimeException("Failed to initialize Robot: " + e.getMessage());
        }
    }

    public void scrollToTopQuick() {
        robot.keyPress(KeyEvent.VK_HOME);
        robot.keyRelease(KeyEvent.VK_HOME);
        Logger4j.info("Scrolled to top quickly using HOME key.");
        sleep(500);
    }

    public void scrollToBottom() {
        robot.keyPress(KeyEvent.VK_END);
        robot.keyRelease(KeyEvent.VK_END);
        Logger4j.info("Scrolled to bottom using END key.");
        sleep(500);
    }

    public void pageDown() {
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        Logger4j.info("Page Down pressed.");
        sleep(300);
    }

    public void pageUp() {
        robot.keyPress(KeyEvent.VK_PAGE_UP);
        robot.keyRelease(KeyEvent.VK_PAGE_UP);
        Logger4j.info("Page Up pressed.");
        sleep(300);
    }

    public void mouseScroll(int amount) {
        robot.mouseWheel(amount);
        Logger4j.info("Mouse scrolled by amount: " + amount);
        sleep(300);
    }

    public void scrollUntilEnd() {
        Logger4j.info("Scrolling until end (PAGE_DOWN x 50)...");
        for (int i = 0; i < 50; i++) {
            robot.keyPress(KeyEvent.VK_PAGE_DOWN);
            robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
            sleep(300);
        }
        Logger4j.info("Finished scrolling to end.");
    }

    public void scrollToTop(int n) {
        Logger4j.info("Scrolling to top (PAGE_UP x " + n + ")...");
        for (int i = 0; i < n; i++) {
            robot.keyPress(KeyEvent.VK_PAGE_UP);
            robot.keyRelease(KeyEvent.VK_PAGE_UP);
            sleep(300);
        }
        Logger4j.info("Finished scrolling to top.");
    }
    public void mouseScrollToTop(int scrollSteps) {
        Logger4j.info("Scrolling to top using mouse wheel (" + scrollSteps + " steps)...");

        for (int i = 0; i < scrollSteps; i++) {
            robot.mouseWheel(-1); // -1 means scroll up
            sleep(100);           // small delay between each scroll for stability
        }

        Logger4j.info("Finished scrolling to top using mouse.");
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Logger4j.warn("Sleep interrupted: " + e.getMessage());
        }
    }
}
