package com.agc.sel.agc_pageObject;

import com.agc.sel.baseutilities.JavaScriptUtil;
import com.agc.sel.baseutilities.PopupHandler;
import com.agc.sel.loggers.Logger4j;
import com.agc.sel.baseutilities.WebWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.agc.sel.baseutilities.Asserrtion;

import java.io.File;

public class Padd_HandProtection_elements {
	WebDriver driver;
	WebWait time;
	
	 JavaScriptUtil jsu = new JavaScriptUtil(driver);
	PopupHandler popupHandler = new PopupHandler(driver) ;

	@FindBy(xpath = "(//input[@class='textInput'])[1]")
	private WebElement organization_Padd;

	@FindBy(xpath = "(//input[@class='textInput'])[2]")
	private WebElement emailId_Padd;

	@FindBy(xpath = "(//input[@class='textInput'])[3]")
	private WebElement contact_Padd;

	@FindBy(xpath = "(//input[@class='textInput'])[4]")
	private WebElement contactNumber_Padd;

	@FindBy(id = "logoFile")
	private WebElement logoFile_Padd;

	@FindBy(id = "salesUserAuto")
	private WebElement salesUserAuto_Padd;

	@FindBy(xpath = "(//img[@class='report-image-size'])[3]")
	private WebElement image3_Padd;

	@FindBy(xpath = "//*[@id='submitOrgDetails']")
	private WebElement submitOrgDetails_Padd;

	@FindBy(xpath = "//*[@id='atc_chemicalTradeName']")
	private WebElement addChemical_InSearchTextField;

	@FindBy(xpath = "(//span[text()='64-19-7'])[1]")
	private WebElement chemical_1;

	@FindBy(xpath = "(//span[text()='108-95-2'])[1]")
	private WebElement chemical_2;

	@FindBy(xpath = "//span[contains(text(),'Add Multiple Singles/Mixtures')]")
	private WebElement add_MultipleChemical;

	@FindBy(xpath = "//div[@id='6']")
	private WebElement selectChemical1;

	@FindBy(xpath = "//div[@id='8']")
	private WebElement selectChemical2;

	@FindBy(xpath = "//*[@id='chemical-tab']/div/div[1]/ul")
	private WebElement mixture1;

	@FindBy(xpath = "//*[@id='multi_2']")
	private WebElement mixture2;

	@FindBy(xpath = "(//button[text()='Add To List'])[1]")
	private WebElement addToListChemical;

	@FindBy(id = "atc_productName")
	private WebElement addProduct;

	@FindBy(xpath = "//span[text()=' Product Group- 91-225']")
	private WebElement addProductSearchText1;

	@FindBy(xpath = "//span[text()=' Product Group- 09-430.922.924.928']")
	private WebElement addProductSearchText2;

	@FindBy(xpath = "//span[contains(text(),'ADD MULTIPLE PRODUCTS')]")
	private WebElement addMultipleProduct;

	@FindBy(xpath = "(//div[@class='prblock'])[2]")
	private WebElement selectProduct1;

	@FindBy(xpath = "//a[text()='3']")
	private WebElement nextPage;

	@FindBy(xpath = "(//div[@class='prblock'])[2]")
	private WebElement selectProduct2;

	@FindBy(xpath = "(//button[text()='Add To List'])[2]")
	private WebElement addToListProduct;

	@FindBy(xpath = "//span[text()='Submit HP']")
	private WebElement submitHp;

	@FindBy(xpath = "//span[contains(text(),'Degradation Chart')]")
	private WebElement clickDegredation;

	@FindBy(xpath = "//span[text()='Combined Chart']")
	private WebElement clickCombined;

	@FindBy(xpath = "//span[text()='ASTM F739']")
	private WebElement ASTM_F739;

	@FindBy(xpath = "(//button[text()='Submit'])[2]")
	private WebElement submit;

	@FindBy(id = "hpStatusId")
	private WebElement hpStatus;

	@FindBy(xpath = ("//span[contains(text(),'Degradation Chart')]"))
	private WebElement selectDegredation;

