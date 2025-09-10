package agc_SmokeTc;

import com.agc.sel.baseutilities.BaseClass;
import org.testng.annotations.Test;

public class Padd_Verify_adding_suggested_products_79 extends BaseClass {
    @Test
    public void verifyAddingSuggestedProducts() throws Throwable {
        paddMethod.initializeAndCreateRequest();
        padd_Hp.add_Multiple_Chemicals_dialog_box();
        paddMethod.Verify_adding_suggested_products();
    }
}
