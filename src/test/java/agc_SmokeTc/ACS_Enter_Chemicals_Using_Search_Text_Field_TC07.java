package agc_SmokeTc;

import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.agc_pageObject.Advanced_Chemical_Product_Selector_Hand_Protection;
import com.agc.sel.agc_pageObject.My_Report;
import com.agc.sel.loggers.Logger4j;
import org.testng.annotations.Test;

/**
 * This class contains a smoke test case to verify the functionality of adding
 * chemicals using the search text field in the Advanced Chemical Selector (ACS)
 * module. It extends the BaseClass and uses TestNG annotations for test
 * execution.
 */
public class ACS_Enter_Chemicals_Using_Search_Text_Field_TC07 extends BaseClass {

	// Chemical text values retrieved from the properties file
	public String chemical_Text1;
	public String chemical_Text2;

	// Object for handling operations in the ACS Hand Protection module
	public Advanced_Chemical_Product_Selector_Hand_Protection acs_Hand_Protection;

	/**
	 * Test case to add chemicals using the search text field in the ACS module.
	 *
	 * @throws Exception if any error occurs during the test execution
	 */
	@Test
	public void acs_Add_Chemicals_Using_Search_Text_Field() throws Exception {
		// Perform login using valid credentials
//		LoginAnsellGuardianTC01 loginAnsellGuardian = new LoginAnsellGuardianTC01();
//		loginAnsellGuardian.loginAnsellGuardian_valid_credentials();

		Logger4j.info("Initialize the object and perform the rest of the operations");
		// Initialize the ACS Hand Protection and My_Report objects
		acs_Hand_Protection = new Advanced_Chemical_Product_Selector_Hand_Protection(driver);
		My_Report my_Report = new My_Report(driver);

			// Attempt to execute hamBurger_MyReport
			my_Report.hamBurger_MyReport();
			// If successful, execute ansell_acs_MyReport
			my_Report.ansell_acs_MyReport(driver);

			// Click on the "Agree" button to proceed
			acs_Hand_Protection.agree_Button();



		Logger4j.info("Retrieving chemical names");
		// Retrieve chemical names from the properties file
		chemical_Text1 = prop_utility.chemicalText1();
		chemical_Text2 = prop_utility.chemicalText2();

		// Add the retrieved chemicals to the ACS module using the search text field
		acs_Hand_Protection.acs_HandProtection_Chemicals(chemical_Text1, chemical_Text2);
		Logger4j.info("Successfully added chemicals using the search text field");
	}
}
