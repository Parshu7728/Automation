package agc_SmokeTc;

import com.agc.sel.agc_pageObject.My_Report;
import com.agc.sel.agc_pageObject.Padd_BodyProtection_elements;
import com.agc.sel.agc_pageObject.Padd_HandProtection_elements;
import com.agc.sel.agc_pageObject.Padd_Methods;
import com.agc.sel.baseutilities.Asserrtion;
import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.loggers.Logger4j;
import org.testng.annotations.Test;

public class PADD_Create_new_mixture_TC47 extends BaseClass {
    String expected_mix_final_message ="Mixture added in Hand & Body Protection";
    @Test
    public void padd_Creating_new_mixture() throws Throwable{
        Logger4j.info("Padd_Creating_new_mixture");
        // Retrieve organization and contact details
        paddMethod.initializeAndCreateRequest();
        paddMethod.clickOnCreateNewSinglesMixtures();
        paddMethod.clickOnMixtureTab();
        paddMethod.creatingNewMixture();
        paddMethod.setPhysical_state_select_mix();
        paddMethod.Add_Mixture_Component();
        Asserrtion asserrtion = new Asserrtion();
        String actual_message =  paddMethod.getFinalMessageforMixture();
        asserrtion.verification( expected_mix_final_message, actual_message);
        Logger4j.info("Assertion passed: " + expected_mix_final_message + " is displayed");
        Thread.sleep(2000);

    }
}
