package PADD_EndToEnd;

import com.agc.sel.agc_pageObject.My_Report;
import com.agc.sel.agc_pageObject.Padd_BodyProtection_elements;
import com.agc.sel.agc_pageObject.Padd_HandProtection_elements;
import com.agc.sel.baseutilities.BaseClass;
import org.testng.annotations.Test;

public class PADD_Advance_Combined_report_download extends BaseClass {
    String chemical1 = prop_utility.paddBpchemical1();
    String chemical2 = prop_utility.paddBpchemical2();
    String chemical1h = prop_utility.paddHpchemical1();
    String chemical2h = prop_utility.paddHpchemical2();
    String hpProduct1 = prop_utility.hpProduct1();
    String hpProduct2 = prop_utility.hpProduct2();
    String bp_product1 = prop_utility.bpProduct1();
    String bp_product2 = prop_utility.bpProduct2();
    @Test(groups = "advanced")
    public void Advance_Combined_report_download() throws Throwable {
        padd_Bp = new Padd_BodyProtection_elements(driver);
        padd_Hp = new Padd_HandProtection_elements(driver);
        my_Report = new My_Report(driver);
        my_Report.BasicPadd();
        padd_Hp.padd_Chemical(chemical1h, chemical2h);
        padd_Hp.padd_Product(hpProduct1, hpProduct2);
        paddMethod.switchToBPStandard();
        padd_Bp.chemicals_For_Bp(chemical1, chemical2);
        padd_Bp.product_For_BPBasic(bp_product1);
        paddMethod.EditingReportName();
        padd_Hp.report_Download_Button();
        padd_Hp.customize_combined_report_forBasic();
        paddMethod.download_report_in_popup();
    }
}
