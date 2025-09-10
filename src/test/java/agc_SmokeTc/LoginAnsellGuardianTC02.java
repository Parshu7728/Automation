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
public class LoginAnsellGuardianTC02 extends BaseClass {

	@Test(groups = "NoLogin")
	public void loginAnsellGuardian_InvalidPassword_Credentials() throws Exception {
	    // Log the initialization of the Login object and retrieval of credentials
	    Logger4j.info("Initializing the Login object and retrieving credentials");
	    Login_Ansell_Guardian loginAnsellGuardian = new Login_Ansell_Guardian(driver);

	    // Load properties containing login credentials
	    prop_utility.Property();

	    // Retrieve valid email and invalid password from properties
	    String validEmailID = prop_utility.valid_EmailID();
	    String invalidPassword = prop_utility.invalid_Password();

	    // Perform login with valid email and invalid password
	    Logger4j.info("Performing login with invalid password credentials");
	    loginAnsellGuardian.login_With_Valid(validEmailID, invalidPassword);

	    // Retrieve the actual error message displayed on the login page
	    String actual = loginAnsellGuardian.login_Error().trim();
	    Logger4j.info("Actual error message: " + actual);

	    // Define the expected messages
	    String expected1 = "invalid user name/password, 3 attempts remaining";
	    String expected2 = "invalid user name/password, 2 attempts remaining";
	    String expected3 = "invalid user name/password, 1 attempts remaining";

	    // Validate the error message
	    Logger4j.info("Validating the login result");
		if (actual.equals(expected1) || actual.equals(expected2) || actual.equals(expected3)) {
			Logger4j.info("Login failed as expected with message: " + actual);
		} else {
			Logger4j.error("Login did not fail as expected. Actual message: " + actual);
		}
	
	}}
