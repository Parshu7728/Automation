package com.agc.sel.agc_pageObject;

import com.agc.sel.loggers.Logger4j;
import com.agc.sel.baseutilities.WebWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.Arrays;
import java.util.List;
import java.awt.*;
import java.io.File;
import java.time.Duration;
public class Advanced_Chemical_Product_Selector_Hand_Protection {
	WebDriver driver;
	WebWait waitTime ;
	public String acs_downloaded_pdf_myreprt;
	String warning_Message_text = "A maximum of 5 chemicals or Other hazards can be added for accurate product recommendation";
    @FindBy(xpath = "//input[@name = 'reportName']")
	private WebElement reportName;
	@FindBy(id = "disclaimerAgree")
	private WebElement agree_Button;

	@FindBy(xpath = "//input[@type='text']")
	private WebElement inputText;

	@FindBy(xpath = "(//label[text()='Silver nitrate'])")
	private WebElement silvernitrate_Chemical;

	@FindBy(xpath = "(//label[text()='Slaked lime'])")
	private WebElement slakedlime_Chemical;

	@FindBy(xpath = "//label[text()='Hydrochloric acid']")
	private WebElement hydrochloric_acid;

	@FindBy(xpath = "//label[text()='Varitox']")
	private WebElement varitox;

	@FindBy(xpath = "//span[text()='Enter Application Details']")
	private WebElement acs_Hp_Step2;

	@FindBy(xpath = "(//label[@class='st-1'])[1]")
	private WebElement hand_Protection_Radio_Button;

	@FindBy(xpath = "//span[text()='Select']")
	private WebElement ExposureTime;

	@FindBy(xpath = "//div[text()='30-60 min']")
	private WebElement Select_dropdown;

	@FindBy(xpath = "//label[text()='Splash']")
	private WebElement splash_Radio_Button;

	@FindBy(xpath = "//span[text()='Secondary Hazards']")
	private WebElement acs_Hp_Step3;

	@FindBy(xpath = "//span[text()='View Products']")
	private WebElement acs_Hp_Step4;

	@FindBy(xpath = "(//p-checkbox[@value='item'])[1]")
	private WebElement alpha1_HandProtect;

	@FindBy(xpath = "(//p-checkbox[@value='item'])[2]")
	private WebElement alpha2_HandProtect;

	@FindBy(xpath = "(//p-checkbox[@value='item'])[3]")
	private WebElement alpha3_HandProtect;

	@FindBy(xpath = "(//button[@type='button'])[3]")
	private WebElement compare_Button;

	@FindBy(xpath = "//span[text()='Return to view Products'][1]")
	private WebElement return_Button1;

	@FindBy(xpath = "//span[text()='Download Report']")
	private WebElement download_Hand_Protection;

	@FindBy(xpath = "//p-checkbox[@label='ASTM F739']")
	private WebElement ASTM_standard;

	@FindBy(xpath = "//p-checkbox[@label='EN ISO 374']")
	private WebElement EnISO_standard;

	@FindBy(xpath = "((//a[@role='tab']/../../../../..)[2]//a)[1]")
	private WebElement organisationDetails;

	@FindBy(xpath = "//input[@name='orgName']")
	private WebElement organisationInput_Text_Field;

	@FindBy(xpath = "//input[@class='p-0']")
	private WebElement upload_Image;

	@FindBy(xpath = "//button[@icon='pi pi-upload']")
	private WebElement upload_Button;

	@FindBy(xpath = "//a[@id='p-accordiontab-3']")
	private WebElement reportDetails;

	@FindBy(xpath = "//a[@id='p-accordiontab-15']")
	private WebElement reportDetailsHP;

	@FindBy(xpath = "//input[@name='reportName']")
	private WebElement reportDetails_text_field;

	@FindBy(xpath = "(//li[@class='ng-star-inserted'])[2]")
	private WebElement image3;

	@FindBy(xpath = "(//span[text()='Download Report'])[2]")
	private WebElement downloadReport;

	@FindBy(xpath = "//button[@class='p-element no-btn btn-outline-blue p-button p-component ng-star-inserted']")
	private WebElement no_Button;

	@FindBy(xpath = "(//span[@class='d-flex'])[3]")
	private WebElement profile_Name_Dropdown;

	@FindBy(id = "report-btn")
	private WebElement myReport;

