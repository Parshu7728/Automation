package agc_SmokeTc;
import com.agc.sel.baseutilities.Asserrtion;
import com.agc.sel.baseutilities.BaseClass;
import org.testng.annotations.Test;

public class PADD_Check_for_standards_ASTM_HP_67 extends BaseClass {
    @Test
    public void checkStandardsASTMHP() throws Throwable {
        paddMethod.initializeAndCreateRequest();
        String standard = "ASTM F739";
       String validate =  paddMethod.Standardcheck(standard);
        Asserrtion.verification(standard, validate);
    }
}