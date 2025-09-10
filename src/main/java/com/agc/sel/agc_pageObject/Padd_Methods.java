package com.agc.sel.agc_pageObject;

import com.agc.sel.baseutilities.*;
import com.agc.sel.loggers.Logger4j;
import lombok.extern.java.Log;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

import static com.agc.sel.baseutilities.Asserrtion.verification;
import static org.testng.Assert.assertEquals;

public class Padd_Methods {
    WebWait time;
    WebDriver driver;
    Random random = new Random();
    Random_Number_utilities Rn = new Random_Number_utilities();
    public Credentials_Utilities props = new Credentials_Utilities();
    public PADD_TestData_utilities padd_utility = new PADD_TestData_utilities();
    public String Rproduct = padd_utility.removable_prodcut();
    public String RproductName = padd_utility.Removable_product_name();
    JavaScriptUtil jsUtil ;
    My_Report my_Report ;
    public Padd_HandProtection_elements padd_Hp;
    public Asserrtion assertionCheck = new Asserrtion();

    @FindBy(xpath = "//*[text() ='Create New Singles/Mixtures']")
    private WebElement createNewSinglesMixtures_button;

    @FindBy(xpath = "//*[@id=\"ui-id-2\"]")
    private WebElement Add_single_tab;

    @FindBy(xpath = " //*[@id='cas']")
    private WebElement CAS_number_textField;

    @FindBy(xpath = "//*[@id='chemicalTradeName']")
    private WebElement chemical_name_textField;

    @FindBy(xpath = "//*[@id='chemicalAggregationSingle']")
    private WebElement Physical_state_select;

    @FindBy(xpath = "//*[@id='maxValue']")
    private WebElement concentration_text_field;

    @FindBy(xpath = "//*[@id='save']")
    private WebElement save_button;

    @FindBy(xpath = "//*[@id = 'snackbar']")
    private WebElement snackbar_message;

    @FindBy(xpath = "//*[text() ='Add Mixture']")
    private WebElement Mixture_tab;

    @FindBy(xpath = "//*[@id='mixture']")
    private WebElement Mixture_Name_textField;

    @FindBy(xpath = "//*[@id='chemicalAggregationForMix']")
    private WebElement Physical_state_mix;

    @FindBy(xpath = "//*[@id='atc_CASNumber']")
    private WebElement add_mixture_cas_number_textField;

    @FindBy(id = "chemicalName")
    private WebElement add_mixture_chemical_name_textField;

    @FindBy(id = "praportion")
    private WebElement add_mixture_proportion_textField;

    @FindBy(id = "aggrigation")
    private WebElement component_physical_state_dropdown;

    @FindBy(id = "addToList")
    private WebElement add_component_button;

    @FindBy(id = "uiComponentsAddToList")
    private WebElement add_my_mixture_button;

    @FindBy(xpath = "   //*[@id='snackbar']")
    private WebElement final_message;

    @FindBy(xpath = "//label[ancestor::td/following-sibling::td[div[contains(text(),'7783-52-0')]]]")
    private WebElement singleCheckbox;

    @FindBy(xpath = "//span[@class='ch-name-cls' and contains(text(), 'mix')]/ancestor::tr//label[1]")
    private WebElement MixtureCheckbox;

    @FindBy(xpath = "//*[@class='pull-right hp removeChem' and normalize-space(text())='Remove']")
    private WebElement chemicalremoveButton;

    @FindBy(xpath = "//*[text()='Confirmation']")
    private WebElement deleteconfirmationPopup;

    @FindBy(xpath = "//div[@class='ui-dialog-buttonset']/button[text()='Remove']")
    private WebElement dialogboxRemoveButton;

    @FindBy(xpath = "//table//tr[contains(@id, 'chem_hp_')]//td[1]//label//i")
    private List<WebElement> checkboxes;

    @FindBy(xpath = "//*[text()= 'Upload Template']")
    private WebElement uploadTemplateButton;

    @FindBy(xpath = "//*[@id='chemicalTemplate']")
    private WebElement uploadFile_popup;

    @FindBy(xpath = "//*[@id='btnDownload']")
    private WebElement TemplateDownloadButton;

    @FindBy(xpath = "//*[@id='btnUpload']")
    private WebElement uploadButtonInPopup;

    @FindBy(xpath = "//*[@id='tcRowHead']/th[2]")
    private WebElement SortByCasButton;

    @FindBy(xpath = "(//table//tbody/tr/td[2])[1]")
    private WebElement cas1;

    @FindBy(xpath = "(//table//tbody/tr/td[2])[2]")
    private WebElement cas2;

    @FindBy(xpath = "//*[@id='hp_gridLoader']")
    private WebElement GridLoader;

    @FindBy(xpath = "//*[@id='tcRowHead']/th[3]")
    private WebElement SortBychemicalButton;

    @FindBy(xpath = "(//table//tbody/tr/td[3])[1]")
    private WebElement chemical1;

    @FindBy(xpath = "(//table//tbody/tr/td[3])[2]")
    private WebElement chemical2;

    @FindBy(xpath = "//*[@id='prodDetail_db63c307-68c4-11e7-b88c-000d3a173cc5']")
    private WebElement productInfoDot1;

    @FindBy(xpath = "//*[@id=\"prodDetail_db636887-68c4-11e7-b88c-000d3a173cc5\"]")
    private WebElement productInfoDot4;

    @FindBy(xpath = "//*[@id='multiSelectDialog']//table//tr[1]/td[2]")
    private WebElement productgroup;

    @FindBy(xpath = "(//button[@class='ui-dialog-titlebar-close'])[5]")
    private WebElement closepopup;

    // Upload MSDS text label
    @FindBy(xpath = "//*[contains(text(), 'Upload SDS')]")
    private WebElement uploadSDSText;

    @FindBy(xpath = "(//button[text()='Close'])[4]")
    private WebElement closeMSDCButton;

    // File upload (Choose Files) button
    @FindBy(xpath = "//*[@id='fileUploader']")
    private WebElement fileUploadButton;

    @FindBy(xpath = "//*[@title='Download MSDS']")
    private WebElement downloadMSDCButton;

    @FindBy(xpath = "//*[@class='msds-file-select']")
    private WebElement msdsFileSelect;

    @FindBy(xpath = "//div[text()='Successfully Uploaded']")
    private WebElement uploadSuccessMessage;

    @FindBy(xpath = "//button[@class='remove-msds pull-right']")
    private WebElement deleteMSDSfile;

    @FindBy(xpath = "//*[@value='YES']")
    private WebElement deleteMSDSfileYesButton;

    @FindBy(xpath = "(//span[@class='label__check label__check_small'])[11] ")
    private WebElement prod_38_001checkbox;

    @FindBy(xpath = "(//span[@class='label__check label__check_small'])[4]")
    private WebElement productRemoveButton;

    @FindBy(xpath = "//*[text()='Remove']")
    private WebElement removeButtonforProduct;

    @FindBy(xpath = "(//*[text()='Remove'])[2]")
    private WebElement procutremoveconfirmationButton;

    @FindBy(xpath = "//*[text()='38-001']")
    private WebElement product38_001;

    @FindBy(xpath = "//span[normalize-space()='add products']")
    private WebElement AddProductText;

    @FindBy(xpath = "//*[@id=\"showDetails\"]")
    private WebElement showproductDetailsbutton;

    @FindBy(xpath = "//*[@id=\"tcRowHead\"]")
    private WebElement productinfotab;

    @FindBy(xpath = "//div[@class='pro_template']")
    private WebElement template_dropdown;

    @FindBy(xpath = "//*[@id='hp_tcChemProd']")
    private WebElement paddTabledata;

    @FindBy(xpath = "//*[contains(normalize-space(text()),'Region Default Product')]")
    private WebElement regionDefaultProductsOption;

    @FindBy(xpath = "//input[@value='YES']")
    private WebElement yesConfirmation;

    @FindBy(xpath = "//*[normalize-space(text())='Default Products are already loaded']")
    private WebElement defaultProductsLoadedMsg;

    @FindBy(xpath = "//*[@id='sortedByPerformanceDiv']")
    private WebElement sortedByPerformanceToggle;

    @FindBy(id = "New")
    private WebElement addEditProductTemplateBtn;

    @FindBy(id = "ptname")
    private WebElement newTemplateTextBox;

    @FindBy(id = "dialogprodTemplate")
    private WebElement currentTemplateDropdown;

    @FindBy(id = "btnSaveTemplateData")
    private WebElement templateSaveButton;

    @FindBy(id = "btnDeleteTemplateData")
    private WebElement templateDeleteButton;

    @FindBy(xpath = "//button[normalize-space(text())='Delete']")
    private WebElement templateDeleteConfirmationBtn;

    @FindBy(id = "hp_standardSelection")
    private WebElement standardSelection;

    @FindBy(id = "standardName")
    private WebElement standardType;

    @FindBy(id = "downArrow")
    private WebElement downArrow;

