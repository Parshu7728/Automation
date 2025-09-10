package agc_SmokeTc;

import com.agc.sel.baseutilities.BaseClass;
import org.testng.annotations.Test;

public class PADD_Update_concentration_with_decimalValues_85 extends BaseClass {
    @Test
    public void update_concentration_in_decimalValues() throws Throwable {
        paddMethod.initializeAndCreateRequest();
        padd_Hp.add_Multiple_Chemicals_dialog_box();
        paddMethod.update_concentration_in_decimalValues();
    }
}