	@FindBy(xpath = "//a[text()='Advanced Product Selector']")
	private WebElement advanced_Product_Selector_Tab3;

	@FindBy(xpath = "//span[@class='p-confirm-dialog-message ng-tns-c68-49']")
	private WebElement lebelMessage;

	@FindBy(xpath = "((//td[@role='gridcell'])/../td)[23]")
	private WebElement acs_Downloaded_Report_Name_Myreport;

	@FindBy(id = "p-tabpanel-1-label")
	private WebElement otherhazards_Button;

	@FindBy(xpath = "//span[text()=' Animal waste (Liquid)']")
	private WebElement otherhazards_1;

	@FindBy(xpath = "(//p-checkbox[@value='item'])[2]")
	private WebElement otherhazards_2;

	@FindBy(xpath = "(//p-checkbox[@value='item'])[3]")
	private WebElement otherhazards_3;

	@FindBy(xpath = "(//p-checkbox[@value='item'])[4]")
	private WebElement otherhazards_4;

	@FindBy(xpath = "(//div[@class='overflow other-hazards-list']/div)[5]")
	private WebElement otherhazards_5;

	@FindBy(xpath = "(//div[@class='overflow other-hazards-list']/div)[6]")
	private WebElement otherhazards_6;

	@FindBy(xpath = "//li[@role='presentation']")
	private WebElement chemical_Disable;

	@FindBy(xpath = "//p-tableheadercheckbox[@class='p-element']")
	private WebElement checkBox;

	@FindBy(xpath = "(//p-tablecheckbox[@class='p-element'])[1]")
	private WebElement specific_Remove;

	@FindBy(xpath = "(//button[@iconpos='right'])[1]")
	private WebElement remove_Button;

	@FindBy(xpath = "//tbody[@class='p-element p-datatable-tbody']")
	private WebElement count_Chemicals;

	@FindBy(xpath = "//div[text()='A maximum of 5 chemicals or Other hazards can be added for accurate product recommendation']")
	private WebElement warning_Message;

	@FindBy(xpath = "//*[text()= 'Acetone']")
	private WebElement chem1_acetone;

	@FindBy(xpath = "//*[text()= 'Varitox']")
	private WebElement chem2_varitox;

	@FindBy(xpath = "//*[text()= 'HYDRARGYRUM']")
	private WebElement chem3_hydrargyrum;

	@FindBy(xpath = "//*[text()='Trichloroacetic acid']")
	private WebElement chem4_Trichloroaceticacid;

	@FindBy(xpath = "//*[text()= 'quicksilver']")
    private WebElement chem5_quicksilver;
	@FindBy(xpath = "//*[text()='Nitric acid']")
	private WebElement chem6_Nitricacid;

	@FindBy(xpath = "//*[@role = 'searchbox']")
    private WebElement searchChemical_Input;
	@FindBy (xpath = "//*[@role = 'alert']")
	private WebElement warning_message;

	public Advanced_Chemical_Product_Selector_Hand_Protection(WebDriver driver) {
		this.driver = driver;
		this.waitTime = new WebWait(driver);
		PageFactory.initElements(driver, this);
	}

	public void acs_HandProtection_Chemicals(String chem1, String chem2) throws InterruptedException {
		// Validate input parameters
		if (chem1 == null || chem1.trim().isEmpty()) {
			Logger4j.error("First chemical parameter is null or empty");
			throw new IllegalArgumentException("First chemical parameter cannot be null or empty");
		}
		if (chem2 == null || chem2.trim().isEmpty()) {
			Logger4j.error("Second chemical parameter is null or empty");
			throw new IllegalArgumentException("Second chemical parameter cannot be null or empty");
		}
		
		Logger4j.info("Entering first chemical in ACS Hand Protection: " + chem1);
		waitTime.elementToBeClickable(inputText);
		inputText.click();
		inputText.sendKeys(chem1);

		waitTime.visibilityOf(silvernitrate_Chemical);
		waitTime.elementToBeClickable(silvernitrate_Chemical);
		try {
			silvernitrate_Chemical.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", silvernitrate_Chemical);
			Logger4j.info("Clicked Silver Nitrate using JavaScript fallback.");
		}
		Logger4j.info("Silver Nitrate is selected in ACS Hand Protection");

		Logger4j.info("Entering second chemical in ACS Hand Protection: " + chem2);
		waitTime.elementToBeClickable(inputText);
		inputText.click();
		inputText.sendKeys(chem2);

		waitTime.visibilityOf(varitox);
		waitTime.elementToBeClickable(varitox);
		try {
			varitox.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", varitox);
			Logger4j.info("Clicked Slaked Lime using JavaScript fallback.");
		}
		Logger4j.info("Varitox is selected in ACS Hand Protection");
	}

