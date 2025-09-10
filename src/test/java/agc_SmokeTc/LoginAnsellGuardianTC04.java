package agc_SmokeTc;

import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.agc_pageObject.Login_Ansell_Guardian;
import com.agc.sel.loggers.Logger4j;
import org.testng.annotations.Test;

/**
 * This class contains a smoke test case to verify the login functionality of
 * the Ancell Guardian application with an invalid new email ID. It extends the
 * BaseClass and uses TestNG annotations for test execution.
 */
public class LoginAnsellGuardianTC04 extends BaseClass {

	// Expected error message when attempting login with an invalid new email ID
	String expected = "We could not find this email address. Try another one or Register";

	/**
	 * Test case to verify login functionality with an invalid new email ID.
	 *
	 * @throws Exception if any error occurs during the test execution
	 */
	@Test(groups = "NoLogin")
	public void loginAnsellGuardian_Invalid_NewEmailId() throws Exception {

		// Log the initialization of the Login object and retrieval of credentials
		Logger4j.info("Initializing the Login object and retrieving credentials");

		// Initialize Login object and retrieve credentials
		Login_Ansell_Guardian loginAnsellGuardian = new Login_Ansell_Guardian(driver);
		prop_utility.Property();

		// Perform login with invalid new email credential
		Logger4j.info("Performing login with invalid new email ID credentials");
		String invalid_NewEmailID = prop_utility.invalid_NewEmailID();
		loginAnsellGuardian.login_With_InValid(invalid_NewEmailID);

		// Verify the error on the "Login" page
		String actual = loginAnsellGuardian.login_Error();
		Logger4j.info("Login failed as expected with message: " + expected);
		// Validate the result by comparing the expected and actual error messages
		Logger4j.info("Validating the log result");
		assertionCheck.verification(expected, actual);
		Logger4j.info("Login failed as actual with message: " + actual);
	
	}
}
