package com.agc.sel.agc_pageObject;
import com.agc.sel.loggers.Logger4j;
import com.agc.sel.baseutilities.WebWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class AnsellPaddHpandBp {
	
	WebDriver driver;
	WebWait time ;
	
	@FindBy(xpath = "((//button[text()='Save']))[2]")
	private WebElement organization_Save_Button;
	
	@FindBy(id="atc_productName")
	private WebElement addProduct;

	@FindBy(xpath="	//span[text()=' Product Group- 2300']")
	private WebElement addProductSearchText1;

	@FindBy(xpath="	//span[text()=' Product Group- 6000']")
	private WebElement addProductSearchText2;

	@FindBy(xpath="//span[contains(text(),'ADD MULTIPLE PRODUCTS')]")
	private WebElement addMultipleProduct;
	
	@FindBy(xpath="//a[text()='2']")
	private WebElement nextPage;

	@FindBy(xpath="//span[text()='4000 CFR']") 
	private WebElement select_Product1;

	@FindBy(xpath="//span[text()='6500']")
	private WebElement select_Product2;

	@FindBy(xpath="(//button[text()='Add To List'])[2]")
	private WebElement addToListProduct;
	
	@FindBy(xpath="//a[contains(text(),'Body Protection ')]")
	private WebElement bpPage;
	
	@FindBy(id="hpStatusId")
	private WebElement hpStatus;
	
	@FindBy(id="bpStatusId")
	private WebElement bpStatus;
	
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement submitHp;
	
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement submitBp;
	
	@FindBy(xpath="//span[text()='Degradation Chart']")
	private WebElement click_Degredation;
	
	@FindBy(xpath="//span[text()='Combined Chart']")
	private WebElement click_Combined;
	
	@FindBy(xpath="//span[text()='EN ISO 374']")
	private WebElement EnIso;
	
	@FindBy(xpath="(//button[text()='Submit'])[2]")
	private WebElement submit;
	
	@FindBy(xpath="(//span[text()='Breakthrough Times BT'])[2]")
	private WebElement Bt01;
	
	@FindBy(xpath="//span[text()='Cumulative Permeation']")
	private WebElement Cp;
	
	@FindBy(id="downloadDropDownMenu")
	private WebElement download;
	
	@FindBy(xpath="//span[text()='hand protection']")
	private WebElement handProtection;
	
	@FindBy(xpath="//span[text()='body protection']")
	private WebElement bodyProtection;
	
	@FindBy(xpath="//span[text()='HP & BP Chart']")
	private WebElement handProtectionAndBodyProtection;

	
	public AnsellPaddHpandBp(WebDriver driver) {
		this.driver = driver;
		this.time = new WebWait(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void organization_Save_Button() throws InterruptedException {
		time.elementToBeClickable(organization_Save_Button);
		organization_Save_Button.click();
		Logger4j.info("Clicked on Organization Save Button");
	}
	
	public void swithToBp() {
		bpPage.click();
		Logger4j.info("Switched to Body Protection Page");
	}
	
	public String textStatusHp() {
		return hpStatus.getText();
		}
	
	public String textStatusBp() {
		return bpStatus.getText();
	}
	
	public void download() throws InterruptedException {

//		time.elementToBeClickable(download);
//		download.click();
//		time.elementToBeClickable(handProtection);
//		handProtection.click();
//		time.elementToBeClickable(download);
//	    download.click();
//	    time.elementToBeClickable(bodyProtection);
//		bodyProtection.click();
		Thread.sleep(60000);
		driver.navigate().refresh();
		driver.navigate().refresh();
		time.elementToBeClickable(download);
		download.click();
		time.elementToBeClickable(handProtectionAndBodyProtection);
		handProtectionAndBodyProtection.click();
	}
	}