	@FindBy(xpath = ("(//span[contains(text(),'BT')])[2]"))
	private WebElement selectCombined;

	@FindBy(id = "btnDownload")
	private WebElement downloadReport;

	@FindBy(xpath = "//span[contains(text(),'sachin N')]")
	private WebElement my_Profile;

	@FindBy(xpath = "//span[contains(text(),'My Reports')]")
	private WebElement MyReport;

	@FindBy(id = "downloadDropDownMenu")
	private WebElement download;

	@FindBy(xpath = "//span[text()='Download Report']")
	private WebElement download_report;

	@FindBy(xpath = "//span[text()='hand protection']")
	private WebElement handProtection;

	@FindBy(xpath = "//span[text()='HP & BP Chart']")
	private WebElement HPBP;

	@FindBy(xpath = "(//span[contains(@id,'span')])[3]")
	private WebElement hp_Report_TextField;

	@FindBy(id = "ui-id-1")
	private WebElement org_Dialouge;

	@FindBy(xpath = "//span[contains(@class,'popupchname')]")
	private WebElement popupChName;

	@FindBy(xpath = "//*[@id='hp_gridLoader']")
	private WebElement GridLoader;

	@FindBy(xpath = "//*[normalize-space(text())='Degradation Chart']")
	private WebElement DegradationChartCheckbox;

	@FindBy(xpath = "//*[normalize-space(text())='Combined Chart']")
	private WebElement CombinedChartCheckbox;

	@FindBy(xpath = "(//*[@id='bpReportType']//span[1])[6]")
	private WebElement basicCheckBoxBT01;

	@FindBy(xpath = "//*[normalize-space()='Customize Report']")
	private WebElement customizeReport;

	public Padd_HandProtection_elements(WebDriver driver)
	{
		this.driver = driver;
		this.time = new WebWait(driver);
		PageFactory.initElements(driver, this);
	}

	public void organization_Model_Window_Details_Padd(String organisation_name, String mail, String contact_name,
			String tel) throws InterruptedException {
		time.visibilityOf(org_Dialouge);
		time.elementToBeClickable(organization_Padd);
		organization_Padd.sendKeys(organisation_name);
		Logger4j.info("Organization Name: " + organisation_name);
		emailId_Padd.sendKeys(mail);
		Logger4j.info("Email ID: " + mail);
		contact_Padd.sendKeys(contact_name);
		Logger4j.info("Contact Name: " + contact_name);
		contactNumber_Padd.sendKeys(tel);
		Logger4j.info("Contact Number: " + tel);
		logoUploadForPaddd();
		Logger4j.info("Logo uploaded successfully.");
//			sharedTo.sendKeys(Shared1);
//			Thread.sleep(5000);
//			sharedTo.sendKeys(Shared2);
		Thread.sleep(2000);
		image3_Padd.click();
		Logger4j.info("Image 3 clicked.");
		submitOrgDetails_Padd.click();

	}

	public void padd_Chemical(String... chemicals) throws InterruptedException {
		Thread.sleep(2000);
		time.visibilityOf(addChemical_InSearchTextField);
		time.waitAndClick(addChemical_InSearchTextField);
		Logger4j.info("Chemical search text field clicked for Hand Protection.");

		for (int i = 0; i < chemicals.length; i++) {
			Logger4j.info("Adding Chemical: " + chemicals[i]);

			Asserrtion.softAssertTrue(addChemical_InSearchTextField.isDisplayed(),
					"Add Chemical text field should be visible");

			addChemical_InSearchTextField.clear();
			addChemical_InSearchTextField.sendKeys(chemicals[i]);

			//  Pick locator dynamically based on index
			WebElement chemicalOption;
			if (i == 0) {
				chemicalOption = chemical_1;
			} else if (i == 1) {
				chemicalOption = chemical_2;
			} else {
				throw new IllegalArgumentException("Currently supports only 2 chemicals. Found: " + chemicals.length);
			}

			Asserrtion.softAssertTrue(chemicalOption.isDisplayed(),
					"Chemical should be visible in the dropdown");

			time.waitAndClick(chemicalOption);
		}

		Logger4j.info("All Chemicals added successfully for Hand Protection.");
	}


