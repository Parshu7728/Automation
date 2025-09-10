package agc_SmokeTc;

import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.loggers.Logger4j;
import org.testng.annotations.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PADD_Check_for_standards_BT0_1_BP_81 extends BaseClass {

    @Test
    public void checkForStandards_BT1_0_BP() throws Throwable {
        paddMethod.initializeAndCreateRequest();
        paddMethod.switchToBPStandard();
        padd_Hp.add_Multiple_Chemicals_dialog_box();

        String actualStandard = paddMethod.checkForStandards_BT1_0_BP("BT0.1");
        Assert.assertTrue(
                actualStandard.contains("BT0.1"),
                "Expected BP standard to contain 'BT0.1' but found: " + actualStandard
        );
        Logger4j.info("Assertion passed → Correct BP standard selected: " + actualStandard);
    }
}