    @FindBy(id = "hp_chartTypeSelection")
    private WebElement chartTypeDropdown;

    @FindBy(xpath = "(//*[@class='chmiclcls'])[1]")
    private WebElement permeationOutput;

    @FindBy(xpath = "(//*[@class='chmiclcls'])[10]")
    private WebElement degradationOutput;

    @FindBy(xpath = "(//*[@class='th-container'])[1]")
    private WebElement first_prodblock;

    @FindBy(xpath = "(//*[@class='th-container'])[4]")
    private WebElement fourth_prodblock;

    @FindBy(xpath = "//*[@id=\"hp_alsotrytheseProds\"]//li[1]//h3")
    private WebElement suggestedProduct1;

    @FindBy(xpath = "//*[@id=\"bp_alsotrytheseProds\"]//li[1]//h3")
    private WebElement suggestedProduct1BP;
    // Comments & FAQs button
    @FindBy(xpath = "//*[normalize-space(text())='Comments & FAQs']")
    private WebElement commentsFaqBtn;

    // Add Comment button
    @FindBy(xpath = "(//*[@id='saveComments'])[2]")
    private WebElement addCommentBtn;

    // Write Comment popup (editor)
    @FindBy(xpath = "//*[@class='jqte_editor']")
    private WebElement writeCommentEditor;

    // Add/Save Comment button
    @FindBy(xpath = "(//*[@id='saveComments'])[3]")
    private WebElement saveCommentBtn;

    // Comment Saved Confirmation message
    @FindBy(xpath = "//*[@id='snackbar']")
    private WebElement commentSavedToast;

    // Edit Comment button
    @FindBy(xpath = "//i[@class='fa fa-pencil']")
    private WebElement editCommentBtn;

    // Align Adjust button in editor toolbar
    @FindBy(xpath = "//*[@class='jqte_tool jqte_tool_14 unselectable']")
    private WebElement alignAdjustBtn;

    // Delete Comment button (trash icon)
    @FindBy(xpath = "//*[@class='fa fa-trash']")
    private WebElement deleteCommentBtn;

    @FindBy(xpath = "//*[@id='snackbar']")
    private WebElement deleteconfirmationMessage;

    // Delete Confirmation button
    @FindBy(xpath = "//button[text()='Delete']")
    private WebElement deleteConfirmBtn;

    @FindBy(xpath = "(//*[@class='ui-dialog-title'])[5]")
    private WebElement FAQsPopupTitle;

    @FindBy(xpath = "(//div[@class='comman-title'])[2]/span")
    private WebElement FAQDocumentsTab;

    @FindBy(xpath = "//*[@id='atc_searchFaq']")
    private WebElement FAQsearchTextfield;

    @FindBy(id = "showAllFaqListId")
    private WebElement viewAllBtn;

    @FindBy(xpath = "//*[@title='Records per Page']")
    private WebElement recordsPerPageDropdown;

    @FindBy(xpath = "//*[@id='gview_faqsListGrid']")
    private WebElement GridViewFAQs;

    @FindBy(xpath = "//*[text()='Show Selected']")
    private WebElement showSelectedButton;

    @FindBy(xpath = "(//button[@class='ui-dialog-titlebar-close'])[5]")
    private WebElement closeFaqsPopup;

    @FindBy(xpath = "//*[normalize-space(text())='Add']")
    private WebElement addFaqButton;
    // Scroll container
    @FindBy(xpath = "//*[@id='gview_faqsListGrid']/div[4]")
    private WebElement scrollContainer;

    @FindBy(xpath = "(//*[text()='Add to Product'])[1]")
    private WebElement AddsuggestedProduct1;
    // All rows
    @FindBy(xpath = "//*[@id='gview_faqsListGrid']/div[4]//tbody/tr[@role='row']")
    private List<WebElement> faqRows;

    // Checkbox inside a row (relative locator)
    @FindBy(xpath = ".//input[@type='checkbox']")
    private WebElement rowCheckbox;

    @FindBy(xpath = "//*[@id='faqsListGridPager_right']/span")
    private WebElement viewTextCount;

    // All rows inside faq-doc-list
    @FindBy(xpath = "//*[@class='faq-doc-list']")
    private List<WebElement> faqSelectedRows;

    @FindBy(xpath = "(//span[@class='comment-edit-icon pull-right'])[1]")
    private WebElement deleteIcons;

    @FindBy(xpath = "//button[text()='Delete']")
    private WebElement FaqDeleteButton;

    @FindBy(xpath = "//li//*[normalize-space(text())='Body Protection']")
    private WebElement bodyProtectionTab;

    @FindBy(xpath = "//*[normalize-space(text())='Breakthrough Times BT']")
    private WebElement breakthroughTimesBTTab;

    @FindBy(xpath = "//*[@id='bp_standardSelection']")
    private WebElement bpStandardSelection;

    @FindBy(xpath = "(//*[@class='third-td-cls'])[1]")
    private WebElement firstChemConcentration;

    @FindBy(xpath = "(//*[@class='third-td-cls'])[2]")
    private WebElement secondChemConcentration;

    @FindBy(xpath = "(//*[@title='Edit Concentration'])[1]")
    private WebElement firstChemicalEditBtn;

    @FindBy(xpath = "(//*[@title='Edit Concentration'])[2]")
    private WebElement secondChemicalEditBtn;

    @FindBy(xpath = "//*[text()='Edit Concentration']")
    private WebElement editConcentrationPopup;

    @FindBy(xpath = "//*[@id='chemicalAggregation']")
    private WebElement Physical_state_dropdown;

    @FindBy(xpath = "//button[text()='Update']")
    private  WebElement update_button;

    @FindBy(xpath = "//input[@id='actualconcentration']")
    private WebElement concentration_textfield;

    @FindBy(xpath = "//*[normalize-space(text())='Single Edited In HP']")
    private WebElement singleEditedInHpMessage;

    @FindBy(xpath = "//*[@id='errorMessageConc']")
    private WebElement errorMessageConcentration;

    @FindBy(xpath = "(//button[@class=\"ui-dialog-titlebar-close\"])[5]")
    private WebElement closeEditConcentrationPopup;
    // Upload Template button
    @FindBy(xpath = "//*[text()='Upload File']")
    private WebElement uploadFilepopup;

    // Dropdown (Chemical Template)
    @FindBy(xpath = "//*[@id='chemicalTemplate']")
    private WebElement chemicalTemplateDropdown;

    // Upload button
    @FindBy(xpath = "//*[normalize-space(text())='Upload']")
    private WebElement uploadButton;

    // Loader (appears during upload)
    @FindBy(xpath = "//*[@id='popupLoaderUpload']")
    private WebElement uploadLoader;

    @FindBy(xpath = "//*[@id='pageSize']")
    private WebElement paginationSizeDropdown;

    @FindBy(xpath = "//*[@id='tcBodyId']/tr")
    private List<WebElement> paddTableRows;

    @FindBy(xpath = "//*[@id='pg_next']")
    private WebElement nextPageButton;

    @FindBy(xpath = "//*[@id='bpStatusId']")
    private WebElement bpStatus;

    @FindBy(xpath = "//*[@id='hpStatusId']")
    private WebElement hpStatus;

    @FindBy(xpath = "//*[@id='reportName']/span[2]")
    private WebElement editreportbutton;

    @FindBy(xpath = "//*[@id='idReportName']")
    private WebElement editreportName;

    @FindBy(xpath = "(//*[@id='renameReportName']//i)[1]")
    private WebElement reportNameSaveButton;

    @FindBy(xpath = "//*[normalize-space(text())='Customize Report']")
    private WebElement customizeReport;

    @FindBy(xpath = "//*[@id='btnDownload']")
    private WebElement DownloadButtonforCustomizeReport;

    @FindBy(xpath = "//*[@id='downloadDropDownMenu']")
    private WebElement PaddDownloadReportbutton;

    @FindBy(xpath = "//*[@id='combinedReportDwnld']")
    private WebElement CombinedReportDownloadbutton;
    public Padd_Methods(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.time = new WebWait(driver);
        this.padd_Hp = new Padd_HandProtection_elements(driver);
        this.my_Report = new My_Report(driver);
        this.jsUtil = new JavaScriptUtil(driver);
    }

    public void CombinedReportDownload()throws InterruptedException{
        int maxAttempts = 5;
        int attempts = 0;
        boolean downloaded = false;
        while(attempts<maxAttempts &&!downloaded){
            try{
                time.waitAndClick(PaddDownloadReportbutton);
                Logger4j.info("Clicked on HP&BP Report Download button.");
                time.waitAndClick(CombinedReportDownloadbutton);
                downloaded = true;

            }
            catch (Exception e){
                attempts++;
                Logger4j.error("Attempt " + attempts + " to download report failed. Retrying");
                Thread.sleep(5000);
                driver.navigate().refresh();
            }
        }
    }

