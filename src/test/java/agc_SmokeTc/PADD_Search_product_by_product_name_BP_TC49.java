package agc_SmokeTc;
import com.agc.sel.baseutilities.BaseClass;
import org.testng.annotations.Test;

public class PADD_Search_product_by_product_name_BP_TC49 extends BaseClass {
    String bpProduct1 = prop_utility.bpProduct1();
    String bpProduct2 = prop_utility.bpProduct2();
    @Test
    public void padd_search_product_by_product_name() throws Throwable {
        paddMethod.initializeAndCreateRequest();
        padd_Bp.switch_To_BodyProtection();
        padd_Bp.product_For_Bp(bpProduct1,bpProduct2);
    }
}
