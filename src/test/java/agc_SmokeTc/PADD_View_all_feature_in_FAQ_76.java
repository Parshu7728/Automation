package agc_SmokeTc;
import com.agc.sel.baseutilities.BaseClass;
import org.testng.annotations.Test;

public class PADD_View_all_feature_in_FAQ_76 extends BaseClass {
    @Test
    public void View_all_feature_in_FAQ() throws Throwable {
        paddMethod.initializeAndCreateRequest();
        paddMethod.ViewAllFAQsList();
    }

}