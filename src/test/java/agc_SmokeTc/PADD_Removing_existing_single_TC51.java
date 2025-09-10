package agc_SmokeTc;

import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.loggers.Logger4j;
import org.testng.annotations.Test;

public class PADD_Removing_existing_single_TC51 extends BaseClass {
    @Test
    public void padd_Creating_single_chemical() throws Throwable {
        Logger4j.info("Padd_Creating_single_chemical");
        // Retrieve organization and contact details
        paddMethod.initializeAndCreateRequest();
        padd_Hp.add_Multiple_Chemicals_dialog_box();
        paddMethod.selectAllCheckboxes(2);
        paddMethod.clickOnRemoveButton();
    }
}
