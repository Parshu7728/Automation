package agc_SmokeTc;

import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.loggers.Logger4j;
import org.testng.annotations.Test;

public class PADD_Edit_concentration_within100_82 extends BaseClass {
    @Test
    public void edit_concentration() throws Throwable {
        Logger4j.info("Editing concentration within 100%");
        paddMethod.initializeAndCreateRequest();
        padd_Hp.add_Multiple_Chemicals_dialog_box();
        paddMethod.edit_concentration_within100();
    }
}
