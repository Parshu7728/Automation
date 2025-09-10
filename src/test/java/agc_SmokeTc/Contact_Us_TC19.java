package agc_SmokeTc;

import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.agc_pageObject.My_Report;
import com.agc.sel.baseutilities.WebWait;
import org.testng.annotations.Test;

/**
 * This class contains a smoke test case to verify the "Contact Us"
 * functionality in the application. It extends the BaseClass and uses TestNG
 * annotations for test execution.
 */
public class Contact_Us_TC19 extends BaseClass {

	// Expected text to verify the "Contact Us" functionality
	String expectedText = "Contact Us";

	// Utility object for handling explicit waits
	WebWait time;

	// Text message to be sent in the "Contact Us" form
	String text = "Hi";

	/**
	 * Test case to verify the "Contact Us" functionality.
	 *
	 * @throws Throwable if any error occurs during the test execution
	 */
	@Test
	public void contact_US() throws Throwable {

		// Initialize the My_Report object for handling "Contact Us" operations
		My_Report my_Report = new My_Report(driver);

		// Send a message using the "Contact Us" form
		my_Report.contactUs(text);

		// Retrieve the actual text displayed after submitting the form
		String actualText = my_Report.contacttext();

		// Verify the actual text matches the expected text
		assertionCheck.verification(expectedText, actualText);
	}
}
