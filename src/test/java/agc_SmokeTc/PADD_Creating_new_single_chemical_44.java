package agc_SmokeTc;

import com.agc.sel.baseutilities.Asserrtion;
import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.loggers.Logger4j;
import org.testng.annotations.Test;

public class PADD_Creating_new_single_chemical_44 extends BaseClass {
    String expected_final_message = "Chemical added in Hand & Body Protection";

    @Test
    public void padd_Creating_single_chemical() throws Throwable {
        Logger4j.info("Padd_Creating_single_chemical");
        // Retrieve organization and contact details
        paddMethod.initializeAndCreateRequest();
        paddMethod.clickOnCreateNewSinglesMixtures();
        paddMethod.CreatingNewSingles();
        paddMethod.enterCASNumber(prop_utility.replaceable_cas());
        paddMethod.enterChemicalName(prop_utility.replaceable_Chemical1());
        paddMethod.setPhysical_state_select();
        paddMethod.enterConcentration("80");
        paddMethod.clickOnSaveButton();
        Thread.sleep(1000);
        Asserrtion asserrtion = new Asserrtion();
        String actual_message = paddMethod.getFinalMessage();
        asserrtion.verification(expected_final_message, actual_message);

    }
}
