package Login_MonkeyTesting;

import org.testng.annotations.Test;
import agc_SmokeTc.LoginAnsellGuardianTC01;
import agc_SmokeTc.LoginAnsellGuardianTC02;
import agc_SmokeTc.LoginAnsellGuardianTC03;
import agc_SmokeTc.LoginAnsellGuardianTC04;
import agc_SmokeTc.LoginAnsellGuardianTC05;
import agc_SmokeTc.LoginAnsellGuardianTC06;
import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.baseutilities.WebWait;

/**
 * This class contains regression test cases for the login functionality of the
 * Ancell Guardian application. It extends the BaseClass and uses TestNG
 * annotations for test execution.
 */
public class Login_Regression_TestSuite extends BaseClass {
	// Utility for handling explicit waits
	WebWait time;

	/**
	 * Test case to verify login functionality with valid credentials.
	 *
	 * @throws Exception if any error occurs during the test execution
	 */
	@Test(priority = 1,groups = "NoLogin")
	public void loginAncellGurdian_valid_credentials() throws Exception {
		LoginAnsellGuardianTC01 loginAnsellGuardian = new LoginAnsellGuardianTC01();
		loginAnsellGuardian.loginAnsellGuardian_valid_credentials();
	}

	/**
	 * Test case to verify login functionality with a valid email and an invalid
	 * password.
	 *
	 * @throws Exception if any error occurs during the test execution
	 */
	@Test(priority = 2,groups = "NoLogin")
	public void LoginAncellGurdian_Invalid_password_credential() throws Exception {
		LoginAnsellGuardianTC02 loginAnsellGuardian = new LoginAnsellGuardianTC02();
		loginAnsellGuardian.loginAnsellGuardian_InvalidPassword_Credentials();
	}

	/**
	 * Test case to verify login functionality with an invalid email.
	 *
	 * @throws Exception if any error occurs during the test execution
	 */
	@Test(priority = 3,groups = "NoLogin")
	public void LoginAncellGurdian_invalid_emailId() throws Exception {
		LoginAnsellGuardianTC03 loginAnsellGuardian = new LoginAnsellGuardianTC03();
		loginAnsellGuardian.loginAnsellGuardian_InvalidEmailId();
	}

	/**
	 * Test case to verify login functionality with an invalid new email.
	 *
	 * @throws Exception if any error occurs during the test execution
	 */
	@Test(priority = 4,groups = "NoLogin")
	public void login_ancell_gurdian_Ivalid_New_emailId() throws Exception {
		LoginAnsellGuardianTC04 loginAnsellGuardian = new LoginAnsellGuardianTC04();
		loginAnsellGuardian.loginAnsellGuardian_Invalid_NewEmailId();
	}

	/**
	 * Test case to verify login functionality with an empty email.
	 *
	 * @throws Exception if any error occurs during the test execution
	 */
	@Test(priority = 5,groups = "NoLogin")
	public void login_ancell_gurdian_empty_mail() throws Exception {
		LoginAnsellGuardianTC05 loginAnsellGuardian = new LoginAnsellGuardianTC05();
		loginAnsellGuardian.loginAnsellGuardian_EmptyMail();
	}

	/**
	 * Test case to verify login functionality with a valid email and an empty
	 * password.
	 *
	 * @throws Exception if any error occurs during the test execution
	 */
	@Test(priority = 6,groups = "NoLogin")
	public void login_AnsellGurdian_EmaptyPassword() throws Exception {
		LoginAnsellGuardianTC06 loginAnsellGuardian = new LoginAnsellGuardianTC06();
		loginAnsellGuardian.loginAnsellGuardian_WithEmaptyPassword();
	}
}
