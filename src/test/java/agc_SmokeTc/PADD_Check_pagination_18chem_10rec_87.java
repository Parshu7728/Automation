package agc_SmokeTc;

import com.agc.sel.baseutilities.BaseClass;
import org.testng.annotations.Test;

public class PADD_Check_pagination_18chem_10rec_87 extends BaseClass {
    String dropdown = padd_utility.records_per_page10();
    int chemnum = padd_utility.number_of_chemicals18();
    @Test
    public void check_pagination_of_table_18chem_10rec() throws Throwable {
        paddMethod.initializeAndCreateRequest();
        paddMethod.uploadTemplate18_chem();
        Thread.sleep(2000);
        paddMethod.PADDcheckPagination(chemnum, dropdown);
    }
}
