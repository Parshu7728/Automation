package ACS_Basic_Anonymous;

import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.agc_pageObject.Login_Ansell_Guardian;
import com.agc.sel.agc_pageObject.My_Report;
import com.agc.sel.loggers.Logger4j;
import org.testng.annotations.Test;

/**
 * This class contains a smoke test case to verify the functionality of changing
 * flag symbols in the application. It extends the BaseClass and uses TestNG
 * annotations for test execution.
 */
public class withoutLogin_Change_of_flag_symbols_TC30 extends BaseClass {

    /**
     * Test case to perform flag change operations and log the title text after each
     * flag change.
     *
     * @throws Exception if any error occurs during the test execution
     */
    @Test(groups = "NoLogin")
    public void testChangeFlagSuccessfully() throws Exception {

         //Accept the cookies
        Login_Ansell_Guardian login = new Login_Ansell_Guardian(driver);
        login.cookies_Handle();

        Logger4j.info("Performing Flag Change operations & logging title text after each flag change");

        // Initialize the My_Report object for handling flag change operations
        My_Report my_report = new My_Report(driver);

        // Perform flag change operations and retrieve the title text for each change
        String korean = my_report.flag_Change_Us_Korean();
        // Log the title text for each flag change
        Logger4j.info(korean);

        String chinease = my_report.flag_Change_Korean_Chinease();
        // Log the title text for each flag change
        Logger4j.info(chinease);

        String deutsch = my_report.flag_Change_Chinease_Deutsch();
        // Log the title text for each flag change
        Logger4j.info(deutsch);

        String us = my_report.flag_Change_Deutsch_Us();
        // Log the title text for each flag change
        Logger4j.info(us);
    }
}
