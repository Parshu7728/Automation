package agc_SmokeTc;
import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.loggers.Logger4j;
import org.testng.annotations.Test;

public class PADD_upload_MSDS_with_chemicals_58 extends BaseClass {
    @Test
    public void upload_MSDS_with_chemicals() throws Throwable {
        Logger4j.info("Padd_upload_MSDS_with_chemicals");
        paddMethod.initializeAndCreateRequest();
        padd_Hp.add_Multiple_Chemicals_dialog_box();
        paddMethod.uploadMSDSFile("E:\\AutomationAGC\\Automation\\src\\main\\resources\\Expected-PDF\\BP_AdvancePTD.pdf");
        paddMethod.chemicalscountinMSDC();
        paddMethod.closeMSDC();
    }
}
