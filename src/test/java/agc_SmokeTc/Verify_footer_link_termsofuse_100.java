package agc_SmokeTc;

import com.agc.sel.agc_pageObject.AGC_Methods;
import com.agc.sel.baseutilities.BaseClass;
import org.testng.annotations.Test;

public class Verify_footer_link_termsofuse_100 extends BaseClass {

    @Test
    public void verifyFooterLinkTermsOfUse() throws Throwable {
        AGC_Methods agc = new AGC_Methods(driver);
        agc.verifyLinkByUrl.accept(agc.termsOfUseLink, "terms-of-use");
    }
}