		public void add_Multiple_Chemicals_dialog_box() throws InterruptedException {
			Logger4j.info("Adding multiple Chemicals from 'Add Multiple Singles/Mixtures' option for Hand Protection");
			time.visibilityOf(add_MultipleChemical);
			add_MultipleChemical.click();
			Logger4j.info("Selected 'Add Multiple Singles/Mixtures' chemicals for Hand Protection");
			time.elementToBeClickable(selectChemical1);
			selectChemical1.click();
			time.elementToBeClickable(selectChemical2);
			selectChemical2.click();

			Logger4j.info("Successfully clicked on Add To List button for Hand Protection chemicals");
			time.visibilityOf(addToListChemical);
			addToListChemical.click();
			Logger4j.info("Added Chemicals to the list for Hand Protection");
			time.invisibilityof(GridLoader);
		}


		public void Add_existing_Mixture(String mixture) throws InterruptedException {
			Logger4j.info("Adding  Mixture from Serach Text Field ");
			time.visibilityOf(addChemical_InSearchTextField);
			addChemical_InSearchTextField.click();
			addChemical_InSearchTextField.sendKeys(mixture);
			Thread.sleep(2000);
		//	popupHandler.waitForElementToDisappear(popupChName);
			time.elementToBeClickable(mixture1);
			mixture1.click();
			Logger4j.info("Added Chemicals to the table for Hand Protection");
		}
    public void padd_Material(String material1) throws InterruptedException{
		Logger4j.info("Searching for  "+ material1+" for Hand Protection");
		time.elementToBeClickable(addProduct);
		addProduct.sendKeys(material1);
		time.visibilityOf(addProductSearchText1);
		addProductSearchText1.click();
		Logger4j.info("Product with "+material1+" selected successfully");

	}
	public void padd_Product(String... products) throws InterruptedException {
		for (int i = 0; i < products.length; i++) {
			Logger4j.info("Adding Product: " + products[i]);
			time.waitAndSendKeys(addProduct, products[i]);

			if (i == 0) {
				Asserrtion.softAssertTrue(addProductSearchText1.isDisplayed()," Product should be visible in the dropdown");
				time.waitAndClick(addProductSearchText1);
			} else if (i == 1) {
				Asserrtion.softAssertTrue(addProductSearchText2.isDisplayed()," Product should be visible in the dropdown");
				time.waitAndClick(addProductSearchText2);
			}
		}

		Logger4j.info("Multiple Products option clicked.");
		time.waitAndClick(addMultipleProduct);

		Logger4j.info("Product 1 selected");
		time.waitAndClick(selectProduct1);

		Logger4j.info("Navigating to next page for product selection.");
		time.waitAndClick(nextPage);

		Logger4j.info("Product 2 selected from multiple");
		time.waitAndClick(selectProduct2);

		time.waitAndClick(addToListProduct);
		Logger4j.info("Added Products to the list for Hand Protection");
	}

