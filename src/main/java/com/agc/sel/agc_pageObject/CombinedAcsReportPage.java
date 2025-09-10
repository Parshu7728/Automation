package com.agc.sel.agc_pageObject;

import com.agc.sel.loggers.Logger4j;
import com.agc.sel.baseutilities.WebWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;


public class CombinedAcsReportPage {
	WebWait waitTime ;
	WebDriver driver;
	
	@FindBy(xpath="//span[text()='Application Details']")
	private WebElement acs_Step2;
	
	@FindBy(xpath="(//label[@class='st-1'])[3]")
	private WebElement both_RadioButton;
	
	@FindBy(xpath="(//p-checkbox[@value='item'])[7]")
	private WebElement u4000Bp1;
	
	@FindBy(xpath="(//p-checkbox[@value='item'])[9]")
	private WebElement u4000Bp2;
	
	@FindBy(xpath="(//p-checkbox[@value='item'])[12]")
	private WebElement u4000Bp3;
	
	@FindBy(xpath="(//i[@class='pi pi-plus-circle'])[1]")
	private WebElement loadMore;
	
	@FindBy(xpath="//a[@id='p-accordiontab-1']")
	private WebElement organizationDetailsBoth;
	
	@FindBy(xpath="(//div[@class='p-radiobutton-box'])[4]")
	private WebElement exposureIntensity2;
	
	@FindBy(xpath="//button[@icon='pi pi-upload']")
	private WebElement upload;
	
	@FindBy(xpath="//input[@name='orgName']")
	private WebElement organization_Input;
	
	@FindBy(xpath="(//span[@class='p-button-label'])[2]")
	private WebElement hp_Compare;
	
	@FindBy(xpath="(//span[@class='p-button-label'])[3]")
	private WebElement bp_Compare;
	
	@FindBy(xpath = "(//span[text()='Return to view Products'])[1]")
	private WebElement return_Button;
	
	@FindBy(xpath = "//span[text()=' Report Details ']")
	private WebElement ReportDetails;
	
	@FindBy(xpath = "(//li[@class='ng-star-inserted'])[2]")
	private WebElement image3;
	
	public CombinedAcsReportPage(WebDriver driver) {
		this.driver = driver;
		this.waitTime = new WebWait(driver);
		PageFactory.initElements(driver, this);

	}
	
//	public void compare_HpBp() throws Throwable {
//		waitTime.visibilityOf(hp_Compare);
//		hp_Compare.click();
//		Thread.sleep(5000);
//		waitTime.elementToBeClickable(return_Button);
//		return_Button.click();
//		waitTime.visibilityOf(bp_Compare);
//		bp_Compare.click();
//		Thread.sleep(5000);
//		waitTime.elementToBeClickable(return_Button);
//		return_Button.click();
//		
//	}
	public void bothBpProduct() throws InterruptedException {
		waitTime.elementToBeClickable(u4000Bp1);
		u4000Bp1.click();
		Logger4j.info("Clicked on U4000 BP Product");
		waitTime.elementToBeClickable(u4000Bp2);
		u4000Bp2.click();
		Logger4j.info("Clicked on U4000 BP Product");
		waitTime.elementToBeClickable(u4000Bp3);
		u4000Bp3.click();
		Logger4j.info("Clicked on U4000 BP Product");
	}
	public void acs_Click_Step2() throws InterruptedException {
		waitTime.visibilityOf(acs_Step2);
		acs_Step2.click();
		Logger4j.info("Clicked on Step 2 of ACS for Combined Report");
	}
	public void exposureInBoth() throws InterruptedException {
		waitTime.visibilityOf(exposureIntensity2);
		exposureIntensity2.click();
		Logger4j.info("Selected Exposure Intensity in ACS Step 2 for Combined Report");
	}
	
	public void load() throws InterruptedException {
		waitTime.visibilityOf(loadMore);
		loadMore.click();
		Logger4j.info("Clicked on Load More in ACS Combined Report Step 2");
	}
	
	public void Both() {
		waitTime.visibilityOf(both_RadioButton);
		both_RadioButton.click();
		Logger4j.info("Selected Both Radio Button in ACS Combined Report Step 2");
			}

	public void click_OrganizationDetails(String org) throws InterruptedException, AWTException {
		waitTime.visibilityOf(organizationDetailsBoth);
		organizationDetailsBoth.click();
		Logger4j.info("Clicked on Organization Details in ACS Combined Report Step 2");
		waitTime.visibilityOf(organization_Input);
		organization_Input.sendKeys(org);
		Logger4j.info("Entered Organization Name in ACS Combined Report Step 2");
	}
	
	public void acs_Report_Details() throws InterruptedException {
		Thread.sleep(5000);
		waitTime.visibilityOf(ReportDetails);
		ReportDetails.click();
		Logger4j.info("Clicked on Report Details in ACS Combined Report Step 2");
		waitTime.visibilityOf(image3);
		image3.click();
		Logger4j.info("Clicked on Image3 in ACS Combined Report Step 2");
	}
	
}