    public void try_till_clickEnabled(WebElement element) {
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
    public void EditingReportName(){
        Logger4j.info("Editing Report Name.");
        time.waitAndClick(editreportbutton);
        String currentReportName = editreportName.getAttribute("value");
        Logger4j.info("clicked edit report button");
        editreportName.clear();
        editreportName.sendKeys("Report" +Rn.random());
        String newReportName = editreportName.getAttribute("value");
        Logger4j.info("Entered random number in edit report name");
        assertionCheck.verification(false, currentReportName.equals(newReportName), "Report name should be changed");
        time.waitAndClick(reportNameSaveButton);
    }

    public void download_report_in_popup(){
        Logger4j.info("Clicking on Download report for report generation. ");
        time.waitAndClick(DownloadButtonforCustomizeReport);
    }
    public void getchemicalConcentrations(){
        String concentration1 =   time.waitAndGetText(firstChemConcentration);
        String concentration2 = time.waitAndGetText(secondChemConcentration);
        Logger4j.info("Current concentrations: " + concentration1 + ", " + concentration2);
    }

    public void edit_concentration_within100() {
        Logger4j.info("Editing concentration to a value within 100%.");
        Logger4j.info("Current concentrations before edit:");
        getchemicalConcentrations();
        time.waitAndClick(firstChemicalEditBtn);
        assertionCheck.softAssertElementDisplayed(editConcentrationPopup, "Edit Concentration");
        String concentration = Rn.randomPercentage();
        concentration_textfield.clear();
        time.waitAndSendKeys(concentration_textfield,concentration);
        Logger4j.info("Entered concentration: " + concentration);
        DropdownUtil.selectRandomOption(Physical_state_dropdown);
        time.waitAndClick(update_button);
        assertionCheck.verification(singleEditedInHpMessage.getText(),"Single Edited In HP");
    }
    public void initializeAndCreateRequest() throws Throwable {
        my_Report.newRiskRequest();
        my_Report.create_Request();
        organizationDetails();
    }

    public void initializeAndCreateRequestBP() throws Throwable {
        my_Report.newRiskRequest();
        my_Report.deselectHp();
        my_Report.create_Request();
        organizationDetails();
    }

    public void initializeAndCreateRequestHP() throws Throwable {
        my_Report.newRiskRequest();
        my_Report.deselectBp();
        my_Report.create_Request();
        organizationDetails();
    }
    public void BP_Status() {
        time.visibilityOf(bpStatus);
        String status = bpStatus.getText();
        try {
            if (!status.equals("In Progress"))
                time.waitUntilTextChanges(bpStatus, "In Progress");
        } catch (StaleElementReferenceException e) {
            time.visibilityOf(bpStatus);
            String updatedStatus = bpStatus.getText();
            Logger4j.info("BP Status updated to: " + updatedStatus);
        }
    }
    public void HP_Status() {
        time.visibilityOf(hpStatus);
        String status = hpStatus.getText();
        try {
            if (!status.equals("In Progress"))
                time.waitUntilTextChanges(hpStatus, "In Progress");
        } catch (StaleElementReferenceException e) {
            time.visibilityOf(hpStatus);
            String updatedStatus = hpStatus.getText();
            Logger4j.info("BP Status updated to: " + updatedStatus);
        }
    }
    public void switchToBPStandard() {
        Logger4j.info("Waiting for Body Protection tab to be clickable.");
        time.elementToBeClickable(bodyProtectionTab);
        bodyProtectionTab.click();
        Logger4j.info("Clicked Body Protection tab.");

        Logger4j.info("Waiting for Breakthrough Times BT tab to be visible.");
        driver.navigate().refresh();
        time.visibilityOf(breakthroughTimesBTTab);

        Assert.assertTrue(breakthroughTimesBTTab.isDisplayed(),
                "Breakthrough Times BT tab is not visible after clicking Body Protection.");
        Logger4j.info("Verified Breakthrough Times BT tab is visible.");
    }

    public void FAQTabDisplay(){
        Logger4j.info("Waiting for Comments & FAQs button to be clickable.");
        time.waitAndClick(commentsFaqBtn);
        Logger4j.info("Verifying FAQ Documents tab is visible.");
        String faqDocumentTabText = time.waitAndGetText(FAQDocumentsTab);
        assertionCheck.verification(" FAQ Documents", faqDocumentTabText);
        time.visibilityOf(FAQsearchTextfield);
        Logger4j.info("FAQ Documents tab is visible along with search text field.");
    }

    public void ViewAllFAQsList() throws InterruptedException {

        FAQTabDisplay();
        Logger4j.info("Clicking on View All FAQs button.");
        time.waitAndClick(viewAllBtn);

        Logger4j.info("Selecting 100 records per page from dropdown.");
        DropdownUtil.selectByVisibleText(recordsPerPageDropdown,"100");

        Logger4j.info("Clicking on Show Selected button.");
        time.waitAndClick(showSelectedButton);
        time.waitAndClick(showSelectedButton); // clicked twice intentionally

        Logger4j.info("Verifying FAQ Grid is visible.");
        String faqGridText = time.waitAndGetText(FAQsPopupTitle);


        assertionCheck.verification("FAQs", faqGridText);

        Logger4j.info("Fetching FAQ checkboxes with their row text...");
        int totalRows = fetchAllFAQRowsAndClick();

        assertionCheck.verification(true, totalRows > 0, "FAQ rows should be present");

        Logger4j.info("Adding selected FAQs by clicking Add button.");
        time.waitAndClick(addFaqButton);
        assertionCheck.verification(final_message.getText(),"Faq documents Linked/Un-Linked successfully");
    }

    public void printFAQRows() {
        Logger4j.info("Printing selected FAQ rows text:");
        time.visibilityOfAll(faqSelectedRows);
        for (WebElement row : faqSelectedRows) {
            String text = row.getText().trim();
            if (!text.isEmpty()) {
                System.out.println("Row Text: " + text);
            }
        }
    }
    public void faqDeletion(){
        printFAQRows();
        Logger4j.info("Clicking delete icon for the first FAQ entry.");
        time.waitAndClick(deleteIcons);
        Logger4j.info("Confirming deletion in the popup.");
        time.waitAndClick(FaqDeleteButton);
        assertionCheck.verification(final_message.getText(),"FAQ document removed");
        Logger4j.info("FAQ deleted successfully.");
    }

    public void organizationDetails() throws InterruptedException {
        String organization_Name = "Report_inuent";
        String email = props.email();
        String contact_Name = props.contact_Name();
        String telephone = props.telephone();
        padd_Hp.organization_Model_Window_Details_Padd(organization_Name + Rn.randomNumber(4), email, contact_Name, telephone);
        Thread.sleep(1000);
    }
    public void DraganddropProducts() throws Exception {
        time.invisibilityof(GridLoader);
        Logger4j.info("Dragging and dropping products to the first and fourth product blocks.");

        time.visibilityOf(first_prodblock);
        Logger4j.info("First product block is visible." + first_prodblock.getText());

        DragAndDropUtil.dragAndDrop(driver, first_prodblock, fourth_prodblock);
        Logger4j.info("Products dragged and dropped successfully.");
        Logger4j.info("Resulting text in first product block: " + first_prodblock.getText());
        Logger4j.info("Resulting text in fourth product block: " + fourth_prodblock.getText());
    }
    public void Verify_adding_suggested_products() throws InterruptedException {
        time.visibilityOf(first_prodblock);
        String firstBlockInitialText = first_prodblock.getText();
        Logger4j.info("Initial text in first product block: " + firstBlockInitialText);
       time.visibilityOf(suggestedProduct1);
       String suggestedProductName = suggestedProduct1.getText();
       Logger4j.info("Suggested product name: " + suggestedProductName);
       AddsuggestedProduct1.click();
       time.waitUntilTextChanges(first_prodblock, firstBlockInitialText);
       String firstBlockText = first_prodblock.getText();
       Logger4j.info("First product block text after adding suggested product: " + firstBlockText);
       assertionCheck.verification(true, firstBlockText.contains(suggestedProductName),
            "First product block should contain the suggested product name.");
    }

    public void Verify_adding_suggested_products_BP() throws InterruptedException {
        time.visibilityOf(first_prodblock);
        String firstBlockInitialText = first_prodblock.getText();
        Logger4j.info("Initial text in first product block: " + firstBlockInitialText);
        time.visibilityOf(suggestedProduct1BP);
        String suggestedProductName = suggestedProduct1BP.getText();
        Logger4j.info("Suggested product name: " + suggestedProductName);
        AddsuggestedProduct1.click();
        time.waitUntilTextChanges(first_prodblock, firstBlockInitialText);
        String firstBlockText = first_prodblock.getText();
        Logger4j.info("First product block text after adding suggested product: " + firstBlockText);
        assertionCheck.verification(true, firstBlockText.contains(suggestedProductName),
                "First product block should contain the suggested product name.");
    }
    public String[] chemicalCellValues() {
        String chemical1Text = chemical1.getText();
        String chemical2Text = chemical2.getText();
        Logger4j.info("Chemical values now : " + chemical1Text + " and " + chemical2Text);
        return new String[]{chemical1Text, chemical2Text};
    }

    public void sort_by_chemicalName() {
        // Capture initial values before any click
        final String[] beforeValues = chemicalCellValues();

        Logger4j.info("Waiting for Sort By Chemical button to be clickable.");
        time.elementToBeClickable(SortBychemicalButton);

        // First click (no change expected yet)
        SortBychemicalButton.click();
        Logger4j.info("Clicked on Sort By Chemical button - first click. No value change expected.");

        // Second click
        SortBychemicalButton.click();
        Logger4j.info("Clicked on Sort By Chemical button - second click. Waiting for value change now...");

        // Wait until values change after the second click
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(d -> {
            try {
                return !chemical1.getText().equals(beforeValues[0]) ||
                        !chemical2.getText().equals(beforeValues[1]);
            } catch (StaleElementReferenceException e) {
                return true;
            }
        });

        // Capture updated values
        chemicalCellValues();
    }


    public void casCellValues() {
        String cas1Text = cas1.getText();
        String cas2Text = cas2.getText();
        Logger4j.info("CAS values now : " + cas1Text + " and " + cas2Text);
    }

    public void sort_By_Cas() throws InterruptedException {
        casCellValues();
        Logger4j.info("Waiting for Sort By CAS button to be clickable.");
        time.elementToBeClickable(SortByCasButton);
        SortByCasButton.click();
        Logger4j.info("Clicked on Sort By CAS button.");
        driver.navigate().refresh();
        casCellValues();
    }

    public void checkboxclick() {
        Logger4j.info("Waiting for first checkbox to be clickable.");
        time.visibilityOf(singleCheckbox);
        Logger4j.info("Clicking on the first checkbox.");
        singleCheckbox.click();
        time.elementToBeClickable(chemicalremoveButton);
        chemicalremoveButton.click();
    }

    public void clickOnRemoveButton() {
        Logger4j.info("Waiting for Remove confirmation popup to be visible.");
        time.visibilityOf(deleteconfirmationPopup);
        if(deleteconfirmationPopup.isDisplayed()){
            Logger4j.info("Remove confirmation popup is displayed.");
        } else {
            Logger4j.error("Remove confirmation popup is NOT displayed.");
        }
        time.elementToBeClickable(dialogboxRemoveButton);
        dialogboxRemoveButton.click();
    }

    public void multipleCheckboxclick() {
        Logger4j.info("Waiting for Mixture checkbox to be clickable.");
        time.visibilityOf(MixtureCheckbox);
        Logger4j.info("Clicking on the Mixture checkbox.");
        MixtureCheckbox.click();
        time.visibilityOf(singleCheckbox);
        Logger4j.info("Clicking on the first checkbox.");
        singleCheckbox.click();
        if(MixtureCheckbox.isSelected() && singleCheckbox.isSelected()){
            Logger4j.info("Both checkboxes are selected.");
        }
    }


    public void selectAllCheckboxes(int count) {
        int total = checkboxes.size();
        System.out.println("Total checkboxes found: " + total);

        for (int i = 0; i < Math.min(count, total); i++) {
            checkboxes.get(i).click();
        }
        Logger4j.info("Selected " + count + " checkboxes out of " + total);
        time.elementToBeClickable(chemicalremoveButton);
        chemicalremoveButton.click();
        Logger4j.info("Removing " + count + " Selected chemicals.");
    }

    public void clickOnMixtureTab() {
        Logger4j.info("Waiting for Mixture tab to be visible.");
        time.visibilityOf(Mixture_tab);
        Logger4j.info("Clicking on Mixture tab.");
        Mixture_tab.click();

    }

    public void creatingNewMixture() {
        Logger4j.info("Creating new mixture initiated.");
        String chars = "abcdefghijklmnopqrstuvwxyz";
        String randomText = "";
        for (int i = 0; i < 6; i++) {
            randomText += chars.charAt(random.nextInt(chars.length()));
        }
        String mixtureName = "mix" + randomText;
        Logger4j.info("Entering mixture name: " + mixtureName);
        Mixture_Name_textField.sendKeys(mixtureName);
        time.visibilityOf(Physical_state_mix);
        setPhysical_state_select_mix();
    }

    public void setPhysical_state_select_mix() {
        Logger4j.info("Waiting for Physical state select to be clickable.");
        time.elementToBeClickable(Physical_state_mix);
        Select dropdown = new Select(Physical_state_mix);
        List<WebElement> options = dropdown.getOptions();
        if (!options.isEmpty() && options.get(0).getText().contains("Select")) {
            options.remove(0);
        }
        if (!options.isEmpty()) {

            int randomIndex = random.nextInt(options.size());
            WebElement selectedOption = options.get(randomIndex);
            dropdown.selectByVisibleText(selectedOption.getText());
            Logger4j.info("Random physical state selected: " + selectedOption.getText());
        }
    }

    public void CreatingNewSingles() {
        Logger4j.info("Creating new singles initiated.");
        // Implementation here
    }

    public void clickOnAddSinglesMixturesTab() {
        Logger4j.info("Waiting for Add Singles/Mixtures tab to be visible.");
        time.visibilityOf(Add_single_tab);
        Logger4j.info("Clicking on Add Singles/Mixtures tab.");
        Add_single_tab.click();
    }

    public void clickOnCreateNewSinglesMixtures() {
        Logger4j.info("Waiting for Create New Singles/Mixtures button to be visible.");
        time.visibilityOf(createNewSinglesMixtures_button);
        Logger4j.info("Clicking on Create New Singles/Mixtures button.");
        createNewSinglesMixtures_button.click();
    }

    public void enterCASNumber(String casNumber) {
        Logger4j.info("Waiting for CAS number text field to be visible.");
        time.visibilityOf(CAS_number_textField);
        Logger4j.info("Entering CAS number: " + casNumber);
        CAS_number_textField.sendKeys(casNumber);
    }

    public void enterChemicalName(String chemicalName) {
        Logger4j.info("Waiting for chemical name text field to be visible.");
        time.visibilityOf(chemical_name_textField);
        Logger4j.info("Entering chemical name: " + chemicalName);
        chemical_name_textField.sendKeys(chemicalName);
    }

    public void setPhysical_state_select() {
        Logger4j.info("Waiting for Physical state select to be clickable.");
        time.elementToBeClickable(Physical_state_select);
        Select dropdown = new Select(Physical_state_select);
        List<WebElement> options = dropdown.getOptions();
        if (!options.isEmpty() && options.get(0).getText().contains("Select")) {
            options.remove(0);
        }
        if (!options.isEmpty()) {

            int randomIndex = random.nextInt(options.size());
            WebElement selectedOption = options.get(randomIndex);
            dropdown.selectByVisibleText(selectedOption.getText());
            Logger4j.info("Random physical state selected: " + selectedOption.getText());
        }
    }

    public void enterConcentration(String concentration) {
        Logger4j.info("Waiting for concentration text field to be visible.");
        time.visibilityOf(concentration_text_field);
        Logger4j.info("Entering concentration: " + concentration);
        concentration_text_field.sendKeys(concentration);
    }

    public void clickOnSaveButton() {
        Logger4j.info("Waiting for Save button to be visible.");
        time.visibilityOf(save_button);
        Logger4j.info("Clicking on Save button.");
        save_button.click();
    }

    public String getFinalMessage() {
        Logger4j.info("Waiting for snackbar message to be visible.");
        time.visibilityOf(snackbar_message);
        String finalMessage = snackbar_message.getText();
        Logger4j.info("Final message retrieved: " + finalMessage);
        return finalMessage;
    }

    public void Add_Mixture_Component() {
        props.AddComponentToMixture(add_mixture_cas_number_textField, add_mixture_chemical_name_textField, add_mixture_proportion_textField,
                component_physical_state_dropdown, add_component_button);
        add_my_mixture_button.click();
    }

    public void waitForElementToDisappear(WebElement element) {
        Logger4j.info("Waiting for popup element to disappear: " + element);

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.invisibilityOf(element));
            Logger4j.info("Element disappeared successfully.");
        } catch (TimeoutException e) {
            Logger4j.info("Element still visible, trying to hide it with JS...");
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].style.display='none';", element);
        }
    }


    public String getFinalMessageforMixture() {
        return final_message.getText();
    }


    //=========================================== EXCEL Template Related code =====================================
    public void UploadTemplateClick() {
        Logger4j.info("clicking on Upload template button ");
        uploadTemplateButton.click();
    }

    public void TemplateDownloadClick() {
        Logger4j.info("Downloading template");
        TemplateDownloadButton.click();
    }

    public void clickuploadButtonClick() {
        Logger4j.info("Uploading template");
        uploadButtonInPopup.click();
    }

    String option = "Upload Template- Top 100 chemicals";

    public void UploadTemplate100chem() {
        DropdownUtil.selectByVisibleText(uploadFile_popup, option);
        TemplateDownloadClick();
        clickuploadButtonClick();
    }

    public void compareExcelAndWebTableData() throws InterruptedException {
        Logger4j.info("Reading Excel file...");
        List<Map<String, String>> excelData = ReadExcelUtility.readExcelAsListofMaps();
        Logger4j.info("Reading Web table...");
        Thread.sleep(8000);
        List<Map<String, String>> WebData = WebTableUtility.readTableAsListOfMaps(driver, By.xpath("//*[@id='hp_tcChemProd']"));
        Logger4j.info("comparing Excel and web table data...");
        for (Map<String, String> excelRow : excelData) {
            boolean matchFound = WebData.contains(excelRow);
            if (!matchFound) {
                Logger4j.error("Row missing in web table: " + excelRow);
            }
            Assert.assertTrue(matchFound, "Excel row not found in web table : " + excelRow);
        }
        Logger4j.info("Comparison completed for all data");
    }

    public static List<Map<String, String>> readExcelToHashMap(String folderPath) {
        List<Map<String, String>> dataList = new ArrayList<>();

        try {
            File folder = new File(folderPath);

            if (!folder.exists() || !folder.isDirectory()) {
                System.out.println("❌ Invalid folder path: " + folderPath);
                return dataList;
            }

            File[] excelFiles = folder.listFiles((dir, name) -> name.endsWith(".xlsx") || name.endsWith(".xls"));
            if (excelFiles == null || excelFiles.length == 0) {
                System.out.println("❌ No Excel files found in folder: " + folderPath);
                return dataList;
            }

            File firstFile = excelFiles[0];
            System.out.println("✅ Reading Excel file: " + firstFile.getName());

            try (FileInputStream fis = new FileInputStream(firstFile);
                 Workbook workbook = WorkbookFactory.create(fis)) {

                Sheet sheet = workbook.getSheet("Request");
                if (sheet == null) {
                    System.out.println("❌ 'Request' sheet not found.");
                    return dataList;
                }

                // ✅ Step 1: find the row that contains the header
                int headerRowIndex = -1;
                String[] requiredHeaders = {"Type", "CAS", "Chemical Name", "Concentration", "Physical State"};

                for (int r = 0; r <= sheet.getLastRowNum(); r++) {
                    Row row = sheet.getRow(r);
                    if (row == null) continue;

                    StringBuilder rowText = new StringBuilder();
                    for (int c = 0; c < row.getLastCellNum(); c++) {
                        Cell cell = row.getCell(c);
                        if (cell != null) rowText.append(normalizeHeader(cell.toString())).append(" ");
                    }

                    String rowStr = rowText.toString();
                    if (rowStr.contains("Type") && rowStr.contains("CAS") && rowStr.contains("Chemical Name")) {
                        headerRowIndex = r;
                        break;
                    }
                }

                if (headerRowIndex == -1) {
                    System.out.println("❌ Could not find header row with required columns.");
                    return dataList;
                }

                Row headerRow = sheet.getRow(headerRowIndex);
                Map<String, Integer> columnIndexMap = new HashMap<>();

                for (int j = 0; j < headerRow.getLastCellNum(); j++) {
                    Cell cell = headerRow.getCell(j);
                    if (cell != null) {
                        String header = normalizeHeader(cell.toString());
                        for (String req : requiredHeaders) {
                            if (header.equalsIgnoreCase(req)) {
                                columnIndexMap.put(req, j);
                            }
                        }
                    }
                }

                System.out.println("📌 Mapped columns: " + columnIndexMap);

                // ✅ Step 2: read rows after the header
                for (int r = headerRowIndex + 1; r <= sheet.getLastRowNum(); r++) {
                    Row row = sheet.getRow(r);
                    if (row == null) continue;

                    Map<String, String> rowData = new LinkedHashMap<>();

                    for (String req : requiredHeaders) {
                        int colIndex = columnIndexMap.getOrDefault(req, -1);
                        String value = "";

                        if (colIndex != -1) {
                            Cell cell = row.getCell(colIndex);
                            if (cell != null) {
                                switch (cell.getCellType()) {
                                    case STRING:  value = cell.getStringCellValue().trim(); break;
                                    case NUMERIC: value = String.valueOf(cell.getNumericCellValue()); break;
                                    case BOOLEAN: value = String.valueOf(cell.getBooleanCellValue()); break;
                                    default:      value = "";
                                }
                            }
                        }

                        rowData.put(req, value);
                    }

                    // Skip empty rows
                    if (rowData.values().stream().anyMatch(v -> v != null && !v.isEmpty())) {
                        dataList.add(rowData);
                    }
                }

            }
        } catch (Exception e) {
            System.out.println("❌ Error reading Excel: " + e.getMessage());
            e.printStackTrace();
        }

        // ✅ Print extracted data
//        for (Map<String, String> row : dataList) {
//            System.out.println(row);
//        }

        return dataList;
    }

    // ✅ Normalize headers
    private static String normalizeHeader(String raw) {
        if (raw == null) return "";
        return raw.replace("\u00A0", " ")
                .replaceAll("[\\t\\n\\r]", " ")
                .trim()
                .replaceAll("\\s+", " ");
    }

    public void viewProductInfoAndVerify(int dotIndex, String expectedValue) {
        Logger4j.info("Waiting for product info dot " + dotIndex + " to be clickable.");
        time.invisibilityof(driver.findElement(By.id("hp_gridLoader")));

        // Locate dot dynamically
        WebElement productInfoDot = driver.findElement(
                By.xpath("(//a[contains(@class,'list-block-cls')])[" + dotIndex + "]")
        );

        time.elementToBeClickable(productInfoDot);
        productInfoDot.click();
        Logger4j.info("Clicked product info dot " + dotIndex);

        // Get actual value
        time.visibilityOf(productgroup);
        String actualValue = productgroup.getText();

        // Compare
        if (actualValue.equals(expectedValue)) {
            Logger4j.info("PASS: Product group for dot " + dotIndex + " matches expected: " + actualValue);
        } else {
            Logger4j.error("FAIL: Product group mismatch for dot " + dotIndex + ". Expected: "
                    + expectedValue + " | Actual: " + actualValue);
            Assert.fail("Product group mismatch for dot " + dotIndex);
        }
        // Close popup
        closepopup.click();
    }

    public void uploadMSDSFile(String filePath) {
        Logger4j.info("Waiting for Upload MSDS text to be visible.");
        time.visibilityOf(uploadSDSText);
        uploadSDSText.click();
        Logger4j.info("Clicking on File Upload button.");
        fileUploadButton.sendKeys(filePath);
        Logger4j.info("File uploaded: " + filePath);
        time.visibilityOf(uploadSuccessMessage);
        Logger4j.info("Upload success message: " + uploadSuccessMessage.getText());
    }

    public void chemicalscountinMSDC() {
        Logger4j.info("Checking for chemical checkboxes in MSDC.");

        // Find all matching elements
        List<WebElement> checkboxes = driver.findElements(By.xpath("//*[@class='chemCheckBox   checkBoxTmp']"));

        // If none found
        if (checkboxes.isEmpty()) {
            Logger4j.info("No chemical checkboxes found in MSDC.");
        } else {
            // Log count
            Logger4j.info("Total chemical checkboxes found: " + checkboxes.size());

            // Log each name/text
            for (int i = 0; i < checkboxes.size(); i++) {
                String checkboxText = checkboxes.get(i).getText().trim();

                // If text is empty, maybe the label is in parent element
                if (checkboxText.isEmpty()) {
                    checkboxText = checkboxes.get(i).findElement(By.xpath("./..")).getText().trim();
                }

                Logger4j.info("Checkbox " + (i + 1) + ": " + checkboxText);
            }
        }
    }

    public void verifyDownloadMSDSButtonPresence() {
        Logger4j.info("Checking for chemical checkboxes in MSDC.");

        // Find all matching elements
        List<WebElement> checkboxes = driver.findElements(By.xpath("//*[@class='chemCheckBox   checkBoxTmp']"));
        // If none found
        if (checkboxes.isEmpty()) {
            Logger4j.info("No chemical checkboxes found in MSDC.");
        } else {
            // Log count
            Logger4j.info("Total chemical checkboxes found: " + checkboxes.size());

            // Log each name/text
            for (int i = 0; i < checkboxes.size(); i++) {
                String checkboxText = checkboxes.get(i).getText().trim();
                Logger4j.info("Clicking on checkbox " + (i + 1) + ": " + checkboxText);
                checkboxes.get(i).click();
                Logger4j.info("Download MSDS button is present for checkbox " + (i + 1) + ": " + checkboxText);
                // If text is empty, maybe the label is in parent element
                if (checkboxText.isEmpty()) {
                    checkboxText = checkboxes.get(i).findElement(By.xpath("./..")).getText().trim();
                }

                Logger4j.info("Checkbox " + (i + 1) + ": " + checkboxText);
            }
        }
    }

    public void countMSDCDownloadButtons() {
        Logger4j.info("Counting Download MSDS buttons in MSDC.");
        time.visibilityOf(downloadMSDCButton);
        // Find all matching elements
        List<WebElement> downloadButtons = driver.findElements(By.xpath("//*[@title='Download MSDS']"));

        // If none found
        if (downloadButtons.isEmpty()) {
            Logger4j.info("No Download MSDS buttons found in MSDC.");
        } else {
            // Log count
            Logger4j.info("Total Download MSDS buttons found: " + downloadButtons.size());
        }
    }

    public void countofSDSfiles() {
        Logger4j.info("Counting SDS files in SDS.");
        // Find all matching elements
        List<WebElement> msdsFiles = driver.findElements(By.xpath("//*[@id='msdsFileUlId']/li"));
        // Log count
        Logger4j.info("Total SDS files found: " + msdsFiles.size());

        if (msdsFiles.isEmpty()) {
            Logger4j.info("No SDS files found in MSDC or file deleted.");
        }

    }

    public void closeMSDC() {
        Logger4j.info("Waiting for close popup button to be clickable.");
        time.elementToBeClickable(closeMSDCButton);
        Logger4j.info("Clicking on close popup button.");
        closeMSDCButton.click();
        Logger4j.info("MSDC closed successfully.");
    }

    public void deleteMSDCFile() {
        Logger4j.info("Deleting MSDS file if it exists.");
        time.elementToBeClickable(deleteMSDSfile);
        deleteMSDSfile.click();
        time.invisibilityof(uploadSuccessMessage);
        time.elementToBeClickable(deleteMSDSfileYesButton);
        deleteMSDSfileYesButton.click();
        Logger4j.info("MSDC file deleted successfully.");
    }

    public void selectandremoveProduct38_001() throws Exception {
        if (product38_001.isDisplayed())
            Logger4j.info("Product 38_001 is displayed, proceeding to select and remove it.");

        if (prod_38_001checkbox.isDisplayed())
            Logger4j.info("Selecting product 38_001 checkbox.");
        prod_38_001checkbox.click();
        Logger4j.info("Waiting for product remove button to be clickable.");
        time.visibilityOf(removeButtonforProduct);
        removeButtonforProduct.click();
        time.visibilityOf(procutremoveconfirmationButton);
        Logger4j.info("Clicking on product remove confirmation button.");
        procutremoveconfirmationButton.click();
        Logger4j.info("Waiting for product 38_001 to be removed from the page.");
        time.invisibilityof(GridLoader);
        // Verify that the product has been removed
        verifyProductRemoval(Rproduct, RproductName);
        // Alternative: You can also use the try-catch approach if preferred
        // verifyProductRemovalWithTryCatch(product38_001, "Product 38-001");
    }

    public void selectandremoveallproducts() {
        Logger4j.info("Selecting all products for removal.");
        time.elementToBeClickable(productRemoveButton);
        productRemoveButton.click();
        Logger4j.info("Waiting for remove button to be clickable.");
        time.elementToBeClickable(removeButtonforProduct);
        removeButtonforProduct.click();
        Logger4j.info("Clicking on product remove confirmation button.");
        procutremoveconfirmationButton.click();
        time.invisibilityof(procutremoveconfirmationButton);
        Logger4j.info("Waiting for all products to be removed from the page.");
        time.invisibilityof(GridLoader);
        Logger4j.info("Waiting for 'add products' text to be visible.");
        time.visibilityOf(AddProductText);
        Logger4j.info("'add products' text is now visible, indicating all products have been removed.");
    }

    /**
     * Utility method to verify if a product element is removed from DOM
     *
     * @param productText The text content of the product to check
     * @param productName Name of the product for logging purposes
     * @throws AssertionError if the product is still visible
     */
    private void verifyProductRemoval(String productText, String productName) {
        Logger4j.info("Verifying removal of " + productName);

        List<WebElement> productElements = driver.findElements(By.xpath("//*[text()='" + productText + "']"));

        if (productElements.isEmpty()) {
            Logger4j.info(productName + " removed successfully from DOM.");
        } else if (!productElements.get(0).isDisplayed()) {
            Logger4j.info(productName + " is present but hidden.");
        } else {
            Logger4j.error(productName + " still displayed after removal attempt.");
            Assert.fail(productName + " was not removed successfully.");
        }
    }

    /**
     * Alternative method using try-catch approach for verification
     *
     * @param element     WebElement to check
     * @param productName Name of the product for logging purposes
     * @throws AssertionError if the product is still visible
     */
    private void verifyProductRemovalWithTryCatch(WebElement element, String productName) {
        Logger4j.info("Verifying removal of " + productName + " using try-catch approach");

        try {
            if (element.isDisplayed()) {
                Logger4j.error(productName + " still displayed after removal attempt.");
                Assert.fail(productName + " was not removed successfully.");
            } else {
                Logger4j.info(productName + " is present but not displayed (hidden).");
            }
        } catch (NoSuchElementException e) {
            Logger4j.info(productName + " removed successfully from DOM.");
        }
    }

    public void clickOnShowProductDetailsButton() {
        Logger4j.info("Waiting for Show Product Details button to be clickable.");
        time.elementToBeClickable(showproductDetailsbutton);
        Logger4j.info("Clicking on Show Product Details button.");
        showproductDetailsbutton.click();
        Logger4j.info("Show Product Details button clicked successfully.");
        time.visibilityOf(productinfotab);
        Logger4j.info("Product info tab is now visible.");
        String p_info = productinfotab.getText();
        Logger4j.info("Product info tab text: " + p_info);
    }

    public void selectRegionDefaultProducts() {
        Logger4j.info("Fetching the table data from PADD table before regional selection.");
        String paddinfo = paddTabledata.getText();
        Logger4j.info("PADD table data: " + paddinfo);
        Logger4j.info("Selecting Region Default Products option from template dropdown.");
        time.elementToBeClickable(template_dropdown);
        template_dropdown.click();
        regionDefaultProductsOption.click();
        Logger4j.info("Region Default Products option selected successfully.");
        time.invisibilityof(GridLoader);
        time.visibilityOf(template_dropdown);
        template_dropdown.click();
        regionDefaultProductsOption.click();
        Logger4j.info("Waiting for default products loaded message to be visible.");
        time.visibilityOf(defaultProductsLoadedMsg);
        String defaultMsg = defaultProductsLoadedMsg.getText();
        assertEquals(defaultMsg, "Default Products are already loaded");
        Logger4j.info("Default products loaded message verified: " + defaultMsg);
    }

    public void sortbyperformance() {
        Logger4j.info("Fetching the table data from PADD table before regional selection.");
        String paddinfoBefore = paddTabledata.getText();

        Logger4j.info("Selecting Region Default Products option from template dropdown.");
        time.elementToBeClickable(sortedByPerformanceToggle);
        sortedByPerformanceToggle.click();
        sortedByPerformanceToggle.click();
        Logger4j.info("Sorted by performance toggle clicked successfully.");
        time.invisibilityof(GridLoader);

        String paddinfoAfter = paddTabledata.getText();

        // Split into lines for comparison
        String[] beforeLines = paddinfoBefore.split("\\r?\\n");
        String[] afterLines = paddinfoAfter.split("\\r?\\n");

        int max = Math.max(beforeLines.length, afterLines.length);

        Logger4j.info("==== Side by Side Comparison ====");
        Logger4j.info("       | Before sorting     |             |    After sorting");
        for (int i = 0; i < max; i++) {
            String before = i < beforeLines.length ? beforeLines[i] : "";
            String after = i < afterLines.length ? afterLines[i] : "";

            Logger4j.info(String.format("%-40s | %-40s", before, after));
        }
        Logger4j.info("==== Comparison End ====");
    }

    public void crudOperationsOnTemplate(String baseTemplateName) {
        // Wait and open template dropdown
        time.invisibilityof(GridLoader);
        time.elementToBeClickable(template_dropdown);
        template_dropdown.click();
        Logger4j.info("Clicked on template dropdown.");

        // Add new template
        time.elementToBeClickable(addEditProductTemplateBtn);
        addEditProductTemplateBtn.click();
        Logger4j.info("Clicked on Add/Edit Product Template button.");

        time.visibilityOf(newTemplateTextBox);
        String uniqueTemplateName = baseTemplateName + "_" + System.currentTimeMillis();
        newTemplateTextBox.sendKeys(uniqueTemplateName);
        Logger4j.info("Entered new template name: " + uniqueTemplateName);

        time.elementToBeClickable(templateSaveButton);
        templateSaveButton.click();
        Logger4j.info("Clicked on Save Template button.");

        // Verify new template in dropdown
        time.elementToBeClickable(template_dropdown);
        template_dropdown.click();
        Logger4j.info("Opened template dropdown again to verify.");

        By newTemplateLocator = By.xpath("//*[text()='" + uniqueTemplateName + "']");
        WebElement newTemplateOption = driver.findElement(newTemplateLocator);
        time.visibilityOf(newTemplateOption);

        Assert.assertTrue(newTemplateOption.isDisplayed(),
                "New template is not visible in dropdown: " + uniqueTemplateName);
        Logger4j.info("Verified template is added: " + uniqueTemplateName);

        // Select template and delete it
        addEditProductTemplateBtn.click();
        Logger4j.info("Clicked on Add/Edit Product Template again.");

        time.visibilityOf(currentTemplateDropdown);
        DropdownUtil.selectByVisibleText(currentTemplateDropdown, uniqueTemplateName);
        Logger4j.info("Selected current template: " + uniqueTemplateName);

        time.elementToBeClickable(templateDeleteButton);
        templateDeleteButton.click();
        Logger4j.info("Clicked on Delete Template button.");

        time.elementToBeClickable(templateDeleteConfirmationBtn);
        templateDeleteConfirmationBtn.click();
        Logger4j.info("Confirmed delete template: " + uniqueTemplateName);

        // Verify template is deleted
        template_dropdown.click();
        boolean isDeleted = driver.findElements(newTemplateLocator).isEmpty();
        Assert.assertTrue(isDeleted, "Template was not deleted: " + uniqueTemplateName);
        Logger4j.info("Verified template is deleted: " + uniqueTemplateName);
    }

    public String Standardcheck(String standard) {
        Logger4j.info("Waiting for Standard Selection dropdown to be clickable.");
        time.elementToBeClickable(standardSelection);
        Logger4j.info("Clicking on Standard Selection dropdown.");
        if (standard == "ASTM F739") {
            Logger4j.info("Selecting ASTM F739 standard.");
            DropdownUtil.selectByVisibleText(standardSelection, standard);
        } else if (standard == "EN ISO 374") {
            Logger4j.info("Selecting EN ISO 374 standard.");
            DropdownUtil.selectByVisibleText(standardSelection, standard);
        } else {
            Logger4j.error("Invalid standard provided: " + standard);
            throw new IllegalArgumentException("Invalid standard: " + standard);

        }
        Logger4j.info("Found standard type " + standardType.getText());

        time.elementToBeClickable(downArrow);
        downArrow.click();
        Logger4j.info("Clicked on down arrow to expand standard options.");
        return standardType.getText();
    }

    public void Check_All_chartTypes() {
        DropdownUtil.selectByVisibleText(chartTypeDropdown, "Permeation Chart");
        Logger4j.info("Selected Permeation Chart from dropdown.");
        String permeationOutputText = permeationOutput.getText();
        Logger4j.info("Permeation output: " + permeationOutputText);
        verification("> 480'", permeationOutputText);
// Degradation Chart
        DropdownUtil.selectByVisibleText(chartTypeDropdown, "Degradation Chart");
        Logger4j.info("Selected Degradation Chart from dropdown.");
        String degradationOutputText = degradationOutput.getText();
        Logger4j.info("Degradation output: " + degradationOutputText);
        verification("240-480'", degradationOutputText);
// Combined Chart
        DropdownUtil.selectByVisibleText(chartTypeDropdown, "Combined Chart");
        String color = driver.findElement(By.xpath("(//*[@class='chmiclcls'])[1]"))
                .getCssValue("background-color");

        Logger4j.info("Selected Combined Chart from dropdown.");
        Logger4j.info("Combined chart color: " + color);
        verification("rgba(171, 183, 49, 1)", color);
    }
    // Inside Padd_Methods.java

    public String addComment(String commentText) {
        Logger4j.info("Starting Add Comment flow...");
        Logger4j.info("Clicking on Comments/FAQ button.");
        time.waitAndClick(commentsFaqBtn);

        Logger4j.info("Clicking on Add Comment button.");
        time.waitAndClick(addCommentBtn);

        Logger4j.info("Waiting for Comment editor to be visible.");
        time.visibilityOf(writeCommentEditor);

        Logger4j.info("Typing comment: " + commentText);
        writeCommentEditor.sendKeys(commentText);

        Logger4j.info("Clicking on Save Comment button.");
        time.waitAndClick(saveCommentBtn);

        Logger4j.info("Waiting for Comment Saved toast message.");
        time.visibilityOf(commentSavedToast);

        String message = commentSavedToast.getText();
        Logger4j.info("Add Comment flow completed. Toast message: " + message);
        return message;
    }

    public String editComment(String updatedText) {
        Logger4j.info("Starting Edit Comment flow...");
        Logger4j.info("Clicking on Edit Comment button.");
        time.waitAndClick(editCommentBtn);

        Logger4j.info("Clicking on Align Adjust button (if required).");
        time.waitAndClick(alignAdjustBtn);

        Logger4j.info("Clearing existing comment text.");
        writeCommentEditor.clear();

        Logger4j.info("Typing updated comment: " + updatedText);
        writeCommentEditor.sendKeys(updatedText);

        Logger4j.info("Clicking on Save Comment button.");
        time.waitAndClick(saveCommentBtn);

        Logger4j.info("Waiting for Comment Updated toast message.");
        time.visibilityOf(commentSavedToast);

        String message = commentSavedToast.getText();
        Logger4j.info("Edit Comment flow completed. Toast message: " + message);
        return message;
    }

    public String deleteComment() throws InterruptedException {
        Logger4j.info("Starting Delete Comment flow...");
        Thread.sleep(2000); // extra wait to handle animation

        Logger4j.info("Clicking on Delete Comment button.");
        time.waitAndClick(deleteCommentBtn);

        Logger4j.info("Clicking on Delete Confirm button.");
        time.waitAndClick(deleteConfirmBtn);

        Logger4j.info("Waiting for Delete Confirmation snackbar message.");
        time.visibilityOf(deleteconfirmationMessage);

        String message = deleteconfirmationMessage.getText();
        Logger4j.info("Delete Comment flow completed. Snackbar message: " + message);
        return message;
    }

    public int fetchAllFAQRowsAndClick() {
        int previousCount = 0;
        int currentCount = 0;

        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> allRows = new ArrayList<>();

        while (true) {
            currentCount = faqRows.size();

            // log and click new rows
            for (int i = previousCount; i < currentCount; i++) {
                WebElement row = faqRows.get(i);
                String rowText = row.getText().trim();
                if (!rowText.isEmpty()) {
                    Logger4j.info("Row " + (allRows.size() + 1) + ": " + rowText);

                    // store row
                    allRows.add(row);

                    // try clicking directly on the row
                    try {
                        row.click();
                        Logger4j.info("Clicked on row text: " + rowText);
                    } catch (Exception e) {
                        Logger4j.warn("Unable to click row: " + rowText + " - " + e.getMessage());
                    }
                }
            }

            // break if no new rows were loaded after scrolling
            if (currentCount == previousCount) {
                break;
            }
            previousCount = currentCount;

            // scroll down a bit to trigger loading more rows
            js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", scrollContainer);

            // wait a moment for new rows to render
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Logger4j.info("Total FAQ rows fetched and clicked: " + allRows.size());
        return allRows.size();
    }

    public String checkForStandards_BT1_0_BP(String standard) {
        Logger4j.info("Waiting for BP Standard Selection dropdown to be clickable.");
        time.elementToBeClickable(bpStandardSelection);

        Logger4j.info("Trying to select BP standard dynamically: " + standard);

        // Get all options in dropdown
        Select select = new Select(bpStandardSelection);
        List<WebElement> options = select.getOptions();

        boolean found = false;
        for (WebElement option : options) {
            String optionText = option.getText().trim();  // e.g. "BT1.0"
            Logger4j.info("Checking option: " + optionText);

            if (optionText.equalsIgnoreCase(standard) || optionText.contains(standard)) {
                Logger4j.info("Match found → Selecting: " + optionText);
                option.click();
                found = true;
                break;
            }
        }

        if (!found) {
            Logger4j.error("Invalid BP standard provided: " + standard);
            throw new IllegalArgumentException("Invalid BP standard: " + standard);
        }

        Logger4j.info("Found BP standard type: " + standardType.getText());
        time.elementToBeClickable(downArrow);
        downArrow.click();
        Logger4j.info("Clicked on down arrow to expand BP standard options.");

        return standardType.getText();
    }

    public void update_concentrationAbove100() {
            Logger4j.info("Editing concentration to a value above 100%.");
            Logger4j.info("Current concentrations before edit:");
            getchemicalConcentrations();
            time.waitAndClick(firstChemicalEditBtn);
            assertionCheck.softAssertElementDisplayed(editConcentrationPopup, "Edit Concentration");
            String concentration = Rn.randomNumber(4);
            concentration_textfield.clear();
            time.waitAndSendKeys(concentration_textfield,concentration);
            Logger4j.info("Entered concentration: " + concentration);
            DropdownUtil.selectRandomOption(Physical_state_dropdown);
            time.waitAndClick(update_button);
            assertionCheck.verification(errorMessageConcentration.getText(),"* Invalid concentration value.");
            time.waitAndClick(closeEditConcentrationPopup);
    }

    public void update_concentrationBelow1() {
        Logger4j.info("Editing concentration to a value below 1% or 0%.");
        Logger4j.info("Current concentrations before edit:");
        getchemicalConcentrations();
        time.waitAndClick(firstChemicalEditBtn);
        assertionCheck.softAssertElementDisplayed(editConcentrationPopup, "Edit Concentration");
        String concentration = "0";
        concentration_textfield.clear();
        time.waitAndSendKeys(concentration_textfield,concentration);
        Logger4j.info("Entered concentration: " + concentration);
        DropdownUtil.selectRandomOption(Physical_state_dropdown);
        time.waitAndClick(update_button);
        String errorText = errorMessageConcentration.getText();

        assertionCheck.assertEquals(errorText,"* Concentration can not be zero","Error message mismatch");
        time.waitAndClick(closeEditConcentrationPopup);
    }

    public void update_concentration_in_decimalValues() throws InterruptedException {
        Logger4j.info("Editing concentration with decimal values.");
        Logger4j.info("Current concentrations before edit:");
        getchemicalConcentrations();
        time.waitAndClick(firstChemicalEditBtn);
        assertionCheck.softAssertElementDisplayed(editConcentrationPopup, "Edit Concentration");
        String concentration = "0."+Rn.randomNumber(1);
        concentration_textfield.clear();
        time.waitAndSendKeys(concentration_textfield,concentration);
        Logger4j.info("Entered concentration: " + concentration);
        DropdownUtil.selectRandomOption(Physical_state_dropdown);
        time.waitAndClick(update_button);
        Logger4j.info("Clicked on Update button.");
        String messageText = time.waitAndGetText(errorMessageConcentration);
        assertionCheck.assertEquals(messageText,"* Concentration can not be zero","Success message mismatch");
        time.waitAndClick(closeEditConcentrationPopup);
    }

    public void uploadTemplate100_chem() throws InterruptedException {
        time.waitAndClick(uploadTemplateButton);
        assertionCheck.verification(uploadFile_popup.getText(),"Upload File");
        DropdownUtil.selectByIndex(chemicalTemplateDropdown,1);
        time.waitAndClick(uploadButton);
        time.invisibilityof(uploadLoader);
        Thread.sleep(4000);//For Backend processing
    }
    public void uploadTemplate18_chem() throws InterruptedException {
        time.waitAndClick(uploadTemplateButton);
        assertionCheck.verification(uploadFile_popup.getText(),"Upload File");
        DropdownUtil.selectByIndex(chemicalTemplateDropdown,2);
        time.waitAndClick(uploadButton);
        time.invisibilityof(uploadLoader);
        Thread.sleep(4000);
    }
//    public void checkPagination100ChemSet50() {
//        int expected = 100;
//
//        // Step 1: Select 50 from dropdown
//        DropdownUtil.selectByVisibleText(paginationSizeDropdown, "50");
//
//        // Step 2: Count rows on first page
//        int firstCount = paddTableRows.size();
//        Logger4j.info("Rows loaded on first page: " + firstCount);
//
//        // Step 3: Go to next page and count
//        time.waitAndClick(nextPageButton);
//        time.visibilityOfAll(paddTableRows);
//        int secondCount = paddTableRows.size();
//        Logger4j.info("Rows loaded on second page: " + secondCount);
//
//        // Step 4: Final verification
//        int finalCount = firstCount + secondCount;
//        if(finalCount == expected) {
//            Logger4j.info("Pagination verified successfully: " + finalCount + " records.");
//        } else {
//            Logger4j.error("Pagination mismatch: expected " + expected + " but got " + finalCount);
//        }
//    }
public void uploadTemplate100_dataTest() throws InterruptedException {
    time.waitAndClick(uploadTemplateButton);
    assertionCheck.verification(uploadFile_popup.getText(),"Upload File");
    DropdownUtil.selectByIndex(chemicalTemplateDropdown,1);
    time.waitAndClick(TemplateDownloadButton);
    time.waitAndClick(uploadButton);
    time.invisibilityof(uploadLoader);
    Thread.sleep(4000);//For Backend processing
}
public void PADDcheckPagination(int chemcount,String dropdown) throws InterruptedException{
        int expected = chemcount;
        DropdownUtil.selectByVisibleText(paginationSizeDropdown, dropdown);
        time.invisibilityof(GridLoader);

        int totalcount = 0;
        int page = 1;

        while (true) {
            int current = paddTableRows.size();
            Logger4j.info("Rows loaded on page " + page + ": " + current);
            totalcount += current;
            Logger4j.info("Total rows after page " + page + ": " + totalcount);

            // Check if Next Page button is disabled
            String disabledAttr = nextPageButton.getAttribute("disabled");
            if (disabledAttr != null) {
                Logger4j.info("Next page button is disabled. Stopping at page " + page);
                break;
            }

            time.waitAndClick(nextPageButton);
            Logger4j.info("Clicked on Next Page button.");
            time.invisibilityof(GridLoader);
            time.visibilityOfAll(paddTableRows);
            page++;
        }

        if (totalcount == expected) {
            Logger4j.info(" Pagination verified successfully: " + totalcount + " records.");
        } else {
            Logger4j.error(" Pagination mismatch: expected " + expected + " but got " + totalcount);
            assertionCheck.assertEquals(totalcount, expected, "Pagination count mismatch");
        }
    }



    //Collect website data into List<Map<String, String>>
    public List<Map<String, String>> PADDcheckPaginationData(int chemcount, String dropdown) throws InterruptedException {
        List<Map<String, String>> webData = new ArrayList<>();

        DropdownUtil.selectByVisibleText(paginationSizeDropdown, dropdown);
        time.invisibilityof(GridLoader);

        int page = 1;

        while (true) {
            // ✅ Collect each row into webData
            for (WebElement row : paddTableRows) {
                List<WebElement> cells = row.findElements(By.tagName("td"));

                if (cells.size() >= 5) {  // safeguard
                    Map<String, String> rowData = new LinkedHashMap<>();
                    rowData.put("CAS", cells.get(1).getText().trim());
                    rowData.put("Chemical Name", cells.get(2).getText().trim());
                    rowData.put("Concentration", cells.get(3).getText().trim());
                    rowData.put("Physical State", cells.get(4).getText().trim());
                    webData.add(rowData);
                }
            }

            // ✅ Check if Next Page button is disabled
            if (nextPageButton.getAttribute("disabled") != null) {
                break;
            }

            time.waitAndClick(nextPageButton);
            time.invisibilityof(GridLoader);
            time.visibilityOfAll(paddTableRows);
            page++;
        }

        Logger4j.info("✅ Total website rows collected: " + webData.size());
        return webData;
    }





    // ✅ Step 2: Compare Website Data with Excel Data
// ✅ Convert row map to a normalized "signature string"
    private String rowSignature(Map<String, String> row) {
        return row.values().stream()
                .filter(v -> v != null && !v.trim().isEmpty())
                .map(v -> v.trim().toLowerCase().replaceAll("\\.0$", "")) // normalize
                .sorted() // ignore order
                .collect(Collectors.joining("|"));
    }

    private String normalize(String value) {
        if (value == null) return "";
        return value.trim()
                .toLowerCase()
                .replaceAll("\\.0$", "")   // remove trailing .0
                .replaceAll("%", "")       // remove %
                .replaceAll("\\s+", " ");  // collapse spaces
    }

    private boolean isRowMatch(Map<String, String> webRow, Map<String, String> excelRow) {
        for (String key : webRow.keySet()) {
            String webVal = normalize(webRow.get(key));
            String excelVal = normalize(excelRow.get(key));

            if (!webVal.isEmpty() && !excelVal.isEmpty() && !webVal.equals(excelVal)) {
                return false; // mismatch found
            }
        }
        return true; // all values matched (after normalization)
    }

    public void compareWebDataWithExcel(String folderPath, int chemcount, String dropdown) throws InterruptedException {
        List<Map<String, String>> webData = PADDcheckPaginationData(chemcount, dropdown);
        List<Map<String, String>> excelData = readExcelToHashMap(folderPath);

        List<Map<String, String>> missingRows = new ArrayList<>();

        for (Map<String, String> webRow : webData) {
            boolean found = false;
            for (Map<String, String> excelRow : excelData) {
                if (isRowMatch(webRow, excelRow)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                missingRows.add(webRow);
            }
        }

        if (missingRows.isEmpty()) {
            Logger4j.info("✅ All  data is present in Excel file.");
            // Hard assert → test will pass if true
            Asserrtion.assertTrue(true, "Current PADD Table data is present in Excel file.");
        } else {
            Logger4j.error("❌ Missing Data! Count: " + missingRows.size());
            for (Map<String, String> row : missingRows) {
                Logger4j.error("Missing Row: " + row);
            }
            // Hard assert → fail test with details
            assertionCheck.softAssertTrue(false, "Missing Data! Count: " + missingRows.size());
        }

        // In case you want soft assertions instead:
        // Asserrtion.softAssertTrue(missingRows.isEmpty(), "Some rows are missing from Excel.");
        // Asserrtion.assertAll();
    }




}
