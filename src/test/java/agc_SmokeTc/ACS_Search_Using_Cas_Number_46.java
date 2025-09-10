package agc_SmokeTc;

import com.agc.sel.agc_pageObject.Advanced_Chemical_Product_Selector_Hand_Protection;
import com.agc.sel.agc_pageObject.My_Report;
import com.agc.sel.baseutilities.BaseClass;
import org.testng.annotations.Test;

public class ACS_Search_Using_Cas_Number_46 extends BaseClass {
   public String CAS_no1 = prop_utility.cas_number1();
   public String CAS_no2 = prop_utility.cas_number2();
    public Advanced_Chemical_Product_Selector_Hand_Protection acs_Hand_Protection;

@Test
    public void acs_search_Cas_Number() throws Exception {
    acs_Hand_Protection = new Advanced_Chemical_Product_Selector_Hand_Protection(driver);
    My_Report my_Report = new My_Report(driver);
    my_Report.hamBurger_MyReport();
    // If successful, execute ansell_acs_MyReport
    my_Report.ansell_acs_MyReport(driver);
    acs_Hand_Protection.agree_Button();
    acs_Hand_Protection.acs_HandProtection_Cas_num(CAS_no1, CAS_no2);

    }
}

