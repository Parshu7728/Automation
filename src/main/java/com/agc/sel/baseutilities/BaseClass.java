package com.agc.sel.baseutilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;
import com.agc.sel.loggers.Logger4j;
import com.agc.sel.pdfReader.PDFReaderTestConfiguration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.lang.reflect.Method;
import java.util.Arrays;
import com.agc.sel.agc_pageObject.*;
import com.agc.sel.baseutilities.*;
import com.agc.sel.baseutilities.Random_Number_utilities;
import com.agc.sel.agc_pageObject.My_Report;
import com.agc.sel.agc_pageObject.Login_Ansell_Guardian;
public class BaseClass {

	public static WebDriver driver;
	public FileInputStream fileInput;
	public Properties p;
	public String downloadFile;
	public String Current_Url;
	public String pdf;
	public PDFReaderTestConfiguration prt;
	public String url;
	Login_Ansell_Guardian login;
	public My_Report myReport;
	public Random_Number_utilities Rn = new Random_Number_utilities();
	public Credentials_Utilities prop_utility = new Credentials_Utilities();
	public PADD_TestData_utilities padd_utility = new PADD_TestData_utilities();
	public Asserrtion assertionCheck = new Asserrtion();
	public WebWait waitTime;
	public static String author = "Parashuram-RY";
	public static String device = System.getProperty("os.name");
	public static String category = "Smoke-TestCase";
	private boolean logoutSuccessful = false;
	public Padd_BodyProtection_elements padd_Bp;
	public Padd_HandProtection_elements padd_Hp;
	protected Padd_Methods paddMethod; // Initialize after driver creation
	public My_Report my_Report;
	@Parameters("browser")
	@BeforeClass
	public void openBrowser(@Optional("chrome") String browser) throws Throwable {
		prop_utility.Property();
		Logger4j.info(device);
		downloadFile = System.getProperty("user.dir") + File.separator + "Pdfdownload";
		File folder = new File(downloadFile);

		if (!folder.exists()) {
			folder.mkdirs();
		}

		try {
			FileUtils.cleanDirectory(folder);
		} catch (IOException e) {
			Logger4j.error("Failed to clean directory: " + e.getMessage());
			e.printStackTrace();
		}

		System.out.println("Launching browser: " + browser);

		try {
			if (browser.equalsIgnoreCase("chrome")) {
				ChromeOptions options1 = new ChromeOptions();
				HashMap<String, Object> chromePrefs = new HashMap<>();
				chromePrefs.put("profile.default_content_settings.popups", 0);
				chromePrefs.put("download.default_directory", downloadFile);
				options1.setExperimentalOption("prefs", chromePrefs);

				Logger4j.info("Open Browser in Chrome");
				driver = new ChromeDriver(options1);
				Logger4j.exceptionDriver = driver;
				waitTime = new WebWait(driver);
			} else if (browser.equalsIgnoreCase("firefox")) {
				Logger4j.info("Open Browser in FireFox");
				driver = new FirefoxDriver();
				Logger4j.exceptionDriver = driver;
				waitTime = new WebWait(driver);
			} else if (browser.equalsIgnoreCase("edge")) {
				Logger4j.info("Open Browser in Edge");
				driver = new EdgeDriver();
				Logger4j.exceptionDriver = driver;
				waitTime = new WebWait(driver);
			} else {
				throw new IllegalArgumentException("Browser not supported: " + browser);
			}

			Logger4j.info("Maximize The Screen");
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
			driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			// Initialize page objects after driver is created
			paddMethod = new Padd_Methods(driver);
			padd_Hp = new Padd_HandProtection_elements(driver);
			padd_Bp = new Padd_BodyProtection_elements(driver);
			Logger4j.info("Page objects initialized successfully");

			prop_utility.Property();
			url = prop_utility.url();

			try {
				driver.get(url);
				Logger4j.info("Url entered successfully");
			} catch (org.openqa.selenium.TimeoutException e) {
				Logger4j.info("Timeout occurred while loading URL: " + url);
				Logger4j.info("Error message: " + e.getMessage());
			}

		} catch (Exception e) {
			Logger4j.info("Exception during browser initialization: " + e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void loginBeforeEachTest(@Optional("chrome") String browser, Method method) throws Throwable {
		if (method.getAnnotation(Test.class).groups().length > 0 &&
				Arrays.asList(method.getAnnotation(Test.class).groups()).contains("NoLogin")) {
			Logger4j.info("Skipping login for this test (marked with group: NoLogin)");
			return;
		}

		login = new Login_Ansell_Guardian(driver);
		String email;
		String password;

		if (Arrays.asList(method.getAnnotation(Test.class).groups()).contains("basic")) {
			email = prop_utility.basic_EmailID();
			password = prop_utility.basic_Password();
			Logger4j.info("Logging into the application with basic credentials");
		}
		else if(Arrays.asList(method.getAnnotation(Test.class).groups()).contains("advanced")){
			email = prop_utility.advanced_EmailID();
			password = prop_utility.advanced_Password();
			Logger4j.info("Logging into the application with advanced credentials");
		}else {
			email = prop_utility.valid_EmailID();
			password = prop_utility.valid_Password();
			Logger4j.info("Logging into the application with valid credentials");
		}

		login.login_With_Valid(email, password);
	}
	public void commonSetup() throws Throwable {
		// Initialize Page Objects
		my_Report = new My_Report(driver);

		padd_Bp = new Padd_BodyProtection_elements(driver);
		padd_Hp = new Padd_HandProtection_elements(driver);
		// Common steps
		my_Report.newRiskRequest();
		my_Report.create_Request();
		paddMethod.organizationDetails();
	}

	@AfterMethod
	public void Logout(Method method, ITestResult result) throws InterruptedException {
		logoutSuccessful = false; // Reset logout status

		Test testAnnotation = method.getAnnotation(Test.class);
		if (testAnnotation != null && Arrays.asList(testAnnotation.groups()).contains("NoLogin")) {
			Logger4j.info("Skipping logout for this test (marked with group: NoLogin)");
			logoutSuccessful = true; // Consider it successful since logout was not required
			return;
		}

		//  Only logout if test passed
		if (result.getStatus() == ITestResult.SUCCESS) {
			try {
				if (driver != null) {
					myReport = new My_Report(driver);
					waitTime.elementToBeClickable(driver.findElement(By.xpath("//*[@class='i-profile']")));
					myReport.logout();
					logoutSuccessful = true; // Mark logout as successful
					Logger4j.info("Logout completed successfully in AfterMethod");
				} else {
					Logger4j.warn("Driver is null, cannot perform logout");
					logoutSuccessful = false;
				}
			} catch (Exception e) {
				Logger4j.error("Exception during logout in AfterMethod: " + e.getMessage(), e);
				logoutSuccessful = false; // Mark logout as failed
				// Don't rethrow the exception to avoid failing the test
			}
		} else {
			Logger4j.info("Test did not pass, skipping logout.");
		}
	}

	@AfterClass(alwaysRun = true)
	public void CloseBrowser(ITestContext context) {
		Logger4j.info("Starting browser cleanup in AfterClass");
		
		// Only proceed with browser cleanup if logout was successful
		if (!logoutSuccessful) {
			Logger4j.warn("Logout was not successful, skipping browser cleanup to avoid issues");
			Logger4j.info("Driver will remain open for manual inspection or debugging");
			return;
		}
		
		Logger4j.info("Logout was successful, proceeding with browser cleanup");
		
		try {
			if (driver != null) {
				try {
					// Give a moment for any pending operations to complete
					Thread.sleep(2000);
					
					// Close the browser
					driver.quit();
					Logger4j.info("Browser closed successfully in AfterClass.");
					
				} catch (Exception e) {
					Logger4j.error("Error while closing browser in AfterClass: " + e.getMessage(), e);
					
					// Force quit if normal quit fails
					try {
						Logger4j.warn("Attempting force quit of browser...");
						driver.quit();
					} catch (Exception forceQuitException) {
						Logger4j.error("Force quit also failed: " + forceQuitException.getMessage());
					}
				} finally {
					driver = null;
					Logger4j.info("Driver reference set to null");
				}
			} else {
				Logger4j.info("Driver is already null, no cleanup needed");
			}
		} catch (Exception e) {
			Logger4j.error("Unexpected error in CloseBrowser @AfterClass: " + e.getMessage(), e);
		}
	}

}
