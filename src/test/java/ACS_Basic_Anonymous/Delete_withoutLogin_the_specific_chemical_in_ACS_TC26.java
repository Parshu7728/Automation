package ACS_Basic_Anonymous;

import com.agc.sel.agc_pageObject.Advanced_Chemical_Product_Selector_Hand_Protection;
import com.agc.sel.baseutilities.BaseClass;
import  com.agc.sel.agc_pageObject.Login_Ansell_Guardian;
import  com.agc.sel.agc_pageObject.My_Report;;
import  com.agc.sel.agc_pageObject.SortingElements;
import com.agc.sel.loggers.Logger4j;
import org.testng.annotations.Test;

public class Delete_withoutLogin_the_specific_chemical_in_ACS_TC26 extends BaseClass {
    // Object for handling operations in the ACS Hand Protection module
    public Advanced_Chemical_Product_Selector_Hand_Protection acs_Hand_Protection;

    // Object for handling sorting operations
    SortingElements sorting_Elements;

    /**
     * Test case to delete a specific chemical in the ACS module.
     *
     * @throws Exception if any error occurs during the test execution
     */
    @Test(groups = "NoLogin")
    public void delete_The_SpecificChemical_InACS() throws Exception {
           Login_Ansell_Guardian lgin = new Login_Ansell_Guardian(driver);
           lgin.cookies_Handle();
        // Retrieve chemical names from the properties fils
        String chemical_Text1 = prop_utility.unsignedchemical1();
        String chemical_Text2 = prop_utility.unsignedchemical2();

        Logger4j.info("Initialize the object and perform the rest of the operations");
        // Initialize the ACS Hand Protection and other required objects
        acs_Hand_Protection = new Advanced_Chemical_Product_Selector_Hand_Protection(driver);
        My_Report my_Report = new My_Report(driver);
        sorting_Elements = new SortingElements(driver);

        Logger4j.info("Click on Hamburger menu and My Report");
        // Navigate to the Advanced chemical Selector (ACS)
        my_Report.acs_MyReport(driver);

        Logger4j.info("Click on the Agree button");
        // Click on the "Agree" button to proceed
        acs_Hand_Protection.agree_Button();

        // Perform operations to handle specific chemicals in ACS
        acs_Hand_Protection.acs_HandProtection_Chemicals_for_unsigned(chemical_Text1,chemical_Text2);

        Logger4j.info("BeforeRemovingSpecificChemical");
        // Log the state before removing the specific chemical
        acs_Hand_Protection.beforeRemovingSpecificChemical();
        String chemicalCount1 = acs_Hand_Protection.beforeRemovingChemicals();
        Logger4j.info(chemicalCount1);

        Logger4j.info("AfterRemovingSpecificChemical");
        // Log the state after removing the specific chemical
        acs_Hand_Protection.afterRemovingSpecificChemical();
        String chemicalCount2 = acs_Hand_Protection.afterRemovingChemical();
        Logger4j.info(chemicalCount2);

    }
}
