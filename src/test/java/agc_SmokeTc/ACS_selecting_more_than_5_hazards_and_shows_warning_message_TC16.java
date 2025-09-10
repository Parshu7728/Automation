package agc_SmokeTc;

import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.agc_pageObject.Advanced_Chemical_Product_Selector_Hand_Protection;
import com.agc.sel.agc_pageObject.My_Report;
import com.agc.sel.loggers.Logger4j;
import org.testng.annotations.Test;

/**
 * This class contains a smoke test case to verify the functionality of
 * selecting more than 5 hazards in the Advanced Chemical Selector (ACS) module
 * and ensuring that a warning message is displayed. It extends the BaseClass
 * and uses TestNG annotations for test execution.
 */
public class ACS_selecting_more_than_5_hazards_and_shows_warning_message_TC16 extends BaseClass {

	// Object for handling operations in the ACS Hand Protection module
	public Advanced_Chemical_Product_Selector_Hand_Protection acs_Hand_Protection;

	// Object for handling report-related operations
	public My_Report my_Report;

	/**
	 * Test case to verify the warning message when selecting more than 5 hazards in
	 * the ACS module.
	 *
	 * @throws Exception if any error occurs during the test execution
	 */
	@Test
	public void acs_Selecting_MoreThan5Hazards_And_Shows_WarningMessage() throws Exception {
		// Perform login using valid credentials
//		LoginAnsellGuardianTC01 loginAnsellGuardian = new LoginAnsellGuardianTC01();
//		loginAnsellGuardian.loginAnsellGuardian_valid_credentials();

		Logger4j.info("Initialize the object and perform the rest of the operations");
		// Initialize the ACS Hand Protection and My_Report objects
		acs_Hand_Protection = new Advanced_Chemical_Product_Selector_Hand_Protection(driver);
		My_Report my_Report = new My_Report(driver);

		// Pause execution for 2 seconds
		Thread.sleep(2000);

		Logger4j.info("Click on Hamburger menu and My Report");
		// Navigate to the "My Report" section via the Hamburger menu
		my_Report.hamBurger_MyReport();
		my_Report.ansell_acs_MyReport(driver);

		Logger4j.info("Click on the Agree button");
		// Click on the "Agree" button to proceed
		acs_Hand_Protection.agree_Button();

		// Perform the operation to select more than 5 hazards and trigger the warning
		// message
		acs_Hand_Protection.moreThan_5_Hazards();
	}
}
