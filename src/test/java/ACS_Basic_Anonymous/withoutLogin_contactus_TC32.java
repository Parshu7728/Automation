package ACS_Basic_Anonymous;

import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.agc_pageObject.Login_Ansell_Guardian;
import com.agc.sel.agc_pageObject.My_Report;
import com.agc.sel.loggers.Logger4j;
import org.testng.annotations.Test;

public class withoutLogin_contactus_TC32  extends BaseClass {
    String message = "Please sign in to avail this feature";
@Test(groups ="NoLogin")
 public void testcontactUs() throws InterruptedException{
    Login_Ansell_Guardian login = new Login_Ansell_Guardian(driver);
    login.cookies_Handle();
    Logger4j.info("clicking on support button");
    My_Report my_report = new My_Report(driver);
    my_report.contactUs_withoutLogin(message);
    Logger4j.info("successfully verified");

}
}
