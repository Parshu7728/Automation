package agc_SmokeTc;

import com.agc.sel.agc_pageObject.My_Report;
import com.agc.sel.agc_pageObject.Padd_BodyProtection_elements;
import com.agc.sel.agc_pageObject.Padd_HandProtection_elements;
import com.agc.sel.agc_pageObject.Padd_Methods;
import com.agc.sel.baseutilities.Asserrtion;
import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.loggers.Logger4j;
import org.testng.annotations.Test;

public class PADD_Check_for_standards_EN374_HP_68 extends BaseClass {
    @Test
    public void checkStandardEN374HP() throws Throwable {
        paddMethod.initializeAndCreateRequest();
        String standard = "EN ISO 374";
        String validate =  paddMethod.Standardcheck(standard);
        Asserrtion.verification(standard, validate);
    }
}
