package agc_SmokeTc;

import com.agc.sel.baseutilities.BaseClass;
import org.testng.annotations.Test;

public class PADD_Upload_template_18_chemicals_95 extends BaseClass {
    String dropdown = padd_utility.records_per_page50();
    int chemnum = padd_utility.number_of_chemicals18();
    @Test
    public void Upload_template_for18Chemicals() throws Throwable {
        // Fetch test data
        paddMethod.initializeAndCreateRequest();
        paddMethod.uploadTemplate18_dataTest();
        Thread.sleep(5000);
        String excelFilePath = "E:/AutomationAGC/Automation/Pdfdownload";
//        paddMethod.compareExcelAndWebTableData();
//        paddMethod.readExcelToHashMap(excelFilePath);
//        paddMethod.PADDcheckPaginationData(chemnum,dropdown);
        paddMethod.compareWebDataWithExcel(excelFilePath, chemnum, dropdown);
    }
}
