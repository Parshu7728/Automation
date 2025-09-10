package com.agc.sel.agc_pageObject;

import com.agc.sel.baseutilities.JavaScriptUtil;
import com.agc.sel.baseutilities.Random_Number_utilities;
import com.agc.sel.baseutilities.WebWait;
import com.agc.sel.loggers.Logger4j;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PTD_Methods {
    WebWait time;
    WebDriver driver;
    @FindBy(xpath = "//*[@id='ptr_reportName']")
    private WebElement ReportName;

    @FindBy(xpath = "//*[@id='orgName']")
    private WebElement OrganizationName;

    @FindBy(xpath = "//*[@id='logoFileSelector']")
    private WebElement chooseLogo;

    @FindBy(xpath = "//*[@id='recepientInfo']")
    private WebElement RecipientInfo;

    @FindBy(xpath = "//img[contains(@src, 'HP_5.jpg')]")
    private WebElement SelectReportImage;

    @FindBy(xpath = "//*[text()='Hand Protection']")
    private WebElement HandProtection;

    @FindBy(xpath = "//label[contains(., 'Body Protection') and @class='cust-radio'] ")
    ////label[contains(., 'Body Protection') and @class='cust-radio test-cls'] --> this xpath also works
    private WebElement BodyProtection;

    @FindBy(xpath = "//*[@id='ptr_productName']")
    private WebElement Searchproducts;

    @FindBy(xpath = "//*[text()='Brand']")
    private WebElement Brand;

    @FindBy(xpath = "//*[@id='btnDownload']")
    private WebElement GenerateReport;

    @FindBy (xpath = "(//ul[contains(@class, 'rich-autocomplete-list')]/li)[1]")
    private WebElement firstItem;

    @FindBy(xpath = "//tr[@id='popupProdName_tr']/td[2]/span")
    private WebElement productGroupValue;

    @FindBy(xpath = "//*[@id='logoFileSelector']")
    private WebElement uploadLogo;

    @FindBy(xpath = "//*[@id='ptrReportLoader']//span[normalize-space(.)='Report is being generated. Please wait.']")
    private WebElement reportLoader;

    @FindBy(xpath = "//*[@id='gs_reportListingTable_reportName']")
    private WebElement reportNameSearchBox;

    @FindBy(xpath = "//*[@id='gs_requestListingGrid_displayId']")
    private WebElement AnsellreportNameSearchBox;

    @FindBy(xpath = "//*[@id='scrollTop']")
    private WebElement scrollTopButton;

    @FindBy(xpath = "//*[@id='gs_requestListingGrid_organization']")
    private WebElement OrganizationNameSearchBox;
    // Constructor
    public PTD_Methods(WebDriver driver) {
        this.driver = driver;
        this.time = new WebWait(driver);
        PageFactory.initElements(driver, this);
    }

    Random_Number_utilities rn = new Random_Number_utilities();
    JavaScriptUtil user = new JavaScriptUtil(driver);
     public String orgName = "Org" + rn.random();
     public String Rname = "Report"+rn.random();
    public void reportName(){
        time.visibilityOf(ReportName);
        ReportName.clear();
        ReportName.sendKeys(Rname);
        Logger4j.info("Entered Report Name: " + ReportName.getAttribute("value"));
    }
    public void uploadLogo(){
        time.visibilityOf(uploadLogo);
        uploadLogo.sendKeys("E:/AutomationAGC/Automation/src/main/resources/Images/logo.jpg");
        Logger4j.info("Uploaded logo for the report.");
    }

    // 1. Enter organization name
    public void enterOrganizationName() {
        time.visibilityOf(OrganizationName);
        OrganizationName.clear();
        OrganizationName.sendKeys(orgName);
        Logger4j.info("Entered Organization Name: " + orgName);
    }

    // 2. Select Report Image
    public void clickSelectReportImage() {
        time.elementToBeClickable(SelectReportImage);
        SelectReportImage.click();
        Logger4j.info("Clicked on Select Report Image");
    }

    // 3. Select Body Protection
    public void clickBodyProtection() {
        time.visibilityOf(BodyProtection);
        BodyProtection.click();
        Logger4j.info("Clicked on Body Protection option");
    }
    public void clickHandProtection() {
        time.visibilityOf(HandProtection);
        if(!HandProtection.isSelected()) {
            HandProtection.click();
            Logger4j.info("Clicked on Hand Protection option");
        }

    }
    // 4. Search for products
// 5. Search product and click first dropdown option
    public void searchAndSelectFirstProduct(String productName) throws InterruptedException {
        time.visibilityOf(Searchproducts);
        Searchproducts.clear();
        Searchproducts.sendKeys(productName);
        Logger4j.info("Typed product name in search: " + productName);
        Thread.sleep(2000);
        // Wait for dropdown list to appear and click first item
        time.elementToBeClickable(firstItem);
        firstItem.click();
        Thread.sleep(2000);
        Logger4j.info("Clicked on first suggested product from dropdown.");
        verifyProductGroup(productName);
    }

    // 5. Click Generate Report
    public void clickGenerateReport() throws InterruptedException {
        time.elementToBeClickable(GenerateReport);
// Extra scroll & wait logic
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", GenerateReport);
            Thread.sleep(1000); // Give UI time to stabilize after scroll
            Logger4j.info("Scrolled to Generate Report button");
        } catch (Exception e) {
            Logger4j.error("Scrolling to Generate Report failed: " + e.getMessage());
        }

// Confirm element is displayed and enabled before clicking
        if (GenerateReport.isDisplayed() && GenerateReport.isEnabled()) {
            GenerateReport.click();
            Logger4j.info("Clicked on Generate Report button");
            time.invisibilityof(reportLoader);
        } else {
            Logger4j.warn("Generate Report button not interactable");
        }
        Thread.sleep(5000);

    }



        // 6. Verify the product displayed matches expected
        // 6. Verify Product Group after selection
    //it still could be improved by using java lists contains number of products
        public void verifyProductGroup(String expectedProductGroup) {
            time.visibilityOf(productGroupValue);
            String actualText = productGroupValue.getText().trim();

            if (actualText.equals(expectedProductGroup)) {
                Logger4j.info("Product Group verified: " + actualText);
            } else {
                Logger4j.error("Product Group mismatch! Expected: " + expectedProductGroup + ", Found: " + actualText);
                throw new AssertionError("Product Group mismatch.");
            }
        }

        public void reportLoader(){
        time.invisibilityof(reportLoader);
        }
        public  void scrollToTop() {
            try {
                time.visibilityOf(scrollTopButton);
                scrollTopButton.click();
                Logger4j.info("Scrolled to top of the page.");
            } catch (Exception e) {
                Logger4j.error("Failed to scroll to top: " + e.getMessage());
            }
        }

    public void verifyReport() {

        try{
            reportNameSearchBox.sendKeys(Rname);
        } catch (Exception e) {
            AnsellreportNameSearchBox.sendKeys(Rname);
        }
        String xpath = "//*[contains(text(),'" + Rname + "')]";

        try {
            WebElement reportElement = driver.findElement(By.xpath(xpath));
            time.visibilityOf(reportElement);
            Assert.assertTrue(reportElement.isDisplayed(), "Report name is not displayed in the report.");
            Logger4j.info("Verified Report Name in Report: " + Rname);
        } catch (Exception e) {
            Logger4j.error("Failed to verify Report Name in Report: " + Rname, e);
            Assert.fail("Report name not found in report: " + Rname);
        }
    }
    public void verifyAnsellReport() {
            OrganizationNameSearchBox.sendKeys(orgName);
            String xpath = "//*[contains(text(),'" + orgName + "')]";

        try {
            WebElement orgElement = driver.findElement(By.xpath(xpath));
            time.visibilityOf(orgElement);
            Assert.assertTrue(orgElement.isDisplayed(), "Organization name is not displayed in the report.");
            Logger4j.info("Verified Organization Name in Report: " + orgName);
        } catch (Exception e) {
            Logger4j.error("Failed to verify Organization Name in Report: " + orgName, e);
            Assert.fail("Organization name not found in report: " + orgName);
        }
    }

}


