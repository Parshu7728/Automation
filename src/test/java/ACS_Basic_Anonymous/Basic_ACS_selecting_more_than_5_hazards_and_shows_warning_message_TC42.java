package ACS_Basic_Anonymous;

import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.agc_pageObject.Advanced_Chemical_Product_Selector_Hand_Protection;
import com.agc.sel.agc_pageObject.My_Report;
import com.agc.sel.loggers.Logger4j;
import org.testng.annotations.Test;

public class Basic_ACS_selecting_more_than_5_hazards_and_shows_warning_message_TC42 extends BaseClass {
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
    @Test(groups = "basic")
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

        my_Report.acs_MyReport(driver);

        // Perform the operation to select more than 5 hazards and trigger the warning
        // message
        acs_Hand_Protection.moreThan_5_Hazards();
    }
}
