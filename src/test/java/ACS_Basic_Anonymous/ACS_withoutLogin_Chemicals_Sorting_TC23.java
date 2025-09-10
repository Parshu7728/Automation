package ACS_Basic_Anonymous;

import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.agc_pageObject.Advanced_Chemical_Product_Selector_Hand_Protection;
import com.agc.sel.agc_pageObject.Login_Ansell_Guardian;
import com.agc.sel.agc_pageObject.My_Report;
import com.agc.sel.agc_pageObject.SortingElements;
import com.agc.sel.loggers.Logger4j;
import org.testng.annotations.Test;

public class ACS_withoutLogin_Chemicals_Sorting_TC23 extends BaseClass {
    // Object for handling operations in the ACS Hand Protection module
    public Advanced_Chemical_Product_Selector_Hand_Protection acs_Hand_Protection;

    // Object for handling sorting operations
    SortingElements sorting_Elements;

    // Object for handling report-related operations
    public My_Report my_Report;

    /**
     * Test case to verify the sorting of chemicals in the ACS module.
     *
     * @throws Exception if any error occurs during the test execution
     */
    @Test(groups = "NoLogin")
    public void acs_Chemical_Sorting() throws Exception {
        Login_Ansell_Guardian lgin = new Login_Ansell_Guardian(driver);
        lgin.cookies_Handle();


        // Retrieve chemical names from the properties file
        String chemical_text1 = prop_utility.unsignedchemical1();
        String chemical_text2 = prop_utility.unsignedchemical2();

        Logger4j.info("Initialize the object and perform the rest of the operations");
        // Initialize the ACS Hand Protection, My_Report, and SortingElements objects
        acs_Hand_Protection = new Advanced_Chemical_Product_Selector_Hand_Protection(driver);
        My_Report my_Report = new My_Report(driver);
        sorting_Elements = new SortingElements(driver);

        // Pause execution for 2 seconds
        Thread.sleep(2000);

        Logger4j.info("Click on Hamburger menu and My Report");
        // Navigate to the Advanced Chemical Product Selector (ACS) module
        my_Report.acs_MyReport(driver);

        Logger4j.info("Click on the Agree button");
        // Click on the "Agree" button to proceed
        acs_Hand_Protection.agree_Button();

        Logger4j.info("Retrieving chemical names");
        // Retrieve chemical names for sorting
        acs_Hand_Protection.acs_HandProtection_Chemicals_for_unsigned(chemical_text1, chemical_text2);

        // Retrieve the chemical numbers before sorting
        String chemical_number_Text1 = sorting_Elements.chemicalSort_Compare1();
        String chemical_number_Text2 = sorting_Elements.chemicalSort_Compare2();

        // Log the chemical numbers before sorting
        Logger4j.info("Before Sorting" + " " + chemical_number_Text1 + " | " + chemical_number_Text2);

        Logger4j.info("Performing CAS Sorting");
        // Perform chemical sorting
        sorting_Elements.acs_sortChemical_button();
        sorting_Elements.acs_sortChemical_button();

        // Retrieve the chemical numbers after sorting
        String Sorted_chrmical_number1 = sorting_Elements.chemicalSort_Compare1();
        String Sorted_chrmical_number2 = sorting_Elements.chemicalSort_Compare2();

        // Log the chemical numbers after sorting
        Logger4j.info("After Sorting" + " " + Sorted_chrmical_number1 + " | " + Sorted_chrmical_number2);

        // Verify the sorting results
        assertionCheck.verification(chemical_number_Text1, Sorted_chrmical_number1);
        assertionCheck.verification(chemical_number_Text2, Sorted_chrmical_number2);
        Logger4j.info("Sorting of chemicals in ACS module is successful");

    }
}
