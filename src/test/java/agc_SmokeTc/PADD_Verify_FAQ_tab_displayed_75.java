package agc_SmokeTc;

import com.agc.sel.baseutilities.BaseClass;
import org.testng.annotations.Test;

public class PADD_Verify_FAQ_tab_displayed_75 extends BaseClass {
    @Test
    public void FAQ_tab_displayed() throws Throwable {
        paddMethod.initializeAndCreateRequest();
        paddMethod.FAQTabDisplay();
    }
}
