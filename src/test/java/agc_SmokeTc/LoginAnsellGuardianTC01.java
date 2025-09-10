package agc_SmokeTc;

import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.agc_pageObject.Login_Ansell_Guardian;
import com.agc.sel.agc_pageObject.My_Report;
import com.agc.sel.baseutilities.WebWait;
import com.agc.sel.loggers.Logger4j;
import org.testng.annotations.Test;

/**
 * This class contains a smoke test case to verify the login functionality of
 * the Ancell Guardian application with valid credentials. It extends the
 * BaseClass and uses TestNG annotations for test execution.
 */
public class LoginAnsellGuardianTC01 extends BaseClass {

	// Expected title of the "My Reports" page after successful login
	String expected = "My Reports";

	// Utility for handling explicit waits
	WebWait time;

	/**
	 * Test case to verify login functionality with valid credentials.
	 *
	 * @throws Exception if any error occurs during the test execution
	 */
	@Test(groups = "NoLogin")
	public void loginAnsellGuardian_valid_credentials() throws Exception {
		
//		 Load properties containing login credentials
			prop_utility.Property();
			String valid_EmailID = prop_utility.valid_EmailID();
			String valid_Password = prop_utility.valid_Password();
		// Log the initialization of the Login object and retrieval of credentials
		Logger4j.info("Initializing the Login object and retrieving credentials");
		Login_Ansell_Guardian loginAnsellGuardian = new Login_Ansell_Guardian(driver);


		// Validate that the credentials are not null or empty
		Logger4j.info("Checking if the credentials are valid (not null or empty)");
		if (valid_EmailID == null || valid_EmailID.isEmpty() || valid_Password == null || valid_Password.isEmpty()) {
			throw new RuntimeException("Invalid credentials: Email or Password is null or empty.");
		}

		// Perform login with valid credentials
		Logger4j.info("Performing login with valid credentials");
		loginAnsellGuardian.login_With_Valid(valid_EmailID, valid_Password);
		Logger4j.info("Logged in Successfully");

		// Verify the title on the "My Reports" page
		Logger4j.info("Verifying the title on the My Reports page");
		My_Report my_Report = new My_Report(driver);
		String actual = my_Report.myReport_Title_verification();

		// Validate the result by comparing the expected and actual titles
		Logger4j.info("Validating the log result");
		if(assertionCheck.verification(expected, actual)){
			Logger4j.info("My reports page title verification passed");
		}
		else{
			Logger4j.warn("My reports page title verification failed");
		}
		my_Report.logout();
	}
}
