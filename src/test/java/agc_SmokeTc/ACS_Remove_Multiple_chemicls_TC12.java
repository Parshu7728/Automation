package agc_SmokeTc;

import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.agc_pageObject.Advanced_Chemical_Product_Selector_Hand_Protection;
import com.agc.sel.agc_pageObject.My_Report;
import com.agc.sel.agc_pageObject.SortingElements;
import com.agc.sel.loggers.Logger4j;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * This class contains a smoke test case to verify the functionality of removing
 * multiple chemicals in the Advanced Chemical Selector (ACS) module. It extends
 * the BaseClass and uses TestNG annotations for test execution.
 */
public class ACS_Remove_Multiple_chemicls_TC12 extends BaseClass {

	// Chemical text values retrieved from the properties file
	public String chemical_Text1;
	public String chemical_Text2;

	// Object for handling operations in the ACS Hand Protection module
	public Advanced_Chemical_Product_Selector_Hand_Protection acs_Hand_Protection;

	// Object for handling sorting operations
	SortingElements sorting_Elements;

	// Object for handling report-related operations
	public My_Report my_Report;

	/**
	 * Test case to remove multiple chemicals in the ACS module.
	 * This test verifies:
	 * 1. Successful navigation to ACS module
	 * 2. Addition of multiple chemicals
	 * 3. Successful removal of all chemicals
	 *
	 * @throws Exception if any error occurs during the test execution
	 */
	@Test
	public void acs_ChemicalSorting() throws Exception {

		// Retrieve chemical names from the properties file
		chemical_Text1 = prop_utility.unsignedchemical1();
		chemical_Text2 = prop_utility.unsignedchemical2();

		// Assert that chemical names are retrieved successfully
		assertionCheck.assertTrue(chemical_Text1 != null && !chemical_Text1.trim().isEmpty(), 
			"Chemical Text 1 should not be null or empty");
		assertionCheck.assertTrue(chemical_Text2 != null && !chemical_Text2.trim().isEmpty(), 
			"Chemical Text 2 should not be null or empty");
		Logger4j.info("Chemical names retrieved: " + chemical_Text1 + " and " + chemical_Text2);

		Logger4j.info("Initialize the object and perform the rest of the operations");
		// Initialize the ACS Hand Protection, My_Report, and SortingElements objects
		acs_Hand_Protection = new Advanced_Chemical_Product_Selector_Hand_Protection(driver);
		My_Report my_Report = new My_Report(driver);
		sorting_Elements = new SortingElements(driver);

		// Assert objects are initialized properly
		assertionCheck.assertTrue(acs_Hand_Protection != null, 
			"ACS Hand Protection object should be initialized");
		assertionCheck.assertTrue(my_Report != null, 
			"My Report object should be initialized");

		try {
			// Attempt to execute hamBurger_MyReport
			my_Report.hamBurger_MyReport();
			Logger4j.info("Successfully navigated to hamburger menu");
			
			// If successful, execute ansell_acs_MyReport
			my_Report.ansell_acs_MyReport(driver);
			Logger4j.info("Successfully navigated to ACS module");

			// Verify that we are on the correct page by checking for disclaimer
			waitTime.elementToBeClickable(driver.findElement(By.id("disclaimerAgree")));
			assertionCheck.assertTrue(driver.findElement(By.id("disclaimerAgree")).isDisplayed(), 
				"Disclaimer agree button should be visible on ACS page");

			// Click on the "Agree" button to proceed
			acs_Hand_Protection.agree_Button();
			Logger4j.info("Clicked on agree button successfully");

			// Wait for the page to load after agreeing to disclaimer
			Thread.sleep(2000);

		} catch (Exception e) {
			Logger4j.error("Error during navigation to ACS module: " + e.getMessage());
			Assert.fail("Failed to navigate to ACS module: " + e.getMessage());
		}

		// Get initial chemical count before adding chemicals
		String initialChemicalCount = "0";
		try {
			initialChemicalCount = acs_Hand_Protection.beforeRemovingChemicals();
			Logger4j.info("Initial chemical count: " + initialChemicalCount);
		} catch (Exception e) {
			Logger4j.warn("Could not get initial chemical count, proceeding with test");
		}

		try {
			// Perform operations to handle specific chemicals in ACS
			acs_Hand_Protection.acs_HandProtection_Chemicals_for_unsigned(chemical_Text1, chemical_Text2);
			Logger4j.info("Successfully added chemicals to ACS");

			// Wait for chemicals to be processed
			Thread.sleep(3000);

			// Get chemical count after adding chemicals
			String chemicalCountAfterAdding = acs_Hand_Protection.beforeRemovingChemicals();
			Logger4j.info("Chemical count after adding: " + chemicalCountAfterAdding);

			// Assert that chemicals were added successfully
			int initialCount = parseChemicalCount(initialChemicalCount);
			int countAfterAdding = parseChemicalCount(chemicalCountAfterAdding);
			
			assertionCheck.assertTrue(countAfterAdding > initialCount, 
				"Chemical count should increase after adding chemicals. Initial: " + initialCount + 
				", After adding: " + countAfterAdding);
			
			// Verify that at least 2 chemicals were added
			assertionCheck.assertTrue(countAfterAdding >= 2, 
				"At least 2 chemicals should be added. Current count: " + countAfterAdding);

		} catch (Exception e) {
			Logger4j.error("Error during chemical addition: " + e.getMessage());
			Assert.fail("Failed to add chemicals: " + e.getMessage());
		}

		try {
			// Remove all chemicals from the ACS module
			acs_Hand_Protection.remove_All_Chemical();
			Logger4j.info("Executed remove all chemicals operation");

			// Wait for removal to complete
			Thread.sleep(3000);

			// Get chemical count after removal
			String chemicalCountAfterRemoval = acs_Hand_Protection.afterRemovingChemical();
			Logger4j.info("Chemical count after removal: " + chemicalCountAfterRemoval);

			// Assert that chemicals were removed successfully
			int countAfterRemoval = parseChemicalCount(chemicalCountAfterRemoval);
			assertionCheck.assertTrue(countAfterRemoval == 0, 
				"All chemicals should be removed. Expected: 0, Actual: " + countAfterRemoval);

			Logger4j.info("Successfully verified that all chemicals are removed from ACS");

		} catch (Exception e) {
			Logger4j.error("Error during chemical removal: " + e.getMessage());
			Assert.fail("Failed to remove chemicals: " + e.getMessage());
		}

		// Final verification - ensure we can still interact with the page
		try {
			assertionCheck.assertTrue(driver.getCurrentUrl().contains("ansellguardian"), 
				"Should still be on Ansell Guardian platform");
			Logger4j.info("Test completed successfully - Multiple chemicals removal verified");
		} catch (Exception e) {
			Logger4j.warn("Could not verify final page state, but main test objectives completed");
		}
	}

	/**
	 * Helper method to parse chemical count from string
	 * Handles various formats like "2 chemicals", "0", etc.
	 */
	private int parseChemicalCount(String countText) {
		if (countText == null || countText.trim().isEmpty()) {
			return 0;
		}
		
		try {
			// Extract numeric part from the text
			String numericPart = countText.replaceAll("[^0-9]", "");
			if (numericPart.isEmpty()) {
				return 0;
			}
			return Integer.parseInt(numericPart);
		} catch (NumberFormatException e) {
			Logger4j.warn("Could not parse chemical count from: " + countText);
			return 0;
		}
	}
}
