package agc_SmokeTc;

import com.agc.sel.baseutilities.BaseClass;
import org.testng.annotations.Test;

public class PADD_Check_pagination_18chem_50rec_89 extends BaseClass {
    String dropdown = padd_utility.records_per_page50();
    int chemnum = padd_utility.number_of_chemicals18();
    @Test
    public void check_pagination_of_table_18chem_50rec() throws Throwable {
        paddMethod.initializeAndCreateRequest();
        paddMethod.uploadTemplate18_chem();
        Thread.sleep(2000);
        paddMethod.PADDcheckPagination(chemnum,dropdown);
    }
}
