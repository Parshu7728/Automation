package agc_SmokeTc;

import com.agc.sel.agc_pageObject.My_Report;
import com.agc.sel.agc_pageObject.Padd_BodyProtection_elements;
import com.agc.sel.agc_pageObject.Padd_HandProtection_elements;
import com.agc.sel.baseutilities.BaseClass;
import org.testng.annotations.Test;

public class PADD_Search_product_by_product_name_HP_TC48 extends BaseClass {
    public Padd_BodyProtection_elements padd_Bp;
    public Padd_HandProtection_elements padd_Hp;
    public My_Report my_Report;
    String organization_Name;
    String email;
    String contact_Name;
    String telephone;
    String random;
    String hpProduct1 = prop_utility.hpProduct1();
    String hpProduct2 = prop_utility.hpProduct2();
    @Test
    public void searchProductByName() throws Exception {
        organization_Name = prop_utility.organization_Name();
        email = prop_utility.email();
        contact_Name = prop_utility.contact_Name();
        telephone = prop_utility.telephone();
        random = Rn.randomNumber(4);
        // Initialize Hand Protection page object
        padd_Hp = new Padd_HandProtection_elements(driver);
        // Initialize Body Protection page object
        padd_Bp = new Padd_BodyProtection_elements(driver);
        // Initialize My Report page object
        my_Report = new My_Report(driver);
        // Create a new risk request in My Report
        my_Report.newRiskRequest();
        my_Report.create_Request();
        padd_Hp.organization_Model_Window_Details_Padd(organization_Name + random, email, contact_Name, telephone);
        Thread.sleep(2000);
        padd_Hp.padd_Product(hpProduct1,hpProduct2);

    }
}
