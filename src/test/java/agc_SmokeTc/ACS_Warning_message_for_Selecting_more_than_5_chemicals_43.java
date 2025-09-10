package agc_SmokeTc;

import com.agc.sel.agc_pageObject.Advanced_Chemical_Product_Selector_Hand_Protection;
import com.agc.sel.agc_pageObject.My_Report;
import com.agc.sel.baseutilities.BaseClass;
import org.testng.annotations.Test;


public class ACS_Warning_message_for_Selecting_more_than_5_chemicals_43 extends BaseClass {
    public String Warning_message = "A maximum of 5 chemicals or Other hazards can be added for accurate product recommendation";
    My_Report myReport;
    Advanced_Chemical_Product_Selector_Hand_Protection acsHandProtection;

    @Test
    public void acs_Warning_message_for_Selecting_more_than_5_chemicals() throws Exception {
        acsHandProtection = new Advanced_Chemical_Product_Selector_Hand_Protection(driver);
        myReport = new My_Report(driver);
        myReport.hamBurger_MyReport();
        myReport.ansell_acs_MyReport(driver);
        acsHandProtection.agree_Button();
        acsHandProtection.addMoreThan5Chemicals();
        Thread.sleep(3000);
    }

}
