package agc_SmokeTc;

import com.agc.sel.agc_pageObject.My_Report;
import com.agc.sel.agc_pageObject.Padd_BodyProtection_elements;
import com.agc.sel.agc_pageObject.Padd_HandProtection_elements;
import com.agc.sel.agc_pageObject.Padd_Methods;
import com.agc.sel.baseutilities.BaseClass;
import org.testng.annotations.Test;

public class PADD_Verify_Deleting_MSDC_pdf_attachment_61 extends BaseClass {
    String dot1 = padd_utility.dots1();
    String dot2 = padd_utility.dots2();

    @Test
    public void verify_deleting_msdc_doc() throws Throwable {
        paddMethod.initializeAndCreateRequest();
        paddMethod.uploadMSDSFile("E:/AutomationAGC/Automation/src/main/resources/Expected-PDF/BP_AdvancePTD.pdf");
        paddMethod.countofSDSfiles();
        paddMethod.deleteMSDCFile();
        paddMethod.closeMSDC();
    }
}
