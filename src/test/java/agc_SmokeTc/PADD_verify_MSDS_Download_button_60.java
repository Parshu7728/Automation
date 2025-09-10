package agc_SmokeTc;

import com.agc.sel.baseutilities.BaseClass;
import org.testng.annotations.Test;
public class PADD_verify_MSDS_Download_button_60 extends BaseClass {
    @Test
    public void verify_MSDS_Download_button() throws Throwable {
        paddMethod.initializeAndCreateRequest();
        padd_Hp.add_Multiple_Chemicals_dialog_box();
        paddMethod.uploadMSDSFile("E:\\AutomationAGC\\Automation\\src\\main\\resources\\Expected-PDF\\BP_AdvancePTD.pdf");
        paddMethod.verifyDownloadMSDSButtonPresence();
        paddMethod.closeMSDC();
        paddMethod.countMSDCDownloadButtons();
    }
}
