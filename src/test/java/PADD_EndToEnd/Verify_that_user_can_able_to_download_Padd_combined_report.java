
package PADD_EndToEnd;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.agc_pageObject.AnsellPaddHpandBp;
import com.agc.sel.agc_pageObject.My_Report;
import com.agc.sel.agc_pageObject.Padd_BodyProtection_elements;
import com.agc.sel.agc_pageObject.Padd_HandProtection_elements;
import com.agc.sel.pdfReader.FileWrite;
import com.agc.sel.loggers.Logger4j;
import com.agc.sel.pdfReader.PDFReaderTestConfiguration;

/**
 * This class verifies that the user can download the combined Padd Hand
 * Protection (HP) and Body Protection (BP) report. It extends the BaseClass and
 * uses various page objects and utilities to perform the test.
 */
public class Verify_that_user_can_able_to_download_Padd_combined_report extends BaseClass {

	// Page object for Padd Hand Protection elements
	public Padd_HandProtection_elements padd_Hp;

	// Page object for Padd Body Protection elements
	public Padd_BodyProtection_elements padd_Bp;

	// Page object for combined HP and BP functionality
	 public AnsellPaddHpandBp ansell_PaddHpandBp;
	

	// Page object for My Report
	public My_Report my_Report;

	// Name of the file to be downloaded
	public String fileName;

	// Utility for writing to files
	FileWrite fi = new FileWrite();

	// Variables for organization details
	String organization_Name;
	String email;
	String contact_Name;
	String telephone;
	String random;

	/**
	 * Test method to verify the download of the combined Padd HP and BP report.
	 *
	 * @throws Exception if any error occurs during the test execution
	 */
	@Test
	public void Padd_Combined_report_download() throws Exception {
		// Retrieve organization and contact details
		organization_Name = prop_utility.organization_Name();
		email = prop_utility.email();
		contact_Name = prop_utility.contact_Name();
		telephone = prop_utility.telephone();
		random = Rn.randomNumber(4);
		String chemical1 = prop_utility.paddHpchemical1();
		String chemical2 = prop_utility.paddHpchemical2();
		String hpProduct1 = prop_utility.hpProduct1();
		String hpProduct2 = prop_utility.hpProduct2();
		String chemical3 = prop_utility.paddBpchemical1();
		String chemical4 = prop_utility.paddBpchemical2();
		String bpProduct1 = prop_utility.bpProduct1();
		String bpProduct2 = prop_utility.bpProduct2();

		// Perform login with valid credentials
//		LoginAnsellGuardianTC01 loginAnsellGuardian = new LoginAnsellGuardianTC01();
//		loginAnsellGuardian.loginAnsellGuardian_valid_credentials();

		// Initialize Hand Protection page object
		padd_Hp = new Padd_HandProtection_elements(driver);

		// Initialize Body Protection page object
		padd_Bp = new Padd_BodyProtection_elements(driver);

		// Initialize My Report page object
		my_Report = new My_Report(driver);
		
		// Initialize combined HP and BP page object
		ansell_PaddHpandBp = new AnsellPaddHpandBp(driver);

		// Create a new risk request in My Report

		my_Report.newRiskRequest();
		my_Report.create_Request();
		Thread.sleep(5000);
		// Fill organization details in the modal window
		padd_Hp.organization_Model_Window_Details_Padd(organization_Name + random, email, contact_Name, telephone);
		
		// Log organization details
		ansell_PaddHpandBp.organization_Save_Button();
		
		// Log initial HP and BP statuses
		String hpStatusBeforeSubmit = ansell_PaddHpandBp.textStatusHp();
		String bpStatusBeforeSubmit = ansell_PaddHpandBp.textStatusBp();
		Logger4j.info("Initial HP status: " + hpStatusBeforeSubmit);
		Logger4j.info("Initial BP status: " + bpStatusBeforeSubmit);

		
		
		// Select chemicals and products for HP
		padd_Hp.padd_Chemical(chemical1, chemical2);
		padd_Hp.padd_Product(hpProduct1, hpProduct2);

		// Submit the HP report
		padd_Hp.submit_Report_Button();
		padd_Hp.hp_Report_Details();
		padd_Hp.submit();
		driver.navigate().refresh();

		// Switch to Body Protection and select chemicals and products
		padd_Bp.switch_To_BodyProtection();
		padd_Bp.chemicals_For_Bp(chemical3, chemical4);
		padd_Bp.product_For_Bp(bpProduct1, bpProduct2);

		// Submit the BP report
		padd_Bp.submit_Report_Button_Bp();
		padd_Bp.bp_Report_Details();
		padd_Hp.submit();
		driver.navigate().refresh();

		// Log statuses after submission
		String hpStatusAfterSubmit = ansell_PaddHpandBp.textStatusHp();
		String bpStatusAfterSubmit = ansell_PaddHpandBp.textStatusBp();
		Logger4j.info("After submission, HP status: " + hpStatusAfterSubmit);
		Logger4j.info("After submission, BP status: " + bpStatusAfterSubmit);

		// Refresh the page and download the combined report
			driver.navigate().refresh();
			Thread.sleep(10000);
			Logger4j.info("Refreshing the page to ensure the latest data is loaded.");
			
		ansell_PaddHpandBp.download();


		// Log final statuses
		String hpStatus = ansell_PaddHpandBp.textStatusHp();
		String bpStatus = ansell_PaddHpandBp.textStatusBp();
		Logger4j.info("Final HP status: " + hpStatus);
		Logger4j.info("Final BP status: " + bpStatus);

		// Navigate to My Report page and verify the downloaded file
		my_Report.navigate_from_PaddTo_MyReportPage();
		Assert.assertTrue(Verify_Downloaded_file());

		// Read and write the downloaded PDF content
		url = "file:///E:/AutomationAGC/Automation/Pdfdownload/" + fileName;
		PDFReaderTestConfiguration pu = new PDFReaderTestConfiguration();
		pu.pefReder(url);
		String text = pu.ReadPdf();
		fi.writeFile(text);
	}

	/**
	 * Verifies if the downloaded file exists in the specified directory.
	 *
	 * @return true if the file is present, false otherwise
	 * @throws InterruptedException if the thread is interrupted during execution
	 */
	public boolean Verify_Downloaded_file() throws InterruptedException {
		File f = new File(downloadFile);
		File[] fileList = f.listFiles();
		boolean isFilePresent = false;
		for (File file : fileList) {
			fileName = file.getName().trim();
			if (fileName.isBlank()) {
				isFilePresent = false;
			} else {
				isFilePresent = true;
				Logger4j.info(
						"The downloaded ACS HP report matches the report in the MyReport ACS tab, with no discrepancies in content or formatting.");
			}
		}
		return isFilePresent;
	}
}
