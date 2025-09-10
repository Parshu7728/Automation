package ACS_Basic_Anonymous;

import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.agc_pageObject.Advanced_Chemical_Product_Selector_Hand_Protection;
import com.agc.sel.agc_pageObject.Login_Ansell_Guardian;
import com.agc.sel.agc_pageObject.My_Report;
import com.agc.sel.agc_pageObject.SortingElements;
import com.agc.sel.loggers.Logger4j;
import org.testng.annotations.Test;

public class ACS_withoutLogin_Cas_Number_Sorting_TC21 extends BaseClass {
    // Object for handling operations in the ACS Hand Protection module
    public Advanced_Chemical_Product_Selector_Hand_Protection acs_Hand_Protection;

    // Object for handling sorting operations
    public SortingElements sorting_Elements;

    // Object for handling report-related operations
    public My_Report my_Report;

    /**
     * Test case to verify the sorting of chemicals by their CAS numbers in the ACS
     * module.
     *
     * @throws Exception if any error occurs during the test execution
     */
    @Test(groups = "NoLogin")
    public void acs_CasNumber_Sorting() throws Exception {
        Login_Ansell_Guardian lgin = new Login_Ansell_Guardian(driver);
        lgin.cookies_Handle();
        // Retrieve chemical names from the properties file
        String chemical_Text1 = prop_utility.unsignedchemical1();
        String chemical_Text2 = prop_utility.unsignedchemical2();

        Logger4j.info("Initialize the object and perform the rest of the operations");
        // Initialize the ACS Hand Protection, My_Report, and SortingElements objects
        acs_Hand_Protection = new Advanced_Chemical_Product_Selector_Hand_Protection(driver);
        my_Report = new My_Report(driver);
        sorting_Elements = new SortingElements(driver);

        // Pause execution for 2 seconds
        Thread.sleep(2000);

        Logger4j.info("Click on Advanced chemical product selector");
        // Navigate to the acs portal or page

        my_Report.acs_MyReport(driver);

        Logger4j.info("Click on the Agree button");
        // Click on the "Agree" button to proceed
        acs_Hand_Protection.agree_Button();

        Logger4j.info("Retrieving chemical names");
        // Retrieve chemical names for sorting
        acs_Hand_Protection.acs_HandProtection_Chemicals_for_unsigned(chemical_Text1, chemical_Text2);

        // Retrieve the CAS numbers of the chemicals before sorting
        String cas_Number_Text1 = sorting_Elements.casSort_Compare1();
        String cas_Number_Text2 = sorting_Elements.casSort_Compare2();

        // Log the CAS numbers before sorting
        Logger4j.info("Before Sorting" + " " + cas_Number_Text1 + " | " + cas_Number_Text2);

        Logger4j.info("Performing CAS Sorting");
        // Perform CAS sorting
        sorting_Elements.acs_CasSort_Button();

        // Retrieve the CAS numbers of the chemicals after sorting
        String sorted_Cas_Number1 = sorting_Elements.casSort_Compare1();
        Thread.sleep(2000);
        String sorted_Cas_Number2 = sorting_Elements.casSort_Compare2();

        // Log the CAS numbers after sorting
        Logger4j.info("After Sorting" + " " + sorted_Cas_Number1 + " | " + sorted_Cas_Number2);

        // Verify the sorting results
        assertionCheck.verification(cas_Number_Text1, sorted_Cas_Number1);
        assertionCheck.verification(cas_Number_Text2, sorted_Cas_Number2);
        Logger4j.info("CAS Number sorting is successful");
    }
}
