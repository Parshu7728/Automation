package agc_SmokeTc;

import com.agc.sel.baseutilities.BaseClass;
import org.testng.annotations.Test;

public class PADD_Check_pagination_100chem_10rec_86 extends BaseClass {
    String dropdown = padd_utility.records_per_page10();
    int chemnum = padd_utility.number_of_chemicals100();
@Test
    public void check_pagination_of_table_100chem_10rec() throws Throwable {
        paddMethod.initializeAndCreateRequest();
        paddMethod.uploadTemplate100_chem();
        paddMethod.PADDcheckPagination(chemnum,dropdown);
    }
}
