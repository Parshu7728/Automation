package agc_SmokeTc;

import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.agc_pageObject.Login_Ansell_Guardian;
import com.agc.sel.loggers.Logger4j;
import org.testng.annotations.Test;

/**
 * This class contains a smoke test case to verify the login functionality of
 * the Ancell Guardian application with an empty email field. It extends the
 * BaseClass and uses TestNG annotations for test execution.
 */
public class LoginAnsellGuardianTC05 extends BaseClass {

	// Expected error message when attempting login with an empty email field
	String expected = "Please enter a valid Email Id";

	/**
	 * Test case to verify login functionality with an empty email field.
	 *
	 * @throws Exception if any error occurs during the test execution
	 */
	@Test(groups = "NoLogin")
	public void loginAnsellGuardian_EmptyMail() throws Exception {
		// Log the initialization of the Login object and retrieval of credentials
		Logger4j.info("Initializing the Login object and retrieving credentials");

		// Initialize Login object and retrieve properties
		Login_Ansell_Guardian loginloginAnsellGuardian = new Login_Ansell_Guardian(driver);
		prop_utility.Property();

		// Perform login with an empty email credential
		Logger4j.info("Performing login with empty email credentials");
		String empty_Email = prop_utility.empty_Email();
		loginloginAnsellGuardian.login_With_InValid(empty_Email);

		// Retrieve the actual error message displayed on the login page
		String actual = loginloginAnsellGuardian.login_Error();
		Logger4j.info("Login failed as expected with message: " + expected);

		// Verify the error message matches the expected result
		Logger4j.info("Validating the log result");
		assertionCheck.verification(expected, actual);
		Logger4j.info("Login failed as actual with message: " + actual);
	
	}
}
