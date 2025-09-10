package ACS_Basic_Anonymous;

import com.agc.sel.agc_pageObject.Login_Ansell_Guardian;
import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.agc_pageObject.My_Report;
import com.agc.sel.loggers.Logger4j;
import com.agc.sel.baseutilities.WebWait;
import org.testng.annotations.Test;

/**
 * This class contains a smoke test case to verify the "Contact Us"
 * functionality in the application. It extends the BaseClass and uses TestNG
 * annotations for test execution.
 */
public class Negative_withoutLogin_Contact_Us_TC31 extends BaseClass {

    // Expected text to verify the "Contact Us" functionality
    String expectedText = "Please Sign In to avail this feature";

    // Utility object for handling explicit waits
    WebWait time;

    // Text message to be sent in the "Contact Us" form
    String text = "Hi";

    /**
     * Test case to verify the "Contact Us" functionality.
     *
     * @throws Throwable if any error occurs during the test execution
     */
    @Test(groups = "NoLogin")
    public void contact_US() throws InterruptedException {
        Login_Ansell_Guardian loginansellGuardian = new Login_Ansell_Guardian(driver);
        loginansellGuardian.cookies_Handle();
        Logger4j.info("clicking on support button");
        My_Report my_Report = new My_Report(driver);
        // Send a message using the "Contact Us" form
        my_Report.contactUs(text);

        // Retrieve the actual text displayed after submitting the form
        String actualText = my_Report.contacttext();

        // Verify the actual text matches the expected text
        assertionCheck.verification(expectedText, actualText);
    }
}
