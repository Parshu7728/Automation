package agc_SmokeTc;

import com.agc.sel.baseutilities.BaseClass;
import org.testng.annotations.Test;

public class PADD_Verify_selected_FAQs_displayed_77 extends BaseClass {
    @Test
    public void verifySelectedFAQsDisplayed() throws Throwable {
        paddMethod.initializeAndCreateRequest();
        paddMethod.ViewAllFAQsList();
        paddMethod.printFAQRows();
    }

}