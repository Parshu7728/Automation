package agc_SmokeTc;

import com.agc.sel.agc_pageObject.My_Report;
import com.agc.sel.agc_pageObject.Padd_BodyProtection_elements;
import com.agc.sel.agc_pageObject.Padd_HandProtection_elements;
import com.agc.sel.agc_pageObject.Padd_Methods;
import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.loggers.Logger4j;
import org.testng.annotations.Test;

public class PADD_Show_productinfo_clickingon_Vlike_symbol_65 extends BaseClass {
    @Test
    public void displaying_product_info() throws Throwable {
        paddMethod.initializeAndCreateRequest();
        paddMethod.clickOnShowProductDetailsButton();
    }
}
