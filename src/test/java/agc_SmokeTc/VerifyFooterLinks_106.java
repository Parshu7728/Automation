package agc_SmokeTc;

import com.agc.sel.agc_pageObject.AGC_Methods;
import com.agc.sel.agc_pageObject.Padd_Methods;
import com.agc.sel.baseutilities.BaseClass;
import org.testng.annotations.Test;
public class VerifyFooterLinks_106 extends BaseClass {
    @Test(groups = "basic")
    public void footer_links() throws Throwable {
        AGC_Methods agc = new AGC_Methods(driver);
        Padd_Methods padd = new Padd_Methods(driver);
        padd.scrollToBottomSmooth();
        // ----------- Static Footer Links (by URL) -----------
        agc.verifyLinkByUrl.accept(agc.privacyPolicyLink, "privacy-policy");
        agc.verifyLinkByUrl.accept(agc.termsOfUseLink, "terms-of-use");
        agc.verifyLinkByUrl.accept(agc.cookiePolicyLink, "cookie-policy");
        agc.verifyLinkByUrl.accept(agc.productDisclaimerLink, "product-disclaimer");
        agc.verifyLinkByUrl.accept(agc.reachStatementLink, "reach-statement");
        agc.verifyLinkByUrl.accept(agc.patentsLink, "patents");
        // ----------- Compliance Footer Links (URL or Page) -----------

        //Takes too long to load the page
       // agc.verifyLinkByUrlorPage.accept(agc.icpFilingNumberLink, "ICP");
    }
}
