package PADD_EndToEnd;

import com.agc.sel.agc_pageObject.Padd_HandProtection_elements;
import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.loggers.Logger4j;
import com.agc.sel.pdfReader.PTD_pdf_comparision;
import org.testng.annotations.Test;
import  com.agc.sel.baseutilities.Asserrtion;
public class PADD_Ansell_HP_report_download extends BaseClass {
    PTD_pdf_comparision ptd_pdf = new PTD_pdf_comparision();
    String chemical1 = prop_utility.paddHpchemical1();
    String chemical2 = prop_utility.paddHpchemical2();
    String hpProduct1 = prop_utility.hpProduct1();
    String hpProduct2 = prop_utility.hpProduct2();

    @Test
    public void Ansell_BP_report_download() throws Throwable {
        padd_Hp = new Padd_HandProtection_elements(driver);
        paddMethod.initializeAndCreateRequestHP();
        padd_Hp.padd_Chemical(chemical1, chemical2);
        padd_Hp.padd_Product(hpProduct1, hpProduct2);
        // Submit the HP report
        padd_Hp.submit_Report_Button();
        padd_Hp.hp_Report_Details();
        padd_Hp.submit();
        driver.navigate().refresh();
        paddMethod.HP_Status();
        padd_Hp.report_Download_Button();
//        Logger4j.info("Waiting for report download....");
//        Thread.sleep(20000);
//        String expectedPdfPath = "E:/AutomationAGC/Automation/src/main/resources/Expected-PDF/HP_AnsellPADD.pdf";
//        String downloadDirPath = "E:/AutomationAGC/Automation/Pdfdownload";
//        int StartPage =4;
//
//        // Get the actual downloaded PDF file path
//        String actualPdfPath = ptd_pdf.getLatestDownloadedPdf(downloadDirPath);
//
//        // Assertions on download path
//         Asserrtion.assertTrue(
//                actualPdfPath != null && !actualPdfPath.trim().isEmpty(),
//                "Downloaded PDF path should not be null or empty"
//        );
//         Asserrtion.assertTrue(
//                actualPdfPath.toLowerCase().endsWith(".pdf"),
//                "Downloaded file should be a PDF"
//        );
//        // Optional: ensure the file exists on disk
//         Asserrtion.assertTrue(
//                new java.io.File(actualPdfPath).exists(),
//                "Downloaded PDF should exist on disk: " + actualPdfPath
//        );
//        // Compare PDFs (throws/asserts internally on mismatch)
//        ptd_pdf.comparePdfIgnoringDynamicOrg(expectedPdfPath, actualPdfPath, StartPage);
    }
    }
