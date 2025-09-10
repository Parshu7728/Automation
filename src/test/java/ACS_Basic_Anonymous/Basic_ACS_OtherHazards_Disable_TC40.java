package ACS_Basic_Anonymous;

import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.agc_pageObject.Advanced_Chemical_Product_Selector_Hand_Protection;
import com.agc.sel.agc_pageObject.My_Report;
import com.agc.sel.loggers.Logger4j;
import org.testng.annotations.Test;

public class Basic_ACS_OtherHazards_Disable_TC40 extends BaseClass {
    // Object for handling operations in the ACS Hand Protection module
    public Advanced_Chemical_Product_Selector_Hand_Protection acs_Hand_Protection;

    // Object for handling report-related operations
    public My_Report my_Report;

    /**
     * Test case to verify the disabling of other hazards in the ACS module.
     *
     * @throws Exception if any error occurs during the test execution
     */
    @Test(groups = "basic")
    public void acs_OtherHazards_Disable() throws Exception {
        // Perform login using valid credentials
//		LoginAnsellGuardianTC01 loginAnsellGuardian = new LoginAnsellGuardianTC01();
//		loginAnsellGuardian.loginAnsellGuardian_valid_credentials();

        // Retrieve chemical names from the properties file
        String chemical_Text1 = prop_utility.chemicalText1();
        String chemical_Text2 = prop_utility.chemicalText2();
        Logger4j.info("Initialize the object and perform the rest of the operations");
        // Initialize the ACS Hand Protection and My_Report objects
        acs_Hand_Protection = new Advanced_Chemical_Product_Selector_Hand_Protection(driver);
        My_Report my_Report = new My_Report(driver);
        my_Report.acs_MyReport(driver);
        // Perform operations to handle specific chemicals in ACS
        acs_Hand_Protection.acs_HandProtection_Chemicals(chemical_Text1, chemical_Text2);


        // Navigate to the "Other Hazards" tab in the ACS module
        acs_Hand_Protection.otherHazards_Tab();
    }
}
