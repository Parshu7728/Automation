package agc_SmokeTc;

import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.agc_pageObject.Advanced_Chemical_Product_Selector_Hand_Protection;
import com.agc.sel.agc_pageObject.My_Report;
import com.agc.sel.agc_pageObject.SortingElements;
import com.agc.sel.loggers.Logger4j;
import org.testng.annotations.Test;

/**
 * This class contains a smoke test case to verify the functionality of
 * disabling the chemical tab in the Advanced Chemical Selector (ACS) module. It
 * extends the BaseClass and uses TestNG annotations for test execution.
 */
public class ACS_chemical_tab_Disable_TC15 extends BaseClass {

	// Object for handling operations in the ACS Hand Protection module
	public Advanced_Chemical_Product_Selector_Hand_Protection acs_Hand_Protection;

	// Object for handling sorting operations
	SortingElements sorting_Elements;

	// Object for handling report-related operations
	public My_Report my_Report;

	/**
	 * Test case to verify the disabling of the chemical tab in the ACS module.
	 *
	 * @throws Exception if any error occurs during the test execution
	 */
	@Test
	public void acs_Chemical_Tab_Disable() throws Exception {
		// Perform login using valid credentials
//		LoginAnsellGuardianTC01 loginAnsellGuardian = new LoginAnsellGuardianTC01();
//		loginAnsellGuardian.loginAnsellGuardian_valid_credentials();

		Logger4j.info("Initialize the object and perform the rest of the operations");
		// Initialize the ACS Hand Protection, My_Report, and SortingElements objects
		acs_Hand_Protection = new Advanced_Chemical_Product_Selector_Hand_Protection(driver);
		my_Report = new My_Report(driver);
		sorting_Elements = new SortingElements(driver);

		Logger4j.info("Click on Hamburger menu and My Report");
		// Navigate to the "My Report" section via the Hamburger menu
		my_Report.hamBurger_MyReport();
		my_Report.ansell_acs_MyReport(driver);

		Logger4j.info("Click on the Agree button");
		// Click on the "Agree" button to proceed
		acs_Hand_Protection.agree_Button();

		// Verify that the chemical tab is disabled
		acs_Hand_Protection.chemical_Tab_DisableCheck();

	}
}
