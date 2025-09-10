package agc_SmokeTc;

import com.agc.sel.baseutilities.BaseClass;
import org.testng.annotations.Test;

public class PADD_Check_for_errorMessage_for_update_concentrationAbove100_83 extends BaseClass {
    @Test
    public void update_concentrationAbove100() throws Throwable {
        paddMethod.initializeAndCreateRequest();
        padd_Hp.add_Multiple_Chemicals_dialog_box();
        paddMethod.update_concentrationAbove100();
    }
}
