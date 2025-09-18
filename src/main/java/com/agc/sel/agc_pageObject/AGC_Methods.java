package com.agc.sel.agc_pageObject;

import com.agc.sel.baseutilities.WebWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.function.BiConsumer;

public class AGC_Methods {
    WebDriver driver;
    WebWait time;

    @FindBy(xpath = "//*[@id='privacy']")
    public WebElement privacyPolicyLink;

    @FindBy(xpath = "//*[@id='termsOfUse']")
    public WebElement termsOfUseLink;

    @FindBy(xpath = "//*[@id='cookiePolicy']")
    public WebElement cookiePolicyLink;

    @FindBy(xpath = "//*[@id='productDisclaimer']")
    public WebElement productDisclaimerLink;

    @FindBy(xpath = "//*[@id='reachStatement']")
    public WebElement reachStatementLink;

    @FindBy(xpath = "//*[@id='patents']")
    public WebElement patentsLink;

    // ICP Filing Number
    @FindBy(xpath = "//a[contains(text(),'ICP FILING NUMBER')]")
    public WebElement icpFilingNumberLink;

    // PSB Filing Number
    @FindBy(xpath = "//a[contains(text(),'PSB FILING NUMBER')]")
    public WebElement psbFilingNumberLink;

    // Shanghai Certificate
    @FindBy(xpath = "//a[contains(text(),'SHANGHAI CERTIFICATE')]")
    private WebElement shanghaiCertificateLink;

    public AGC_Methods(WebDriver driver) {
        this.driver = driver;
        this.time = new WebWait(driver);
        PageFactory.initElements(driver, this);
    }

    public BiConsumer<WebElement, String> verifyLinkByUrl = (link, expectedUrlPart) -> {
       time.waitAndClick(link);
        // Switch to new tab
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        // Verify URL
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(expectedUrlPart),
                "❌ URL mismatch! Expected to contain: " + expectedUrlPart);
        driver.close();
        driver.switchTo().window(tabs.get(0));
    };

    public BiConsumer<WebElement,String> verifyLinkByUrlorPage = (link, expectedUrlorpage) -> {
        time.waitAndClick(link);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String currentUrl = driver.getCurrentUrl();
        boolean found = currentUrl.contains(expectedUrlorpage);

        boolean foundInPage = false;
        if(!found){
            foundInPage = driver.getPageSource().contains(expectedUrlorpage);
        }
        Assert.assertTrue(found || foundInPage,
                "❌ URL or Page content mismatch! Expected to contain: " + expectedUrlorpage);
        driver.close();
        driver.switchTo().window(tabs.get(0));
    };


}
