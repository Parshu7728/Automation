package com.agc.sel.agc_pageObject;

import com.agc.sel.baseutilities.Asserrtion;
import com.agc.sel.baseutilities.JavaScriptUtil;
import com.agc.sel.loggers.Logger4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertNotEquals;

public class My_Report {
	String us;
	String chi;
	String du;
	String ko;
	WebDriver driver;
	public static com.agc.sel.baseutilities.WebWait time ;

	@FindBy(xpath = "(//div/h1)[3]")
	private WebElement my_Report_Title_Verification;

	@FindBy(id = "selectedLang")
	private WebElement flag;

	@FindBy(xpath = "//span[text()='한국어']")
	private WebElement korean;

	@FindBy(xpath = "//span[text()='Deutsch']")
	private WebElement Deutsch;

	@FindBy(xpath = "//span[text()='简体中文']")
	private WebElement chinease;

	@FindBy(xpath = "//span[text()='English']")
	private WebElement english;

	@FindBy(id = "switchToDropdown")
	private WebElement hamBurger_My_report;

//	@FindBy(id="cptdTiles")
//	private WebElement Chemical_Product_Test_Data ;

	@FindBy(xpath = "//a[normalize-space()='ADVANCED CHEMICAL PRODUCT SELECTOR']")
	private WebElement advanced_Chemical_Product_Selector_MyReport;

	@FindBy(xpath = "//span[text()='Permeation & Degradation Database ']")
	private WebElement permeation_and_Degradation_Database_MyReport;

	@FindBy(xpath = "//span[text()='Organization Details']")
	private WebElement textPadPage;

	@FindBy(xpath = "//span[text()='Chemical Product Test Data ']")
	private WebElement chemical_Product_Test_Data_MyReport;

	@FindBy(xpath = "//*[@id='cptdTiles']")
	private WebElement Basic_Ptd;

	@FindBy(xpath = "//*[normalize-space(text())='PERMEATION AND DEGRADATION DATABASE']")
	private WebElement Basic_Padd;

	@FindBy(xpath = "//*[@id = 'openCreateRequestDialog']")
	private WebElement new_Risk_Request;

	@FindBy(id = "createRequest")
	private WebElement createRequest;

	@FindBy(xpath = "(//span[@class='label__text'])[1]")
	private WebElement deselectHp;

	@FindBy(xpath = "(//span[@class='label__text'])[2]")
	private WebElement deselectBp;

	@FindBy(xpath = "(//span[contains(@id,'span')])[3]")
	private WebElement my_Report_RowReport1;

	@FindBy(xpath = "(//span[contains(@id,'span')])[4]")
	private WebElement my_Report_RowReport2;

	@FindBy(xpath = "//i[@class='i-profile']")
	private WebElement profile_Name_Dropdown;

	@FindBy(xpath = "//i[@class='i-profile']")
	private WebElement my_Profile;

	@FindBy(xpath = "//span[text()='Sign Out']")
	private WebElement signOut;

	@FindBy(id = "report-btn")
	private WebElement myReport;

	@FindBy(id = "ui-id-4")
	private WebElement advanced_Product_Selector_Tab3;
	
	@FindBy(xpath = "//span[text()='Support']")
	private WebElement support;
	
	@FindBy(id = "skipOrgDetails")
	private WebElement skipOrgDetails;
	
	@FindBy(id = "subject")
	private WebElement subject;
	
	@FindBy(xpath = "//option[text()='Can’t Find Chemicals / Other Hazards']")
	private WebElement dropdown_Reason;
	
	@FindBy(id = "description")
	private WebElement description;
	
	@FindBy(xpath = "(//div[@class='container']//h1)[1]") 
	private WebElement contactText;
	
	@FindBy(id = "captchaValue")
	private WebElement captcha;
	
	@FindBy(xpath = "//input[@type='button']")
	private WebElement submit_Reason;

	@FindBy(xpath = "//*[@id='snackbar']")
	private WebElement snackBar;

    @FindBy(xpath = "//*[text()='Product Test Data']")
	private WebElement ptd_list;

