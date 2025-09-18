package agc_SmokeTc;

import com.agc.sel.agc_pageObject.AGC_Methods;
import com.agc.sel.baseutilities.BaseClass;
import org.testng.annotations.Test;

public class Verify_footer_link_patents_104 extends BaseClass {
    @Test
    public void footer_link_patents() throws Throwable {
        AGC_Methods agc =  new AGC_Methods(driver);
        agc.verifyLinkByUrl.accept(agc.patentsLink, "patents");
    }
}
