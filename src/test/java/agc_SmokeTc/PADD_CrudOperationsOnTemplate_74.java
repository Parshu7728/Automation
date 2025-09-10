package agc_SmokeTc;

import com.agc.sel.agc_pageObject.My_Report;
import com.agc.sel.agc_pageObject.Padd_BodyProtection_elements;
import com.agc.sel.agc_pageObject.Padd_HandProtection_elements;
import com.agc.sel.agc_pageObject.Padd_Methods;
import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.loggers.Logger4j;
import org.testng.annotations.Test;

public class PADD_CrudOperationsOnTemplate_74 extends BaseClass {
    String random = Rn.randomNumber(4);

    @Test
    public void PADD_CrudOperationsOnTemplate() throws Throwable {
        Logger4j.info("PADD_CrudOperationsOnTemplate");
        paddMethod.initializeAndCreateRequest();
        padd_Hp.add_Multiple_Chemicals_dialog_box();
        String templateName = "Template_" + random;
        paddMethod.crudOperationsOnTemplate(templateName);
    }
}
