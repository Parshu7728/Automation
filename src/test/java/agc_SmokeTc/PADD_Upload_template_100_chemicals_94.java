package agc_SmokeTc;

import com.agc.sel.baseutilities.BaseClass;
import org.testng.annotations.Test;

public class PADD_Upload_template_100_chemicals_94 extends BaseClass {
    String dropdown = padd_utility.records_per_page50();
    int chemnum = padd_utility.number_of_chemicals100();
    @Test
    public void Upload_template_for100Chemicals() throws Throwable {
        // Fetch test data
        paddMethod.initializeAndCreateRequest();
        paddMethod.uploadTemplate100_dataTest();
        Thread.sleep(3000);
        String excelFilePath = "E:/AutomationAGC/Automation/Pdfdownload";
//        paddMethod.compareExcelAndWebTableData();
        paddMethod.readExcelToHashMap(excelFilePath);
        paddMethod.PADDcheckPaginationData(chemnum,dropdown);
        paddMethod.compareWebDataWithExcel(excelFilePath, chemnum, dropdown);
    }
}