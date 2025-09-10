package PADD_EndToEnd;

import com.agc.sel.agc_pageObject.Padd_HandProtection_elements;
import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.loggers.Logger4j;
import com.agc.sel.pdfReader.PTD_pdf_comparision;
import org.testng.annotations.Test;

public class PADD_Ansell_BP_report_download extends BaseClass {
    String bp_product1 = prop_utility.bpProduct1();
    String bp_product2 = prop_utility.bpProduct2();
    String chemical1 = prop_utility.paddBpchemical1();
    String chemical2 = prop_utility.paddBpchemical2();


    PTD_pdf_comparision ptd_pdf = new PTD_pdf_comparision();
    @Test
    public void Ansell_BP_report_download() throws Throwable {
        padd_Hp = new Padd_HandProtection_elements(driver);
        paddMethod.initializeAndCreateRequestBP();
        padd_Bp.chemicals_For_Bp(chemical1, chemical2);
        padd_Bp.product_For_Bp(bp_product1, bp_product2);
        padd_Bp.submit_Report_Button_Bp();
        padd_Bp.submit_Report_Button_Bp();
        // Retrieve BP report details
        padd_Bp.bp_Report_Details();
        // Submit the form
        padd_Hp.submit();
        driver.navigate().refresh();
        paddMethod.BP_Status();
        padd_Hp.report_Download_Button();
        Logger4j.info("Waiting for report download....");
        Thread.sleep(20000);
        String expectedPdfPath = "E:/AutomationAGC/Automation/src/main/resources/Expected-PDF/BP_AnsellPADD.pdf";
        String downloadDirPath = "E:/AutomationAGC/Automation/Pdfdownload";
        int StartPage =4;

        // Get the actual downloaded PDF file path
        String actualPdfPath = ptd_pdf.getLatestDownloadedPdf(downloadDirPath);
        if (actualPdfPath != null) {
            ptd_pdf.comparePdfIgnoringDynamicOrg(expectedPdfPath, actualPdfPath, StartPage);
        } else {
            throw new RuntimeException("No PDF file found in download directory: " + downloadDirPath);
        }
    }
}
