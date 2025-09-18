package agc_SmokeTc;

import com.agc.sel.agc_pageObject.AGC_Methods;
import com.agc.sel.baseutilities.BaseClass;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.function.BiConsumer;

public class Verify_footer_link_privacy_policy_99 extends BaseClass{
    
    @Test
    public void verify_footer_link_privacy_policy() throws Throwable {
        AGC_Methods agc =  new AGC_Methods(driver);
        agc.verifyLinkByUrl.accept(agc.privacyPolicyLink, "privacy-policy");
    }
}
