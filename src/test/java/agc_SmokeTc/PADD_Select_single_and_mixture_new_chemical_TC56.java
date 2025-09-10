package agc_SmokeTc;

import com.agc.sel.agc_pageObject.My_Report;
import com.agc.sel.agc_pageObject.Padd_BodyProtection_elements;
import com.agc.sel.agc_pageObject.Padd_HandProtection_elements;
import com.agc.sel.agc_pageObject.Padd_Methods;
import com.agc.sel.baseutilities.Asserrtion;
import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.loggers.Logger4j;
import org.testng.annotations.Test;

public class PADD_Select_single_and_mixture_new_chemical_TC56 extends BaseClass {
    @Test
    public void padd_Create_Single_And_Mix_Then_Select() throws Throwable {
        Logger4j.info("Padd_Create_Single_And_Mix_Then_Select");
        paddMethod.initializeAndCreateRequest();
        // ========== STEP 1: CREATE SINGLE CHEMICAL ==========
        paddMethod.clickOnCreateNewSinglesMixtures();
        paddMethod.CreatingNewSingles();
        paddMethod.enterCASNumber(prop_utility.replaceable_cas());
        paddMethod.enterChemicalName(prop_utility.replaceable_Chemical1());
        paddMethod.setPhysical_state_select();
        paddMethod.enterConcentration("80");
        paddMethod.clickOnSaveButton();
        Thread.sleep(1000);

        // Validate success message
        String expected_final_message = "Chemical added in Hand & Body Protection";
        String actual_message = paddMethod.getFinalMessage();
       assertionCheck.verification(expected_final_message,actual_message);
        Thread.sleep(3000);

        // ========== STEP 2: CREATE MIXTURE ==========
        paddMethod.clickOnCreateNewSinglesMixtures();
        paddMethod.clickOnMixtureTab();
        paddMethod.creatingNewMixture();
        paddMethod.setPhysical_state_select_mix();
        paddMethod.Add_Mixture_Component();
        String actual_mix_message = paddMethod.getFinalMessage();
        String expected_mix_final_message = "Mixture added in Hand & Body Protection";
        assertionCheck.verification(expected_mix_final_message, actual_mix_message);
        Thread.sleep(1000);

        // ========== STEP 3: SELECT FIRST AND SECOND CHECKBOX ==========
        paddMethod.multipleCheckboxclick();
        Thread.sleep(2000);
    }

}