	public void submit_Report_Button() throws InterruptedException {
		Asserrtion.softAssertTrue(submitHp.isDisplayed(), "Submit HP button should be visible");
		Asserrtion.softAssertTrue(submitHp.isEnabled(), "Submit HP button should be enabled");
		time.elementToBeClickable(submitHp);
		submitHp.click();
		Logger4j.info("Report submitted successfully for Hand Protection.");
	}
	public void try_till_clickEnabled1(WebElement element) {
		int maxAttempts = 4;
		int attempts =0;
		boolean clicked = false;
		while(attempts<maxAttempts && !clicked){
			try{
				time.waitAndClick(element);
				clicked = true;
			}
			catch (Exception e){
				attempts++;
				Logger4j.error("Attempt " + attempts + " to click element failed. Retrying");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException ex) {
					throw new RuntimeException(ex);
				}
			}
		}
	}
	public void report_Download_Button() throws InterruptedException {
		try_till_clickEnabled1(download_report);
		//time.waitAndClick(download_report);
//		time.elementToBeClickable(download_report);
//		download_report.click();
		Logger4j.info("Download button enabled and clicked for report customization.");

		if(customizeReport.isDisplayed());
		Logger4j.info("Customize Report button is displayed");
	}

	public void hp_Report_Details() throws InterruptedException {
		Asserrtion.softAssertTrue(clickDegredation.isDisplayed(), "Degradation Chart option should be visible");
		time.elementToBeClickable(clickDegredation);
		clickDegredation.click();
		Logger4j.info("Degradation Chart option clicked.");
		Asserrtion.softAssertTrue(clickCombined.isDisplayed(), "Combined Chart option should be visible");
		time.elementToBeClickable(clickCombined);
		clickCombined.click();
		Logger4j.info("Combined Chart option clicked.");
		Logger4j.info("ENISO374 option is preclicked for Hand Protection report.");
		Asserrtion.softAssertTrue(ASTM_F739.isDisplayed(), "ASTM F739 option should be visible");
		time.elementToBeClickable(ASTM_F739);
		ASTM_F739.click();
		Logger4j.info("ASTM F739 option is clicked for Hand Protection report.");
	}

	public void submit() throws InterruptedException {
		time.elementToBeClickable(submit);
		submit.click();
		Logger4j.info("Report submitted successfully.");
		Thread.sleep(18000);
	}

	public void report() throws InterruptedException {
		time.elementToBeClickable(download);
		download.click();
		Logger4j.info("Download button clicked.");
		time.elementToBeClickable(downloadReport);
		selectDegredation.click();
		Logger4j.info("Degradation Chart selected for download.");
		time.elementToBeClickable(selectCombined);
		selectCombined.click();
		Logger4j.info("Combined Chart selected for download.");
		time.elementToBeClickable(downloadReport);
		downloadReport.click();
		Logger4j.info("Report download initiated.");
		time.elementToBeClickable(my_Profile);
		my_Profile.click();
		Logger4j.info("My Profile clicked.");
		time.elementToBeClickable(MyReport);
		MyReport.click();
		Logger4j.info("My Reports clicked.");
	}

	public WebElement orgDetails_Title() {
		return org_Dialouge;
	}

	public String textStatusHp() {
		return hpStatus.getText();
	}

	public void hp_Report_Download() {
		handProtection.click();
		Logger4j.info("Hand Protection Report Download initiated.");
	}

	public void download_Button_Dropdown() throws InterruptedException {
		download.click();
		Logger4j.info("Download button clicked.");
		Thread.sleep(3000);
	}

	public void combined_Report_Download() {
		HPBP.click();
		Logger4j.info("HP & BP Chart option clicked for download.");
	}


	public void customize_hp_report_forBasic() {
		time.waitAndClick(DegradationChartCheckbox);
		Logger4j.info("Degradation chart checkbox clicked");
		time.waitAndClick(CombinedChartCheckbox);
		Logger4j.info("Combined chart checkbox clicked");
	}
	public void customize_combined_report_forBasic(){
		try_till_clickEnabled1(DegradationChartCheckbox);
		Logger4j.info("Degradation chart checkbox clicked");
		time.waitAndClick(CombinedChartCheckbox);
		Logger4j.info("Combined chart checkbox clicked");
		time.waitAndClick(basicCheckBoxBT01);
		Logger4j.info(" CheckBox BT01 is selected successfully");
	}
	public String hp_Report_Expected_Text() throws InterruptedException {
		Thread.sleep(5000);
		String expected_hp_report = hp_Report_TextField.getText() + ".pdf";
		Logger4j.info(expected_hp_report);
		return expected_hp_report;
	}

	public void logoUploadForPaddd() {
		File f = new File("E:\\AutomationAGC\\Automation\\src\\main\\resources\\Images\\logo.jpg");
		String logo = f.getAbsolutePath();
		logoFile_Padd.sendKeys(logo);
		Logger4j.info("Logo uploaded successfully");
	}
}
