package agc_SmokeTc;

import com.agc.sel.agc_pageObject.My_Report;
import com.agc.sel.agc_pageObject.Padd_BodyProtection_elements;
import com.agc.sel.agc_pageObject.Padd_HandProtection_elements;
import com.agc.sel.agc_pageObject.Padd_Methods;
import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.loggers.Logger4j;
import org.testng.annotations.Test;

public class PADD_Select_product_checkbox_and_delete_66 extends BaseClass {
    @Test
    public void selectandremoveProduct() throws Throwable {
        paddMethod.initializeAndCreateRequest();
        paddMethod.selectandremoveProduct38_001();
    }
}
