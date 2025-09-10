package agc_SmokeTc;

import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.loggers.Logger4j;
import org.testng.annotations.Test;

public class PADD_upload_MSDS_without_chem_59 extends BaseClass {
    @Test
    public void uploading_MSDC_without_chem() throws Throwable {
        Logger4j.info("Padd_uploading_MSDC_without_chem");
        paddMethod.initializeAndCreateRequest();
        paddMethod.uploadMSDSFile("E:/AutomationAGC/Automation/src/main/resources/Expected-PDF/BP_AdvancePTD.pdf");
        paddMethod.chemicalscountinMSDC();
        paddMethod.closeMSDC();
    }
}
