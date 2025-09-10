package com.agc.sel.baseutilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.agc.sel.loggers.Logger4j;

import java.util.List;
import java.util.Random;

public class DropdownUtil {

    /**
     * Selects an option from a dropdown by visible text.
     *
     * @param dropdownElement The WebElement representing the dropdown.
     * @param visibleText     The visible text of the option to select.
     */
    public static void selectByVisibleText(WebElement dropdownElement, String visibleText) {
        try {
            Select select = new Select(dropdownElement);
            select.selectByVisibleText(visibleText);
            Logger4j.info("Selected option by visible text: " + visibleText);
        } catch (Exception e) {
            Logger4j.error("Failed to select option by visible text: " + visibleText, e);
        }
    }

    /**
     * Selects an option from a dropdown by index.
     *
     * @param dropdownElement The WebElement representing the dropdown.
     * @param index           The index of the option to select (0-based).
     */
    public static void selectByIndex(WebElement dropdownElement, int index) {
        try {
            Select select = new Select(dropdownElement);
            select.selectByIndex(index);
            Logger4j.info("Selected option by index: " + index);
        } catch (Exception e) {
            Logger4j.error("Failed to select option by index: " + index, e);
        }
    }

    /**
     * Selects a random option from the dropdown.
     * Skips "Select" placeholder if present.
     *
     * @param dropdownElement The WebElement representing the dropdown.
     */
    public static void selectRandomOption(WebElement dropdownElement) {
        try {
            Select select = new Select(dropdownElement);
            List<WebElement> options = select.getOptions();

            // Remove placeholder if it contains "Select"
            if (!options.isEmpty() && options.get(0).getText().trim().toLowerCase().contains("select")) {
                options.remove(0);
            }

            if (!options.isEmpty()) {
                Random random = new Random();
                int randomIndex = random.nextInt(options.size());
                String selectedText = options.get(randomIndex).getText();
                select.selectByVisibleText(selectedText);
                Logger4j.info("Randomly selected option: " + selectedText);
            } else {
                Logger4j.warn("No valid options found to select randomly.");
            }
        } catch (Exception e) {
            Logger4j.error("Failed to select a random option.", e);
        }
    }

}
