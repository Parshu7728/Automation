package agc_SmokeTc;

import com.agc.sel.agc_pageObject.My_Report;
import com.agc.sel.agc_pageObject.Padd_BodyProtection_elements;
import com.agc.sel.agc_pageObject.Padd_HandProtection_elements;
import com.agc.sel.agc_pageObject.Padd_Methods;
import com.agc.sel.baseutilities.BaseClass;
import org.testng.annotations.Test;

public class PADD_SearchProductsbyMaterial_HP_TC50 extends BaseClass {
    String material1;
    @Test
    public void serachProductsbyMaterial() throws Throwable{
        paddMethod.initializeAndCreateRequest();
        padd_Hp.padd_Material(material1);
    }
}
