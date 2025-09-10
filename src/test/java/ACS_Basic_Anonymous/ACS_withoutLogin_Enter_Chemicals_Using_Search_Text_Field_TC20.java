package ACS_Basic_Anonymous;

import com.agc.sel.baseutilities.BaseClass;

import com.agc.sel.agc_pageObject.Advanced_Chemical_Product_Selector_Hand_Protection;
import com.agc.sel.agc_pageObject.Login_Ansell_Guardian;
import com.agc.sel.agc_pageObject.My_Report;
import com.agc.sel.loggers.Logger4j;
import org.testng.annotations.Test;

/**
 * This test case verifies adding chemicals using the search text field
 * without performing a login, assuming the session is already valid or login is not required.
 */
public class ACS_withoutLogin_Enter_Chemicals_Using_Search_Text_Field_TC20 extends BaseClass {

    public String chemical_Text1;
    public String chemical_Text2;
    public Advanced_Chemical_Product_Selector_Hand_Protection acs_Hand_Protection;

    @Test(groups = "NoLogin")
    public void acs_Add_Chemicals_Using_Search_Text_Field() throws Exception {
        Login_Ansell_Guardian loginAnsellGuardian = new Login_Ansell_Guardian(driver);
        Logger4j.info("Handling cookies (if shown)");
        loginAnsellGuardian.cookies_Handle();

        Logger4j.info("Navigating to My Report");
        My_Report my_Report = new My_Report(driver);
        my_Report.acs_MyReport(driver);

        Logger4j.info("Clicking on Agree button in ACS");
        acs_Hand_Protection = new Advanced_Chemical_Product_Selector_Hand_Protection(driver);
        Logger4j.info("Issue is here");
        acs_Hand_Protection.agree_Button();

        Logger4j.info("Fetching chemical names from properties");
        chemical_Text1 = prop_utility.unsignedchemical1();
        chemical_Text2 = prop_utility.unsignedchemical2();

        Logger4j.info("Adding chemicals using search text field");
        acs_Hand_Protection.acs_HandProtection_Chemicals_for_unsigned(chemical_Text1, chemical_Text2);
        Logger4j.info("Test completed: Chemicals added successfully");
    }
}
