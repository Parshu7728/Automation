
package com.agc.sel.baseutilities;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

/**
 * The Random_Number_utilities class provides utility methods for generating
 * random strings and numbers, as well as handling browser window operations
 * using Selenium WebDriver.
 */
public class Random_Number_utilities {

	// WebDriver instance for interacting with the browser
	WebDriver driver;

	/**
	 * Switches the WebDriver to the current browser window using its window handle.
	 *
	 * @throws InterruptedException If the thread is interrupted during execution.
	 */
	public void getWindowHandle() throws InterruptedException {
		String allwid = driver.getWindowHandle();
		driver.switchTo().window(allwid);
	}

	/**
	 * Generates a random alphabetic string of length 8.
	 *
	 * @return A randomly generated alphabetic string.
	 */
	public String random() {
		String generatorstring = RandomStringUtils.randomAlphabetic(8);
		return generatorstring;
	}

	/**
	 * Generates a random numeric string of length 4.
	 *
	 * @return A randomly generated numeric string.
	 */
	public String randomNumber(int num) {
		String generator = RandomStringUtils.randomNumeric(num);
		return generator;
	}
	public String randomNumberWithLength(int num) {
		return RandomStringUtils.randomNumeric(num);
	}

	public String randomPercentage() {
		int percentage = (int) (Math.random() * 100) + 1; // 1–100
		return String.valueOf(percentage);                // convert to String
	}


	public static void selectRandomPhysicalState(WebElement dropdownElement) {
		Select dropdown = new Select(dropdownElement);
		List<WebElement> options = dropdown.getOptions();

		// Avoid selecting first item if it's a placeholder (like "--Select--")
		int startIndex = (options.get(0).getText().contains("Select")) ? 1 : 0;

		Random random = new Random();
		int randomIndex = random.nextInt(options.size() - startIndex) + startIndex;
		dropdown.selectByIndex(randomIndex);
	}

}
