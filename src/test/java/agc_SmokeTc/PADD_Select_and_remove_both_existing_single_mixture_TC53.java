package agc_SmokeTc;

import com.agc.sel.baseutilities.BaseClass;
import org.testng.annotations.Test;

public class PADD_Select_and_remove_both_existing_single_mixture_TC53 extends BaseClass {
    String mixture = prop_utility.mixture1();
    @Test
    public void selecting_and_removing_chemicals() throws Throwable {
        paddMethod.initializeAndCreateRequest();
        padd_Hp.add_Multiple_Chemicals_dialog_box();
        padd_Hp.Add_existing_Mixture(mixture);
        Thread.sleep(2000);
        paddMethod.selectAllCheckboxes(3);
        paddMethod.clickOnRemoveButton();
    }
}
