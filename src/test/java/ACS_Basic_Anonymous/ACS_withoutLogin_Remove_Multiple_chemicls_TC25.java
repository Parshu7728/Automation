package ACS_Basic_Anonymous;

import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.agc_pageObject.Advanced_Chemical_Product_Selector_Hand_Protection;
import com.agc.sel.agc_pageObject.Login_Ansell_Guardian;
import com.agc.sel.agc_pageObject.My_Report;
import com.agc.sel.agc_pageObject.SortingElements;
import com.agc.sel.loggers.Logger4j;
import org.testng.annotations.Test;

public class ACS_withoutLogin_Remove_Multiple_chemicls_TC25 extends BaseClass {
    // Chemical text values retrieved from the properties file
    public String chemical_Text1;
    public String chemical_Text2;

    // Object for handling operations in the ACS Hand Protection module
    public Advanced_Chemical_Product_Selector_Hand_Protection acs_Hand_Protection;

    // Object for handling sorting operations
    SortingElements sorting_Elements;

    // Object for handling report-related operations
    public My_Report my_Report;

    /**
     * Test case to remove multiple chemicals in the ACS module.
     *
     * @throws Exception if any error occurs during the test execution
     */
    @Test(groups = "NoLogin")
    public void acs_ChemicalSorting() throws Exception {
        // Accept the cookies
        Login_Ansell_Guardian lgin = new Login_Ansell_Guardian(driver);
        lgin.cookies_Handle();


        // Retrieve chemical names from the properties file
        chemical_Text1 = prop_utility.unsignedchemical1();
        chemical_Text2 = prop_utility.unsignedchemical2();

        Logger4j.info("Initialize the object and perform the rest of the operations");
        // Initialize the ACS Hand Protection, My_Report, and SortingElements objects
        acs_Hand_Protection = new Advanced_Chemical_Product_Selector_Hand_Protection(driver);
        My_Report my_Report = new My_Report(driver);
        sorting_Elements = new SortingElements(driver);

        Logger4j.info("Click on Advanced chemical search");
        // Navigate to the Advanced chemical search(ACS)
        my_Report.acs_MyReport(driver);

        Logger4j.info("Click on the Agree button");
        // Click on the "Agree" button to proceed
        acs_Hand_Protection.agree_Button();

        // Perform operations to handle specific chemicals in ACS
        acs_Hand_Protection.acs_HandProtection_Chemicals_for_unsigned(chemical_Text1,chemical_Text2);

        // Remove all chemicals from the ACS module
        acs_Hand_Protection.remove_All_Chemical();
    }
}
