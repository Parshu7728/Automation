
package agc_SmokeTc;

import com.agc.sel.baseutilities.BaseClass;
import  com.agc.sel.agc_pageObject.Advanced_Chemical_Product_Selector_Hand_Protection;
import  com.agc.sel.agc_pageObject.My_Report;
import  com.agc.sel.agc_pageObject.SortingElements;
import com.agc.sel.loggers.Logger4j;
import org.testng.annotations.Test;

/**
 * This class contains a smoke test case to verify the functionality of sorting
 * chemicals by their physical state in the Advanced Chemical Selector (ACS)
 * module. It extends the BaseClass and uses TestNG annotations for test
 * execution.
 */
public class ACS_Physical_State_Sorting_TC11 extends BaseClass {

	// Object for handling operations in the ACS Hand Protection module
	public Advanced_Chemical_Product_Selector_Hand_Protection acs_Hand_Protection;

	// Object for handling sorting operations
	SortingElements sorting_Elements;

	// Chemical text values retrieved from the properties file
	String chemical_Text1;
	String chemical_Text2;

	/**
	 * Test case to verify the sorting of chemicals by their physical state in the
	 * ACS module.
	 *
	 * @throws Exception if any error occurs during the test execution
	 */
	@Test
	public void acs_PhysicalStateSorting() throws Exception {
		// Perform login using valid credentials
//		LoginAnsellGuardianTC01 loginAnsellGuardian = new LoginAnsellGuardianTC01();
//		loginAnsellGuardian.loginAnsellGuardian_valid_credentials();

		// Retrieve chemical names from the properties file
		chemical_Text1 = prop_utility.chemicalText1();
		chemical_Text2 = prop_utility.chemicalText2();

		Logger4j.info("Initialize the object and perform the rest of the operations");
		// Initialize the ACS Hand Protection, My_Report, and SortingElements objects
		acs_Hand_Protection = new Advanced_Chemical_Product_Selector_Hand_Protection(driver);
		My_Report my_Report = new My_Report(driver);
		sorting_Elements = new SortingElements(driver);

		// Pause execution for 2 seconds
		Thread.sleep(2000);


			// Attempt to execute hamBurger_MyReport
			my_Report.hamBurger_MyReport();
			// If successful, execute ansell_acs_MyReport
			my_Report.ansell_acs_MyReport(driver);

			// Click on the "Agree" button to proceed
			acs_Hand_Protection.agree_Button();

		Logger4j.info("Retrieving chemical names");
		// Retrieve chemical names for sorting
		acs_Hand_Protection.acs_HandProtection_Chemicals(chemical_Text1, chemical_Text2);

		// Retrieve the physical state of the chemicals before sorting
		String chemical_physical_Text1 = sorting_Elements.physicalSort_Compare1();
		String chemical_physical_Text2 = sorting_Elements.physicalSort_Compare2();

		// Log the physical state of the chemicals before sorting
		Logger4j.info("Before Sorting" + " " + chemical_physical_Text1 + " | " + chemical_physical_Text2);

		Logger4j.info("Performing physical state Sorting");
		// Perform physical state sorting
		sorting_Elements.acs_PhysicalSort_Button();
		sorting_Elements.acs_PhysicalSort_Button();

		// Retrieve the physical state of the chemicals after sorting
		String Sorted_chrmical_Physical1 = sorting_Elements.physicalSort_Compare1();
		String Sorted_chrmical_Physical2 = sorting_Elements.physicalSort_Compare2();

		// Log the physical state of the chemicals after sorting
		Logger4j.info("After Sorting" + " " + Sorted_chrmical_Physical1 + " | " + Sorted_chrmical_Physical2);

		// Verify the sorting results
		assertionCheck.verification(chemical_physical_Text1, Sorted_chrmical_Physical2);
		assertionCheck.verification(chemical_physical_Text2, Sorted_chrmical_Physical1);
		Logger4j.info("ACS Physical State Sorting Test Case Passed Successfully");
	}
}
