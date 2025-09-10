package agc_SmokeTc;

import com.agc.sel.agc_pageObject.My_Report;
import com.agc.sel.agc_pageObject.Padd_BodyProtection_elements;
import com.agc.sel.agc_pageObject.Padd_HandProtection_elements;
import com.agc.sel.agc_pageObject.Padd_Methods;
import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.loggers.Logger4j;
import org.testng.annotations.Test;

public class PADD_Removing_existing_mixtures_52 extends BaseClass {
    public Padd_BodyProtection_elements padd_Bp;
    public Padd_HandProtection_elements padd_Hp;
    public My_Report my_Report;
    String expected_final_message = "Chemical added in Hand & Body Protection";

    @Test
    public void padd_Creating_single_chemical() throws Throwable {
        Logger4j.info("Padd_Creating_single_chemical");
        paddMethod.initializeAndCreateRequest();
        String mixture = prop_utility.mixture1();
        padd_Hp.Add_existing_Mixture(mixture);
        paddMethod.selectAllCheckboxes(1);
        paddMethod.clickOnRemoveButton();
    }
}
