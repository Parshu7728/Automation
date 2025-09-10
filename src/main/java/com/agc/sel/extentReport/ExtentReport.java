package com.agc.sel.extentReport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.MediaEntityBuilder;

/**
 * The ExtentReport class provides methods to generate and manage ExtentReports
 * for test execution. It includes functionality for initializing reports,
 * capturing screenshots, logging test results, and adding system information.
 */
public final class ExtentReport {

	// ExtentReports instance for managing the report
	private static ExtentReports extent;

	// ExtentTest instance for logging test-specific information
	public static ExtentTest test;

	// Private constructor to prevent instantiation
	private ExtentReport() {
	}

	/**
	 * Initializes the ExtentReports with configurations and attaches reporters.
	 *
	 * @param driver The WebDriver instance used for capturing environment details.
	 * @throws Throwable If an error occurs during initialization.
	 */
	public static void initReports(WebDriver driver) throws Throwable {
		if (Objects.isNull(extent)) {
			extent = new ExtentReports();

			// Passed test report configuration
			ExtentSparkReporter passedspark = new ExtentSparkReporter("./extentreport_file/finalreport.html");

			// Failed test report configuration
			ExtentSparkReporter failedspark = new ExtentSparkReporter("./extentreport_file/failedreport.html").filter()
					.statusFilter().as(new Status[] { Status.FAIL, Status.SKIP }).apply();

			// Load XML configuration for reporters
			passedspark.loadXMLConfig(new File(Thread.currentThread().getContextClassLoader().getResource("Extentreportconfig.xml").getFile()));
			failedspark.loadXMLConfig(new File(Thread.currentThread().getContextClassLoader().getResource("Extentreportconfig.xml").getFile()));

			// Attach reporters to ExtentReports
			extent.attachReporter(passedspark);

			// Configure report themes and titles
			failedspark.config().setTheme(Theme.DARK);
			failedspark.config().setDocumentTitle("Final Failed Report");
			passedspark.config().setTheme(Theme.DARK);
			passedspark.config().setDocumentTitle("Final Report");

			// Add system environment details
			env(driver);
		}
	}

	/**
	 * Captures a screenshot of the current browser state as a Base64 string.
	 *
	 * @param driver The WebDriver instance used to capture the screenshot.
	 * @return The Base64 string representation of the screenshot.
	 */
	public static String captureScreenshot(WebDriver driver) {
		try {
			if (driver != null) {
				return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
			} else {
				throw new IllegalStateException("WebDriver is not initialized.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Logs a passed test case in the report.
	 *
	 * @param TestCaseName The name of the test case.
	 * @param author       The author of the test case.
	 * @param category     The category of the test case.
	 * @param device       The device on which the test was executed.
	 * @param driver       The WebDriver instance used for capturing screenshots.
	 */
	public static void passed_test(String TestCaseName, String author, String category, String device,
			WebDriver driver) {
		test = extent.createTest(TestCaseName).assignAuthor(author).assignCategory(category).assignDevice(device);
	}

	/**
	 * Logs a failed test case in the report with a screenshot and failure message.
	 *
	 * @param testcaseName The name of the test case.
	 * @param message      The failure message.
	 * @param author       The author of the test case.
	 * @param category     The category of the test case.
	 * @param device       The device on which the test was executed.
	 * @param driver       The WebDriver instance used for capturing screenshots.
	 */
	public static void failed_test(String testcaseName, String message, String author, String category, String device,
			WebDriver driver) {
		System.out.println("Executing failed Test");
		test = extent
				.createTest(testcaseName,
						"This is where the test case failed, and we took screenshots to capture the failure.")
				.assignAuthor(author).assignCategory(category).assignDevice(device)
				.addScreenCaptureFromBase64String(captureScreenshot(driver))
				.fail(MarkupHelper.createLabel(message, ExtentColor.RED)).fail(MediaEntityBuilder
						.createScreenCaptureFromBase64String(captureScreenshot(driver), "ANC Dashboard").build());
	}

	/**
	 * Adds system environment details to the report.
	 *
	 * @param driver The WebDriver instance used to retrieve browser capabilities.
	 */
	public static void env(WebDriver driver) {
		RemoteWebDriver re = (RemoteWebDriver) driver;
		Capabilities capabilities = re.getCapabilities();
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Browser & Version",
				capabilities.getBrowserName() + " " + capabilities.getBrowserVersion());
		extent.setSystemInfo("Java Version", System.getProperty("java.version"));
		extent.setSystemInfo("Application URL", "https://gc-development.ansell.com");
	}

	/**
	 * Logs a passed message in the report.
	 *
	 * @param Pass The message to be logged as passed.
	 */
	public static void passmessage(String Pass) {
		if (test != null) {
			test.pass(MarkupHelper.createLabel(Pass, ExtentColor.GREEN));
		} else {
			System.out.println("ExtentTest is not initialized.");
		}
	}

	/**
	 * Logs a failed message in the report.
	 *
	 * @param fail The message to be logged as failed.
	 */
	public static void failmessage(String fail) {
		if (test != null) {
			test.fail(MarkupHelper.createLabel(fail, ExtentColor.RED));
		} else {
			System.out.println("ExtentTest is not initialized.");
		}
	}

	/**
	 * Logs an informational message in the report with a blue highlight.
	 *
	 * @param pass The message to be logged as informational.
	 */
	public static void highlight_message(String pass) {
		if (test != null) {
			test.info(MarkupHelper.createLabel(pass, ExtentColor.BLUE));
		} else {
			System.out.println("ExtentTest is not initialized.");
		}
	}

	/**
	 * Logs a warning message in the report with a yellow highlight.
	 *
	 * @param pass The message to be logged as a warning.
	 */
	public static void highlight_message_warning(String pass) {
		if (test != null) {
			test.warning(MarkupHelper.createLabel(pass, ExtentColor.YELLOW));
		} else {
			System.out.println("ExtentTest is not initialized.");
		}
	}
	public static ExtentReports getExtent() {
		return extent;
	}

	/**
	 * Flushes the report and opens it in the default browser.
	 *
	 * @throws IOException If an error occurs while opening the report.
	 */
	public static void flushReport() throws IOException {
		if (Objects.nonNull(extent)) {
			extent.flush();
		}
		Desktop.getDesktop()
				.browse(new File("E:\\AutomationAGC\\Automation\\extentreport_file\\finalreport.html").toURI());
	}
}
