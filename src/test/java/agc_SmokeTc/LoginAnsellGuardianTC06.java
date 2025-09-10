package agc_SmokeTc;

import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.agc_pageObject.Login_Ansell_Guardian;
import com.agc.sel.loggers.Logger4j;
import org.testng.annotations.Test;

/**
 * This class contains a smoke test case to verify the login functionality of
 * the Ancell Guardian application with a valid email and an empty password. It
 * extends the BaseClass and uses TestNG annotations for test execution.
 */
public class LoginAnsellGuardianTC06 extends BaseClass {

	// Expected error message when attempting login with an empty password
	String expected = "This field is required";

	/**
	 * Test case to verify login functionality with a valid email and an empty
	 * password.
	 *
	 * @throws Exception if any error occurs during the test execution
	 */
	@Test(groups = "NoLogin")
	public void loginAnsellGuardian_WithEmaptyPassword() throws Exception {

		// Initialize the Login object and retrieve properties
		Login_Ansell_Guardian loginAnsellGuardian = new Login_Ansell_Guardian(driver);
		prop_utility.Property();

		// Perform login with valid email and empty password credentials
		String valid_EmailID = prop_utility.valid_EmailID();
		String empty_Password = prop_utility.empty_Password();
		loginAnsellGuardian.login_With_Valid(valid_EmailID, empty_Password);

		// Retrieve the actual error message displayed on the login page
		String actual = loginAnsellGuardian.login_Error2();
		Logger4j.info("Login failed as expected with message: " + expected);

		// Verify the error message matches the expected result
		assertionCheck.verification(expected, actual);
		Logger4j.info("Login failed as actual with message: " + actual);
	
	}
}
