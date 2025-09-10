package agc_SmokeTc;

import com.agc.sel.agc_pageObject.My_Report;
import com.agc.sel.agc_pageObject.Padd_BodyProtection_elements;
import com.agc.sel.agc_pageObject.Padd_HandProtection_elements;
import com.agc.sel.agc_pageObject.Padd_Methods;
import com.agc.sel.baseutilities.BaseClass;
import org.testng.annotations.Test;

public class PADD_Crud_operations_on_comments_73 extends BaseClass {
    public Padd_BodyProtection_elements padd_Bp;
    public Padd_HandProtection_elements padd_Hp;
    public My_Report my_Report;

    /**
     * Test method to perform CRUD operations on comments.
     *
     * This test initializes the necessary page objects and performs the following steps:
     * 1. Creates a new risk request.
     * 2. Adds a comment to the Hand Protection section and verifies the success message.
     * 3. Edits the previously added comment and verifies the success message.
     * 4. Deletes the comment and verifies the deletion message.
     *
     * @throws Throwable if any exception occurs during the test execution.
     */
    @Test
    public void CrudOperationsOnComments() throws Throwable {
        // Initialize page objects
        my_Report = new My_Report(driver);
        Padd_Methods paddMethod = new Padd_Methods(driver);
        padd_Bp = new Padd_BodyProtection_elements(driver);
        padd_Hp = new Padd_HandProtection_elements(driver);

        // Create request flow
        my_Report.newRiskRequest();
        my_Report.create_Request();
        paddMethod.organizationDetails();
        padd_Hp.add_Multiple_Chemicals_dialog_box();

        // --- Add Comment ---
        String addMsg = paddMethod.addComment("This is a test comment for Hand Protection.");
        assertionCheck.verification(addMsg, "Comments saved successfully");

        // --- Edit Comment ---
        String editMsg = paddMethod.editComment("Updated comment text for Hand Protection.");
        assertionCheck.verification(editMsg, "Comments saved successfully");

        // --- Delete Comment ---
        String deleteMsg = paddMethod.deleteComment();
        assertionCheck.verification(deleteMsg, "Comment deleted");
    }

}
