package agc_SmokeTc;

import com.agc.sel.agc_pageObject.My_Report;
import com.agc.sel.agc_pageObject.Padd_BodyProtection_elements;
import com.agc.sel.agc_pageObject.Padd_HandProtection_elements;
import com.agc.sel.agc_pageObject.Padd_Methods;
import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.loggers.Logger4j;
import org.testng.annotations.Test;

public class PADD_view_productinfo_ByClickingOnDots_71 extends BaseClass {
    public Padd_HandProtection_elements padd_Hp;
    String dot1 = padd_utility.dots1();
    String dot2 = padd_utility.dots2();
    @Test
    public void viewProductInfoClickingDots() throws Throwable {
        padd_Hp = new Padd_HandProtection_elements(driver);
        paddMethod.initializeAndCreateRequest();
        padd_Hp.add_Multiple_Chemicals_dialog_box();
        paddMethod.viewProductInfoAndVerify(1, "93-260.360");
        paddMethod.viewProductInfoAndVerify(4, "58-270");
    }
}