	@FindBy(id = "ilogo")
	private WebElement logo;

	public My_Report(WebDriver driver) {
		this.driver = driver;
		time = new com.agc.sel.baseutilities.WebWait(driver);
		PageFactory.initElements(driver, this);
	}
   JavaScriptUtil user = new JavaScriptUtil(driver);
	public void contactUs(String text) {
		time.visibilityOf(support);
		support.click();
		Logger4j.info("Clicked on Support link in My Report page");
		time.visibilityOf(subject);
		subject.click();
		Logger4j.info("Clicked on Subject field in Contact Us form");
		time.visibilityOf(dropdown_Reason);
		dropdown_Reason.click();
		Logger4j.info("Clicked on Dropdown Reason in Contact Us form");
		time.visibilityOf(description);
		description.sendKeys(text);
		Logger4j.info("Entered description in Contact Us form: " + text);
	}
	public void contactUs_withoutLogin(String text) {
		time.visibilityOf(support);
		support.click();
		Logger4j.info("Clicked on Support link in My Report page");

		// Ensure the snackbar is visible before retrieving its text
		time.visibilityOf(snackBar);

		// Log the actual message displayed in the snackbar
		String snackbarMessage = snackBar.getText();
		Logger4j.info("Snackbar message displayed: " + snackbarMessage);

		Asserrtion assertion = new Asserrtion();
		assertion.verification(text, snackbarMessage);
	}

public void BasicPtd() {
	time.visibilityOf(Basic_Ptd);
	Basic_Ptd.click();
	Logger4j.info("Clicked on Chemical Product Test Data ");

}
public void BasicPadd(){
time.waitAndClick(Basic_Padd);
Logger4j.info("Clicked on Permeation and Degradation Database");
Asserrtion.softAssertTrue(logo.isDisplayed(), "Logo is not displayed on PTD page");
}
	public void captcha() throws Throwable {
//		time.visibilityOf(submit_reason);
//		submit_reason.click();

	}

	public String contacttext() {
		return contactText.getText();
	}

	public void newRiskRequest() throws InterruptedException {
		time.elementToBeClickable(new_Risk_Request);
		new_Risk_Request.click();
		Logger4j.info("Clicked on New Risk Request button in My Report page");
	}

	public void deselectHp() throws InterruptedException {
		time.elementToBeClickable(deselectHp);
		deselectHp.click();
		Logger4j.info("Deselected Hand Protection in My Report page");
		create_Request();
		Logger4j.info("Clicked on Create Request button after deselecting Hand Protection");

	}

	public void create_Request() throws InterruptedException {
		time.visibilityOf(createRequest);
		createRequest.click();
		Logger4j.info("Clicked on Create Request button in My Report page");
	}

	public void deselectBp() throws InterruptedException {
		time.visibilityOf(deselectBp);
		deselectBp.click();
		Logger4j.info("Deselected Body Protection in My Report page");
		create_Request();
		Logger4j.info("Clicked on Create Request button after deselecting Body Protection");

	}

	public void firstRequest_Id() throws InterruptedException {
		my_Report_RowReport1.click();
		Logger4j.info("Clicked on the first report in My Report page");
	}

//	public void BpRequest_Id() throws InterruptedException  {;
//		Thread.sleep(8000);
//		My_Report_RowReport2.click();
//	}

	public String myReport_Title_verification() throws InterruptedException {
		Thread.sleep(4000);
		return my_Report_Title_Verification.getText();
	}

	public void hamBurger_MyReport() {
		time.visibilityOf(hamBurger_My_report);
		Logger4j.info("Click on Hamburger menu in My Report page");
		hamBurger_My_report.click();
		Logger4j.info("Clicked on Hamburger menu in My Report page");
	}
	
	public void skipOrgDetailss() {
		time.visibilityOf(skipOrgDetails);
		skipOrgDetails.click();
		Logger4j.info("Clicked on Skip Organization Details in My Report page");
	}

//	public void PTDD(WebDriver driver) throws InterruptedException {
//		Actions actions = new Actions(driver);
//		Thread.sleep(4000);
//		actions.moveToElement(Chemical_Product_Test_Data).click().perform();
//
//	}

