package com.agc.sel.agc_pageObject;//package agc_pageObject;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//import agc_utilities.WebWait;
//
//public class RegistrationPage {
//	
//	@FindBy(xpath="//button[text()='Accept All']")
//	private WebElement accept_cookies;
//	
//	@FindBy(xpath="//span[text()='Sign in / Register']")
//	private WebElement signin;
//	
//	@FindBy(xpath="(//a[text()='Register Now '])[1]")
//	private WebElement registration;
//	
//	@FindBy(id="firstName")
//	private WebElement first_name;
//	
//	@FindBy(id="lastName")
//	private WebElement last_name;
//	
//	@FindBy(id="emailId")
//	private WebElement email_address;
//	
//	@FindBy(id="password")
//	private WebElement password;
//	
//	@FindBy(id="organizationName")
//	private WebElement organization_name;
//	
//	@FindBy(id="userTypeDetail")
//	private WebElement userTypeDetail;
//	
//	@FindBy(xpath="//option[text()='Distributor Sales Rep.']")
//	private WebElement select_userTp;
//	
//	@FindBy(id="country")
//	private WebElement country;
//	
//	@FindBy(xpath="//option[text()='Argentina']")
//	private WebElement select_country;
//	
//	@FindBy(id="zipCode")
//	private WebElement postal_code;
//	
//	@FindBy(id="sector")
//	private WebElement sector;
//	
//	@FindBy(xpath="//option[text()='Healthcare']")
//	private WebElement select_sector;
//	
//	@FindBy(id="subsector")
//	private WebElement subsector;
//	
//	@FindBy(xpath="//option[text()='Dental']")
//	private WebElement select_subsector;
//	
//	@FindBy(xpath="/html/body/div[2]/div[10]/div[1]/div[1]/div[1]/form/div[6]/div/label/img")
//	private WebElement captcha_id;
//	
//	@FindBy(id="captchaValue")
//	private WebElement captchaValue;
//	
//	@FindBy(id="termsAndConditions")
//	private WebElement termsAndConditions;
//	
//	@FindBy(id="Submit")
//	private WebElement register;
//	
//	public RegistrationPage(WebDriver driver) {
//		PageFactory.initElements(driver, this);
//	}
//	
//	public void cookies() throws InterruptedException {
//		Thread.sleep(2000);
//		accept_cookies.click();
//		Thread.sleep(2000);
//		signin.click();
//		Thread.sleep(2000);
//		registration.click();
//	}
//	public void Register(String fn,String ln, String email,String pass, String org,String code) throws InterruptedException {
//		WebWait w=new WebWait();
//		w.visibilityOf(first_name);
//		first_name.sendKeys(fn);
//		w.visibilityOf(last_name);
//		last_name.sendKeys(ln);
//		w.visibilityOf(email_address);
//		email_address.sendKeys(email);
//		w.visibilityOf(password);
//		password.sendKeys(pass);
//		w.visibilityOf(organization_name);
//		organization_name.sendKeys(org);
//		w.visibilityOf(userTypeDetail);
//		userTypeDetail.click();
//		w.visibilityOf(select_userTp);
//		select_userTp.click();
//		w.visibilityOf(country);
//		country.click();
//		w.visibilityOf(select_country);
//		select_country.click();
//		w.visibilityOf(postal_code);
//		postal_code.sendKeys(code);
//		w.visibilityOf(sector);
//		sector.click();
//		w.visibilityOf(select_sector);
//		select_sector.click();
//		w.visibilityOf(subsector);
//		subsector.click();
//		w.visibilityOf(select_subsector);
//		select_subsector.click();
//		w.visibilityOf(captcha_id);
//		String captchaid = captcha_id.getText();
//		w.visibilityOf(captchaValue);
//		captchaValue.sendKeys(captchaid);
//		w.visibilityOf(termsAndConditions);
//		termsAndConditions.click();
//		w.visibilityOf(register);
//		register.click();
//	}
//
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	}