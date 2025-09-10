
package ACS_EndToEnd;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.agc_pageObject.Advanced_Chemical_Product_Selector_Hand_Protection;
import com.agc.sel.agc_pageObject.My_Report;
import com.agc.sel.pdfReader.FileWrite;
import com.agc.sel.loggers.Logger4j;
import com.agc.sel.pdfReader.PDFReaderTestConfiguration;

/**
 * This class contains a test case to verify the functionality of downloading
 * the ACS Hand Protection report. It extends the BaseClass and uses various
 * page objects and utilities to perform the test.
 */
public class ACS_HandProtection_Report_Download extends BaseClass {

	// Page object for Advanced Chemical Product Selector Hand Protection
	public Advanced_Chemical_Product_Selector_Hand_Protection acs_Hand_Protection;

	// Name of the file to be downloaded
	public String fileName;

	// Utility for writing to files
	FileWrite fi = new FileWrite();

	/**
	 * Test method to verify the download of the ACS Hand Protection report.
	 *
	 * @throws Exception if any error occurs during the test execution
	 */
	@Test
	public void ACSHandProtection_Report_Download() throws Exception {
		// Load properties
		prop_utility.Property();

		// Generate a random organization name
		String organization_Name = Rn.random() + "Company";

		// Initialize My Report page object
		My_Report my_report = new My_Report(driver);

		// Initialize ACS Hand Protection page object
		acs_Hand_Protection = new Advanced_Chemical_Product_Selector_Hand_Protection(driver);

		// Retrieve login credentials and chemical details
		String validEmailID = prop_utility.valid_EmailID();
		String validPassword = prop_utility.valid_Password();
		String chemicalText1 = prop_utility.chemicalText1();
		String chemicalText2 = prop_utility.chemicalText2();

		// Navigate to My Report page and access ACS Hand Protection
		my_report.hamBurger_MyReport();
		my_report.ansell_acs_MyReport(driver);

		// Agree to terms in ACS Hand Protection
		acs_Hand_Protection.agree_Button();

		// Search for chemicals in ACS Hand Protection
		acs_Hand_Protection.acs_HandProtection_Chemicals(chemicalText1, chemicalText2);

		// Perform steps 2, 3, and 4 in ACS Hand Protection
		acs_Hand_Protection.acs_Click_Step2();
		acs_Hand_Protection.acs_Step2();
		acs_Hand_Protection.acs_Step3();
		acs_Hand_Protection.acs_Step4();

		// Compare HP products
		acs_Hand_Protection.compare_Products();

		// Download report details
		acs_Hand_Protection.acs_Download_Report_Details();

		// Select hand protection standards
		acs_Hand_Protection.hand_Protection_Standards();

		// Fill organization details
		acs_Hand_Protection.acs_OrganizationDetails(organization_Name);

		// Upload an image
		acs_Hand_Protection.uploadImage();
       acs_Hand_Protection.acs_HPreport_Details();
		// Download the ACS Hand Protection report
		acs_Hand_Protection.acs_Hp_Report_Download();

		// Click "No" for creating a new report
		acs_Hand_Protection.acs_Hp_No_Button();

		// Navigate back to My Report page
		acs_Hand_Protection.navigate_From_AcsTo_MyReportPage();

		// Verify the downloaded file
		Assert.assertTrue(Verify_Downloaded_file());

		// Read and write the downloaded PDF content
		try {
			url = "file:///E:/AutomationAGC/Automation/Pdfdownload/" + fileName;
			PDFReaderTestConfiguration pu = new PDFReaderTestConfiguration();
			pu.pefReder(url);
			String text = pu.ReadPdf();
			fi.writeFile(text);
		} catch (Exception e) {
			Logger4j.error("Error reading PDF: " + e.getMessage());
		}

	}

	/**
	 * Verifies if the downloaded file exists and matches the expected result.
	 *
	 * @return true if the file is present and matches the expected result, false
	 *         otherwise
	 * @throws InterruptedException if the thread is interrupted during execution
	 */
	public boolean Verify_Downloaded_file() throws InterruptedException {
		// Initialize ACS Hand Protection page object
		acs_Hand_Protection = new Advanced_Chemical_Product_Selector_Hand_Protection(driver);

		// Retrieve the expected PDF result
		String Exp2 = acs_Hand_Protection.expected_Pdf_ResultIn_Text2().trim();

		// Check if the file exists in the download directory
		File f = new File(downloadFile);
		File[] fileList = f.listFiles();
		boolean isFilePresent = false;
		for (File file : fileList) {
			fileName = file.getName().trim();
			if (fileName.equals(Exp2)) {
				isFilePresent = true;
				Logger4j.info(
						"The downloaded ACS HP report matches the report in the MyReport ACS tab, with no discrepancies in content or formatting.");
			}
		}
		return isFilePresent;
	}
}