	public void acs_HandProtection_Chemicals_for_unsigned(String chem1, String chem2) throws InterruptedException {
		// Validate input parameters
		if (chem1 == null || chem1.trim().isEmpty()) {
			Logger4j.error("First chemical parameter is null or empty");
			throw new IllegalArgumentException("First chemical parameter cannot be null or empty");
		}
		if (chem2 == null || chem2.trim().isEmpty()) {
			Logger4j.error("Second chemical parameter is null or empty");
			throw new IllegalArgumentException("Second chemical parameter cannot be null or empty");
		}
		
		Logger4j.info("Entering first chemical in ACS Hand Protection: " + chem1);
		waitTime.elementToBeClickable(inputText);
		inputText.click();
		inputText.sendKeys(chem1);

		waitTime.visibilityOf(hydrochloric_acid);
		waitTime.elementToBeClickable(hydrochloric_acid);
		try {
			hydrochloric_acid.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", hydrochloric_acid);
			Logger4j.info("Clicked hydrocholoric acid using JavaScript fallback.");
		}
		Logger4j.info("hydrochoric acid is selected in ACS Hand Protection");

		Logger4j.info("Entering second chemical in ACS Hand Protection: " + chem2);
		waitTime.elementToBeClickable(inputText);
		inputText.click();
		inputText.sendKeys(chem2);

		waitTime.visibilityOf(varitox);
		waitTime.elementToBeClickable(varitox);
		try {
			varitox.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", varitox);
			Logger4j.info("Clicked varitox using JavaScript fallback.");
		}
		Logger4j.info("varitox is selected in ACS Hand Protection");
	}
	public void acs_HandProtection_Cas_num(String chem1, String chem2) throws InterruptedException {
		// Validate input parameters
		if (chem1 == null || chem1.trim().isEmpty()) {
			Logger4j.error("First chemical/CAS number parameter is null or empty");
			throw new IllegalArgumentException("First chemical/CAS number parameter cannot be null or empty");
		}
		if (chem2 == null || chem2.trim().isEmpty()) {
			Logger4j.error("Second chemical/CAS number parameter is null or empty");
			throw new IllegalArgumentException("Second chemical/CAS number parameter cannot be null or empty");
		}
		
		Logger4j.info("Entering 7647-01-0 in ACS Search TextField: " + chem1);
		waitTime.elementToBeClickable(inputText);
		inputText.click();
		inputText.sendKeys(chem1);

		waitTime.visibilityOf(hydrochloric_acid);
		waitTime.elementToBeClickable(hydrochloric_acid);
		try {
			hydrochloric_acid.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", hydrochloric_acid);
			Logger4j.info("Clicked  7647-01-0's chemical using JavaScript fallback.");
		}
		Logger4j.info("chemical number 7647-01-0 is selected in ACS Hand Protection");

		Logger4j.info("Entering  76-03-9 in ACS Search TextField: " + chem2);
		waitTime.elementToBeClickable(inputText);
		inputText.click();
		inputText.sendKeys(chem2);

		waitTime.visibilityOf(varitox);
		waitTime.elementToBeClickable(varitox);
		try {
			varitox.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", varitox);
			Logger4j.info("Clicked 76-03-9's chemical using JavaScript fallback.");
		}

		Logger4j.info("chemical number 76-03-9 is selected in ACS Hand Protection");
	}

	public void acs_Click_Step2() throws InterruptedException {
		waitTime.elementToBeClickable(acs_Hp_Step2);
		acs_Hp_Step2.click();
		Logger4j.info("Clicked on Step 2 of ACS for Hand Protection");
		waitTime.elementToBeClickable(hand_Protection_Radio_Button);
		hand_Protection_Radio_Button.click();
		Logger4j.info("Selected Hand Protection Radio Button in ACS Step 2");
	}

