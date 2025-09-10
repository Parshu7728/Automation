package agc_SmokeTc;

import com.agc.sel.baseutilities.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PADD_Check_for_standards_BT1_0_BP_80 extends BaseClass {
    @Test
    public void checkForStandards_BT1_0_BP() throws Throwable {
        paddMethod.initializeAndCreateRequest();
        paddMethod.switchToBPStandard();
        padd_Hp.add_Multiple_Chemicals_dialog_box();
        paddMethod.checkForStandards_BT1_0_BP("BT1.0");
    }
}
