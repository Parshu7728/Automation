package PTD_Regression_TC;

import com.agc.sel.agc_pageObject.My_Report;
import com.agc.sel.agc_pageObject.PTD_Methods;
import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.baseutilities.RobotUtil;
import com.agc.sel.pdfReader.PTD_pdf_comparision;
import org.testng.annotations.Test;

public class Advanced_usr_BP_ptd_TC extends BaseClass {

    String productgroup = prop_utility.ptd_ProductGroupBP();

    @Test(groups = "advanced")
    public void ansell_usr_ptd() throws InterruptedException {
        PTD_Methods ptd = new PTD_Methods(driver);
        My_Report my_Report = new My_Report(driver);
        RobotUtil robotUtil = new RobotUtil();
        PTD_pdf_comparision ptd_pdf = new PTD_pdf_comparision();

        my_Report.BasicPtd();
        ptd.reportName();
        ptd.enterOrganizationName();
        ptd.uploadLogo();
        ptd.clickSelectReportImage();
        Thread.sleep(2000);
        ptd.clickBodyProtection();
        ptd.searchAndSelectFirstProduct(productgroup);
        ptd.clickGenerateReport();
        //  Scroll till top before going back to My Report page
        ptd.scrollToTop();
        my_Report.navigate_from_PTD_MyReportPage(); // navigate to My Report page
        ptd.verifyReport();
        String expectedPdfPath = "E:/AutomationAGC/Automation/src/main/resources/Expected-PDF/BP_AdvancePTD.pdf";
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