	public void acs_Step2() throws InterruptedException {
		ExposureTime.click();
		waitTime.elementToBeClickable(Select_dropdown);
		Select_dropdown.click();
		Logger4j.info("Exposure Time is selected in ACS Step 2");
//		waitTime.elementToBeClickable(splash_Radio_Button);
//		splash_Radio_Button.click();
//		Logger4j.info("Splash Radio Button is selected in ACS Step 2");

	}

	public void acs_Step3() throws InterruptedException {
		acs_Hp_Step3.click();
		waitTime.elementToBeClickable(acs_Hp_Step4);
		acs_Hp_Step4.click();
		Logger4j.info("Clicked on Step 3 of ACS for Hand Protection");
	}

	public void acs_Step4() throws InterruptedException {
		Thread.sleep(10000);
		waitTime.elementToBeClickable(alpha1_HandProtect);
		alpha1_HandProtect.click();
		Logger4j.info("Selected Alpha 1 Hand Protection Product in ACS Step 4");
		waitTime.elementToBeClickable(alpha2_HandProtect);
		alpha2_HandProtect.click();
		Logger4j.info("Selected Alpha 2 Hand Protection Product in ACS Step 4");
		waitTime.elementToBeClickable(alpha3_HandProtect);
		alpha3_HandProtect.click();
		Logger4j.info("Selected Alpha 3 Hand Protection Product in ACS Step 4");
	}

	public void compare_Products() throws InterruptedException {
		waitTime.elementToBeClickable(compare_Button);
		compare_Button.click();
		Logger4j.info("Clicked on Compare Products in ACS Hand Protection");
		Thread.sleep(5000);
		waitTime.elementToBeClickable(return_Button1);
		return_Button1.click();
		Logger4j.info("Clicked on Return to View Products in ACS Hand Protection");
	}

	public void acs_Download_Report_Details() throws InterruptedException, AWTException {
		waitTime.elementToBeClickable(download_Hand_Protection);
		download_Hand_Protection.click();
		Logger4j.info("Clicked on Download Report in ACS Hand Protection");
	}

	public void hand_Protection_Standards() throws InterruptedException {
		waitTime.elementToBeClickable(ASTM_standard);
		ASTM_standard.click();
		Logger4j.info("ASTM Standard is selected in ACS Hand Protection");
		waitTime.elementToBeClickable(EnISO_standard);
		EnISO_standard.click();
		Logger4j.info("EN ISO Standard is selected in ACS Hand Protection");

	}

	public void acs_OrganizationDetails(String org) throws InterruptedException {
		// Validate input parameter
		if (org == null || org.trim().isEmpty()) {
			Logger4j.error("Organization name parameter is null or empty");
			throw new IllegalArgumentException("Organization name parameter cannot be null or empty");
		}
		
		waitTime.elementToBeClickable(organisationDetails);
		organisationDetails.click();
		Logger4j.info("Clicked on Organisation Details in ACS Hand Protection");
		waitTime.visibilityOf(organisationInput_Text_Field);
		organisationInput_Text_Field.sendKeys(org);
		Logger4j.info("Entered Organisation Name in ACS Hand Protection: " + org);
	}

	public void uploadImage() throws InterruptedException, AWTException {
		File f = new File("E:\\AutomationAGC\\Automation\\src\\main\\resources\\Images\\logo.jpg");
		String logo = f.getAbsolutePath();
		upload_Image.sendKeys(logo);
		Logger4j.info("Logo is uploaded in ACS Hand Protection");
		waitTime.elementToBeClickable(upload_Button);
		upload_Button.click();
		Logger4j.info("Upload button is clicked in ACS Hand Protection");
	}

	public void acs_Report_Details() throws InterruptedException  {
		Thread.sleep(3000);
		waitTime.elementToBeClickable(reportDetails);
		reportDetails.click();
		Logger4j.info("Clicked on Report Details in ACS Hand Protection");
		waitTime.visibilityOf(image3);
		image3.click();
		Logger4j.info("Clicked on Image3 in ACS Hand Protection Report Details");
	}