	public void logout() throws InterruptedException {
		time.elementToBeClickable(my_Profile);
		my_Profile.click();
		Logger4j.info("Clicked on My Profile in My Report page");
		try {
			Thread.sleep(2000);
			// Perform logout action if logged in
			if (signOut.isDisplayed()&& signOut.isEnabled()) {
				 Logger4j.info("Logout button is displayed and enabled, proceeding to click.");
				    time.elementToBeClickable(signOut);
			     	signOut.click();
				 Logger4j.info("Logged out successfully.");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			// Handle case where logout button might not be present (e.g., if the user is
			// not logged in)
			 Logger4j.info("Logout button not found, possibly already logged out.");
		} catch (Exception e) {
			// Catch any other exception during logout and print it
			 Logger4j.info("Error during logout: " + e.getMessage());
		}

	}

	public void acs_MyReport(WebDriver driver) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement acsLink = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[normalize-space()='ADVANCED CHEMICAL PRODUCT SELECTOR']")));

		// Final force-click using JavaScript
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", acsLink);
		Logger4j.info("Clicked on ACS link using JavaScriptExecutor");
	}
	public void ansell_acs_MyReport(WebDriver driver) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement acsLink = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"header\"]/div[1]/nav/div[1]/div/ul/li[1]/a/span")));

		// Final force-click using JavaScript
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", acsLink);
		Logger4j.info("Clicked on ACS link using JavaScriptExecutor");
	}



	public void padd_MyReport(WebDriver driver) throws InterruptedException {
		permeation_and_Degradation_Database_MyReport.click();
		Logger4j.info("Clicked on Permeation and Degradation Database in My Report page");

	}

	public void ptd_MyReport(WebDriver driver) throws InterruptedException {
		chemical_Product_Test_Data_MyReport.click();
		Logger4j.info("Clicked on Chemical Product Test Data in My Report page");

	}

	public String verify_PaddPage(WebDriver driver) throws InterruptedException {
		time.visibilityOf(textPadPage);
		return textPadPage.getText();

	}

	public void navigate_from_PaddTo_MyReportPage() throws InterruptedException {
		time.visibilityOf(profile_Name_Dropdown);
		profile_Name_Dropdown.click();
		Logger4j.info("Clicked on Profile Name Dropdown in My Report page");
		time.visibilityOf(myReport);
		myReport.click();
			Logger4j.info("Clicked on My Report in Profile Name Dropdown");
			//for PTD indexes

		time.visibilityOf(ptd_list);
		ptd_list.click();
	}
	public void navigate_from_PTD_MyReportPage() throws InterruptedException {
		Thread.sleep(2000);
		time.visibilityOf(profile_Name_Dropdown);
		profile_Name_Dropdown.click();
		Logger4j.info("Clicked on Profile Name Dropdown in My Report page");
		time.visibilityOf(myReport);
		myReport.click();
		Logger4j.info("Clicked on My Report in Profile Name Dropdown");
		driver.navigate().refresh();
		Thread.sleep(5000);
		time.elementToBeClickable(ptd_list);
		ptd_list.click();
		Thread.sleep(4000);
	}
	public String flag_Change_Us_Korean() throws InterruptedException {
	    // Flag changing from US to Korean
	    String us = myReport_Title_verification();
	    if (us == null) {
	        Logger4j.error("Failed to retrieve the initial title.");
	        throw new IllegalStateException("Initial title is null.");
	    }
	    Logger4j.info("Initial title: " + us);

	    try {
	        time.elementToBeClickable(flag);
	        flag.click();
	        Logger4j.info("Clicked on the flag element.");

	        time.elementToBeClickable(korean);
	        korean.click();
	        Logger4j.info("Clicked on the Korean flag element.");

	        String ko = myReport_Title_verification();
	        if (ko == null) {
	            Logger4j.error("Failed to retrieve the updated title.");
	            throw new IllegalStateException("Updated title is null.");
	        }
	        Logger4j.info("Updated title: " + ko);

	        assertNotEquals(us, ko, "Titles before and after flag change should not be the same.");
	        return ko;
	    } catch (Exception e) {
	        Logger4j.error("An error occurred during flag change: " + e.getMessage(), e);
	        throw e;
	    }
	}
	
	public String flag_Change_Korean_Chinease() throws InterruptedException {
	    // Flag changing from Korean to Chinese
	    String ko = myReport_Title_verification();
	    if (ko == null) {
	        Logger4j.error("Failed to retrieve the initial title.");
	        throw new IllegalStateException("Initial title is null.");
	    }
	    Logger4j.info("Initial title: " + ko);

	    try {
	        time.elementToBeClickable(flag);
	        flag.click();
	        Logger4j.info("Clicked on the flag element.");

	        time.elementToBeClickable(chinease);
	        chinease.click();
	        Logger4j.info("Clicked on the Chinese flag element.");

	        String chi = myReport_Title_verification();
	        if (chi == null) {
	            Logger4j.error("Failed to retrieve the updated title.");
	            throw new IllegalStateException("Updated title is null.");
	        }
	        Logger4j.info("Updated title: " + chi);

	        assertNotEquals(ko, chi, "Titles before and after flag change should not be the same.");
	        return chi;
	    } catch (Exception e) {
	        Logger4j.error("An error occurred during flag change: " + e.getMessage(), e);
	        throw e;
	    }
	}
		
	public String flag_Change_Chinease_Deutsch() throws InterruptedException {
	    // Flag changing from Chinese to Deutsch
	    String chi = myReport_Title_verification();
	    if (chi == null) {
	        Logger4j.error("Failed to retrieve the initial title.");
	        throw new IllegalStateException("Initial title is null.");
	    }
	    Logger4j.info("Initial title: " + chi);

	    try {
	        time.elementToBeClickable(flag);
	        flag.click();
	        Logger4j.info("Clicked on the flag element.");

	        time.elementToBeClickable(Deutsch);
	        Deutsch.click();
	        Logger4j.info("Clicked on the Deutsch flag element.");

	        String du = myReport_Title_verification();
	        if (du == null) {
	            Logger4j.error("Failed to retrieve the updated title.");
	            throw new IllegalStateException("Updated title is null.");
	        }
	        Logger4j.info("Updated title: " + du);

	        assertNotEquals(chi, du, "Titles before and after flag change should not be the same.");
	        return du;
	    } catch (Exception e) {
	        Logger4j.error("An error occurred during flag change: " + e.getMessage(), e);
	        throw e;
	    }
	}
		
	public String flag_Change_Deutsch_Us() throws InterruptedException {
	    // Flag changing from Deutsch to US
	    String du = myReport_Title_verification();
	    if (du == null) {
	        Logger4j.error("Failed to retrieve the initial title.");
	        throw new IllegalStateException("Initial title is null.");
	    }
	    Logger4j.info("Initial title: " + du);

	    try {
	        time.elementToBeClickable(flag);
	        flag.click();
	        Logger4j.info("Clicked on the flag element.");

	        time.elementToBeClickable(english);
	        english.click();
	        Logger4j.info("Clicked on the English flag element.");

	        String us = myReport_Title_verification();
	        if (us == null) {
	            Logger4j.error("Failed to retrieve the updated title.");
	            throw new IllegalStateException("Updated title is null.");
	        }
	        Logger4j.info("Updated title: " + us);

	        assertNotEquals(du, us, "Titles before and after flag change should not be the same.");
	        return us;
	    } catch (Exception e) {
	        Logger4j.error("An error occurred during flag change: " + e.getMessage(), e);
	        throw e;
	    }
	}

	public void acs_Myreport_Tab() {
		advanced_Product_Selector_Tab3.click();
		Logger4j.info("Clicked on Advanced Product Selector Tab in My Report page");
	}

	public void scrollToTop() {
		user.scrollToTop();
        		Logger4j.info("Scrolled to Top");
	}

}
