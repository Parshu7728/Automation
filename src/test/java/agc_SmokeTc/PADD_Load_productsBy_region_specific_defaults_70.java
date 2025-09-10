package agc_SmokeTc;

import com.agc.sel.agc_pageObject.My_Report;
import com.agc.sel.agc_pageObject.Padd_BodyProtection_elements;
import com.agc.sel.agc_pageObject.Padd_HandProtection_elements;
import com.agc.sel.agc_pageObject.Padd_Methods;
import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.loggers.Logger4j;
import org.testng.annotations.Test;

public class PADD_Load_productsBy_region_specific_defaults_70 extends BaseClass {
    public Padd_BodyProtection_elements padd_Bp;
    public Padd_HandProtection_elements padd_Hp;
    public My_Report my_Report;
    @Test
    public void productsBy_region_specific_defaults() throws Throwable {
        paddMethod.initializeAndCreateRequest();
        paddMethod.selectRegionDefaultProducts();
    }
}