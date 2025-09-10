package com.agc.sel.agc_pageObject;

import com.agc.sel.loggers.Logger4j;
import com.agc.sel.baseutilities.WebWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Advanced_Chemical_Product_Selector_Body_Protection {
	WebDriver driver;
	WebWait wedWait;

	@FindBy(xpath = "//input[@type='text']")
	private WebElement inputText;

	@FindBy(xpath = "//span[text()='Application Details']")
	private WebElement acs_Bp_Step2;

	@FindBy(xpath = "(//label[@class='st-1'])[2]")
	private WebElement body_Protection_Radio_Button;

	@FindBy(xpath = "(//div[@class='p-checkbox-box'])[1]")
	private WebElement exposedHazard1;

	@FindBy(xpath = "(//div[@class='p-checkbox-box'])[2]")
	private WebElement exposedHazard2;

	@FindBy(xpath = "(//div[@class='p-checkbox-box'])[3]")
	private WebElement exposedHazard3;

	@FindBy(xpath = "//span[text()='Select']")
	private WebElement exposureTime;

	@FindBy(xpath = "//div[text()='30-60 min']")
	private WebElement select_Dropdown;

	@FindBy(xpath = "(//div[@class='p-radiobutton-box'])[3]")
	private WebElement exposureIntensity;

	@FindBy(xpath = "//span[text()='Secondary Hazards']")
	private WebElement acs_Bp_Step3;

	@FindBy(xpath = "//span[text()='View Products']")
	private WebElement acs_Bp_Step4;

	@FindBy(xpath = "(//p-checkbox[@value='item'])[1]")
	private WebElement u4000_Bp_Product;

	@FindBy(xpath = "(//p-checkbox[@value='item'])[8]")
	private WebElement u5000_Bp_Product;

	@FindBy(xpath = "(//p-checkbox[@value='item'])[4]")
	private WebElement a4000_Bp_Product;

	@FindBy(xpath = "(//button[@type='button'])[3]")
	private WebElement compare_Button;

	@FindBy(xpath = "(//span[text()='Return to view Products'])[1]")
	private WebElement return_Button1;

	@FindBy(xpath = "(//span[@class='p-button-label'])[1]")
	private WebElement download_Body_Protection;

	@FindBy(xpath = "//p-checkbox[@label='BT1.0']")
	private WebElement BT10_standard;

	@FindBy(xpath = "//p-checkbox[@label='BT0.1']")
	private WebElement BT01_standard;

	@FindBy(xpath = "//p-checkbox[@value='Cumulative Permeation']")
	private WebElement Cp_standard;

	@FindBy(xpath = "//a[@id='p-accordiontab-13']")
	private WebElement organisationDetails;

	@FindBy(xpath = "//input[@name='orgName']")
	private WebElement organisationinput_Text_Field;

	@FindBy(xpath = "//button[@icon='pi pi-upload']")
	private WebElement upload;

	@FindBy(xpath = "//span[text()=' Report Details ']")
	private WebElement reportDetails;

	@FindBy(xpath = "//input[@name='reportName']")
	private WebElement input;

	@FindBy(xpath = "(//li[@class='ng-star-inserted'])[2]")
	private WebElement image3;

	@FindBy(xpath = "(//span[text()='Download Report'])[2]")
	private WebElement downloadReport;

	@FindBy(xpath = "//span[text()='No']/..")
	private WebElement no_Button;

	public Advanced_Chemical_Product_Selector_Body_Protection(WebDriver driver) {
		this.driver = driver;
		this.wedWait = new WebWait(driver);
		PageFactory.initElements(driver, this);
	}

	public void acs_Click_Step2() throws InterruptedException {
		wedWait.visibilityOf(acs_Bp_Step2);
		acs_Bp_Step2.click();
		Logger4j.info("Clicked on Step 2 of ACS for Body Protection");
		wedWait.visibilityOf(body_Protection_Radio_Button);
		body_Protection_Radio_Button.click();
		Logger4j.info("Selected Body Protection Radio Button in ACS Step 2");
	}

	public void acs_Step2() throws InterruptedException {
		wedWait.visibilityOf(exposedHazard1);
		exposedHazard1.click();
		Logger4j.info("Selected Exposed Hazard 1 in ACS Step 2");
		wedWait.visibilityOf(exposedHazard2);
		exposedHazard2.click();
		Logger4j.info("Selected Exposed Hazard 2 in ACS Step 2");
		wedWait.visibilityOf(exposedHazard3);
		exposedHazard3.click();
		Logger4j.info("Selected Exposed Hazard 3 in ACS Step 2");
		wedWait.visibilityOf(exposureTime);
		exposureTime.click();
		Logger4j.info("Clicked on Exposure Time in ACS Step 2");
		wedWait.visibilityOf(select_Dropdown);
		select_Dropdown.click();
		Logger4j.info("Selected Exposure Time in ACS Step 2");
	}

	public void exposure_Bp() throws InterruptedException {
		wedWait.visibilityOf(exposureIntensity);
		exposureIntensity.click();
		Logger4j.info("Selected Exposure Intensity in ACS Step 2");
	}

	public void acs_Step3() throws InterruptedException {
		wedWait.visibilityOf(acs_Bp_Step3);
		acs_Bp_Step3.click();
		Logger4j.info("Clicked on Step 3 of ACS for Body Protection");
		wedWait.visibilityOf(acs_Bp_Step4);
		acs_Bp_Step4.click();
		Logger4j.info("Clicked on Step 4 of ACS for Body Protection");
	}

	public void acs_Step4() throws InterruptedException {
		wedWait.visibilityOf(u4000_Bp_Product);
		u4000_Bp_Product.click();
		Logger4j.info("Selected U4000 Body Protection Product in ACS Step 4");
		wedWait.visibilityOf(u5000_Bp_Product);
		u5000_Bp_Product.click();
		Logger4j.info("Selected U5000 Body Protection Product in ACS Step 4");
		wedWait.visibilityOf(a4000_Bp_Product);
		a4000_Bp_Product.click();
		Logger4j.info("Selected A4000 Body Protection Product in ACS Step 4");
	}

	public void downloadBpReport() throws InterruptedException {
		wedWait.visibilityOf(download_Body_Protection);
		download_Body_Protection.click();
		Logger4j.info("Clicked on Download Body Protection Report");
	}

	public void acs_Bp_Report_Download() throws InterruptedException {
		wedWait.visibilityOf(downloadReport);
		downloadReport.click();
		Logger4j.info("Clicked on Download Report in ACS Body Protection");
	}

	public void acs_Bp_No_Button() throws InterruptedException {
		wedWait.elementToBeClickable(no_Button);
		no_Button.click();
		Logger4j.info("Clicked on No Button in ACS Body Protection");
	}

	public void charts() throws InterruptedException {
		wedWait.visibilityOf(BT10_standard);
		BT10_standard.click();
		Logger4j.info("Selected BT10 Standard in ACS Body Protection");
		wedWait.visibilityOf(BT01_standard);
		BT01_standard.click();
		Logger4j.info("Selected BT01 Standard in ACS Body Protection");
		wedWait.visibilityOf(Cp_standard);
		Cp_standard.click();
		Logger4j.info("Selected Cumulative Permeation Standard in ACS Body Protection");
	}
//	public void downloadDet(String org,String Rpname) throws InterruptedException {
//		reportDetails.click();
//		Thread.sleep(2000);
//		input.sendKeys(Rpname);
//		Thread.sleep(2000);
//		image3.click();
//		Thread.sleep(2000);
//		downloadReport.click();
//		Thread.sleep(10000);
//		No.click();
//	}
}
