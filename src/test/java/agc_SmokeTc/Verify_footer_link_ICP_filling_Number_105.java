package agc_SmokeTc;

import com.agc.sel.agc_pageObject.AGC_Methods;
import com.agc.sel.baseutilities.BaseClass;
import org.testng.annotations.Test;

public class Verify_footer_link_ICP_filling_Number_105 extends BaseClass {
    @Test
    public void footer_link_ICP_filling() throws Throwable {
        AGC_Methods agc = new AGC_Methods(driver);
        agc.verifyLinkByUrlorPage.accept(agc.icpFilingNumberLink,"ICP");
    }
}
