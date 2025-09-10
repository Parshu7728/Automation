package agc_SmokeTc;

import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.agc_pageObject.My_Report;
import com.agc.sel.baseutilities.Asserrtion;
import com.agc.sel.loggers.Logger4j;
import org.testng.annotations.Test;

/**
 * This class contains a smoke test case to verify the functionality of creating
 * a new risk request and navigating to the Padd Page in the application. It
 * extends the BaseClass and uses TestNG annotations for test execution.
 */
public class Create_New_Risk_Request_TC18 extends BaseClass {

	// Object for Assertion
	private Asserrtion assertionCheck = new Asserrtion();

	// Expected result for verifying navigation to the Padd Page
	private static final String expected_Result = "Organization Details";
	/**
	 * Test case to create a new risk request and navigate to the Padd Page.
	 *
	 * @throws Exception if any error occurs during the test execution
	 */
	@Test
	public void createNewRiskRequest() throws Exception {

		// Initialize the My_Report object for handling report-related operations
		My_Report myReport = new My_Report(driver);

		Logger4j.info("Creating a new risk request");
		// Create a new risk request
		myReport.newRiskRequest();
		myReport.create_Request();

		// Verify navigation to the Padd Page by comparing the expected and actual
		// results
		Logger4j.info("Verifying navigation to the Padd Page");
		String actualResult = myReport.verify_PaddPage(driver);
		if (assertionCheck.verification(expected_Result, actualResult)) {
			Logger4j.info("Successfully navigated to Padd Page: " + actualResult);
		} else {
			Logger4j.info("Failed to navigate to Padd Page");
		}

		// Skip organization details if necessary
		myReport.skipOrgDetailss();

		Logger4j.info("Successfully completed navigation to Padd Page");
	}
}
