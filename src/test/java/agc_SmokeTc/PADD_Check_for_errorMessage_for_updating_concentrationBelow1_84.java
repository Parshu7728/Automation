package agc_SmokeTc;

import com.agc.sel.baseutilities.BaseClass;
import org.testng.annotations.Test;

public class PADD_Check_for_errorMessage_for_updating_concentrationBelow1_84 extends BaseClass {
    @Test
    public void update_concentrationBelow1() throws Throwable {
        paddMethod.initializeAndCreateRequest();
        padd_Hp.add_Multiple_Chemicals_dialog_box();
        paddMethod.update_concentrationBelow1();
    }
}
