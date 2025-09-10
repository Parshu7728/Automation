package com.agc.sel.agc_pageObject;

import com.agc.sel.baseutilities.ApplicationLoader;
import com.agc.sel.baseutilities.WebWait;
import com.agc.sel.loggers.Logger4j;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;


public class Login_Ansell_Guardian {
	public static Logger4j log;
	WebWait time;
	private WebDriver driver; // Add driver as an instance variable

	@FindBy(xpath = "//button[text()='Accept All']")
	private WebElement accept_Cookies;

	@FindBy(xpath = "//span[text()='Sign in / Register']")
	private WebElement signIn_Register;

	@FindBy(id = "username")
	private WebElement email_TextField;

	@FindBy(id = "password")
	private WebElement password_TextField;

	@FindBy(id = "signIn")
	private WebElement signIn_Button;

	@FindBy(id = "login-msg-block")
	private WebElement signIn_Error;

	@FindBy(xpath = "(//span[@class='required'])[6]")
	private WebElement signIn_Error_Empty_Password;

	public Login_Ansell_Guardian(WebDriver driver) {
		this.driver = driver; // Initialize driver
		this.time = new WebWait(driver);
		PageFactory.initElements(driver, this);
	}

	public void signInRegister() {
		time.visibilityOf(signIn_Register);
		signIn_Register.click();
	}
	
	
	public void login_With_Valid(String emailId, String password) throws InterruptedException, AWTException {
		cookies_Handle();
		signInRegister();
		Logger4j.info("successfully clicked on signin button");
		time.elementToBeClickable(email_TextField);
		email_TextField.sendKeys(emailId+ Keys.TAB);
		Logger4j.info("successfully entered email in emailtext text field ");
		time.elementToBeClickable(password_TextField);
		password_TextField.click();
		password_TextField.sendKeys(password);
		Logger4j.info("successfully entered password in password text field ");
		signIn_Button.click();
		Logger4j.info("successfully clicked on login button and navigated to My report page");
	}

	public void login_With_InValid(String un) throws InterruptedException, AWTException {
		cookies_Handle();
		signInRegister();
		Logger4j.info("successfully clicked on signin button");
		time.elementToBeClickable(email_TextField);
		email_TextField.sendKeys(un+ Keys.TAB);
		Logger4j.info("successfully entered email on email textfield");
	}

	public String login_Error() throws AWTException {
		String error_text = signIn_Error.getText();
		Logger4j.info("signInError");
		return error_text;
	}

	public String login_Error2() throws AWTException {
		String error_text = signIn_Error_Empty_Password.getText();
		Logger4j.info("signInError");
		return error_text;
	}

	public void cookies_Handle() {
		Logger4j.info("Handling cookies acceptance if present.");
		waitForApplicationLoad(accept_Cookies);
		    try {
				if (accept_Cookies.isDisplayed() && accept_Cookies.isEnabled()) {
					Logger4j.info("Cookies button is displayed and enabled, proceeding to click.");
					// Wait until the element is clickable before clicking
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
					wait.until(ExpectedConditions.elementToBeClickable(accept_Cookies));
					Thread.sleep(5000); // Optional: wait for 5 seconds before clicking
		            accept_Cookies.click();
		            Logger4j.info("Cookies accepted successfully");
		        }
		    } catch (org.openqa.selenium.NoSuchElementException e) {
		        // Handle case where the cookies button might not be present
		        Logger4j.info("Cookies button not found, possibly already accepted.");
		    } catch (Exception e) {
		        // Catch any other exception during the process
		        Logger4j.info("An error occurred while handling cookies.");
		    }
		}
	
	public void waitForApplicationLoad(WebElement element) {
		ApplicationLoader appLoader = new ApplicationLoader(driver);
		appLoader.waitForApplicationToLoad(element);
	}
}
