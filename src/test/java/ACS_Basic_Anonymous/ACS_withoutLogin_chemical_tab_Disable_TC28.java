package ACS_Basic_Anonymous;

import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.agc_pageObject.Advanced_Chemical_Product_Selector_Hand_Protection;
import com.agc.sel.agc_pageObject.Login_Ansell_Guardian;
import com.agc.sel.agc_pageObject.My_Report;
import com.agc.sel.loggers.Logger4j;
import org.testng.annotations.Test;

/**
 * Test case TC28: Verify that the Chemical tab is disabled in ACS
 * when accessed without login using unsigned chemicals.
 */
public class ACS_withoutLogin_chemical_tab_Disable_TC28 extends BaseClass {

    public Advanced_Chemical_Product_Selector_Hand_Protection acs_Hand_Protection;
    public My_Report my_Report;

    @Test(groups = "NoLogin")
    public void acs_WithoutLogin_Chemical_Tab_Disable() throws Exception {
        // Only handle cookies (skip login)
        Login_Ansell_Guardian login = new Login_Ansell_Guardian(driver);
        login.cookies_Handle();

        // Load unsigned chemicals from properties
        String chemical_Text1 = prop_utility.unsignedchemical1();
        String chemical_Text2 = prop_utility.unsignedchemical2();

        Logger4j.info("Initialize ACS Hand Protection and My Report objects");
        acs_Hand_Protection = new Advanced_Chemical_Product_Selector_Hand_Protection(driver);
        my_Report = new My_Report(driver);

        Logger4j.info("Open My Report from hamburger menu");
        my_Report.acs_MyReport(driver);

        Logger4j.info("Accept terms to continue to ACS");
        acs_Hand_Protection.agree_Button();


        Logger4j.info("Check if Chemical tab is disabled");
        acs_Hand_Protection.chemical_Tab_DisableCheck();
    }
}