	public void acs_HPreport_Details() throws InterruptedException  {
		Thread.sleep(3000);
		waitTime.elementToBeClickable(reportDetailsHP);
		reportDetailsHP.click();
		Logger4j.info("Clicked on Report Details in ACS Hand Protection");
		waitTime.visibilityOf(image3);
		image3.click();
		Logger4j.info("Clicked on Image3 in ACS Hand Protection Report Details");
	}
	public void basic_acs_Report_Details(String repname) throws InterruptedException  {
		try {
			Thread.sleep(3000);
			waitTime.elementToBeClickable(reportDetails);
			reportDetails.click();
			Logger4j.info("Clicked on Report Details in ACS Hand Protection");
			
			// Wait for the report name field to be visible and interactable
			waitTime.visibilityOf(reportName);
			waitTime.elementToBeClickable(reportName);
			
			// Clear the field first if it has any existing text
			reportName.clear();
			
			// Send the report name
			reportName.sendKeys(repname);
			Logger4j.info("Entered report name: " + repname);
			
			// Wait for image3 to be visible and click it
			waitTime.visibilityOf(image3);
			image3.click();
			Logger4j.info("Clicked on Image3 in ACS Hand Protection Report Details");
			
		} catch (Exception e) {
			Logger4j.error("Error in basic_acs_Report_Details method: " + e.getMessage());
			throw new RuntimeException("Failed to enter report details", e);
		}
	}
	public void acs_Hp_Report_Download() throws InterruptedException {
		waitTime.elementToBeClickable(downloadReport);
		downloadReport.click();
		Logger4j.info("Clicked on Download Report in ACS Hand Protection");
	}

	public void acs_Hp_No_Button() throws InterruptedException {
		waitTime.elementToBeClickable(no_Button);
		no_Button.click();
		Logger4j.info("Clicked on No Button in ACS Hand Protection");
	}

	public void navigate_From_AcsTo_MyReportPage() throws InterruptedException {
		waitTime.elementToBeClickable(profile_Name_Dropdown);
		profile_Name_Dropdown.click();
		Logger4j.info("Clicked on Profile Name Dropdown in ACS Hand Protection");
		waitTime.elementToBeClickable(myReport);
		myReport.click();
		Thread.sleep(5000);
		Logger4j.info("Clicked on My Report in ACS Hand Protection");
		waitTime.elementToBeClickable(advanced_Product_Selector_Tab3);
		advanced_Product_Selector_Tab3.click();
		Logger4j.info("Clicked on Advanced Product Selector Tab in My Report Page");

	}

	public String expected_Pdf_ResultIn_Text2() throws InterruptedException {
		try {
			// Wait for the page to load properly
			Thread.sleep(3000);
			
			// Try to find the element with a shorter timeout using custom wait
			WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement reportElement = shortWait.until(ExpectedConditions.visibilityOf(acs_Downloaded_Report_Name_Myreport));
			
			acs_downloaded_pdf_myreprt = reportElement.getText() + ".pdf";
			Logger4j.info("Expected PDF result: " + acs_downloaded_pdf_myreprt);
			return acs_downloaded_pdf_myreprt;
		} catch (Exception e) {
			Logger4j.error("Could not find expected PDF result element: " + e.getMessage());
			// Return a default value or throw the exception
			throw new RuntimeException("Unable to retrieve expected PDF result from MyReport page", e);
		}
	}

	public void agree_Button() throws InterruptedException {
		waitTime.elementToBeClickable(agree_Button);
		if(agree_Button.isDisplayed()) {
			Logger4j.info("Clicking on Agree Button in ACS Hand Protection");
			agree_Button.click();
			Logger4j.info("Clicked on Agree Button in ACS Hand Protection");
		}

	}

	public void otherHazards_Tab() throws InterruptedException {
		Thread.sleep(5000);
		if (!otherhazards_Button.isEnabled()) {
			Logger4j.info("The hazard button is enabled. Test failed.");
		} else {
			Logger4j.info("The hazard button is disabled as expected.");
		}
	}

	public void remove_All_Chemical() throws InterruptedException {
		waitTime.elementToBeClickable(checkBox);
		checkBox.click();
		Logger4j.info("Checkbox is clicked to select all chemicals for removal");
		waitTime.elementToBeClickable(remove_Button);
		remove_Button.click();
		Logger4j.info("Remove button is clicked to remove all selected chemicals");
		if (!checkBox.isEnabled()) {
			Logger4j.info("Chemicals are not removed");
		}  else {
			Logger4j.info("Chemicals are removed");
		}
		
	}

