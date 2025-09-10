package PADD_EndToEnd;

import com.agc.sel.agc_pageObject.My_Report;
import com.agc.sel.agc_pageObject.Padd_BodyProtection_elements;
import com.agc.sel.agc_pageObject.Padd_HandProtection_elements;
import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.loggers.Logger4j;
import com.agc.sel.pdfReader.PTD_pdf_comparision;
import org.testng.annotations.Test;

public class PADD_Advanced_BP_report_download extends BaseClass {
    PTD_pdf_comparision ptd_pdf = new PTD_pdf_comparision();
    String chemical1 = prop_utility.paddBpchemical1();
    String chemical2 = prop_utility.paddBpchemical2();
    String bp_product1 = prop_utility.bpProduct1();
    String bp_product2 = prop_utility.bpProduct2();

    @Test(groups = "advanced")
    public void Advanced_BP_report_download() throws Throwable {
        padd_Bp = new Padd_BodyProtection_elements(driver);
        padd_Hp = new Padd_HandProtection_elements(driver);
        my_Report = new My_Report(driver);
        my_Report.BasicPadd();
        paddMethod.switchToBPStandard();
        padd_Bp.chemicals_For_Bp(chemical1, chemical2);
        padd_Bp.product_For_BPBasic(bp_product1);
        paddMethod.EditingReportName();
        padd_Hp.report_Download_Button();
        padd_Bp.customize_bp_report_forBasic();
        paddMethod.download_report_in_popup();
//        Logger4j.info("Waiting for report download....");
//        Thread.sleep(30000);
//        String expectedPdfPath = "E:/AutomationAGC/Automation/src/main/resources/Expected-PDF/BP_AdvancePADD.pdf";
//        String downloadDirPath = "E:/AutomationAGC/Automation/Pdfdownload";
//        int StartPage =4;
//
//        // Get the actual downloaded PDF file path
//        String actualPdfPath = ptd_pdf.getLatestDownloadedPdf(downloadDirPath);
//        if (actualPdfPath != null) {
//            ptd_pdf.comparePdfIgnoringDynamicOrg(expectedPdfPath, actualPdfPath, StartPage);
//        } else {
//            throw new RuntimeException("No PDF file found in download directory: " + downloadDirPath);
//        }
    }
}
