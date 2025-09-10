package PADD_EndToEnd;

import com.agc.sel.agc_pageObject.Padd_HandProtection_elements;
import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.loggers.Logger4j;
import com.agc.sel.pdfReader.PTD_pdf_comparision;
import org.testng.annotations.Test;

import static com.agc.sel.pdfReader.PTD_pdf_comparision.validateDownloadedPdf;

public class PADD_Ansell_Combined_report_download extends BaseClass {
    PTD_pdf_comparision ptd_pdf = new PTD_pdf_comparision();
    String chemical1 = prop_utility.paddBpchemical1();
    String chemical2 = prop_utility.paddBpchemical2();
    String chemical1h = prop_utility.paddHpchemical1();
    String chemical2h = prop_utility.paddHpchemical2();
    String hpProduct1 = prop_utility.hpProduct1();
    String hpProduct2 = prop_utility.hpProduct2();
    String bp_product1 = prop_utility.bpProduct1();
    String bp_product2 = prop_utility.bpProduct2();
    @Test
    public void PADD_Ansell_Combined_report_download() throws Throwable {
        padd_Hp = new Padd_HandProtection_elements(driver);
        paddMethod.initializeAndCreateRequest();

        padd_Hp.padd_Chemical(chemical1h, chemical2h);
        padd_Hp.padd_Product(hpProduct1, hpProduct2);
        padd_Hp.submit_Report_Button();
        padd_Hp.hp_Report_Details();
        padd_Hp.submit();
        driver.navigate().refresh();
        paddMethod.HP_Status();
        // Submit the BP report
        padd_Bp.switch_To_BodyProtection();
        padd_Bp.chemicals_For_Bp(chemical1, chemical2);
        padd_Bp.product_For_Bp(bp_product1, bp_product2);
        padd_Bp.submit_Report_Button_Bp();
        padd_Bp.bp_Report_Details();
        padd_Hp.submit();
        driver.navigate().refresh();
        paddMethod.BP_Status();
        paddMethod.CombinedReportDownload();
//        Logger4j.info("Waiting for report download....");
//        Thread.sleep(20000);
//        String expectedPdfPath = padd_utility.Ansell_Combined_PADD();
//        String downloadDir = padd_utility.Download_Directory();
//      validateDownloadedPdf(expectedPdfPath,downloadDir, 4);
        // Get the actual downloaded PDF file path
    }
}
