package com.agc.sel.baseutilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * The Credentials_Utilities class provides methods to manage and retrieve
 * application credentials and configuration properties. It reads data from a
 * properties file and provides utility methods to access specific values.
 */
public class Credentials_Utilities {

	// Properties object to store key-value pairs from the properties file
	public Properties p;

	// Variables to store various credentials and configuration values
	public String valid_EmailID;
	public String valid_Password;
	public String invalid_Password;
	public String invalid_NewEmailID;
	public String invalid_EmailID;
	public String empty_Email;
	public String empty_Password;
	public String report_Name;
	public String email;
	public String contact_Name;
	public String sharedto1;
	public String sharedto2;
	public String telephone;
	public String organization_Name;
	public String chemical_Text;
	public FileInputStream fileInput;

	/**
	 * Constructor that initializes the Properties object by loading the configuration file.
	 */
	public Credentials_Utilities() {
		try {
			Property();
		} catch (Exception e) {
			System.err.println("Error loading properties file: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Loads the properties file and initializes the Properties object.
	 *
	 * @throws Exception If an error occurs while reading the properties file.
	 */
	public void Property() throws Exception {
		fileInput = new FileInputStream("./src/main/resources/Data/AgcData.txt");
		this.p = new Properties();
		p.load(fileInput);
	}

	/**
	 * Retrieves the development URL from the properties file.
	 *
	 * @return The development URL as a String.
	 */
	public String url() {
		return p.getProperty("Developement_URL");
	}

	public String basic_EmailID() {
		return p.getProperty("SignIn_BasicEmailID");
	}

	public String basic_Password() {
		return p.getProperty("SignIn_BasicPassword");
	}

	public String advanced_EmailID() {
		return p.getProperty("SignIn_AdvanceEmailID");
	}

	public String advanced_Password() {
		return p.getProperty("SignIn_AdvancePassword");
	}

	public String signIn_SecondEmailID() {
		return p.getProperty("SignIn_SecondEmailID");
	}


	/**
	 * Retrieves the valid email ID for sign-in from the properties file.
	 *
	 * @return The valid email ID as a String.
	 */
	public String valid_EmailID() {
		return valid_EmailID = p.getProperty("SignIn_ValidEmailID");
	}

	/**
	 * Retrieves the valid password for sign-in from the properties file.
	 *
	 * @return The valid password as a String.
	 */
	public String valid_Password() {
		return valid_Password = p.getProperty("SignIn_ValidPassword");
	}

	/**
	 * Retrieves the invalid password for sign-in from the properties file.
	 *
	 * @return The invalid password as a String.
	 */
	public String invalid_Password() {
		return invalid_Password = p.getProperty("SignIn_InvalidPassword");
	}

	/**
	 * Retrieves the invalid new email ID for sign-in from the properties file.
	 *
	 * @return The invalid new email ID as a String.
	 */
	public String invalid_NewEmailID() {
		return invalid_NewEmailID = p.getProperty("SignIn_InvalidNewEmailID");
	}

	/**
	 * Retrieves the invalid email ID for sign-in from the properties file.
	 *
	 * @return The invalid email ID as a String.
	 */
	public String invalid_EmailID() {
		return invalid_EmailID = p.getProperty("SignIn_InvalidEmailID");
	}

	/**
	 * Retrieves the empty email value for sign-in from the properties file.
	 *
	 * @return The empty email value as a String.
	 */
	public String empty_Email() {
		return empty_Email = p.getProperty("SignIn_EmptyEmail");
	}

	/**
	 * Retrieves the empty password value for sign-in from the properties file.
	 *
	 * @return The empty password value as a String.
	 */
	public String empty_Password() {
		return empty_Password = p.getProperty("SignIn_EmptyPassword");
	}

	/**
	 * Retrieves the organization name from the properties file.
	 *
	 * @return The organization name as a String.
	 */
	public String organization_Name() {
		return organization_Name = p.getProperty("OrganisationName");
	}

	/**
	 * Retrieves the report name from the properties file.
	 *
	 * @return The report name as a String.
	 */
	public String report_Name() {
		return report_Name = p.getProperty("Report_Name");
	}

	/**
	 * Retrieves the email address from the properties file.
	 *
	 * @return The email address as a String.
	 */
	public String email() {
		return email = p.getProperty("Email");
	}

	/**
	 * Retrieves the contact name from the properties file.
	 *
	 * @return The contact name as a String.
	 */
	public String contact_Name() {
		return contact_Name = p.getProperty("Contact_Name");
	}

	/**
	 * Retrieves the first shared-to email address from the properties file.
	 *
	 * @return The first shared-to email address as a String.
	 */
	public String sharedTo1() {
		return sharedto1 = p.getProperty("SharedTo1");
	}

	/**
	 * Retrieves the second shared-to email address from the properties file.
	 *
	 * @return The second shared-to email address as a String.
	 */
	public String sharedTo2() {
		return sharedto2 = p.getProperty("SharedTo2");
	}

	/**
	 * Retrieves the telephone number from the properties file.
	 *
	 * @return The telephone number as a String.
	 */
	public String telephone() {
		return telephone = p.getProperty("Tel/Mob");
	}

	/**
	 * Retrieves the first chemical text from the properties file.
	 *
	 * @return The first chemical text as a String.
	 */
	public String chemicalText1() {
		return chemical_Text = p.getProperty("Chemical1");
	}

	/**
	 * Retrieves the second chemical text from the properties file.
	 *
	 * @return The second chemical text as a String.
	 */
	public String chemicalText2() {
		return chemical_Text = p.getProperty("Chemical2");
	}

	/**
	 * Retrieves the value of unsignedchemical1 from the properties file.
	 *
	 * @return The value of unsignedchemical1 as a String.
	 */
	public String unsignedchemical1() {
		return p.getProperty("Unsigned_usr_chemical1");
	}

	/**
	 * Retrieves the value of unsignedchemical2 from the properties file.
	 *
	 * @return The value of unsignedchemical2 as a String.
	 */
	public String unsignedchemical2() {
		return p.getProperty("Unsigned_usr_chemical2");
	}

	/**
	 * Retrieves the first padd BP chemical from the properties file.
	 *
	 * @return The first padd BP chemical as a String.
	 */
	public String paddBpchemical1() {
		String padd_BpChemical1 = p.getProperty("PaddBpChemical1");
		return padd_BpChemical1;
	}

	/**
	 * Retrieves the second padd BP chemical from the properties file.
	 *
	 * @return The second padd BP chemical as a String.
	 */
	public String paddBpchemical2() {
		String padd_BpChemical2 = p.getProperty("PaddBpChemical2");
		return padd_BpChemical2;
	}

	/**
	 * Retrieves the first padd HP chemical from the properties file.
	 *
	 * @return The first padd HP chemical as a String.
	 */
	public String paddHpchemical1() {
		String padd_HpChemical1 = p.getProperty("PaddHpChemical1");
		return padd_HpChemical1;
	}

	/**
	 * Retrieves the second padd HP chemical from the properties file.
	 *
	 * @return The second padd HP chemical as a String.
	 */
	public String paddHpchemical2() {
		String padd_HpChemical2 = p.getProperty("PaddHpChemical2");
		return padd_HpChemical2;
	}

	/**
	 * Retrieves the first BP product from the properties file.
	 *
	 * @return The first BP product as a String.
	 */
	public String bpProduct1() {
		String bp_product1 = p.getProperty("BodyProduct1");
		return bp_product1;
	}

	/**
	 * Retrieves the second BP product from the properties file.
	 *
	 * @return The second BP product as a String.
	 */
	public String bpProduct2() {
		String bp_product2 = p.getProperty("BodyProduct2");
		return bp_product2;
	}

	/**
	 * Retrieves the first HP product from the properties file.
	 *
	 * @return The first HP product as a String.
	 */
	public String hpProduct1() {
		String bp_product1 = p.getProperty("HandProduct1");
		return bp_product1;
	}

	/**
	 * Retrieves the second HP product from the properties file.
	 *
	 * @return The second HP product as a String.
	 */
	public String hpProduct2() {
		String bp_product2 = p.getProperty("HandProduct2");
		return bp_product2;
	}

	public String materialHP1() {
		return p.getProperty("MaterialHP1");
	}
	public String materialHP2() {
		return p.getProperty("MaterialHP2");
	}
	public String replaceable_Chemical1() {
		String chemname = p.getProperty("Replaceable_Chemical1");
		return chemname;
	}

	public String replaceable_cas() {
		String cas_number = p.getProperty("Replaceable_Cas");
		return cas_number;
	}

	public String cas_number1() {
		if (p == null) {
			System.err.println("Properties not initialized. Please check the properties file.");
			return null;
		}
		return p.getProperty("Cas_No1");
	}

	public String cas_number2() {
		if (p == null) {
			System.err.println("Properties not initialized. Please check the properties file.");
			return null;
		}
		return p.getProperty("Cas_No2");
	}

	public String PTD_BP_product() {
		if (p == null) {
			System.err.println("Properties not initialized. Please check the properties file.");
			return null;
		}
		return p.getProperty("PTD_BP_product1");
	}

	/**
	 * Retrieves the PTD product group from the properties file.
	 *
	 * @return The PTD product group as a String.
	 */
	public String ptd_ProductGroupBP() {
		if (p == null) {
			System.err.println("Properties not initialized. Please check the properties file.");
			return null;
		}
		return p.getProperty("BP_product_group");
	}

	public String ptd_ProductGroupHP() {
		if (p == null) {
			System.err.println("Properties not initialized. Please check the properties file.");
			return null;
		}
		return p.getProperty("HP_product_group");
	}

	/**
	 * Retrieves the PTD product name from the properties file.
	 *
	 * @return The PTD product name as a String.
	 */
	public String ptd_ProductName() {
		if (p == null) {
			System.err.println("Properties not initialized. Please check the properties file.");
			return null;
		}
		return p.getProperty("product_name");
	}

	public String mixtureName() {
		return p.getProperty("mixture.name");
	}

	public String mixturePhysicalState() {
		return p.getProperty("mixture.physicalState");
	}

	public String component1_CAS() {
		return p.getProperty("component1.cas");
	}

	public String component1_ChemicalName() {
		return p.getProperty("component1.chemicalName");
	}

	public String component1_Proportion() {
		return p.getProperty("component1.proportion");
	}

	public String component1_PhysicalState() {
		return p.getProperty("component1.physicalState");
	}

	public String component2_CAS() {
		return p.getProperty("component2.cas");
	}

	public String component2_ChemicalName() {
		return p.getProperty("component2.chemicalName");
	}

	public String component2_Proportion() {
		return p.getProperty("component2.proportion");
	}

	public String component2_PhysicalState() {
		return p.getProperty("component2.physicalState");
	}

	public  String mixture1(){return p.getProperty("mixture1");}
	public void AddComponentToMixture(WebElement Wcas, WebElement WchemName, WebElement Wproportion, WebElement physicalState, WebElement Save) {

		for (int i = 1; i <= 2; i++) {
			String cas = p.getProperty("component" + i + ".cas");
			Wcas.clear();
			Wcas.sendKeys(cas);
			String chemName = p.getProperty("component" + i + ".chemicalName");
			WchemName.clear();
			WchemName.sendKeys(chemName);
			String proportion = p.getProperty("component" + i + ".proportion");
			Wproportion.clear();
			Wproportion.sendKeys(proportion);
			Random_Number_utilities.selectRandomPhysicalState(physicalState);
			Save.click();;
		}
	}
}