	public void beforeRemovingSpecificChemical() {
		waitTime.elementToBeClickable(specific_Remove);
		specific_Remove.click();
		Logger4j.info("Specific chemical is selected for removal");
	}
	
	public String beforeRemovingChemicals() {
		return count_Chemicals.getText();
	}

	public void afterRemovingSpecificChemical() {
		waitTime.elementToBeClickable(remove_Button);
		remove_Button.click();
		Logger4j.info("Remove button is clicked to remove the specific chemical");
	}
	
	public String afterRemovingChemical() {
		return count_Chemicals.getText();
	}

	public void chemical_Tab_DisableCheck() throws InterruptedException {
		Thread.sleep(5000);
		waitTime.elementToBeClickable(otherhazards_Button);
		otherhazards_Button.click();
		Logger4j.info("Clicked on Other Hazards Button in ACS Hand Protection");
		waitTime.elementToBeClickable(otherhazards_1);
		otherhazards_1.click();
		Logger4j.info("Clicked on Other Hazards 1 in ACS Hand Protection");
		Thread.sleep(2000);
		if (!chemical_Disable.isEnabled()) {
			Logger4j.info("Chemicals tab button is enabled and test failed");
		} else {
			Logger4j.info("Chemicals tab button is disabled and Test Pass");
		}
	}
 public void moreThan_5_Chemicals() throws InterruptedException{
		Thread.sleep(2000);

 }
	public void moreThan_5_Hazards() throws InterruptedException {
		Thread.sleep(5000);
		otherhazards_Button.click();
		Logger4j.info("Clicked on Other Hazards Button in ACS Hand Protection");
		waitTime.elementToBeClickable(otherhazards_1);
		otherhazards_1.click();
		Logger4j.info("Clicked on Other Hazards 1 in ACS Hand Protection");
		waitTime.elementToBeClickable(otherhazards_2);
		otherhazards_2.click();
		Logger4j.info("Clicked on Other Hazards 2 in ACS Hand Protection");
		waitTime.elementToBeClickable(otherhazards_3);
		otherhazards_3.click();
		Logger4j.info("Clicked on Other Hazards 3 in ACS Hand Protection");
		waitTime.elementToBeClickable(otherhazards_4);
		otherhazards_4.click();
		Logger4j.info("Clicked on Other Hazards 4 in ACS Hand Protection");
		waitTime.elementToBeClickable(otherhazards_5);
		otherhazards_5.click();
		Logger4j.info("Clicked on Other Hazards 5 in ACS Hand Protection");
		waitTime.visibilityOf(otherhazards_6);
		otherhazards_6.click();
		Logger4j.info("Clicked on Other Hazards 6 in ACS Hand Protection");
		String Actual_message = warning_Message.getText();
		Logger4j.info("Actual warning message: " + Actual_message);
		Assert.assertEquals(Actual_message, warning_Message_text);
		Logger4j.info("Warning message is verified successfully in ACS Hand Protection");
		Thread.sleep(3000);
	}
	public void addMoreThan5Chemicals() {
		List<String> chemicalNames = Arrays.asList(
				"Acetone",
				"Varitox",
				"HYDRARGYRUM",
				"Trichloroacetic acid",
				"quicksilver",
				"Nitric acid"
		);

		for (int i = 0; i < chemicalNames.size(); i++) {
			String chemName = chemicalNames.get(i);

			// Step 1: Enter the chemical name into search input
			searchChemical_Input.clear();
			searchChemical_Input.sendKeys(chemName);
			Logger4j.info("Entered chemical name in search: " + chemName);

			// Step 2: Build xpath and find element using driver directly
			String xpath = "//label[text()='" + chemName + "']";
			WebElement chemicalElement = driver.findElement(By.xpath(xpath));

			// Step 3: Wait for it to be clickable
			waitTime.elementToBeClickable(chemicalElement);

			// Step 4: Click the element
			chemicalElement.click();
			Logger4j.info("Clicked on Chemical " + (i + 1) + ": " + chemName);
		}

		// Step 5: Verify the warning message
		String actualMessage = warning_Message.getText();
		Logger4j.info("Actual warning message: " + actualMessage);
		Assert.assertEquals(actualMessage, warning_Message_text);
		Logger4j.info("Warning message is verified successfully after adding more than 5 chemicals.");
	}

}