package agc_SmokeTc;

import com.agc.sel.agc_pageObject.My_Report;
import com.agc.sel.agc_pageObject.Padd_BodyProtection_elements;
import com.agc.sel.agc_pageObject.Padd_HandProtection_elements;
import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.loggers.Logger4j;
import org.testng.annotations.Test;

public class PADD_Removing_new_mixtures_TC54 extends BaseClass {
    public Padd_BodyProtection_elements padd_Bp;
    public Padd_HandProtection_elements padd_Hp;
    public My_Report my_Report;
    String expected_mix_final_message = "Mixture added in Hand & Body Protection";

    @Test
    public void padd_Removing_new_mixture() throws Throwable {
        Logger4j.info("Padd_Removing_new_mixture");
        paddMethod.initializeAndCreateRequest();
        paddMethod.clickOnCreateNewSinglesMixtures();
        paddMethod.clickOnMixtureTab();
        paddMethod.creatingNewMixture();
        paddMethod.setPhysical_state_select_mix();
        paddMethod.Add_Mixture_Component();
        String actual_message = paddMethod.getFinalMessageforMixture();
        assertionCheck.verification(expected_mix_final_message, actual_message);
        Thread.sleep(2000);
        paddMethod.selectAllCheckboxes(1);
        paddMethod.clickOnRemoveButton();
    }
}
