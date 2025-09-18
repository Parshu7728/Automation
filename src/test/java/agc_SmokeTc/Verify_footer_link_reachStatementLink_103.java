package agc_SmokeTc;

import com.agc.sel.agc_pageObject.AGC_Methods;
import com.agc.sel.baseutilities.BaseClass;
import org.testng.annotations.Test;

public class Verify_footer_link_reachStatementLink_103 extends BaseClass {
    @Test
    public void verifyFooterLinkReachStatementLInk() throws Throwable {
        AGC_Methods agc = new AGC_Methods(driver);
        agc.verifyLinkByUrl.accept(agc.reachStatementLink, "reach-statement");
    }
}
