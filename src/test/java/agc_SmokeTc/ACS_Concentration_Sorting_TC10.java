package agc_SmokeTc;

import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.agc_pageObject.Advanced_Chemical_Product_Selector_Hand_Protection;
import com.agc.sel.agc_pageObject.My_Report;
import com.agc.sel.agc_pageObject.SortingElements;
import com.agc.sel.loggers.Logger4j;
import org.testng.annotations.Test;

/**
 * This class contains a smoke test case to verify the functionality of sorting
 * chemicals by their concentration in the Advanced Chemical Selector (ACS)
 * module. It extends the BaseClass and uses TestNG annotations for test
 * execution.
 */
public class ACS_Concentration_Sorting_TC10 extends BaseClass {

	// Chemical text values retrieved from the properties file
	public String chemical_Text1;
	public String chemical_Text2;

	// Object for handling operations in the ACS Hand Protection module
	public Advanced_Chemical_Product_Selector_Hand_Protection acs_Hand_Protection;

	// Object for handling sorting operations
	SortingElements sorting_Elements;

	/**
	 * Test case to verify the sorting of chemicals by their concentration in the
	 * ACS module.
	 *
	 * @throws Exception if any error occurs during the test execution
	 */
	@Test
	public void acs_Concentration_Sorting() throws Exception {
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

		// Retrieve the concentration of the chemicals before sorting
		String chemical_concentration_Text1 = sorting_Elements.concentrationSort_Compare1();
		String chemical_concentration_Text2 = sorting_Elements.concentrationSort_Compare2();

		// Pause execution for 2 seconds
		Thread.sleep(2000);

		// Log the concentration of the chemicals before sorting
		Logger4j.info("Before Conc Sorting" + " " + chemical_concentration_Text1 + " | " + chemical_concentration_Text2);

		Logger4j.info("Performing concentration sorting");
		// Perform concentration sorting
		sorting_Elements.acs_ConcentrationSort_Button();

		// Retrieve the concentration of the chemicals after sorting
		String Sorted_chemical_Concentration1 = sorting_Elements.concentrationSort_Compare1();
		String Sorted_chemical_Concentration2 = sorting_Elements.concentrationSort_Compare2();

		// Log the concentration of the chemicals after sorting
		Logger4j.info("After Conc Sorting" + " " + Sorted_chemical_Concentration1 + " | " + Sorted_chemical_Concentration2);

		// Verify the sorting results
		assertionCheck.verification(chemical_concentration_Text1, Sorted_chemical_Concentration2);
		assertionCheck.verification(chemical_concentration_Text2, Sorted_chemical_Concentration1);
		Logger4j.info("Concentration sorting test case executed successfully.");
	}
}
