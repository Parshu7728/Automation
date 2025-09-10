package ACS_Basic_Anonymous;

import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.agc_pageObject.Advanced_Chemical_Product_Selector_Hand_Protection;
import com.agc.sel.agc_pageObject.Login_Ansell_Guardian;
import com.agc.sel.agc_pageObject.My_Report;
import com.agc.sel.loggers.Logger4j;
import org.testng.annotations.Test;

public class ACS_withoutLogin_OtherHazards_Disable_TC27 extends BaseClass {
    // Object for handling operations in the ACS Hand Protection module
    public Advanced_Chemical_Product_Selector_Hand_Protection acs_Hand_Protection;

    // Object for handling report-related operations
    public My_Report my_Report;

    /**
     * Test case to verify the disabling of other hazards in the ACS module.
     *
     * @throws Exception if any error occurs during the test execution
     */
    @Test(groups = "NoLogin")
    public void acs_OtherHazards_Disable() throws Exception {
        // Perform login and handle cookies
        Login_Ansell_Guardian lgin = new Login_Ansell_Guardian(driver);
        lgin.cookies_Handle();

        // Retrieve chemical names from the properties file
        String chemical_Text1 = prop_utility.unsignedchemical1();
        String chemical_Text2 = prop_utility.unsignedchemical2();

        Logger4j.info("Initialize the object and perform the rest of the operations");
        acs_Hand_Protection = new Advanced_Chemical_Product_Selector_Hand_Protection(driver);
        My_Report my_Report = new My_Report(driver);

        Logger4j.info("Click on Hamburger menu and My Report");
        my_Report.acs_MyReport(driver);

        Logger4j.info("Click on the Agree button");
        acs_Hand_Protection.agree_Button();

        // Perform operations to handle specific chemicals in ACS
        acs_Hand_Protection.acs_HandProtection_Chemicals_for_unsigned(chemical_Text1, chemical_Text2);

        // Navigate to the "Other Hazards" tab in the ACS module
        acs_Hand_Protection.otherHazards_Tab();
    }
}

