package com.agc.sel.agc_pageObject;


import com.agc.sel.loggers.Logger4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SortingElements {

	@FindBy(xpath = "//th[text()=' Chemical/Hazard Name ']")
	private WebElement acs_Chemical_Sort_Button;

	@FindBy(xpath = "//th[text()=' CAS ']")
	private WebElement acs_Cas_Sort_Button;

	@FindBy(xpath = "//th[text()=' Concentration ']")
	private WebElement acs_Concentration_Sort_Button;

	@FindBy(xpath = "//th[text()=' Physical State ']")
	private WebElement acs_Physical_Sort_Button;

	@FindBy(xpath = "(//td[@class='ng-star-inserted'])[2]")
	private WebElement chemical_Sort_Compare1;

	@FindBy(xpath = "(//td[@class='ng-star-inserted'])[6]")
	private WebElement chemical_Sort_Compare2;

	@FindBy(xpath = "(//td[@class='ng-star-inserted'])[1]")
	private WebElement cas_Sort_Compare1;

	@FindBy(xpath = "(//td[@class='ng-star-inserted'])[5]")
	private WebElement cas_Sort_Compare2;

	@FindBy(xpath = "(//td[@class='ng-star-inserted'])[3]")
	private WebElement concentration_Sort_Compare1;

	@FindBy(xpath = "(//td[@class='ng-star-inserted'])[7]")
	private WebElement concentration_Sort_Compare2;

	@FindBy(xpath = "(//td[@class='ng-star-inserted'])[4]")
	private WebElement physical_Sort_Compare1;

	@FindBy(xpath = "(//td[@class='ng-star-inserted'])[8]")
	private WebElement physical_Sort_Compare2;

	public SortingElements(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String chemicalSort_Compare1() {
		String Compare = chemical_Sort_Compare1.getText();
		return Compare;
	}

	public String chemicalSort_Compare2() {
		String CasCompare = chemical_Sort_Compare2.getText();
		return CasCompare;
	}

	public String casSort_Compare1() {
		String CasCompare = cas_Sort_Compare1.getText();
		return CasCompare;
	}

	public String casSort_Compare2() {
		String Compare = cas_Sort_Compare2.getText();
		return Compare;
	}

	public String concentrationSort_Compare1() {
		String Concentration_Compare1 = concentration_Sort_Compare1.getText();
		return Concentration_Compare1;
	}

	public String concentrationSort_Compare2() {
		String Concentration_Compare2 = concentration_Sort_Compare2.getText();
		return Concentration_Compare2;
	}

	public String physicalSort_Compare1() {
		String physical1 = physical_Sort_Compare1.getText();
		return physical1;
	}

	public String physicalSort_Compare2() {
		String physical2 = physical_Sort_Compare2.getText();
		return physical2;
	}

	public void acs_sortChemical_button() {
		acs_Chemical_Sort_Button.click();
		Logger4j.info("Chemical Sort Button clicked: acs_Chemical_Sort_Button");
	}

	public void acs_CasSort_Button() throws InterruptedException {
		acs_Cas_Sort_Button.click();
		Logger4j.info("CAS Sort Button clicked: acs_Cas_Sort_Button");
	}

	public void acs_ConcentrationSort_Button() {
		acs_Concentration_Sort_Button.click();
		Logger4j.info("Concentration Sort Button clicked: acs_Concentration_Sort_Button");

	}

	public void acs_PhysicalSort_Button() {
		acs_Physical_Sort_Button.click();
		Logger4j.info("Physical State Sort Button clicked: acs_Physical_Sort_Button");
	}
}
