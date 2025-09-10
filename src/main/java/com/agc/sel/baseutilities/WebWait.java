
package com.agc.sel.baseutilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * The WebWait class provides utility methods for implementing explicit waits in
 * Selenium WebDriver. It includes methods to wait for the visibility of
 * elements and for elements to become clickable.
 */
public class WebWait {

	// WebDriver instance for interacting with the browser
	WebDriver driver;

    public WebWait(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
    }

    /**
	 * Waits until the specified WebElement is visible on the page.
	 *
	 * @param Ele The WebElement to wait for.
	 */
	public void visibilityOf(WebElement Ele) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(20));
		w.until(ExpectedConditions.visibilityOf(Ele));
	}

	public void visibilityOfAll(List <WebElement> ele){
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		w.until(ExpectedConditions.visibilityOfAllElements(ele));
	}
	/**
	 * Waits until the specified WebElement is clickable on the page.
	 *
	 * @param Ele The WebElement to wait for.
	 */
	public void elementToBeClickable(WebElement element) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		w.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void waitAndClick(WebElement element) {
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(30));
		w.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	public String waitAndGetText(WebElement element) {
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(30));
		return w.until(ExpectedConditions.visibilityOf(element)).getText();
	}

	public void waitAndSendKeys(WebElement element, String text) {
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(30));
		w.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
	}
	public void invisibilityof(WebElement element){
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(30));
		w.until(ExpectedConditions.invisibilityOf(element));
	}


	/**
	 * Waits until the specified WebElement contains the expected text.
	 */
	public void textToBePresentInElement(WebElement element, String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	/**
	 * Waits until the specified WebElement is selected.
	 */
	public void elementToBeSelected(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}

	/**
	 * Waits until a frame is available and switches to it.
	 */
	public void frameToBeAvailableAndSwitchToIt(WebElement frameElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
	}

	/**
	 * Waits until a specific attribute of an element contains the expected value.
	 */
	public void attributeContains(WebElement element, String attribute, String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.attributeContains(element, attribute, value));
	}

	/**
	 * Waits until an element is present in the DOM (not necessarily visible).
	 */
	public void presenceOfElement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public void waitUntilTextChanges(WebElement element, String oldText) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.not(
				ExpectedConditions.textToBePresentInElement(element, oldText)
		));
	}
	public boolean fluentWaitForText(WebElement element, String expectedText, int timeoutSec, int pollingSec) {
		FluentWait<WebDriver> wait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(timeoutSec))
				.pollingEvery(Duration.ofSeconds(pollingSec))
				.ignoring(NoSuchElementException.class);

		return wait.until(driver -> element.getText().contains(expectedText));
	}
	public WebElement waitForOptionalVisibility(WebElement element, int timeoutSec, int pollingSec) {
		try {
			FluentWait<WebDriver> wait = new FluentWait<>(driver)
					.withTimeout(Duration.ofSeconds(timeoutSec))
					.pollingEvery(Duration.ofSeconds(pollingSec))
					.ignoring(Exception.class);

			return wait.until(driver -> element.isDisplayed() ? element : null);
		} catch (Exception e) {
			return null; // if not visible in given time
		}
	}
}
