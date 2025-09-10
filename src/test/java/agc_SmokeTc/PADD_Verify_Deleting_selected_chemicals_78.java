package agc_SmokeTc;

import com.agc.sel.baseutilities.BaseClass;
import org.testng.annotations.Test;

public class PADD_Verify_Deleting_selected_chemicals_78 extends BaseClass {
    @Test
    public void deleting_selected_chemicals() throws Throwable {
        paddMethod.initializeAndCreateRequest();
        paddMethod.ViewAllFAQsList();
        paddMethod.faqDeletion();
    }
}
