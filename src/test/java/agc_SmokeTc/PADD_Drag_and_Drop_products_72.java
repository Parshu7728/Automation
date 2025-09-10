package agc_SmokeTc;

import com.agc.sel.agc_pageObject.My_Report;
import com.agc.sel.agc_pageObject.Padd_BodyProtection_elements;
import com.agc.sel.agc_pageObject.Padd_HandProtection_elements;
import com.agc.sel.agc_pageObject.Padd_Methods;
import com.agc.sel.baseutilities.BaseClass;
import org.testng.annotations.Test;

public class PADD_Drag_and_Drop_products_72 extends BaseClass {
    @Test
    public void Drag_and_drop_on_paddTable() throws Throwable {
        // Initialize page objects
        paddMethod.initializeAndCreateRequest();
        padd_Hp.add_Multiple_Chemicals_dialog_box();
        paddMethod.DraganddropProducts();
    }
}