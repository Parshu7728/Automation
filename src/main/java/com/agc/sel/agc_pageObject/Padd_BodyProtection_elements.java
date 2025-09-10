package com.agc.sel.agc_pageObject;

import com.agc.sel.baseutilities.Asserrtion;
import com.agc.sel.loggers.Logger4j;
import com.agc.sel.baseutilities.WebWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Padd_BodyProtection_elements {
	WebWait time;
	WebDriver driver;
	public String padd_Downloaded_Pdf_Myreport;

	@FindBy(xpath="//button[text()='Save']")
	private WebElement submitOrgDetails_Padd;
	
	@FindBy(xpath="//a[contains(text(),'Body Protection ')]")
	private WebElement bpPage;
	
	@FindBy(id="bpStatusId")
	private WebElement bpStatus;
	
	@FindBy(xpath="//input[@id='atc_chemicalTradeName']")
	private WebElement addChemicalSearchTextField;

	@FindBy(xpath="//span[text()='Acetaldehyde']")
	private WebElement chemical_1;

	@FindBy(xpath="	//li[@class='rich-autocomplete-list-item'][1]")
	private WebElement chemical_2;

	@FindBy(xpath="//span[contains(text(),'Add Multiple Singles/Mixtures')]")
	private WebElement addMultipleChemical;

	@FindBy(xpath="//div[@id='2']")
	private WebElement selectChemical1;

	@FindBy(xpath="//div[@id='3']")
	private WebElement selectChemical2;

	@FindBy(xpath="(//button[text()='Add To List'])[1]")
	private WebElement addToListChemical;

	@FindBy(id="atc_productName")
	private WebElement addProduct;

	@FindBy(xpath="	//span[text()=' Product Group- 4000 CFR']")
	private WebElement addProductSearchText1;

	@FindBy(xpath="	//span[text()=' Product Group- 6000']")
	private WebElement addProductSearchText2;

	@FindBy(xpath="//span[contains(text(),'ADD MULTIPLE PRODUCTS')]")
	private WebElement addMultipleProduct;

	@FindBy(xpath="(//span[@class='select-pro-tick icon-Tick'])[3]") 
	private WebElement selectProduct1;
	
	@FindBy(xpath="//a[text()='3']")
	private WebElement nextPage;

	@FindBy(xpath="(//span[@class='select-pro-tick icon-Tick'])[2]")
	private WebElement selectProduct2;

	@FindBy(xpath="(//button[text()='Add To List'])[2]")
	private WebElement addToListProduct;
	
	@FindBy(xpath="(//button[text()='Add to Product'])[3]")
	private WebElement addProduct1;
	
	@FindBy(xpath="(//button[text()='Add to Product'])[1]")
	private WebElement addProduct2;
	
	@FindBy(id="downloadDropDownMenu")
	private WebElement downloadReport;
	
	@FindBy(xpath="//span[text()='Degradation Chart']")
	private WebElement degredationCheckBox;
	
	@FindBy(xpath="//span[text()='Combined Chart']")
	private WebElement combinedCheckBox;
	
	@FindBy(xpath="//span/sub[text()='0.1']")
	private WebElement BT01;
	
	@FindBy(xpath="//span[text()='Cumulative Permeation']")
	private WebElement cumulative_Permeation;
	
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement submit;
	
	@FindBy(xpath="//span[text()='body protection']")
	private WebElement bodyprotection;
	
	@FindBy(xpath="(//button[text()='Submit BP'])")
	private WebElement submitBp;
	
	@FindBy(xpath = "((//td[@role='gridcell'])/../td)[23]")
	private WebElement padd_Downloaded_Report_Name_Myreport;

	@FindBy(xpath = "(//*[@id='bpReportType']//span[1])[6]")
	private WebElement basicCheckBoxBT01;

	@FindBy(xpath = "//*[@id='bpReportType']/ul/li[1]/span/label")
	private WebElement basicCheckBoxBT10;

	@FindBy(xpath = "//div[@class='ui-widget-overlay ui-front']")
	private WebElement overlay;


	public Padd_BodyProtection_elements(WebDriver driver) {
		this.driver = driver;
		this.time = new WebWait(driver);
		PageFactory.initElements(driver, this);
	}


	public void submitOrgDetails_PaddBp() {
		time.visibilityOf(submitOrgDetails_Padd);
		submitOrgDetails_Padd.click();
		Logger4j.info("Organization details submitted");
	}
public void dialogue_box_multiplechemicals(){
	time.visibilityOf(addMultipleChemical);
	addMultipleChemical.click();
	Logger4j.info("Adding Multiple Chemicals for Body Protection");

	time.visibilityOf(selectChemical1);
	selectChemical1.click();
	Logger4j.info("Chemical 1 selected from multiple: " + selectChemical1.getText());

	time.visibilityOf(selectChemical2);
	selectChemical2.click();
	Logger4j.info("Chemical 2 selected from multiple: " + selectChemical2.getText());

	time.visibilityOf(addToListChemical);
	addToListChemical.click();
	Logger4j.info("Added Chemicals to the list for Body Protection");
}
	public void chemicals_For_Bp(String... bp_chemicals) throws InterruptedException {
		for (int i = 0; i < bp_chemicals.length; i++) {
			Logger4j.info("Adding Chemical: " + bp_chemicals[i]);
			time.waitAndSendKeys(addChemicalSearchTextField, bp_chemicals[i]);

			if (i == 0) {
				Asserrtion.softAssertTrue(chemical_1.isDisplayed(), "Chemical 1 should be visible in the dropdown");
				time.waitAndClick(chemical_1);
				Logger4j.info("Chemical 1 selected: " + chemical_1.getText());
			} else if (i == 1) {
				Asserrtion.softAssertTrue(chemical_2.isDisplayed(), "Chemical 2 should be visible in the dropdown");
				time.waitAndClick(chemical_2);
				Logger4j.info("Chemical 2 selected: " + chemical_2.getText());
			}
		}

		Logger4j.info("Multiple Chemicals option clicked.");
		time.waitAndClick(addMultipleChemical);

		Logger4j.info("Chemical 1 selected from multiple");
		time.waitAndClick(selectChemical1);

		Logger4j.info("Chemical 2 selected from multiple");
		time.waitAndClick(selectChemical2);

		time.waitAndClick(addToListChemical);
		Logger4j.info("Added Chemicals to the list for Body Protection");
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

	public void product_For_BPBasic(String product1) throws InterruptedException {
		try_till_clickEnabled1(addProduct);
		Logger4j.info("Adding Products for Body Protection");
		addProduct.sendKeys(product1);
		Logger4j.info("Product 1: " + product1);

		time.visibilityOf(addProductSearchText1);
		addProductSearchText1.click();
		Logger4j.info("Product Group 4000 CFR selected");

		time.visibilityOf(addProduct);
		addProduct.click();
	}
	public void product_For_Bp(String product1,String product2) throws InterruptedException {
		try_till_clickEnabled1(addProduct);
		Logger4j.info("Adding Products for Body Protection");
		addProduct.sendKeys(product1);
		Logger4j.info("Product 1: " + product1);
		
		time.visibilityOf(addProductSearchText1);
		addProductSearchText1.click();
		Logger4j.info("Product Group 4000 CFR selected");
		
		time.visibilityOf(addProduct);
		addProduct.click();
		Logger4j.info("Adding second Product for Body Protection");
		addProduct.sendKeys(product2);
		Logger4j.info("Product 2: " + product2);
		time.visibilityOf(addProductSearchText2);
		addProductSearchText2.click();
		Logger4j.info("Product Group 6000 selected");
		
		time.visibilityOf(addMultipleProduct);
		addMultipleProduct.click();
		Logger4j.info("Adding Multiple Products for Body Protection");
		
		time.visibilityOf(selectProduct1);
		selectProduct1.click();
		Logger4j.info("Product 1 selected from multiple: " + selectProduct1.getText());
		
		time.visibilityOf(nextPage);
		nextPage.click();
		Logger4j.info("Navigating to next page for product selection");
		
		time.visibilityOf(selectProduct2);
		selectProduct2.click();
		Logger4j.info("Product 2 selected from multiple: " + selectProduct2.getText());
		
		time.visibilityOf(addToListProduct);
		addToListProduct.click();
		Logger4j.info("Added Products to the list for Body Protection");
		
//		time.visibilityOf(addProduct1);
//		addProduct1.click();
//		time.visibilityOf(addProduct2);
//		addProduct2.click();
	}
	public void switch_To_BodyProtection() throws InterruptedException {
		Thread.sleep(3000);
		time.visibilityOf(bpPage);
		bpPage.click();
		Logger4j.info("Switched to Body Protection Page");

	}
	
	public String textStatusBp() {
		return bpStatus.getText();
	}
	
	public void submit_Report_Button_Bp() throws InterruptedException {
//		time.visibilityOf(submitBp);
//		submitBp.click();
		try_till_clickEnabled1(submitBp);
		Logger4j.info("Submitted Body Protection Report");
	}
	
	public void bp_Report_Download() throws InterruptedException {
		time.visibilityOf(downloadReport);
		bodyprotection.click();
		Logger4j.info("Body Protection Report Download initiated");
	}
	
	public void bp_Report_Details() throws InterruptedException {
		time.elementToBeClickable(BT01);
		BT01.click();
		Logger4j.info("Selected BT01 for Body Protection Report");
		time.elementToBeClickable(cumulative_Permeation);
		cumulative_Permeation.click();
		Logger4j.info("Selected Cumulative Permeation for Body Protection Report");
	}
	
	public String expected_Pdf_Result_In_Text2() throws InterruptedException {
		time.visibilityOf(padd_Downloaded_Report_Name_Myreport);
		padd_Downloaded_Pdf_Myreport = padd_Downloaded_Report_Name_Myreport.getText() + ".pdf";
		Logger4j.info(padd_Downloaded_Pdf_Myreport);
		return padd_Downloaded_Pdf_Myreport;
	}

	public void customize_bp_report_forBasic() {
		Logger4j.info(" CheckBox BT01 is selected successfully");
		time.waitAndClick(basicCheckBoxBT01);
	}


}
