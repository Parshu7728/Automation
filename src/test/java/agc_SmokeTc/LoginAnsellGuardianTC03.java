package agc_SmokeTc;


import com.agc.sel.agc_pageObject.Login_Ansell_Guardian;
import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.loggers.Logger4j;
import org.testng.annotations.Test;

/**
 * This class contains a smoke test case to verify the login functionality of
 * the Ancell Guardian application with an invalid email ID. It extends the
 * BaseClass and uses TestNG annotations for test execution.
 */
public class LoginAnsellGuardianTC03 extends BaseClass {

	// Expected error message when attempting login with an invalid email ID
	String expected = "Please enter a valid Email Id";

	/**
	 * Test case to verify login functionality with an invalid email ID.
	 *
	 * @throws Exception if any error occurs during the test execution
	 */
	@Test(groups = "NoLogin")
	public void loginAnsellGuardian_InvalidEmailId() throws Exception {
		// Log the initialization of the Login object and retrieval of credentials
		Logger4j.info("Initializing the Login object and retrieving credentials");

		// Initialize Login object and retrieve credentials
		Login_Ansell_Guardian loginAnsellGuardian = new Login_Ansell_Guardian(driver);
		prop_utility.Property();
		String Invalid_EmailID = prop_utility.invalid_EmailID();

		// Perform login with invalid email credential
		Logger4j.info("Performing login with invalid emailId credentials");
		loginAnsellGuardian.login_With_InValid(Invalid_EmailID);

		// Retrieve the actual error message displayed on the login page
		String actual = loginAnsellGuardian.login_Error();
		Logger4j.info("Login failed as expected with message: " + expected);
		// Verify the error message matches the expected result
		Logger4j.info("Validating the log result");
		assertionCheck.verification(expected, actual);
		Logger4j.info("Login failed as actual with message: " + actual);
	
	}
}
