package com.agc.sel.baseutilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

/**
 * The Assertion class provides utility methods for performing
 * basic hard and soft assertions in Selenium-based test automation.
 */
public class Asserrtion {

	// WebDriver instance used for interacting with the browser
	WebDriver driver;

	// SoftAssert instance for soft assertions
	private static SoftAssert softAssert = new SoftAssert();

	/**
	 * Verifies if the expected value matches the actual value (Custom Boolean Check).
	 *
	 * @param expected The expected value as a String.
	 * @param actual   The actual value as a String.
	 * @return true if the expected value matches the actual value, false otherwise.
	 */
	public static boolean verification(String expected, String actual) {
		return expected.equals(actual);
	}

	/**
	 * Hard Assertion: Verifies that two strings are equal.
	 */
	public static void assertEquals(String actual, String expected, String message) {
		Assert.assertEquals(actual, expected, message);
	}

	/**
	 * Hard Assertion: Verifies that a condition is true.
	 */
	public static void assertTrue(boolean condition, String message) {
		Assert.assertTrue(condition, message);
	}

	/**
	 * Hard Assertion: Verifies that a condition is false.
	 */
	public static void assertFalse(boolean condition, String message) {
		Assert.assertFalse(condition, message);
	}

	/**
	 * Soft Assertion: Verifies that two strings are equal.
	 */
	public static void softAssertEquals(String actual, String expected, String message) {
		softAssert.assertEquals(actual, expected, message);
	}

	/**
	 * Soft Assertion: Verifies that a condition is true.
	 */
	public static void softAssertTrue(boolean condition, String message) {
		softAssert.assertTrue(condition, message);
	}

	/**
	 * Soft Assertion: Verifies that a condition is false.
	 */
	public static void softAssertFalse(boolean condition, String message) {
		softAssert.assertFalse(condition, message);
	}

	public static void softAssertElementDisplayed(WebElement element, String message) {
		softAssert.assertTrue(element.isDisplayed(), message);
	}

	/**
	 * Call this at the end of the test to assert all soft assertions.
	 */
	public static void assertAll() {
		softAssert.assertAll();
	}


	public static void verification(boolean b, boolean b1, String faqRowsShouldBePresent) {
		Assert.assertEquals(b, b1, faqRowsShouldBePresent);
	}

	public void assertEquals(int totalcount, int expected, String paginationCountMismatch) {
		Assert.assertEquals(totalcount, expected, paginationCountMismatch);
	}
}
